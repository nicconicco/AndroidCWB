package carlos.nicolau.galves.core.utils

interface Mapper<in E, T>{
    fun mapFrom(from: E): T
}