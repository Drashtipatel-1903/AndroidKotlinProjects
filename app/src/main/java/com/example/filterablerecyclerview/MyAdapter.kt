package com.example.filterablerecyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import java.util.*
import kotlin.collections.ArrayList

class MyAdapter(var context: Context , var dataList : MutableList<Modal>) :
        RecyclerView.Adapter<MyAdapter.ViewHolder>() ,Filterable
{
    var dataFilterList : MutableList<Modal> = ArrayList<Modal>()

    init {
        dataFilterList = dataList
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        var title = itemView.findViewById<TextView>(R.id.title)
        var image = itemView.findViewById<ImageView>(R.id.img_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.raw_layout , parent , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myData = dataFilterList[position]
        holder.image.setImageResource(myData.image)
        holder.title.text = myData.title
    }

    override fun getItemCount(): Int {
        return dataFilterList.size
    }


    override fun getFilter(): Filter {
        return object :Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    dataFilterList = dataList
                } else {
                    val resultList = ArrayList<Modal>()
                    for (row in dataList) {
                        if (row.title.lowercase(Locale.ROOT).contains(
                                constraint.toString().lowercase(
                                    Locale.ROOT
                                )
                            )) {
                            resultList.add(row)
                        }
                    }
                    dataFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = dataFilterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                dataFilterList = results?.values as ArrayList<Modal>
                Log.d("adapterData",dataFilterList.toString())
                notifyDataSetChanged()
            }

        }
    }

}

