package com.mango.domain

import com.mango.domain.entity.DomainEntityDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailUseCase constructor(
    private val repository: ShopRepository
) : BaseUseCase<DetailUseCase.Params, DomainEntityDetail> {

    data class Params(val id: Int)

    override fun invoke(
        scope: CoroutineScope,
        params: Params,
        onSuccess: (DomainEntityDetail) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        scope.launch(Dispatchers.IO) {
            repository.detail(params.id).runCatching(onSuccess).onFailure(onFailure)
        }
    }
}