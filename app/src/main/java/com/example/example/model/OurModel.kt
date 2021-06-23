package com.example.example.model

import java.io.OutputStream
import java.net.Socket

import java.util.*


class OurModel:Observer{

    lateinit var connection: Socket
    lateinit var outputStream: OutputStream

    fun openSock(ip:String,port:String){
        val r = Thread(Runnable {
            this.connection = Socket(ip, port.toInt())
            this.outputStream = this.connection.getOutputStream()
        })
        r.start()
        r.join()
    }
    fun closeSock(){
        val r = Thread(Runnable {

            connection!!.close()
        })
        r.start()
        r.join()

    }
    fun updateAileron(value:Float){
        if(connection!=null) {
            val r = Thread(Runnable {
                val message = "set /controls/flight/aileron $value\r\n"
                val sendM = message.toByteArray(Charsets.UTF_8)
                outputStream.write(sendM)
                outputStream.flush()
            })
            r.start()
            r.join()
        }

    }
    fun updateElevator(value:Float){
        if(connection!=null) {
            val r = Thread(Runnable {
            val message = "set /controls/flight/elevator $value\r\n"
            val sendM = message.toByteArray(Charsets.UTF_8)
            outputStream.write(sendM)
            outputStream.flush()
        })
            r.start()
            r.join()
        }
    }
    fun updateThrottle(value:Float){
        if(connection!=null) {
                val r = Thread(Runnable {
                    val message = "set /controls/engines/current-engine/throttle $value\r\n"
                    val sendM = message.toByteArray(Charsets.UTF_8)
                    outputStream.write(sendM)
                    outputStream.flush()
                })
                r.start()
                r.join()
            }
    }
    fun updateRudder(value:Float) {
        if(connection!=null) {
            val r = Thread(Runnable {
                val message = "set /controls/flight/rudder $value\r\n"
                val sendM = message.toByteArray(Charsets.UTF_8)
                outputStream.write(sendM)
                outputStream.flush()
            })
            r.start()
            r.join()
        }
    }

    override fun update(o: Observable?, arg: Any?) {
        TODO("Not yet implemented")
    }
}
















