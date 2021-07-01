package com.example.ssamone.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.ssamone.db.question.Question
import com.example.ssamone.R
import com.example.ssamone.activity.QuestionActivity

class ListAdapter(val questionList: ArrayList<Question>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = inflater.inflate(R.layout.ltem, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = questionList[position]

        holder.tvNum.text = "#${item.number}번"
        holder.tvContent.text = item.content
    }

    override fun getItemCount(): Int = questionList.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, QuestionActivity::class.java)
                intent.putExtra("qNum", adapterPosition)

                ContextCompat.startActivity(itemView.context, intent, null)
            }
        }
        val tvNum: TextView = itemView.findViewById(R.id.tvNum)
        val tvContent: TextView = itemView.findViewById(R.id.tvContent)


    }
}