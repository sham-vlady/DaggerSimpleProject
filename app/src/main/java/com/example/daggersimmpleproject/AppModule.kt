package com.example.daggersimmpleproject

import android.content.Context
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Named
import javax.inject.Singleton


@Module
class AppModule(private val appContext: Context) {
    @Provides
    @Singleton
    fun provideContext(): Context {
        return appContext
    }

    // ------ Qualifiers
    @Provides
    @Singleton
    @Named("SingleThread")
    fun provideSingleThreadExecutor(): Executor {
        return Executors.newSingleThreadExecutor()
    }

    @Provides
    @Singleton
    @Named("MultiThread")
    fun provideMultiThreadExecutor(): Executor {
        return Executors.newCachedThreadPool()
    }
}