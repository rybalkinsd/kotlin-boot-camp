package io.rybalkinsd.kotlinbootcamp.dao

interface Dao<T> {
    /**
     * SELECT * from ...
     */
    val all: List<T>

    /**
     * SELECT * ... WHERE cond0 AND ... AND condN
     */
    fun getAllWhere(vararg conditions: String): List<T>

    /**
     * INSERT INTO ...
     */
    fun insert(t: T)

    /**
     * SELECT * from ... WHERE id=
     * @return Optional.empty() if nothing found
     */
    fun findById(id: Int): T? = getAllWhere("id=$id").firstOrNull()
}
