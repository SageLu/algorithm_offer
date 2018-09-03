package com.sagelu.javaproblems;

import android.app.ActivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
private String TAG ="maxMemory";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Runtime rt=Runtime.getRuntime();
        long maxMemory=rt.maxMemory();
        Log.i(TAG,"maxMemory="+Long.toString(maxMemory/(1024*1024)));
        displayBriefMemory();
    }
	
    /*
    08-14 16:16:20.216 5650-5650/? I/maxMemory: maxMemory=256
    08-14 16:16:20.216 5650-5650/? I/maxMemory: 系统剩余内存:937MB
    08-14 16:16:20.216 5650-5650/? I/maxMemory: 系统是否处于低内存运行：false
    08-14 16:16:20.216 5650-5650/? I/maxMemory: 当系统剩余内存低于96时就看成低内存运行
     */
    private void displayBriefMemory() {
        final ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(info);
        Log.i(TAG, "系统剩余内存:" + (info.availMem >> 10)/1024 + "MB");
        Log.i(TAG, "系统是否处于低内存运行：" + info.lowMemory);
        Log.i(TAG,"当系统剩余内存低于"+(info.threshold)/1024/1024+"时就看成低内存运行");
    }
}
