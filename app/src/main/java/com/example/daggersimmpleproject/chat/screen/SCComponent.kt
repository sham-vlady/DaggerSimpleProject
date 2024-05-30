package com.example.daggersimmpleproject.chat.screen

import com.example.daggersimmpleproject.chat.ChatComponent
import dagger.Component
import dagger.Subcomponent


@ChatScreenScope
@Component(dependencies = [ChatComponent::class], modules = [SCModule::class])
interface SCComponent {
    fun inject(singleChatFragment: SingleChatFragment)
}

@ChatScreenScope
@Subcomponent(modules = [SCModule::class])
interface SingleChatFragmentSubcomponent {
     fun inject(singleChatFragment: SingleChatFragment)
}