package com.example.fishermenhandbook

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener(this)

        var list = ArrayList<ListItem>()

        list.addAll(fillArrays(resources.getStringArray(R.array.fish),
            resources.getStringArray(R.array.fish_content),
        getImageId(R.array.fish_image_array)))

        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        rcView.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.fish -> {
                Toast.makeText(this, "This is Fish", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.fish),
                    resources.getStringArray(R.array.fish_content),
                    getImageId(R.array.fish_image_array)))
            }
            R.id.na -> {
                Toast.makeText(this, "This is nazhivko", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.nazhivko),
                    resources.getStringArray(R.array.nazhivko_content),
                    getImageId(R.array.nazhivko_image_array)))
            } R.id.sna -> Toast.makeText(this,"This is snasty",Toast.LENGTH_SHORT).show()
            R.id.history -> Toast.makeText(this,"This is history",Toast.LENGTH_SHORT).show()

        }
        driverLayout.closeDrawer(GravityCompat.START)

        return true
    }

    fun fillArrays(titleArray:Array<String>,contentArray: Array<String>,imageArray:IntArray):List<ListItem>{
        var listItemArray = ArrayList<ListItem>()
        for (n in 0..titleArray.size - 1) {
            var listItem = ListItem(imageArray[n],titleArray[n],contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    fun getImageId(imageArrayId:Int):IntArray{
        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)

        for (i in ids.indices){
            ids[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
    }

}