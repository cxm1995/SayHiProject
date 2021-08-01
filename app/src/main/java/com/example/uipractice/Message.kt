package com.example.uipractice

/**
 * created by cxm1995
 * on 2021/8/1 2:46
 */
class Message(val content: String, val type: Int) {
    companion object {
        const val SEND_MESSAGE = 1
        const val RECEIVE_MESSAGE = 2
    }
}