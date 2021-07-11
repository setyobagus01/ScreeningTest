package com.screening.screeningtest.ui.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.LinearLayoutManager
import com.screening.screeningtest.core.data.utils.DataDummy
import com.screening.screeningtest.core.ui.event.EventAdapter
import com.screening.screeningtest.databinding.FragmentEventBinding
import com.screening.screeningtest.ui.ChooserFragment


class EventFragment : Fragment() {

    private var _binding: FragmentEventBinding? = null
    private val binding get() = _binding as FragmentEventBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val eventAdapter = EventAdapter()
        eventAdapter.setEvents(DataDummy.getEvents())
        binding.rvEvent.apply {
            setHasFixedSize(true)
            adapter = eventAdapter
            layoutManager = LinearLayoutManager(context)
        }

        eventAdapter.onItemClick = { selectedData ->
            setFragmentResult("requestKey", bundleOf(ChooserFragment.EVENT_NAME to selectedData.name))

            parentFragmentManager.popBackStackImmediate()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}