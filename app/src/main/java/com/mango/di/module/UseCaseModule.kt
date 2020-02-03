package com.mango.di.module

import com.mango.domain.DetailUseCase
import com.mango.domain.ShopUseCase
import com.mango.domain.ShopRepository
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    //Example
    @Provides
    fun provideGithubUseCase(githubRepository: ShopRepository)
            : ShopUseCase {
        return ShopUseCase(githubRepository)
    }

    @Provides
    fun provideDetailUseCase(repository: ShopRepository): DetailUseCase {
        return DetailUseCase(repository)
    }

}