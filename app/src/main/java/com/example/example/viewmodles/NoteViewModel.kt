package com.example.example.viewmodles

import com.example.example.model.NoteItem
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import kotlin.collections.ArrayList

class NoteViewModel:ViewModel(),Observable {
    val isStringEmpty = MutableLiveData<Boolean>()
    @Bindable
    val inputPort = MutableLiveData<String>()
    @Bindable
    val inputIp = MutableLiveData<String>()
    val list = MutableLiveData<ArrayList<NoteItem>>()
    private val arraylst = ArrayList<NoteItem>()

    init {
        isStringEmpty.value = false

    }
    fun connectFg() {
        val ip = inputIp.value!!
        val port = inputPort.value!!
        if (ip.isBlank() || port.isBlank()) {
            isStringEmpty.value = true
        } else {
            println("connect")

            inputIp.value = " "
            inputPort.value = " "
            var model = NoteItem(ip,port)
            arraylst.add(model)
            list.value = arraylst

            //connect to the socket
            model.openSock()

        }

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}