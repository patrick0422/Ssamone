package com.example.ssamone.db.user

import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE number = :number")
    fun getUser(number: Int): User

    @Insert
    fun addUser(user: User)

    @Query("UPDATE user SET progress = :progress WHERE number = :number")
    fun setProgress(number: Int, progress: Int)
}