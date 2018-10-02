package io.rybalkinsd.kotlinbootcamp.practice

class RawProfile(val rawData: String)

enum class DataSource {
    FACEBOOK,
    VK,
    LINKEDIN
}

sealed class Profile(
    var id: Long,
    var firstName: String? = null,
    var lastName: String? = null,
    var age: Int? = null,
    var dataSource: DataSource
)

/**
 * Task #1
 * Declare classes for all data sources
 */
class FacebookProfile(id: Long) : Profile(dataSource = DataSource.FACEBOOK, id = id)

/**
 * Task #2
 * Find the average age for each datasource (for profiles that has age)
 */
val avgAge: Map<DataSource, Double> = TODO()

/**
 * Task #3
 * Group all user ids together with all profiles of this user.
 * We can assume users equality by : firstName & lastName & age
 */
val groupedProfiles: Map<Long, List<Profile>> = TODO()

/**
 * Here are Raw profiles to analyse
 */
val rawProfiles = listOf(
    RawProfile("""
            fisrtName=alice,
            age=16,
            source=facebook
            """.trimIndent()
    ),
    RawProfile("""
            fisrtName=Dent,
            lastName=kent,
            age=88,
            source=linkedin
            """.trimIndent()
    ),
    RawProfile("""
            fisrtName=alla,
            lastName=OloOlooLoasla,
            source=vk
            """.trimIndent()
    ),
    RawProfile("""
            fisrtName=bella,
            age=36,
            source=vk
            """.trimIndent()
    ),
    RawProfile("""
            fisrtName=angel,
            age=I will not tell you =),
            source=facebook
            """.trimIndent()
    ),

    RawProfile(
        """
            lastName=carol,
            source=vk
            age=49,
            """.trimIndent()
    ),
    RawProfile("""
            fisrtName=bob,
            lastName=John,
            age=47,
            source=linkedin
            """.trimIndent()
    ),
    RawProfile("""
            lastName=kent,
            fisrtName=dent,
            age=88,
            source=facebook
            """.trimIndent()
    )
)
