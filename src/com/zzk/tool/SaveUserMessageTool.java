package com.zzk.tool;
/**
 * ��Ȩ����: �����л�������ѧԱ
 * 
 * ������ڣ� 2013-05-15
 * 
 * ��Ŀ������ ��̴ʵ�
 * 
 * ���������� www.hygj.com
 * 
 * �����ˣ� ����
 *
 */
public class SaveUserMessageTool {
	private static String userName = null;     // ��¼�û����û���
	private static String password = null;     // ��¼�û�������
	// ��¼�û�����getter����
	public static String getUserName() {
		return userName;
	}
	// ��¼�û���setter����
	public static void setUserName(String userName) {
		SaveUserMessageTool.userName = userName;
	}
	// ��¼�����getter����
	public static String getPassword() {
		return password;
	}
	// ��¼�����setter����
	public static void setPassword(String password) {
		SaveUserMessageTool.password = password;
	}
}
