#include <android/log.h>

void logi(const char *content) {
    __android_log_write(ANDROID_LOG_INFO, "KLOG", content);
}
