package com.example.wirelessdebug.utils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.example.wirelessdebug.model.MyCommand;
import com.stericson.RootTools.RootTools;
import com.stericson.RootTools.exceptions.RootDeniedException;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.Toast;

public final class Utils {

	/**
	 * 获取Wifi状态下的ip地址
	 * 
	 * @param context
	 * @return
	 */
	public static String getWifiIpAddress(Activity context) {
		WifiManager wifiMgr = (WifiManager) context
				.getSystemService(context.WIFI_SERVICE);
		WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
		int ip = wifiInfo.getIpAddress();
		String ipAddress = Formatter.formatIpAddress(ip);
		return ipAddress;
	}
	
	/**
	 * 检查无线调试状态
	 * @param state
	 * @return
	 */
	public static boolean checkWirelessState(String state) {
		state = state.replace(" ", "");
		String[] temp = state.split(":");
		if (temp.length != 2) return false;
		state = temp[1].replace("[", "").replace("]", "");
		int port = Integer.parseInt(state);
		Log.e("端口", port + "");
		if (port != 0) {
			return true;
		}
		return false;
	}
	
	public static boolean runCommand(MyCommand myCommand) {
		if (RootTools.isAccessGiven()) {
			try {
				RootTools.getShell(true).runCommand(myCommand);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RootDeniedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}
