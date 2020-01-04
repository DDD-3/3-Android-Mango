package com.mango.domain

import com.mango.domain.entity.DomainEntityShop
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ShopUseCase constructor(
    private val shopRepository: ShopRepository
) : BaseUseCase<ShopUseCase.Params, List<DomainEntityShop>> {

    data class Params(val number: Int)

    override fun invoke(
        scope: CoroutineScope,
        params: Params,
        onSuccess: (List<DomainEntityShop>) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        scope.launch(Dispatchers.IO) {
            shopRepository.getList().runCatching(onSuccess).onFailure(onFailure)

            /*kotlin.runCatching { pengpongRepository.getList() }.onSuccess {
                withContext(Dispatchers.Main) {

                }
            }.onFailure {

            }*/
        }
    }
}
