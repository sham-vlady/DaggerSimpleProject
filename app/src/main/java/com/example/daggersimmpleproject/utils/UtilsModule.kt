package com.example.daggersimmpleproject.utils

import android.content.Context
import com.example.daggersimmpleproject.receivers.MyNetworkChannel
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
class UtilsModule {
    @Provides
    @Reusable
    fun provideRxUtils(context: Context?): RxUtilsAbs {
        return RxUtils(context)
    }

    @Provides
    @Singleton
    fun provideNetworkUtils(context: Context?, networkChannel: MyNetworkChannel?): NetworkUtils {
        return NetworkUtils(context, networkChannel)
    }
}