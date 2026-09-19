package com.example.androidstudioactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.androidstudioactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val tabTitles = listOf("Aldrei", "Cherry Ann", "Eunice", "Sherline", "Nawaf")

        val pager = findViewById<ViewPager2>(R.id.view_pager)
        val tabs = findViewById<TabLayout>(R.id.tab_layout)

        pager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = fragments.size
            override fun createFragment(position: Int) = fragments[position]
        }

        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}