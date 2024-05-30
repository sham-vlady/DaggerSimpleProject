package com.example.daggersimmpleproject.chat

import android.content.Context
import com.example.daggersimmpleproject.data.IDataRepository

class ChatInteract(
    private val context: Context,
    private val iDataRepository: IDataRepository,
    private val iChatStateController: IChatStateController
) : IChatInteract {
    // Implement necessary methods
}

interface IChatInteract