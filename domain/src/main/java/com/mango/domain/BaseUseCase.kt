package com.mango.domain

import kotlinx.coroutines.CoroutineScope

interface BaseUseCase<in Param, out Type> {

    operator fun invoke(
        scope: CoroutineScope,
        params: Param,
        onSuccess: (Type) -> Unit,
        onFailure : (Throwable) -> Unit
    )

}