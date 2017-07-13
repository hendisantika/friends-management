package com.hendisantika.friends.management.domain

import java.util.*



/**
 * Created by hendisantika on 7/12/17.
 */
data class FriendsDTO (var success: Boolean = false, var friends: ArrayList<String>? = null, var count: Int = 0)