package com.example.daggersimmpleproject

import android.app.Application
import com.example.daggersimmpleproject.chat.ChatComponent
import com.example.daggersimmpleproject.chat.ChatSubComponent
import com.example.daggersimmpleproject.chat.DaggerChatComponent
import com.example.daggersimmpleproject.chat.screen.SingleChatFragmentSubcomponent
import com.example.daggersimmpleproject.chat.ChatModule
import com.example.daggersimmpleproject.receivers.ReceiversModule
import com.example.daggersimmpleproject.chat.screen.SCModule
import com.example.daggersimmpleproject.utils.UtilsModule


class MyApplication : Application() {

    lateinit var appComponent: AppComponent
        private set


    override fun onCreate() {
        super.onCreate()
        appComponent = buildComponent()
    }

    fun buildComponent(): AppComponent {
        return DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .utilsModule(UtilsModule())
            .receiversModule(ReceiversModule())
            .build()
    }

    // TODO ЖЦ определяется тем, где был вызван метод создания компонента?
    /**
     * По сути,  да. В активити компонент проживет столько, сколько живет инстанс активити. При переворотe
     * экрана - произойдет пересоздание компонента. Поэтому создание всех долгоживущих, глобальных
     * зависимостей нужно тем или иным способом вынести в глобальный компонент, и организовать иерархию зависимостей.
     *
     * Для этого есть 2 основных способа - subcomponent и component dependencies. Первый имеет  ряд недостатков
     * в многомодульной среде, поэтому в Авито используются component dependencies.
     * Подробно об этом ты узнаешь в следующем цикле материалов)
     * */
    fun createChatComponent(): ChatComponent {
        return DaggerChatComponent.builder()
            .appComponent(appComponent)
            .build()
    }

    // ------- for sub components

    private var chatComponent: ChatSubComponent? = null
    private var scComponent: SingleChatFragmentSubcomponent? = null

    fun plusChatComponent(): ChatSubComponent {
        // always get only one instance
        if (chatComponent == null) {
            // start lifecycle of chatComponent
            chatComponent = appComponent.plusChatComponent(ChatModule())
        }
        return chatComponent!!
    }

    fun clearChatComponent() {
        // end lifecycle of chatComponent
        chatComponent = null
    }

    fun plusSCComponent(): SingleChatFragmentSubcomponent {
        // always get only one instance
        if (scComponent == null) {
            // start lifecycle of scComponent
            scComponent = chatComponent?.plusSCComponent(SCModule())
        }
        return scComponent!!
    }

    fun clearSCComponent() {
        // end lifecycle of scComponent
        scComponent = null
    }


}