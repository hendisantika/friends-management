package com.hendisantika.friends.management.dto

/**
 * Created by hendisantika on 7/12/17.
 */
data class FriendsDTO(
    val success: Boolean = false,
    val friends: List<String> = emptyList(),
    val count: Int = 0
)

data class EmailRequest(val email: String = "")
