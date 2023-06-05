#include <jni.h>
#include <string>
#include <android/log.h>

extern "C" JNIEXPORT void JNICALL
Java_com_sissi_lab_prefabdemo_Logger_logw(
        JNIEnv* env,
        jobject /* this */,
        jstring content) {
//    std::string hello = "Hello from C++";
//    return env->NewStringUTF(hello.c_str());
    const char *c = env->GetStringUTFChars(content, NULL);
    printf("%s", c);
    __android_log_write(ANDROID_LOG_INFO, "LOGWRAPPER", c);
    env->ReleaseStringUTFChars(content, c);
}
