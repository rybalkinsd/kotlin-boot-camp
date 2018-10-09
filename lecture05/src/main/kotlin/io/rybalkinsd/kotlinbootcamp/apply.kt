package io.rybalkinsd.kotlinbootcamp

class User(val id: Long) {
    var firstName: String? = null
    var lastName: String? = null

    override fun toString(): String {
        return "User(id=$id, firstName=$firstName, lastName=$lastName)"
    }
}
