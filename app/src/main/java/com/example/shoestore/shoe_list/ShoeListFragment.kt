package com.example.shoestore.shoe_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.CustomLayoutBinding
import com.example.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val shoeViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        binding.shoeViewModel = shoeViewModel
        binding.lifecycleOwner = this

        shoeViewModel.shoeItem.observe(viewLifecycleOwner, Observer { newShoe ->
            for (item in newShoe) {
                val customViewBinding: CustomLayoutBinding = DataBindingUtil.inflate(
                    layoutInflater,
                    R.layout.custom_layout,
                    container,
                    false
                )
                customViewBinding.shoeItem = item
                binding.linearLayoutData.addView(customViewBinding.root)
            }//end for()
        })

        binding.floatingBtn.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_detailsFragment)
        }

        return binding.root
    }//end onCreateView()
}//end class