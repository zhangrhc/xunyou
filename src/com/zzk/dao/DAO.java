package com.zzk.dao;

import java.sql.*;
import javax.swing.JOptionPane;

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
public class DAO {
    private static DAO dao = new DAO(); // 声明DAO类的静态实例
    
    /**
     * 构造方法，加载数据库驱动
     */
    public DAO() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // 加载数据库驱动
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "数据库驱动加载失败，请将JTDS驱动配置到构建路径中。\n"
                    + e.getMessage());
        }
    }
    
    /**
     * 获得数据库连接的方法
     * 
     * @return Connection
     */
    public static Connection getConn() {
        try {
            Connection conn = null; // 定义数据库连接
            String url = "jdbc:jtds:sqlserver://localhost:1433/db_AddressList"; // 数据库db_AddressList的URL
            String username = "sa"; // 数据库的用户名
            String password = "xaeduask"; // 数据库密码
            conn = DriverManager.getConnection(url, username, password); // 建立连接
            return conn; // 返回连接
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "数据库连接失败。\n请检查是否安装了SP4补丁，\n以及数据库用户名和密码是否正确。"
                            + e.getMessage());
            return null;
        }
    }
}
