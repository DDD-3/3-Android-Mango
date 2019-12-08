package com.mango.data


//Example
/*

class GithubRepositoryImpl constructor(
    private val githubService: GithubService,
    private val githubMapper: GithubMapper
) : GithubRepository {

    override suspend fun getGithubs(
        userId: String,
        page: Int,
        perPage: Int
    ): List<DomainEntityGithub> {
        return githubMapper.mapFromEntity(
            githubService.getSearchUsers(userId, page, perPage)
        )
    }
}*/
