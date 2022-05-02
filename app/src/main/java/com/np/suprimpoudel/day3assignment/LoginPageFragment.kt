package com.np.suprimpoudel.day3assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.np.suprimpoudel.day3assignment.databinding.FragmentLoginPageBinding

class LoginPageFragment : Fragment() {

    private val args by navArgs<LoginPageFragmentArgs>()
    private lateinit var binding: FragmentLoginPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginPageBinding.bind(view)

        val username = args.username

        binding.edtUsername.setText(username)

        binding.btnLogin.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}