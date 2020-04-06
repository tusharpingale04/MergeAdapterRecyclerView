package com.tushar.recyclerviewmergeadapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.tushar.recyclerviewmergeadapter.base.BaseAdapter
import com.tushar.recyclerviewmergeadapter.databinding.RowItemMyadapterBinding
import com.tushar.recyclerviewmergeadapter.model.ListItem

class MyAdapter(private val callBack: (ListItem) -> Unit) : BaseAdapter<ListItem>(diffCallback) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val mBinding = RowItemMyadapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewModel = MyAdapterViewModel()
        mBinding.vm = viewModel
        mBinding.rootView.setOnClickListener {
            mBinding.vm?.item?.get()?.let { callBack.invoke(it) }
        }
        return mBinding
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        (binding as RowItemMyadapterBinding).vm?.item?.set(getItem(position))
        binding.executePendingBindings()
    }

}

