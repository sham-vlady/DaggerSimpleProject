package com.example.daggersimmpleproject.chat

import android.content.Context
import com.example.daggersimmpleproject.AppComponent
import com.example.daggersimmpleproject.utils.RxUtilsAbs
import com.example.daggersimmpleproject.chat.screen.SingleChatFragmentSubcomponent
import com.example.daggersimmpleproject.chat.screen.SCModule
import dagger.Component
import dagger.Subcomponent

@ChatScope
@Component(dependencies = [AppComponent::class], modules = [ChatModule::class])
interface ChatComponent {
    fun context(): Context
    fun iChatInteract(): IChatInteract
    fun rxUtilsAbs(): RxUtilsAbs

    // Add inject methods if needed
}

@ChatScope
@Subcomponent(modules = [ChatModule::class])
interface ChatSubComponent {
    fun plusSCComponent(scModule: SCModule): SingleChatFragmentSubcomponent

    // Add inject methods if needed
}