package com.example.ite_app

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ite_app.databinding.DetailActivityBinding

class DetailFragment : Fragment(R.layout.detail_activity) {

    private var _binding: DetailActivityBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewBinding
        _binding = DetailActivityBinding.bind(view)

        // Now you can safely use binding
        // binding.textView.text = "Hello"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Avoid memory leaks
    }
}