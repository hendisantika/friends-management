package com.hendisantika.friends.management.dto

import com.hendisantika.friends.management.domain.Friend
import java.util.*


/**
 * Created by hendisantika on 7/12/17.
 */
data class FriendsDTO(
        var success: Boolean = false,
        var friends: List<Optional<Friend?>?>,
        var count: Int = 0)