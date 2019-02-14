package com.zzk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.zzk.tool.SaveUserMessageTool;

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
public class UserDao {
	/**
	 * 判断用户名和密码的方法
	 * @param user	用户名
	 * @param pwd	密码
	 * @return	用户名和密码正确返回true,用户名和密码不正确返回false
	 */
    public static boolean okUser(String user, String pwd) {
        Connection conn = null;
        try {
            conn = DAO.getConn(); // 获得数据库连接
            // 创建PreparedStatement对象，并传递SQL语句
            PreparedStatement ps = conn
                    .prepareStatement("select password  from tb_user where username=?");
            ps.setString(1, user); // 为参数赋值
            ResultSet rs = ps.executeQuery(); // 执行SQL语句，获得查询结果集
            if (rs.next() && rs.getRow() > 0) { // 查询到用户信息
                String password = rs.getString(1); // 获得密码
                if (password.equals(pwd)) {
                    SaveUserMessageTool.setUserName(user);
                    SaveUserMessageTool.setPassword(pwd);
                    return true; // 密码正确返回true
                } else {
                    JOptionPane.showMessageDialog(null, "密码不正确。");
                    return false; // 密码错误返回false
                }
            } else {
                JOptionPane.showMessageDialog(null, "用户名不存在。");
                return false; // 用户不存在返回false
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "数据库异常！\n" + ex.getMessage());
            return false; // 数据库异常返回false
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
	 * 添加用户名和密码的方法
	 * @param user	用户名
	 * @param pwd	密码
	 */
	public static void addUser(String user,String pwd,String okPwd){
		try{
			if (!pwd.trim().equals(okPwd.trim())){
				JOptionPane.showMessageDialog(null, "两次输入的密码不一致。");
				return;
			}
			Connection conn=DAO.getConn();									// 获得数据库连接
			// 创建PreparedStatement对象，并传递SQL语句
			PreparedStatement ps=conn.prepareStatement("insert into tb_user (username,password)  values(?,?)");
			ps.setString(1, user.trim());											// 为参数赋值
			ps.setString(2, pwd.trim());
			int flag = ps.executeUpdate();
			if (flag > 0){								
				JOptionPane.showMessageDialog(null, "添加成功。");
			}else{
				JOptionPane.showMessageDialog(null, "添加失败。");
			}
			ps.close();
			conn.close();
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "用户名重复，请换个名称！");
			return;
		}
	}
	
	/**
	 * 修改用户密码的方法
	 * @param oldPwd	原密码
	 * @param newPwd	新密码
	 * @param okPwd	          确认新密码
	 */
	public static void updateUser(String oldPwd,String newPwd,String okPwd){
		try{
			if (!newPwd.trim().equals(okPwd.trim())){
				JOptionPane.showMessageDialog(null, "两次输入的密码不一致。");
				return;
			}
			if (!oldPwd.trim().equals(SaveUserMessageTool.getPassword())){
				JOptionPane.showMessageDialog(null, "原密码不正确。");
				return;
			}
			Connection conn=DAO.getConn();									// 获得数据库连接
			// 创建PreparedStatement对象，并传递SQL语句
			PreparedStatement ps=conn.prepareStatement("update tb_user set password = ? where username = ?");
			ps.setString(1, newPwd.trim());											// 为参数赋值
			ps.setString(2, SaveUserMessageTool.getUserName());
			int flag = ps.executeUpdate();
			if (flag > 0){								
				JOptionPane.showMessageDialog(null, "修改成功。");
			}else{
				JOptionPane.showMessageDialog(null, "修改失败。");
			}
			ps.close();
			conn.close();
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "数据库异常！"+ex.getMessage());
			return;
		}
	}
	
}
