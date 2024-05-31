package com.example.daggersimmpleproject.chat.screen

import android.content.Context
import com.example.daggersimmpleproject.chat.IChatInteract
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

class SCPresenter @AssistedInject constructor(
    private val context: Context,
    private val iChatInteract: IChatInteract,
    @Assisted private val chatId: String
) : ISCPresenter {
    override fun getChatId(): String {
        return chatId
    }
}

interface ISCPresenter {
    fun getChatId() : String
}