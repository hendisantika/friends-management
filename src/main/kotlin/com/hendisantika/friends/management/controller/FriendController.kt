package com.hendisantika.friends.management.controller

import com.hendisantika.friends.management.domain.Friend
import com.hendisantika.friends.management.dto.EmailRequest
import com.hendisantika.friends.management.dto.FriendsDTO
import com.hendisantika.friends.management.repository.FriendRepo
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by hendisantika on 7/12/17.
 */
@RestController
@RequestMapping("/api/v1/friends")
class FriendController(private val friendRepo: FriendRepo) {

    private val log = LoggerFactory.getLogger(FriendController::class.java)

    @PostMapping
    fun createFriends(@RequestBody friend: Friend): Map<String, Boolean> {
        friendRepo.save(friend)
        log.info("Data Friend {} saved successfully!", friend)
        return mapOf("success" to true)
    }

    @GetMapping
    fun listAll(): List<Friend> {
        log.info("Getting All Friends Data ...")
        return friendRepo.findAll()
    }

    @PostMapping("/find")
    fun getFriendsByEmail(@RequestBody request: EmailRequest): FriendsDTO {
        val friends = friendRepo.findByUserEmail(request.email).map { it.name }
        log.info("Friends of {} -> {}", request.email, friends)
        return FriendsDTO(success = true, friends = friends, count = friends.size)
    }
}
