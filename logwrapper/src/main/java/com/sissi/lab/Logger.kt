package com.sissi.lab

object Logger {
    init {
        System.loadLibrary("logwrapper")
    }

    private external fun log(content:String)

    fun d(content:String){
        log(content)
    }

    fun i(content:String){
        log(content)
    }

    fun w(content:String){
        log(content)
    }

    fun e(content:String){
        log(content)
    }
}
