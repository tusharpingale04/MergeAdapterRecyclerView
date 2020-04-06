package com.tushar.recyclerviewmergeadapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.tushar.recyclerviewmergeadapter.base.BaseAdapter
import com.tushar.recyclerviewmergeadapter.databinding.RowItemYouradapterBinding
import com.tushar.recyclerviewmergeadapter.model.ListItem

class YourAdapter(private val callBack: (ListItem) -> Unit) : BaseAdapter<ListItem>(diffCallback) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val mBinding = RowItemYouradapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewModel = YourAdapterViewModel()
        mBinding.vm = viewModel
        mBinding.rootView.setOnClickListener {
            mBinding.vm?.item?.get()?.let { callBack.invoke(it) }
        }
        return mBinding
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        (binding as RowItemYouradapterBinding).vm?.item?.set(getItem(position))
        binding.executePendingBindings()
    }

}