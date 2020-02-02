package com.mango.domain

import com.mango.domain.entity.DomainEntityShop
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ShopUseCase constructor(
    private val shopRepository: ShopRepository
) : BaseUseCase {

    data class Params(val number: Int)

    fun execute(
        scope: CoroutineScope,
        onSuccess: (List<DomainEntityShop>) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        scope.launch {
            shopRepository.getList().runCatching(onSuccess).onFailure(onFailure)
        }
    }

}
