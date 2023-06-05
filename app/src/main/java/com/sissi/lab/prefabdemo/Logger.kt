package com.sissi.lab.prefabdemo

object Logger {

    init {
        System.loadLibrary("logwrapper")
    }

    external fun logw(content:String)

    fun d(content:String){
        logw(content)
    }

    fun i(content:String){
        logw(content)
    }

    fun w(content:String){
        logw(content)
    }

    fun e(content:String){
        logw(content)
    }
}