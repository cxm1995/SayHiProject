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
    RecyclerView.Adapter<SealedMessageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SealedMessageViewHolder {
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

    override fun onBindViewHolder(holder: SealedMessageViewHolder, position: Int) {
        val message = messages[position]
        when (holder) {
            is LeftViewHolder -> holder.tv_receive.text = message.content
            is RightViewHolder -> holder.tv_send.text = message.content
        }
    }

    override fun getItemViewType(position: Int): Int {
        val message = messages[position]
        return message.type
    }
}