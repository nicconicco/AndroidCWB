package carlos.nicolau.galves.core.utils

interface Mapper<E, T>{
    fun mapFrom(from: E): T
    fun reverseFrom(from: T): E
}