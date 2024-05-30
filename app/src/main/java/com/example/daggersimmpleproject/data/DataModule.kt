package com.example.daggersimmpleproject.data

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideIDataRepository(dataRepository: DataRepository): IDataRepository
}