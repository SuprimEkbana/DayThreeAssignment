package com.np.suprimpoudel.day3assignment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.np.suprimpoudel.day3assignment.databinding.FragmentProfilePageBinding

class ProfilePage : Fragment() {

    private lateinit var binding: FragmentProfilePageBinding

    private val args by navArgs<ProfilePageArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfilePageBinding.bind(view)

        setUpData()
    }

    @SuppressLint("SetTextI18n")
    private fun setUpData() {
        val name = args.personName
        val age = args.age
        val address = args.address
        val email = args.emailAddress
        val phoneNumber = args.phoneNumber

        binding.txtPersonName.text = name
        binding.txtPersonAge.text = "Age: $age"
        binding.txtPersonAddress.text = "Address: $address"
        binding.txtPersonEmailAddress.text = "Email: $email"
        binding.txtPersonPhoneNumber.text = "Phone Number: $phoneNumber"
    }
}