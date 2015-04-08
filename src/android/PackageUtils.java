package org.noyaxe.scanapps;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
//import com.wodi.who.config.Config;

import java.util.ArrayList;
import java.util.List;

public class PackageUtils {

    public final static class AppInfo {
        public String appName;

        public String packageName;

        public String versionName;

        public int versionCode;

        public Drawable icon;

        @Override
        public String toString() {
            return "AppInfo{" +
                       "appName='" + appName + '\'' +
                       ", packageName='" + packageName + '\'' +
                       ", versionName='" + versionName + '\'' +
                       ", versionCode='" + versionCode + '\'' +
                       ", icon=" + icon +
                       '}';
        }
    }

    public static String getInstalledAppInfoList(Context context) {
        ArrayList<AppInfo> ret = new ArrayList<>();

        List<PackageInfo> packages = context.getPackageManager().getInstalledPackages(PackageManager.GET_ACTIVITIES);
        if (packages != null) {
            for (PackageInfo packageInfo : packages) {
                AppInfo info = new AppInfo();
                info.appName = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
                info.packageName = packageInfo.packageName;
                info.versionCode = packageInfo.versionCode;
                info.versionName = packageInfo.versionName;
                info.icon = packageInfo.applicationInfo.loadIcon(context.getPackageManager());
                ret.add(info);
            }
        }

        //Config.LOGD(ret.toString());

        return ret.toString();
    }

}
