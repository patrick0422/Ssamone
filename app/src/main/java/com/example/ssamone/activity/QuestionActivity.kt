package com.example.ssamone.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.ssamone.db.question.QuestionDao
import com.example.ssamone.db.question.QuestionDatabase
import com.example.ssamone.databinding.ActivityQuestionBinding
import com.example.ssamone.db.user.UserDao
import com.example.ssamone.db.user.UserDatabase

class QuestionActivity : AppCompatActivity() {
    val binding by lazy { ActivityQuestionBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val qService = QuestionDatabase.getInstance(applicationContext)!!.dao()
        val uService = UserDatabase.getInstance(applicationContext)!!.dao()

        // index는 0부터 시작하지만 질문의 기본키는 1부터 시작하므로 1을 더해준다
        val qNum = intent.getIntExtra("qNum", -1) + 1

        binding.answerSubmit.setOnClickListener {
            onAnswerSubmit(qService, uService, qNum)
        }
        binding.diarySubmit.setOnClickListener {
            onDiarySubmit(qService, uService, qNum)
        }

        Log.d(TAG, qNum.toString())

        initQuestion(qService, qNum)
    }
    // 답변을 제출
    private fun onAnswerSubmit(qService: QuestionDao, uService: UserDao, qNum: Int) {
        // 답변을 저장
        qService.updateAnswer(qNum, binding.answer.text.toString())

        uService.setProgress(1, qNum + 1)

        binding.tvAnswer.text = "당신의 답변: ${binding.answer.text}"

        binding.answerWrap.visibility = View.GONE
        binding.tvAnswer.visibility = View.VISIBLE

        Toast.makeText(applicationContext, "답변이 저장되었습니다.", Toast.LENGTH_SHORT).show()

        // 일기 쓰는 공간을 활성화
        openDiary()
    }
    private fun openDiary() {
        binding.diaryWrap.visibility = View.VISIBLE
    }
    private fun onDiarySubmit(qService: QuestionDao, uService: UserDao, qNum: Int) {
        qService.updateDiary(qNum, binding.diary.text.toString())

        binding.tvDiary.text = "오늘의 한줄: ${binding.diary.text}"

        binding.diaryWrap.visibility = View.GONE
        binding.tvDiary.visibility = View.VISIBLE
    }

    // 질문을 화면에 표시
    private fun initQuestion(service: QuestionDao, qNum: Int) {
        Thread {
            // 질문 번호로 질문을 요청
            var question = service.getQuestion(qNum)

            runOnUiThread {
                binding.qNum.text = "#${question.number}"
                binding.qContent.text = question.content

                if (question.answer.isNotBlank()) {
                    binding.tvAnswer.text = "당신의 답변: ${question.answer}"

                    binding.answerWrap.visibility = View.GONE
                    binding.tvAnswer.visibility = View.VISIBLE
                }
                if (question.diary.isNotBlank()) {
                    binding.tvDiary.text = "당신의 한줄: ${question.diary}"

                    binding.diaryWrap.visibility = View.GONE
                    binding.tvDiary.visibility = View.VISIBLE
                }
            }
        }.run()
    }
}