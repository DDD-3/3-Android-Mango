package com.mango.di.module

import com.mango.data.PengpongRepositoryImpl
import com.mango.data.PengpongService
import com.mango.data.mapper.PengpongMapper
import com.mango.domain.PengpongRepository
import dagger.Module
import dagger.Provides

@Module(includes = [MapperModule::class])
class RepositoryModule {

    //Example
    @Provides
    fun providePengpongRepository(
        pengpongService: PengpongService,
        pengpongMapper: PengpongMapper
    ): PengpongRepository {
        return PengpongRepositoryImpl(pengpongService, pengpongMapper)
    }

}

@Module
class MapperModule {
    //Example
    @Provides
    fun providePengpongMapper(): PengpongMapper {
        return PengpongMapper()
    }

}