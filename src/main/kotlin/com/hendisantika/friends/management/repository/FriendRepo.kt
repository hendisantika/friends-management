package com.hendisantika.friends.management.repository

import com.hendisantika.friends.management.domain.Friend
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * Created by hendisantika on 7/12/17.
 */
interface FriendRepo : PagingAndSortingRepository<Friend, String> {
}