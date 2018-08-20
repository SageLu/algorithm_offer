package com.sagelu.javaproblems;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ExportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export);
    }

    /**
     *       1、通过APP启动另一个APP
     */
    private void startOtherApp(String packname) {
        PackageManager packageManager = getPackageManager();
        if (checkPackInfo(packname)) {
            Intent intent = packageManager.getLaunchIntentForPackage(packname);
            startActivity(intent);
        } else {
            Toast.makeText(this, "没有安装" + packname, 1).show();
        }

    }
    /**
     * 检查包是否存在
     *
     * @param packname
     * @return
     */
    private boolean checkPackInfo(String packname) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(packname, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo != null;
    }

    /**
     *       2、通过APP启动另一个APP的activity
     *       需要将目标Activity的android:exported="true"属性在所属应用AndroidMainfest里设置为true
     */
    private void startOtherAppofActivity() {
        Intent intent = new Intent();
        //第一种方式
        ComponentName cn = new ComponentName("com.example.fm", "com.example.fm.MainFragmentActivity");
        try {
            intent.setComponent(cn);
            //第二种方式
            //intent.setClassName("com.example.fm", "com.example.fm.MainFragmentActivity");
            intent.putExtra("test", "intent1");
            startActivity(intent);
        } catch (Exception e) {
            //TODO  可以在这里提示用户没有安装应用或找不到指定Activity，或者是做其他的操作
        }

    }
}
