package com.example.ssamone.db.question

import androidx.room.*

@Entity(tableName = "questions")
data class Question (
    @PrimaryKey val number: Int,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "answer") val answer: String,
    @ColumnInfo(name = "diary") val diary: String,
)