#include <jni.h>
#include "klog.h"

extern "C" JNIEXPORT void JNICALL
Java_com_sissi_lab_prefabdemo_Logger_logw(
        JNIEnv* env,
        jobject /* this */,
        jstring content) {
    const char *c = env->GetStringUTFChars(content, NULL);
    logi(c);
    env->ReleaseStringUTFChars(content, c);
}
