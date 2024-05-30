package com.example.daggersimmpleproject.chat

import android.content.Context
import com.example.daggersimmpleproject.data.IDataRepository
import com.example.daggersimmpleproject.utils.RxUtilsAbs
import dagger.Module
import dagger.Provides

@Module
class ChatModule {
    @Provides
    // TODO то есть при наличии собственного скоупа даггер кэширует объекты в компоненте до тех пор пока он существует?
    /**
     * Да, по сути так. Скоуп - просто метка, используемая внутри DaggerComponent, сообщающая,
     * нужно ли закэшировать объект. Логика работы с разными скоупами внутри даггера одинакова, то есть
     * причина иметь несколько скоупов - только чтобы напрямую разграничить более долгоживущие зависимости
     * от менее долгоживущих.
     */
    @ChatScope
    fun provideChatInteract(
        context: Context,
        iDataRepository: IDataRepository,
        iChatStateController: IChatStateController
    ): IChatInteract {
        return ChatInteract(context, iDataRepository, iChatStateController)
    }

    @Provides
    @ChatScope
    fun provideIChatStateController(rxUtilsAbs: RxUtilsAbs): IChatStateController {
        return ChatStateController(rxUtilsAbs)
    }
}