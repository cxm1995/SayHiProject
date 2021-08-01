package com.example.uipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val messages = ArrayList<Message>()
    private var messageAdapter: MessageAdapter? = null // 提到全局

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManager = LinearLayoutManager(this)
        initMessage()
        messageAdapter = MessageAdapter(messages)
        rcv_content.layoutManager = layoutManager
        rcv_content.adapter = messageAdapter

        btn_send.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v) {
            btn_send -> {
                Log.d("MainActivity", "发送消息")
                val content = et_input.text.toString()
                if (content.isNotEmpty()) {
                    val message = Message(content, Message.SEND_MESSAGE)
                    messages.add(message)
                    messageAdapter?.notifyItemInserted(messages.size - 1)//刷新recyceview中的显示
                    rcv_content.scrollToPosition(messages.size - 1)//将recycler定位到最后一行
                    et_input.setText("")
                }
            }
        }
    }

    private fun initMessage() {
        messages.add(Message("小红，你 好 。        ", Message.RECEIVE_MESSAGE))
        messages.add(Message("小白 ，你好！!!!!", Message.SEND_MESSAGE))
        messages.add(Message("今天天 气不错\n......", Message.RECEIVE_MESSAGE))
        messages.add(Message("小红， 你好。        ", Message.RECEIVE_MESSAGE))
        messages.add(Message("小白， 你好！!!!!", Message.SEND_MESSAGE))
        messages.add(Message("今天  天气不错......", Message.RECEIVE_MESSAGE))
        messages.add(Message("小红  ，你好。        ", Message.RECEIVE_MESSAGE))
        messages.add(Message("小白，你好 ！!!!!", Message.SEND_MESSAGE))
        messages.add(Message("今天天气不错 ......", Message.RECEIVE_MESSAGE))
        messages.add(Message("小红 ， 你好。        ", Message.RECEIVE_MESSAGE))
        messages.add(Message("小 白，你好！!!! !", Message.SEND_MESSAGE))
        messages.add(Message("今 天天气不 错......", Message.RECEIVE_MESSAGE))
    }
}