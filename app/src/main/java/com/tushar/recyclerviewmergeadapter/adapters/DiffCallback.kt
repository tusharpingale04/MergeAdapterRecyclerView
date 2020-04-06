package com.tushar.recyclerviewmergeadapter.adapters

import androidx.recyclerview.widget.DiffUtil
import com.tushar.recyclerviewmergeadapter.model.ListItem

val diffCallback = object : DiffUtil.ItemCallback<ListItem>() {
    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
        oldItem == newItem

    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
        oldItem.value == newItem.value
}