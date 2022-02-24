package com.gatsu.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.gatsu.fragment.databinding.Fragment2Binding


class BlankFragment2 : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment2Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonactivity2.setOnClickListener {
            dataModel.message.value = "From fragment 2"
        }
        binding.buttonfrag2.setOnClickListener {
            dataModel.messageFragment1.value = "от 2 фрагмента"
        }

        dataModel.messageFragment2.observe(activity as LifecycleOwner) {
            binding.textfrag2.text = it
        }
    }


        companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
        }
}

