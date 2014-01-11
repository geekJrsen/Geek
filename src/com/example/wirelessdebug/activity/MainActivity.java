package com.example.wirelessdebug.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.wirelessdebug.R;
import com.example.wirelessdebug.constant.Constant;
import com.example.wirelessdebug.model.MyCommand;
import com.example.wirelessdebug.model.OnCommandResponse;
import com.example.wirelessdebug.utils.Utils;

public final class MainActivity extends Activity implements OnClickListener, OnCommandResponse {

	private TextView mShowIp;
	private Button mWirelessDebugSwitch;
	private MyCommand mMyCommand;
	private boolean mWirelessStateFlag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.initWidget();
		// this.checkWirelessState();
	}

	private void checkWirelessState() {
		// TODO Auto-generated method stub
		mWirelessDebugSwitch.setClickable(false);
		mWirelessDebugSwitch.setText("正在检查Debug状态");
		mMyCommand = new MyCommand(Constant.CHECK_WIRELESS_DEBUG_STATE_ID, Constant.CHECK_WIRELESS_DEBUG_STATE, this);
		if (!Utils.runCommand(mMyCommand)) {
			mWirelessDebugSwitch.setText("没有获取Root权限");
		}
	}

	private void initWidget() {
		// TODO Auto-generated method stub
		mShowIp = (TextView) this.findViewById(R.id.show_ip);
		mWirelessDebugSwitch = (Button) this.findViewById(R.id.open_wireless_debug);
		mShowIp.setText(Utils.getWifiIpAddress(this));
		mWirelessDebugSwitch.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		// if (mWirelessStateFlag) {
		// mMyCommand = new MyCommand(Constant.CLOSE_WIRELESS_DEBUG_ID,
		// Constant.CLOSE_WIRELESS_DEBUG, this);
		// } else {
		mMyCommand = new MyCommand(Constant.OPEN_WIRELESS_DEBUG_ID, Constant.OPEN_WIRELESS_DEBUG, this);
		// }
		Utils.runCommand(mMyCommand);
	}

	@Override
	public void onCommandCompleted(int arg0, int arg1) {
		// TODO Auto-generated method stub
		Log.e("回调了", "结束" + arg1);
		// checkWirelessStateAction("");
	}

	@Override
	public void onCommandOutput(int id, String output) {
		// TODO Auto-generated method stub
		Log.e("回调了输出,This is commit", " YES " + output);
		switch (id) {
		case Constant.CHECK_WIRELESS_DEBUG_STATE_ID:
			this.checkWirelessStateAction(output);
			break;
		case Constant.OPEN_WIRELESS_DEBUG_ID:
			this.checkWirelessState();
			break;
		case Constant.CLOSE_WIRELESS_DEBUG_ID:
			this.checkWirelessState();
			break;
		default:
			break;
		}
	}

	@Override
	public void onCommandTerminated(int arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	private void checkWirelessStateAction(String outString) {
		// TODO Auto-generated method stub
		Log.e("命令输出的数据", outString);
		mWirelessDebugSwitch.setClickable(true);
		if (Utils.checkWirelessState(outString)) {
			mWirelessStateFlag = true;
			mWirelessDebugSwitch.setText("关闭无线调试");
		} else {
			mWirelessStateFlag = false;
			mWirelessDebugSwitch.setText("打开无线调试");
		}
	}
}
