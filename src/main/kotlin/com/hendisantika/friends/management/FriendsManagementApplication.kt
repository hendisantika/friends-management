package com.hendisantika.friends.management

import com.hendisantika.friends.management.domain.Friend
import com.hendisantika.friends.management.domain.User
import com.hendisantika.friends.management.repository.FriendRepo
import com.hendisantika.friends.management.repository.UserRepo
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class FriendsManagementApplication {

    @Bean
    fun init(userRepo: UserRepo, friendRepo: FriendRepo) = CommandLineRunner {
        (1..5).forEach { i ->
            val user = userRepo.save(User(email = "user$i@example.com"))
            friendRepo.save(Friend(name = "friend$i@example.com", user = user))
        }
    }
}

fun main(args: Array<String>) {
    runApplication<FriendsManagementApplication>(*args)
}
