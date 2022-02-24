package com.gatsu.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.gatsu.fragment.databinding.Fragment1Binding


class BlankFragment : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
     binding = Fragment1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonactivity1.setOnClickListener {
            dataModel.message.value = "From fragment 1"
        }
        binding.buttonfrag1.setOnClickListener {
            dataModel.messageFragment2.value = "От 1 фрагмента"
        }

        dataModel.messageFragment1.observe(activity as LifecycleOwner){
            binding.textfrag1.text = it
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
            }
    }
