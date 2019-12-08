package com.mango.domain

/*
Example

class GithubUseCase constructor(
    private val githubRepository: GithubRepository
) : BaseUseCase<GithubUseCase.Params, List<DomainEntityGithub>> {

    data class Params(val userId: String, val page: Int, val perPage: Int)

    override fun invoke(
        scope: CoroutineScope,
        params: Params,
        onSuccess: (List<DomainEntityGithub>) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        scope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                githubRepository.getGithubs(
                    params.userId,
                    params.page,
                    params.perPage
                )
            }.onSuccess {
                onSuccess(it)
            }.onFailure {
                onFailure(it)
            }
        }
    }
}*/
