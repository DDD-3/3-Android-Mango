package com.mango.domain

import com.mango.domain.entity.DomainEntityPengpong
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class PengpongUseCase constructor(
    private val pengpongRepository: PengpongRepository
) : BaseUseCase<PengpongUseCase.Params, List<DomainEntityPengpong>> {

    data class Params(val number: Int)

    override fun invoke(
        scope: CoroutineScope,
        params: Params,
        onSuccess: (List<DomainEntityPengpong>) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        scope.launch(Dispatchers.IO) {
            pengpongRepository.getList().runCatching(onSuccess).onFailure(onFailure)

            /*kotlin.runCatching { pengpongRepository.getList() }.onSuccess {
                withContext(Dispatchers.Main) {

                }
            }.onFailure {

            }*/
        }
    }
}
