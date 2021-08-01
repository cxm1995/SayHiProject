package com.example.uipractice

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * created by cxm1995
 * on 2021/8/1 13:06
 * 密封类
 */
sealed class SealedMessageViewHolder(view: View) : RecyclerView.ViewHolder(view)

class LeftViewHolder(view: View) : SealedMessageViewHolder(view) {
    val tv_receive: TextView = view.findViewById(R.id.tv_receive)
}

class RightViewHolder(view: View) : SealedMessageViewHolder(view) {
    val tv_send: TextView = view.findViewById(R.id.tv_send)

}
