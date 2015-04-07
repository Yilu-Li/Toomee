package com.noyaxe.plugintest;

import java.util.ArrayList;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.noyaxe.plugintest.PackageUtils.AppInfo;

import android.content.Intent;
import android.net.Uri;

public class ScanPlugin extends CordovaPlugin {

    public static final String ACTION_SCAN_APPS_ENTRY = "scanAppsEntry";
	private CallbackContext callbackContext;
	public boolean execute(String action , JSONArray args , CallbackContext callbackContext)throws JSONException{
//		if(action.equals("start")){
//		String url = args.getString(0);
//		Intent intent = new Intent(Intent.ACTION_VIEW);
//		intent.setDataAndType(Uri.parse(url), "video/mp4");
//		cordova.startActivityForResult(this, intent, 1);
//		return true;
//		}
//		return false;
		this.callbackContext = callbackContext;
		JSONObject obj = new JSONObject();
		String ret = PackageUtils.getInstalledAppInfoList(MainActivity.appContext);
		obj.put("appslist", ret);
		this.callbackContext.success(obj);
        this.callbackContext.error("1111111");
		return true;
		}
}
