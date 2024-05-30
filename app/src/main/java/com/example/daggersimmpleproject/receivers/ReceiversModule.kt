package com.example.daggersimmpleproject.receivers

import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ReceiversModule {
    @Provides
    @Singleton
    fun provideNetworkChannel(): MyNetworkChannel {
        return MyNetworkChannel()
    }
}