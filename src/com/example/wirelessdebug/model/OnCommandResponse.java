package com.example.wirelessdebug.model;

public interface OnCommandResponse {

	/**
	 * 当命令执行完成
	 * 
	 * @param arg0
	 * @param arg1
	 */
	public void onCommandCompleted(int arg0, int arg1);

	/**
	 * 当命令输出信息
	 * 
	 * @param arg0
	 * @param arg1
	 */
	public void onCommandOutput(int arg0, String arg1);

	/**
	 * 当命令终止
	 * 
	 * @param arg0
	 * @param arg1
	 */
	public void onCommandTerminated(int arg0, String arg1);

}
