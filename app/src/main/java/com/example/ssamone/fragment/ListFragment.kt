package com.example.ssamone.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ssamone.activity.TAG
import com.example.ssamone.adapter.ListAdapter
import com.example.ssamone.db.question.Question
import com.example.ssamone.db.question.QuestionDatabase
import com.example.ssamone.databinding.FragmentListBinding
import com.example.ssamone.db.user.UserDatabase

class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding

    val qService by lazy { QuestionDatabase.getInstance(requireActivity().applicationContext)!!.dao() }
    val uService by lazy { UserDatabase.getInstance(requireActivity().applicationContext)!!.dao() }

    var progress = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView() Called")

        binding = FragmentListBinding.inflate(inflater, container, false)


        progress = uService.getUser(1).progress

        val list = qService.getProgressQuestions(progress)


        binding.questionList.adapter = ListAdapter(list as ArrayList<Question>)
        binding.questionList.layoutManager = LinearLayoutManager(activity)

        val adapter = binding.questionList.adapter
        binding.questionList.scrollToPosition(adapter!!.itemCount - 1)

        return binding.root
    }
}