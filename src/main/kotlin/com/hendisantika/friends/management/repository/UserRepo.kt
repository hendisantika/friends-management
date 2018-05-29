package com.hendisantika.friends.management.repository

import com.hendisantika.friends.management.domain.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by hendisantika on 7/17/17.
 */
interface UserRepo : JpaRepository<User, Long>