package com.example.shoestore.details

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentDetailsBinding
import com.example.shoestore.shoe_list.ShoeListViewModel

class DetailsFragment : Fragment(), TextWatcher {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var detailsViewModel: DetailsViewModel
    private val shoeViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        detailsViewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        binding.detailsViewModel = detailsViewModel
        binding.lifecycleOwner = this

        binding.shoeListConfirmBtn.setOnClickListener {
            val newShoe = detailsViewModel.addNewShoe()
            shoeViewModel.addNewShoeItem(newShoe)
            findNavController().navigate(R.id.action_detailsFragment_to_shoeListFragment)
        }

        binding.shoeNameEdt.addTextChangedListener(this)
        binding.shoeCompanyEdt.addTextChangedListener(this)
        binding.shoeSizeEdt.addTextChangedListener(this)
        binding.shoeDescEdt.addTextChangedListener(this)

        binding.shoeListCancelBtn.setOnClickListener {
            findNavController().navigate(R.id.action_detailsFragment_to_shoeListFragment)
        }

        return binding.root
    }//end onCreateView()

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }//end beforeTextChanged()

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        binding.shoeListConfirmBtn.isEnabled =
            binding.shoeNameEdt.text!!.isNotEmpty() && binding.shoeCompanyEdt.text!!.isNotEmpty() && binding.shoeSizeEdt.text?.isNotEmpty()!! && binding.shoeDescEdt.text!!.isNotEmpty()
    }//end onTextChanged()

    override fun afterTextChanged(p0: Editable?) {

    }//end afterTextChanged()

}//end class