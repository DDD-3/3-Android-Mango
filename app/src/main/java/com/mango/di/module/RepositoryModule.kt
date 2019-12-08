package com.mango.di.module

import dagger.Module
import dagger.Provides

@Module(includes = [MapperModule::class])
class RepositoryModule {

    //Example
    /*@Provides
    fun provideGithubRepository(
        githubService: GithubService,
        githubMapper: GithubMapper
    ): GithubRepository {
        return GithubRepositoryImpl(githubService, githubMapper)
    }*/

}

@Module
class MapperModule {
    //Example
/*
    @Provides
    fun provideGithubMapper(): GithubMapper {
        return GithubMapper()
    }*/

}