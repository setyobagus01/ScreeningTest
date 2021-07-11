package com.screening.screeningtest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.screening.screeningtest.R
import com.screening.screeningtest.databinding.FragmentChooserBinding
import com.screening.screeningtest.ui.event.EventFragment
import com.screening.screeningtest.ui.guest.GuestFragment


class ChooserFragment : Fragment() {
    private var _binding: FragmentChooserBinding? = null
    private val binding get() = _binding as FragmentChooserBinding
    private var guestName: String? = null
    private var eventName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            eventName = savedInstanceState.getString(EVENT_NAME)
            binding.btnEvent.text = if (eventName.isNullOrEmpty()) "Pilih Event" else eventName
            guestName = savedInstanceState.getString(GUEST_NAME)
            binding.btnGuest.text = if (guestName.isNullOrEmpty()) "Pilih Guest" else guestName
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooserBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            eventName = bundle.getString(EVENT_NAME)
            binding.btnEvent.text = if (eventName.isNullOrEmpty()) "Pilih Event" else eventName
            guestName = bundle.getString(GUEST_NAME)
            binding.btnGuest.text = if (guestName.isNullOrEmpty()) "Pilih Guest" else guestName
            val guestBirth = bundle.getString(GUEST_BIRTH)?.toInt()
            val guestPrimeNumber = bundle.getString(GUEST_PRIME)
            if (guestBirth != null) {
                when {
                    guestBirth % 2 == 0 && guestBirth % 3 == 0 -> Toast.makeText(
                        context,
                        "iOS and $guestPrimeNumber",
                        Toast.LENGTH_SHORT
                    ).show()
                    guestBirth % 2 == 0 -> Toast.makeText(context, "Blackberry and $guestPrimeNumber", Toast.LENGTH_SHORT)
                        .show()
                    guestBirth % 3 == 0 -> Toast.makeText(context, "Android and $guestPrimeNumber", Toast.LENGTH_SHORT)
                        .show()
                    else -> Toast.makeText(context, "Feature Phone and $guestPrimeNumber", Toast.LENGTH_SHORT).show()
                }
            }
        }

        if (arguments != null) {
            val inputText = arguments?.getString(USER_NAME)
            binding.nameTextView.text = inputText
        }

        binding.btnEvent.setOnClickListener {

            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_container, EventFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.btnGuest.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_container, GuestFragment())
                .addToBackStack(null)
                .commit()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(GUEST_NAME, guestName)
        outState.putString(EVENT_NAME, eventName)
    }

    companion object {
        const val USER_NAME = "USER_NAME"
        const val EVENT_NAME = "EVENT_NAME"
        const val GUEST_NAME = "GUEST_NAME"
        const val GUEST_BIRTH = "GUEST_BIRTH"
        const val GUEST_PRIME = "GUEST_PRIME"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}