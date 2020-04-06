package com.tushar.recyclerviewmergeadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import com.tushar.recyclerviewmergeadapter.adapters.MyAdapter
import com.tushar.recyclerviewmergeadapter.adapters.YourAdapter
import com.tushar.recyclerviewmergeadapter.databinding.ActivityMainBinding
import com.tushar.recyclerviewmergeadapter.model.ListItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: MyAdapter
    private lateinit var yourAdapter: YourAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setUpList()
        setUpMergeAdapterRecyclerView()
    }

    private fun setUpList() {
        myAdapter = MyAdapter{ myItem ->
            Toast.makeText(this@MainActivity, "My Item Clicked: ${myItem.value}", Toast.LENGTH_SHORT).show()
        }
        yourAdapter = YourAdapter{ yourItem ->
            Toast.makeText(this@MainActivity, "Your Item Clicked: ${yourItem.value}", Toast.LENGTH_SHORT).show()
        }
        val myList = ArrayList<ListItem>()
        val yourList = ArrayList<ListItem>()
        (0..10).forEach {
            myList.add(ListItem("My Adapter $it"))
            yourList.add(ListItem("Your Adapter $it"))
        }
        myAdapter.submitList(myList)
        yourAdapter.submitList(yourList)
    }

    private fun setUpMergeAdapterRecyclerView() = with(recyclerView){

        layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = MergeAdapter(
            myAdapter,
            yourAdapter
        )
    }
}
