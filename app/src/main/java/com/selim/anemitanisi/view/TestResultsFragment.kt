package com.selim.anemitanisi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.selim.anemitanisi.adapters.ResultsAdapter
import com.selim.anemitanisi.data.AnemiaDatabase
import com.selim.anemitanisi.databinding.FragmentTestResultsBinding


class TestResultsFragment : Fragment() {
    private var db: AnemiaDatabase? = null
    private val adapter: ResultsAdapter by lazy { ResultsAdapter() }
    private var binding: FragmentTestResultsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        db = AnemiaDatabase.getDatabase(requireContext())


        // Inflate the layout for this fragment
        binding = FragmentTestResultsBinding.inflate(inflater, container, false)
        binding!!.lifecycleOwner = this
        setupRecyclerview()
        adapter.setData(db!!.anemiaDao().getAll())

        return binding!!.root
    }

    private fun setupRecyclerview() {
        val recyclerView = binding?.recyclerView
        if (recyclerView != null) {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(context)
        }
    }


}