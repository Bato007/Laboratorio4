package com.example.guatemalalaboratorio4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class Communicator: ViewModel(){

    val message = MutableLiveData<Any>()

    fun setMsgCommunicator(msg: String){
        message.value = msg
    }

}