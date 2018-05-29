package com.hendisantika.friends.management.domain

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne


@Entity
data class Friend(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        var name: String,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        var user: User)
