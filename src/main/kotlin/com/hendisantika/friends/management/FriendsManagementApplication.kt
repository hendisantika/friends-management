package com.hendisantika.friends.management

import com.hendisantika.friends.management.domain.Friend
import com.hendisantika.friends.management.domain.User
import com.hendisantika.friends.management.repository.FriendsRepo
import com.hendisantika.friends.management.repository.UserRepo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class FriendsManagementApplication {
    val logger = LoggerFactory.getLogger(FriendsManagementApplication::class.java)

    @Autowired
    val fr: FriendsRepo? = null

    @Bean
    fun init(ur: UserRepo) = CommandLineRunner {
        //        val user1 = User(1, "hendisantika@yahoo.co.id", listOf(fr1))
        val usr1 = User(1L, "user1@example.com")
        val usr2 = User(2L, "user2@example.com")
        val usr3 = User(3L, "user3@example.com")
        val usr4 = User(4L, "user4@example.com")
        val usr5 = User(5L, "user5@example.com")

        val fr1 = Friend(1L, "friend1@example.com", usr1)
        val fr2 = Friend(2L, "friend2@example.com", usr2)
        val fr3 = Friend(3L, "friend3@example.com", usr3)
        val fr4 = Friend(4L, "friend4@example.com", usr4)
        val fr5 = Friend(5L, "friend5@example.com", usr5)

        ur.save(usr1)
        ur.save(usr2)
    }

}


fun main(args: Array<String>) {
    SpringApplication.run(FriendsManagementApplication::class.java, *args)
}




