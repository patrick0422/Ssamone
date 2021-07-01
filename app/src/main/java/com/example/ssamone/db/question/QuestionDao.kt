package com.example.ssamone.db.question

import androidx.room.*

@Dao
interface QuestionDao {

    // 모든 질문들을 가져오기
    @Query("SELECT * FROM questions")
    fun getAllQuestions(): List<Question>

    // 질문 가져오기
    @Query("SELECT * FROM questions WHERE number=:number")
    fun getQuestion(number: Int): Question

    // 답변한 모든 질문들을 가져오기
    @Query("""SELECT * FROM questions WHERE content IS NOT NULL OR NOT TRIM(content) = "" OR NOT TRIM(content) = '' """)
    fun getAnsweredQuestions(): List<Question>

    // 답변하지 않은 모든 질문들을 가져오기
    @Query("""SELECT * FROM questions WHERE content IS NULL OR TRIM(content) = "" OR TRIM(content) = '' """)
    fun getUnAnsweredQuestions(): List<Question>

    // 일정 번호까지의 질문들을 가져오기
    @Query("SELECT * FROM questions WHERE number <= :progress")
    fun getProgressQuestions(progress: Int): List<Question>

    // 질문의 갯수를 가져오기
    @Query("SELECT COUNT(*) FROM questions")
    fun getQuestionCount(): Int



    // 질문의 답변 수정하기
    @Query("UPDATE questions SET answer=:answer WHERE number=:number")
    fun updateAnswer(number: Int, answer: String)
    // 질문의 일기 수정하기
    @Query("UPDATE questions SET diary=:diary WHERE number=:number")
    fun updateDiary(number: Int, diary: String)

    // 질문 추가 (초기화용)
    @Insert
    fun addQuestion(question: Question)
    // 질문 리스트로 추가 (초기화용)
    @Insert
    fun addQuestions(questions: List<Question>)
}