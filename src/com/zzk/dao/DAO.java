package com.zzk.dao;

import java.sql.*;
import javax.swing.JOptionPane;

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
public class DAO {
    private static DAO dao = new DAO(); // ����DAO��ľ�̬ʵ��
    
    /**
     * ���췽�����������ݿ�����
     */
    public DAO() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // �������ݿ�����
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "���ݿ���������ʧ�ܣ��뽫JTDS�������õ�����·���С�\n"
                    + e.getMessage());
        }
    }
    
    /**
     * ������ݿ����ӵķ���
     * 
     * @return Connection
     */
    public static Connection getConn() {
        try {
            Connection conn = null; // �������ݿ�����
            String url = "jdbc:jtds:sqlserver://localhost:1433/db_AddressList"; // ���ݿ�db_AddressList��URL
            String username = "sa"; // ���ݿ���û���
            String password = "xaeduask"; // ���ݿ�����
            conn = DriverManager.getConnection(url, username, password); // ��������
            return conn; // ��������
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "���ݿ�����ʧ�ܡ�\n�����Ƿ�װ��SP4������\n�Լ����ݿ��û����������Ƿ���ȷ��"
                            + e.getMessage());
            return null;
        }
    }
}
