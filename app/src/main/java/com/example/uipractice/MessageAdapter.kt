package com.example.uipractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * created by cxm1995
 * on 2021/8/1 2:48
 */
class MessageAdapter(val messages: List<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class LeftViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_receive: TextView = view.findViewById(R.id.tv_receive)
    }

    inner class RightViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_send: TextView = view.findViewById(R.id.tv_send)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == Message.RECEIVE_MESSAGE) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_message_left, parent, false)
            return LeftViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_message_right, parent, false)
            return RightViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messages[position]
        if (holder is LeftViewHolder) {
            holder.tv_receive.text = message.content
        } else if (holder is RightViewHolder) {
            holder.tv_send.text = message.content
        }

    }

    override fun getItemViewType(position: Int): Int {
        val message = messages[position]
        return message.type
    }
}