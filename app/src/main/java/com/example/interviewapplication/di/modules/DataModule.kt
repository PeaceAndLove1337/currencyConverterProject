package com.example.interviewapplication.di.modules

import com.example.interviewapplication.data.RepositoryImpl
import com.example.interviewapplication.data.net.ApiMapperImpl
import com.example.interviewapplication.domain.InteractorImpl
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @NotNull
    @Singleton
    fun provideMapper(): ApiMapperImpl {
        return ApiMapperImpl()
    }

    @Provides
    @NotNull
    @Singleton
    fun provideRepository(apiMapper: ApiMapperImpl): RepositoryImpl {
        return RepositoryImpl(apiMapper)
    }

    @Provides
    @NotNull
    @Singleton
    fun provideInteractor(repository: RepositoryImpl): InteractorImpl {
        return InteractorImpl(repository)
    }
}