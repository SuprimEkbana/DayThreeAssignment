package com.np.suprimpoudel.day3assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.np.suprimpoudel.day3assignment.databinding.FragmentABinding

class FragmentA : Fragment() {

    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentABinding.bind(view)

        initListener()
    }

    private fun initListener() {
        binding.btnSubmit.setOnClickListener {
            passData()
        }
    }

    private fun passData() {
        val action = FragmentADirections.actionFragmentAToProfilePage("Suprim", 21)
        findNavController().navigate(action)
    }
}