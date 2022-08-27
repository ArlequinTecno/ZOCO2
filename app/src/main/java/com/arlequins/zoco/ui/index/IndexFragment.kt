package com.arlequins.zoco.ui.allProducts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.arlequins.zoco.databinding.FragmentAllProductsBinding

class AllProductsFragment : Fragment() {

    private var _binding: FragmentAllProductsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val allProductsViewModel = ViewModelProvider(this)[AllProductsViewModel::class.java]

        _binding = FragmentAllProductsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        allProductsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}