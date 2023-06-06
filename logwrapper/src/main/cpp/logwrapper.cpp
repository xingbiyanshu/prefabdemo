#include <jni.h>
#include "klog.h"

JavaVM* gVm;

extern "C" void log(JNIEnv* env, jobject obj, jstring content);

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM* vm, void* reserved) {
    logi("JNI_OnLoad IN");

    JNIEnv* env;
    if (vm->GetEnv(reinterpret_cast<void **>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    }

    jclass c = env->FindClass("com/sissi/lab/Logger");
    if (c == nullptr) return JNI_ERR;

    static const JNINativeMethod methods[] = {
            {"log", "(Ljava/lang/String;)V", reinterpret_cast<void *>(log)},
    };
    int rc = env->RegisterNatives(c, methods, sizeof(methods)/sizeof(JNINativeMethod));
    if (rc != JNI_OK) return rc;

    gVm = vm;

    logi("JNI_OnLoad OUT");

    return JNI_VERSION_1_6;
}


void log(JNIEnv* env, jobject obj, jstring content) {
    const char *c = env->GetStringUTFChars(content, NULL);
    logi(c);
    env->ReleaseStringUTFChars(content, c);
}