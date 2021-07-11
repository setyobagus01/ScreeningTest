package com.screening.screeningtest.ui.guest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.screening.screeningtest.core.data.utils.DataState
import com.screening.screeningtest.core.domain.model.Guest
import com.screening.screeningtest.core.ui.event.GuestAdapter
import com.screening.screeningtest.databinding.FragmentGuestBinding
import com.screening.screeningtest.ui.ChooserFragment
import com.screening.screeningtest.utils.DataModification
import com.screening.screeningtest.utils.MainStateEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuestFragment : Fragment() {
    private var _binding: FragmentGuestBinding? = null
    private val binding get() = _binding as FragmentGuestBinding

    private val viewModel: GuestViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGuestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setStateEvent(MainStateEvent.GetGuestEvent)
        val guestAdapter = GuestAdapter()
        viewModel.dataState.observe(viewLifecycleOwner, { guest ->
            when (guest) {
                is DataState.Success<List<Guest>> -> {
                    guestAdapter.setGuest(guest.data)
                }
                is DataState.Error -> {
                    Toast.makeText(context, guest.exception.message, Toast.LENGTH_SHORT)
                }
                DataState.Loading -> {

                }
            }
        })

        binding.rvGuest.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = guestAdapter
            setHasFixedSize(true)
        }

        guestAdapter.onItemClick = { selectedData ->
            setFragmentResult("requestKey", bundleOf(ChooserFragment.GUEST_NAME to selectedData.name, ChooserFragment.GUEST_BIRTH to DataModification.dayConverter(selectedData.birthDate)))
            parentFragmentManager.popBackStackImmediate()
        }
    }
}