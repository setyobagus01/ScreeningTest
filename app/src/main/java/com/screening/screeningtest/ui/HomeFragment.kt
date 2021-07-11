package com.screening.screeningtest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.screening.screeningtest.R
import com.screening.screeningtest.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding as FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnNext.setOnClickListener {
            if (binding.nameEditText.text.isNullOrEmpty()) {
                binding.nameEditText.error = "Field cannot be blank"
            } else {

                if(isPalindrome(binding.nameEditText.text.toString())) {
                    Toast.makeText(context, "isPalindrome", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "not palindrome", Toast.LENGTH_SHORT).show()
                }

                val fragment = ChooserFragment()
                val args = Bundle().apply {
                    putString(ChooserFragment.USER_NAME, binding.nameEditText.text.toString())
                }
                fragment.arguments = args

                parentFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .addToBackStack(null)
                    .commit()
            }

        }
    }

    override fun onResume() {
        super.onResume()
        activity?.actionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        activity?.actionBar?.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun isPalindrome(word: String): Boolean {
        val re = "/[^a-z0-9]+/g".toRegex()
        val palindrome = word.toLowerCase().replace(re, "")
        return palindrome.replace("\\s".toRegex(), "") == palindrome.split("").reversed().joinToString("").replace(re, "").replace("\\s".toRegex(), "")

    }
}