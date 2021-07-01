package com.example.ssamone.db.user

import androidx.room.*
import java.time.LocalDate

@Entity(tableName = "user")
data class User (
        @PrimaryKey val number: Int,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "dateStarted") val dateStarted: String,
        @ColumnInfo(name = "progress") val progress: Int,
)