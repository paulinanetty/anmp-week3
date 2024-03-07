package com.nmp.adv160921008week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nmp.adv160921008week2.databinding.FragmentOptionBinding


class optionFragment : BottomSheetDialogFragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentOptionBinding
    private val level = arrayOf("Easy", "Medium", "Hard")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentOptionBinding.inflate(inflater,container,false)

        return binding.root
        // Inflate the layout for this fragment
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ArrayAdapter<String>(requireContext(),
            android.R.layout.simple_dropdown_item_1line, level)
        binding.txtLevel.setAdapter(adapter)
    }


}