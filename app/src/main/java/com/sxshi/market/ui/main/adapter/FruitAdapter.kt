package com.sxshi.market.ui.main.adapter

import android.content.Context
import com.sxshi.market.R
import com.sxshi.market.data.Fruit
import com.zhy.adapter.recyclerview.CommonAdapter
import com.zhy.adapter.recyclerview.base.ViewHolder

class FruitAdapter(context: Context, layoutId: Int, mData: List<Fruit>) :
    CommonAdapter<Fruit>(context, layoutId, mData) {

    override fun convert(holder: ViewHolder?, fruit: Fruit?, position: Int) {
        holder?.setText(R.id.fruitCode, fruit?.fruitCode)
        holder?.setText(R.id.fruitName, fruit?.fruitName)
    }
}