package com.example.daggersimmpleproject

import android.content.Context
import com.example.daggersimmpleproject.chat.ChatSubComponent
import com.example.daggersimmpleproject.chat.ChatModule
import com.example.daggersimmpleproject.data.DataModule
import com.example.daggersimmpleproject.data.IDataRepository
import com.example.daggersimmpleproject.receivers.ReceiversModule
import com.example.daggersimmpleproject.translator.Translator
import com.example.daggersimmpleproject.translator.TranslatorsModule
import com.example.daggersimmpleproject.utils.RxUtilsAbs
import com.example.daggersimmpleproject.utils.UtilsModule
import dagger.Component
import javax.inject.Singleton

// TODO если компонент указывается как Singleton все ли его модули должны провайдить только синглтоны?
/**
 * Не совсем, методы модуля также могут быть без скоупа. Такие методы будут вызываться каждый раз
 * при inject-е этой зависимости, например, в двух разных классах будет 2 инстанса данного класса-зависимости.
 *
 * То есть, отвечая на твой вопрос - если компонент помечен скоупом, то его модули должны использовать
 * в своих методах этот же скоуп, либо никакого - допускается в одном модуле иметь часть методов,
 * помеченных скоупом, а часть - без скоупа.
 */
@Singleton
@Component(modules = [AppModule::class, UtilsModule::class, ReceiversModule::class, DataModule::class, TranslatorsModule::class])
interface AppComponent {

    fun plusChatComponent(chatModule: ChatModule): ChatSubComponent

    fun context(): Context
    fun iDataRepository(): IDataRepository
    fun rxUtilsAbs(): RxUtilsAbs
    fun getTranslators(): Set<Translator>


    fun inject(mainFragment: MainFragment)
}