package com.dacs.vku.ui.fragments.Authentication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.dacs.vku.R
import com.dacs.vku.models.UserData
import com.dacs.vku.databinding.FragmentProfileFragmentBinding


class Profile_fragment : Fragment(R.layout.fragment_profile_fragment) {
    private var _binding: FragmentProfileFragmentBinding? = null
    private val binding get() = _binding!!
    private var userData: UserData? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userData = arguments?.getSerializable("userData") as? UserData ?: getUserDataFromPreferences()

        Log.e("VKUUUUUU", userData.toString())
        _binding = FragmentProfileFragmentBinding.bind(view)

        binding.profileEmail.text = userData?.email
        binding.profileName.text = userData?.username
        Glide.with(this)
            .load(userData?.profilePictureUrl)
            .into(binding.profileURL)

        binding.btnAlarm.setOnClickListener {
            navigateToSeminarFragment()

        }
        binding.btnCalendar.setOnClickListener {
            navigateToScheduleFragment()
        }

        binding.btnSignOut.setOnClickListener {
            navigateBackToLoginRegister()
        }
    }

    private fun navigateBackToLoginRegister() {
        val sharedPreferences = requireContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putString("user_email", null)
            putString("user_name", null)
            putString("user_id", null)
            putString("profile_picture_url", null)
            apply()
        }
        findNavController().navigate(R.id.action_ProfileFragment_to_LoginRegister)

    }
    private fun getUserDataFromPreferences(): UserData? {
        val sharedPreferences = requireContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("user_name", null)
        val email = sharedPreferences.getString("user_email", null)
        val userId = sharedPreferences.getString("user_id", null)
        val profilePictureUrl = sharedPreferences.getString("profile_picture_url", null)

        return if (email != null && username != null && profilePictureUrl != null) {
            UserData(username, email, userId, profilePictureUrl)
        } else {
            null
        }
    }
    private fun navigateToScheduleFragment() {
        val bundle = Bundle().apply {
            putSerializable("userData", userData)
        }

        Log.e("VKUUU", bundle.toString())
        try {
            Log.e("VKUUUUU", "Bundle $bundle")
            findNavController().navigate(R.id.action_ProfileFragment_to_ScheduleFragment, bundle)
        } catch (e: IllegalArgumentException) {
            Log.e("NavigationError", "Navigation failed: ${e.message}")
        }
    }

    private fun navigateToSeminarFragment() {
        val bundle = Bundle().apply {
            putSerializable("userData", userData)
        }

        Log.e("VKUUU", bundle.toString())
        try {
            Log.e("VKUUUUU", "Bundle $bundle")
            findNavController().navigate(R.id.action_ProfileFragment_to_Seminar, bundle)
        } catch (e: IllegalArgumentException) {
            Log.e("NavigationError", "Navigation failed: ${e.message}")
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


