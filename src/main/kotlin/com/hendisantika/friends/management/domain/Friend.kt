package com.hendisantika.friends.management.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class Friend(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var name: String = "",

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User? = null
) {
    override fun toString() = "Friend(id=$id, name=$name, user=${user?.email})"
}
