package com.example.example.viewmodles

import com.example.example.model.OurModel
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.collections.ArrayList

class NoteViewModel(model:OurModel):ViewModel(),Observable {
    private val isSocket = MutableLiveData<Boolean>()
    @Bindable
    val inputPort = MutableLiveData<String>()
    @Bindable
    val inputIp = MutableLiveData<String>()
    @Bindable
    val submit = MutableLiveData<String>()

    private val list = MutableLiveData<ArrayList<OurModel>>()
    private val arraylist = ArrayList<OurModel>()
    var model:OurModel = model


    init {
        isSocket.value = false
        submit.value="Submit"
    }

    fun writeThrottle(value :Float){
        model.updateThrottle(value)
    }
    fun writeRudder(value: Float){
        model.updateRudder(value)
    }
 fun connectFg() {
        val ip = inputIp.value!!
        val port = inputPort.value!!

     if (!ip.isBlank() && !port.isBlank()) {
         submit.value = "Connect"
         isSocket.value = true

         arraylist.add(model!!)
            list.value = arraylist
            //connect to the socket
            model!!.openSock(ip,port)
   }
   }
    fun closeFg(){
        if(isSocket.value == true){
            model!!.closeSock()
            submit.value = "Submit"
            isSocket.value = false
        }

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}