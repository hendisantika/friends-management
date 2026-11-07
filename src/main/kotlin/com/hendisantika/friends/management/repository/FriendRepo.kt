package com.hendisantika.friends.management.repository

import com.hendisantika.friends.management.domain.Friend
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by hendisantika on 7/12/17.
 */
interface FriendRepo : JpaRepository<Friend, Long> {
    fun findByUserEmail(email: String): List<Friend>
}
