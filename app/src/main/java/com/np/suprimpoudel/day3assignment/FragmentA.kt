package com.np.suprimpoudel.day3assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.np.suprimpoudel.day3assignment.databinding.FragmentABinding
import java.lang.Exception

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
        val name = binding.edtName.text.toString()
        val age = binding.edtAge.text.toString()
        val address = binding.edtAddress.text.toString()
        val email = binding.edtEmailAddress.text.toString()
        val phoneNumber = binding.edtPhoneNumber.text.toString()

        if(name.isNotEmpty() && age.isNotEmpty() && address.isNotEmpty() && email.isNotEmpty() && phoneNumber.isNotEmpty()) {
            try {
                val ageInt = age.toInt()

                val action = FragmentADirections.actionFragmentAToProfilePage(
                    personName = name,
                    age = ageInt,
                    address = address,
                    emailAddress = email,
                    phoneNumber = phoneNumber
                )
                findNavController().navigate(action)

            } catch (e: Exception) {
                Toast.makeText(context, e.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, "Please enter all fields", Toast.LENGTH_SHORT).show()
        }
    }
}