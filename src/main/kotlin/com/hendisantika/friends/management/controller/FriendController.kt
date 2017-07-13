package com.hendisantika.friends.management.controller

import com.hendisantika.friends.management.domain.Friend
import com.hendisantika.friends.management.repository.FriendRepo
import org.apache.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*


/**
 * Created by hendisantika on 7/12/17.
 */
@RestController
class FriendController @Autowired constructor(val fr: FriendRepo) {

    val log = LogManager.getLogger(FriendController::class.java.name)

    @PostMapping("/api/v1/friends")
    fun createFriends(@RequestBody friend: Friend?): Map<String, Boolean> {
        if (friend != null) {
            fr.save(friend)
            log.info("Data $friend")
            log.info("Data Friend save successfully!")
            return Collections.singletonMap("success", true)
        } else {
            log.info("Data NULL")
            log.info("Data Friend failed!")
            return Collections.singletonMap("success", false)
        }

    }

//    @GetMapping("/api/v1/friends")
//    @ResponseBody
//    fun getAll():  Map<String, JvmType.Object> {
//        val data = fr.findAll()
//        val frMap = mapOf(
//                "success" to true,
//                "created" to "created"
//        )
//
//        if (data != null){
//            log.info("Getting All Friends Data ...")
//            return frMap
//        }else{
//            log.info("Data NULL")
//            return Collections.singletonMap("success", false)
//        }
//
//    }

    @GetMapping("/api/v1/friends")
    @ResponseBody
    fun listAll(): List<MutableIterable<Friend>> {
        val data = this.fr.findAll()

        if (data != null) {
            log.info("Getting All Friends Data ...")
            return listOf(data)
        } else {
            log.info("All Friends Data NULL ...")
            return listOf(data as Nothing)
        }

    }

    @PostMapping("/api/v1/friends/find")
    fun getFriendsByEmail(@RequestBody email: String): List<ArrayList<String>?> {
        val data = listOf(fr.findOne(email))
        val number = fr.findOne(email)
        log.info("Data -> $data")
        log.info("Jumlah -> $number")

//        val jml = data.count { it.equals("email") }
//        log.info("Jumlah Data --> $jml")

        val map = mapOf(
                "success" to true,
                "friends" to data,
                "count" to 1
        )

        return data.map { it.friends  }


    }


}