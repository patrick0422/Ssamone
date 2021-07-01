package com.example.ssamone.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ssamone.fragment.DisplayFragment
import com.example.ssamone.fragment.ListFragment
import com.example.ssamone.fragment.MainFragment
import com.example.ssamone.R
import com.example.ssamone.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

const val TAG = "Ssamone"

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bottomNav.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.itemMain -> setFrag(0)
                R.id.itemList -> setFrag(1)
                R.id.itemDisplay -> setFrag(2)
            }
            true
        })

        setFrag(0)
    }

    private fun setFrag(n: Int) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        when (n) {
            0 -> {
                ft.replace(binding.display.id, MainFragment())
                ft.commit()
            }
            1 -> {
                ft.replace(binding.display.id, ListFragment())
                ft.commit()
            }
            2 -> {
                ft.replace(binding.display.id, DisplayFragment())
                ft.commit()
            }
        }
    }
}