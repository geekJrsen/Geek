package com.example.wirelessdebug.model;

import com.stericson.RootTools.execution.Command;

public final class MyCommand extends Command {

	private OnCommandResponse mCallBack;

	public MyCommand(int id, String[] command, OnCommandResponse callBack) {
		super(id, command);
		this.mCallBack = callBack;
	}

	@Override
	public void commandCompleted(int arg0, int arg1) {
		// TODO Auto-generated method stub
		mCallBack.onCommandCompleted(arg0, arg1);
	}

	@Override
	public void commandOutput(int arg0, String arg1) {
		// TODO Auto-generated method stub
		mCallBack.onCommandOutput(arg0, arg1);
	}

	@Override
	public void commandTerminated(int arg0, String arg1) {
		// TODO Auto-generated method stub
		mCallBack.onCommandTerminated(arg0, arg1);
	}

}
