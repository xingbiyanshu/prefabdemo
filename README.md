
# Troubleshooting

## 2 files found with path 'lib/arm64-v8a/libklog.so' from inputs:

logwrapper implementation("com.sissi.lab:klog:1.0")  
app implementation(project(":logwrapper"))  
cause compiling error:  
2 files found with path 'lib/arm64-v8a/libklog.so' from inputs:
- D:\AndroidStudioProjects\Laboratory\PrefabDemo\logwrapper\build\intermediates\library_jni\debug\jni\arm64-v8a\libklog.so
- C:\Users\sissi\.gradle\caches\transforms-3\28acdd71bf12a1af6408592f6c1693f4\transformed\klog-1.0\jni\arm64-v8a\libklog.so
  If you are using jniLibs and CMake IMPORTED targets, see
  https://developer.android.com/r/tools/jniLibs-vs-imported-targets

**SOLUTION**  
change  
app implementation(project(":logwrapper"))  
to  
app implementation("com.sissi.lab:logwrapper:1.0")  
**However, the reason is not figured out yet.**