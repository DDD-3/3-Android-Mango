package com.mango.di.module

import com.mango.domain.DetailUseCase
import com.mango.domain.PengpongUseCase
import com.mango.domain.PengpongRepository
import dagger.Module
import dagger.Provides

@Module
class
UseCaseModule {

    //Example
    @Provides
    fun provideGithubUseCase(githubRepository: PengpongRepository)
            : PengpongUseCase {
        return PengpongUseCase(githubRepository)
    }

    @Provides
    fun provideDetailUseCase(repository: PengpongRepository): DetailUseCase {
        return DetailUseCase(repository)
    }

}