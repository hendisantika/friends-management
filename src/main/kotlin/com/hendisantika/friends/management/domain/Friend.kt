package com.hendisantika.friends.management.domain

import jakarta.persistence.*
import org.springframework.security.core.userdetails.User

@Entity
data class Friend(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        var name: String,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        var user: User
)
