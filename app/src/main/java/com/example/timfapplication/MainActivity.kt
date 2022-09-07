package com.example.timfapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val jobFragment = JobFragment()
        val calculateFragment = CalculateFragment()
        val communityFragment = CommunityFragment()
        val reviewFragment = ReviewFragment()

        makeCurrentFragment(homeFragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_homeFragment -> makeCurrentFragment(homeFragment)
                R.id.item_jobFragment -> makeCurrentFragment(jobFragment)
                R.id.item_calculateFragment -> makeCurrentFragment(calculateFragment)
                R.id.item_communityFragment -> makeCurrentFragment(communityFragment)
                R.id.item_reviewFragment -> makeCurrentFragment(reviewFragment)
            }
            true
        }
    }


    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.homeFragment, fragment)
            commit()
        }

}