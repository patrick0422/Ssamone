package com.example.ssamone.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ssamone.activity.TAG
import com.example.ssamone.databinding.FragmentDisplayBinding
import com.example.ssamone.db.user.UserDatabase

class DisplayFragment : Fragment() {
    lateinit var binding: FragmentDisplayBinding

    val uService by lazy { UserDatabase.getInstance(requireActivity().applicationContext)!!.dao() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDisplayBinding.inflate(inflater, container, false)

        val progress = uService.getUser(1).progress

        if (progress >= 10) {
            binding.iv2.visibility = View.VISIBLE
            if (progress >= 20) {
                binding.iv3.visibility = View.VISIBLE
                if(progress >= 30) {
                    binding.iv4.visibility = View.VISIBLE
                }
            }
        }

        return binding.root
    }
}