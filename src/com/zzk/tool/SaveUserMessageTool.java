package com.zzk.tool;
/**
 * 版权所有: 西安市华育国际学员
 * 
 * 完成日期： 2013-05-15
 * 
 * 项目出处： 编程词典
 * 
 * 服务社区： www.hygj.com
 * 
 * 制作人： 文敏
 *
 */
public class SaveUserMessageTool {
	private static String userName = null;     // 登录用户的用户名
	private static String password = null;     // 登录用户的密码
	// 登录用户名的getter方法
	public static String getUserName() {
		return userName;
	}
	// 登录用户的setter方法
	public static void setUserName(String userName) {
		SaveUserMessageTool.userName = userName;
	}
	// 登录密码的getter方法
	public static String getPassword() {
		return password;
	}
	// 登录密码的setter方法
	public static void setPassword(String password) {
		SaveUserMessageTool.password = password;
	}
}
