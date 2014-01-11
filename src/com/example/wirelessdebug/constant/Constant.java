package com.example.wirelessdebug.constant;

public final class Constant {

	// 打开无线调试
	public final static int OPEN_WIRELESS_DEBUG_ID = 0x10;
	public final static String[] OPEN_WIRELESS_DEBUG = { "setprop service.adb.tcp.port 5555", "stop adbd", "start adbd" };

	// 关闭无线调试
	public final static int CLOSE_WIRELESS_DEBUG_ID = 0x11;
	public final static String[] CLOSE_WIRELESS_DEBUG = { "setprop service.adb.tcp.port -1", "stop adbd", "start adbd" };

	// 检查无线调试状态
	public final static int CHECK_WIRELESS_DEBUG_STATE_ID = 0x12;
	public final static String[] CHECK_WIRELESS_DEBUG_STATE = { "getprop | grep service.adb.tcp.port" };

}
