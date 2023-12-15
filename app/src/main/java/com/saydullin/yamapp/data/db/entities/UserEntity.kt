package com.saydullin.yamapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = false) val id: Int = 0,
    val username: String,
    val isRegistered: Boolean,
    val age: Int,
)


