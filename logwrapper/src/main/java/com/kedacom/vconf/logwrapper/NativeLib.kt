package com.kedacom.vconf.logwrapper

class NativeLib {

    /**
     * A native method that is implemented by the 'logwrapper' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'logwrapper' library on application startup.
        init {
            System.loadLibrary("logwrapper")
        }
    }
}