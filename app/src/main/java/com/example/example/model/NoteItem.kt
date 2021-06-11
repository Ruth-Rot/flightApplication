package com.example.example.model

import java.io.OutputStream
import java.net.Socket


data class NoteItem(
    val ip: String,
    val port: String,
    var connection: Socket? = null,
    var writer: OutputStream? = null
    ){
    fun openSock(){
        println("open soket")
        this.connection = Socket(this.ip,this.port.toInt())
        this.writer = this.connection!!.getOutputStream()
    }
    fun closeSock(){
        connection!!.close()
    }
}








