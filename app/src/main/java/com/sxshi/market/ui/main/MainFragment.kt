package com.sxshi.market.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sxshi.market.R
import com.sxshi.market.ui.main.adapter.FruitAdapter
import com.sxshi.market.utils.InjectorUtil
import com.sxshi.market.utils.hideKeyboard
import com.sxshi.market.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var autoAdapter: ArrayAdapter<String>? = null

    private val viewModel: MainViewModel by viewModels {
        InjectorUtil.providerMainViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getFruitNames().observe(this@MainFragment, Observer {
            autoAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, it)
            autoQuery.threshold = 1
            autoQuery.setAdapter(autoAdapter)
        })

        addFruit.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_addFruitFragment)
        }


        btn_start.setOnClickListener {
            val querStr = autoQuery.text.toString()
            requireActivity().hideKeyboard()
            if (querStr.isEmpty()) {
                Toast.makeText(requireContext(), getString(R.string.fruitdesc), Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            list.layoutManager = LinearLayoutManager(requireContext())
            list.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            viewModel.getFruit(fruitName = querStr).observe(this@MainFragment, Observer {
                val fruitAdapter = FruitAdapter(requireContext(), R.layout.layout_item, it)
                list.adapter = fruitAdapter
            })
        }
    }

}
