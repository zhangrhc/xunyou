package com.zzk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.zzk.tool.SaveUserMessageTool;

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
public class UserDao {
	/**
	 * �ж��û���������ķ���
	 * @param user	�û���
	 * @param pwd	����
	 * @return	�û�����������ȷ����true,�û��������벻��ȷ����false
	 */
    public static boolean okUser(String user, String pwd) {
        Connection conn = null;
        try {
            conn = DAO.getConn(); // ������ݿ�����
            // ����PreparedStatement���󣬲�����SQL���
            PreparedStatement ps = conn
                    .prepareStatement("select password  from tb_user where username=?");
            ps.setString(1, user); // Ϊ������ֵ
            ResultSet rs = ps.executeQuery(); // ִ��SQL��䣬��ò�ѯ�����
            if (rs.next() && rs.getRow() > 0) { // ��ѯ���û���Ϣ
                String password = rs.getString(1); // �������
                if (password.equals(pwd)) {
                    SaveUserMessageTool.setUserName(user);
                    SaveUserMessageTool.setPassword(pwd);
                    return true; // ������ȷ����true
                } else {
                    JOptionPane.showMessageDialog(null, "���벻��ȷ��");
                    return false; // ������󷵻�false
                }
            } else {
                JOptionPane.showMessageDialog(null, "�û��������ڡ�");
                return false; // �û������ڷ���false
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "���ݿ��쳣��\n" + ex.getMessage());
            return false; // ���ݿ��쳣����false
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	/**
	 * ����û���������ķ���
	 * @param user	�û���
	 * @param pwd	����
	 */
	public static void addUser(String user,String pwd,String okPwd){
		try{
			if (!pwd.trim().equals(okPwd.trim())){
				JOptionPane.showMessageDialog(null, "������������벻һ�¡�");
				return;
			}
			Connection conn=DAO.getConn();									// ������ݿ�����
			// ����PreparedStatement���󣬲�����SQL���
			PreparedStatement ps=conn.prepareStatement("insert into tb_user (username,password)  values(?,?)");
			ps.setString(1, user.trim());											// Ϊ������ֵ
			ps.setString(2, pwd.trim());
			int flag = ps.executeUpdate();
			if (flag > 0){								
				JOptionPane.showMessageDialog(null, "��ӳɹ���");
			}else{
				JOptionPane.showMessageDialog(null, "���ʧ�ܡ�");
			}
			ps.close();
			conn.close();
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "�û����ظ����뻻�����ƣ�");
			return;
		}
	}
	
	/**
	 * �޸��û�����ķ���
	 * @param oldPwd	ԭ����
	 * @param newPwd	������
	 * @param okPwd	          ȷ��������
	 */
	public static void updateUser(String oldPwd,String newPwd,String okPwd){
		try{
			if (!newPwd.trim().equals(okPwd.trim())){
				JOptionPane.showMessageDialog(null, "������������벻һ�¡�");
				return;
			}
			if (!oldPwd.trim().equals(SaveUserMessageTool.getPassword())){
				JOptionPane.showMessageDialog(null, "ԭ���벻��ȷ��");
				return;
			}
			Connection conn=DAO.getConn();									// ������ݿ�����
			// ����PreparedStatement���󣬲�����SQL���
			PreparedStatement ps=conn.prepareStatement("update tb_user set password = ? where username = ?");
			ps.setString(1, newPwd.trim());											// Ϊ������ֵ
			ps.setString(2, SaveUserMessageTool.getUserName());
			int flag = ps.executeUpdate();
			if (flag > 0){								
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
			}else{
				JOptionPane.showMessageDialog(null, "�޸�ʧ�ܡ�");
			}
			ps.close();
			conn.close();
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "���ݿ��쳣��"+ex.getMessage());
			return;
		}
	}
	
}
