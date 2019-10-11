package com.sxshi.market.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sxshi.market.R
import com.sxshi.market.data.Fruit
import com.sxshi.market.utils.InjectorUtil
import com.sxshi.market.utils.toast
import com.sxshi.market.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_add_fruit.*

class AddFruitFragment : Fragment() {
    companion object {
        fun newInstance() = AddFruitFragment()
    }

    private val viewModel: MainViewModel by viewModels {
        InjectorUtil.providerMainViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_add_fruit, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        btn_add.setOnClickListener {
            val mFruitName = fruitName.text.toString()
            val mFruitCode = fruitCode.text.toString()

            if (mFruitName.isEmpty()) {
                requireActivity().toast("请输入商品名称")
                return@setOnClickListener
            }

            if (mFruitCode.isEmpty()) {
                requireActivity().toast("请输入商品编码")
                return@setOnClickListener
            }

            val fruit = Fruit(mFruitName, mFruitCode)
            viewModel.addFruit(fruit)
            requireActivity().toast("添加成功")
            fruitName.text = null
            fruitCode.text = null
        }
    }
}

