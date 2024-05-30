package com.example.daggersimmpleproject.chat.screen

import android.content.Context
import com.example.daggersimmpleproject.chat.IChatInteract

class SCPresenter(
    private val context: Context,
    private val iChatInteract: IChatInteract
) : ISCPresenter {
    // Implement necessary methods
}

interface ISCPresenter