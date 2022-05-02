package com.np.suprimpoudel.day3assignment.features.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.np.suprimpoudel.day3assignment.R
import com.np.suprimpoudel.day3assignment.databinding.FragmentBBinding
import com.np.suprimpoudel.day3assignment.features.shared.service.App.Companion.CHANNEL_ID
import com.np.suprimpoudel.day3assignment.features.shared.service.App.Companion.NOTIF_ID

class FragmentB : Fragment() {

    private lateinit var binding: FragmentBBinding
    private lateinit var notificationManagerCompat: NotificationManagerCompat

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBBinding.bind(view)

        notificationManagerCompat = NotificationManagerCompat.from(requireContext())

        binding.btnMakeRequest.setOnClickListener {
            sendNotification()
        }
    }

    private fun sendNotification() {
        val name = binding.edtNameExplicit.text.toString()

        val pendingIntent = findNavController()
            .createDeepLink()
            .setDestination(R.id.loginPageFragment)
            .setGraph(R.navigation.app_navigation)
            .setArguments(LoginPageFragmentArgs(name).toBundle())
            .createPendingIntent()

        val notification = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setContentTitle("Demo")
            .setContentText("Login Here $name")
            .setSmallIcon(R.drawable.ic_baseline_home_24)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        notificationManagerCompat.notify(NOTIF_ID, notification)
    }


}