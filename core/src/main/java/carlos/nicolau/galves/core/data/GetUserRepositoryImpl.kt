package carlos.nicolau.galves.core.data

class GetUserRepositoryImpl(private val dataSource: IGetUserDataSource) : IGetUserRepository {
    override fun execute(username: String, password: String) =
        dataSource.execute("","")
}