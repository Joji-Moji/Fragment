package com.gatsu.fragment

import android.animation.PropertyValuesHolder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.gatsu.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFrag(BlankFragment.newInstance(), R.id.frame1)
        openFrag(BlankFragment2.newInstance(), R.id.frame2)

        dataModel.message.observe(this) {
            binding.textView.text = it
        }


    }


    private fun openFrag(f: Fragment, idHolder: Int){
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}