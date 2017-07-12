package com.hendisantika.friends.management.domain

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id


/**
 * Created by hendisantika on 7/12/17.
 */
@Entity
data class Friend (@Id var friends: ArrayList<String>? = null)