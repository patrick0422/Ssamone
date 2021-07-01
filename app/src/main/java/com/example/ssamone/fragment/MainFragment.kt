package com.example.ssamone.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ssamone.activity.QuestionActivity
import com.example.ssamone.activity.TAG
import com.example.ssamone.databinding.FragmentMainBinding
import com.example.ssamone.db.user.UserDatabase

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    val uService by lazy { UserDatabase.getInstance(requireActivity().applicationContext)!!.dao() }
    val progress by lazy { uService.getUser(1).progress }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        setDate(progress)

        binding.TodayWrap.setOnClickListener {
            val intent = Intent(context, QuestionActivity::class.java)
            intent.putExtra("qNum", (progress - 1))

            startActivity(intent)
        }

        return binding.root
    }
    fun setDate(progress: Int) {
        binding.tvDate.text = "Love yourself\nD + $progress"
    }

    override fun onResume() {
        super.onResume()

        setDate(progress)
    }
}