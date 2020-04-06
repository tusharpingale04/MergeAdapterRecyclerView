package com.tushar.recyclerviewmergeadapter.adapters

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.tushar.recyclerviewmergeadapter.model.ListItem

class YourAdapterViewModel : ViewModel() {
    var item = ObservableField<ListItem>()
}