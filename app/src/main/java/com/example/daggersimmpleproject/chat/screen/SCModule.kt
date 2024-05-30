package com.example.daggersimmpleproject.chat.screen

import android.content.Context
import com.example.daggersimmpleproject.chat.IChatInteract
import dagger.Module
import dagger.Provides

@Module
class SCModule {

    @Provides
    @ChatScreenScope
    fun provideISCPresenter(context: Context, iChatInteract: IChatInteract): ISCPresenter {
        return SCPresenter(context, iChatInteract)
    }
}