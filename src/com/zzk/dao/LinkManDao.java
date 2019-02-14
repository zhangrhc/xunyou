package com.zzk.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import com.zzk.bean.LinkMan;

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
public class LinkManDao {
    /**
     * 向数据库中添加联系人信息的方法
     * 
     * @param m
     *            实体类LinkMan的对象
     */
    public static void insert(LinkMan m) {
        try {
            Connection conn = DAO.getConn(); // 获得数据连接
            
            String sql = null;
            if (m.getPicturePath() != null) {
                sql = "insert into tb_LinkMan (name,sex,employment,birthday,principalship,telephone,address,postalcode,QQ,email,picture,SortID) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            } else {
                sql = "insert into tb_LinkMan (name,sex,employment,birthday,principalship,telephone,address,postalcode,QQ,email,SortID) values(?,?,?,?,?,?,?,?,?,?,?)";
            }
            
            // 创建PreparedStatement对象，并传递SQL语句
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, m.getName()); // 通过实体类的实例为第1个参数赋值
            ps.setString(2, m.getSex()); // 通过实体类的实例为第2个参数赋值
            ps.setString(3, m.getEmployment());
            if (m.getBirthday() == null || m.getBirthday().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "请输入出生日期。");
                conn.close();
                return;
            }
            // 创建日期格式化对象，并指定格式
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(m.getBirthday()); // 将实体类的出生日期转换为Date类型
            ps.setTimestamp(4, new Timestamp(date.getTime())); // 通过实体类的实例为第4个参数赋值
            ps.setString(5, m.getPrincipalship()); // 通过实体类的实例为第5个参数赋值
            ps.setString(6, m.getTelephone()); // 通过实体类的实例为第6个参数赋值
            ps.setString(7, m.getAddress()); // 通过实体类的实例为第7个参数赋值
            if (m.getPostalcode().trim().length() == 6) {
                ps.setString(8, m.getPostalcode()); // 通过实体类的实例为第8个参数赋值
            } else {
                JOptionPane.showMessageDialog(null, "请输入6位的邮编。");
                conn.close();
                return;
            }
            ps.setString(9, m.getQQ()); // 通过实体类的实例为第9个参数赋值
            ps.setString(10, m.getEmail()); // 通过实体类的实例为第10个参数赋值
            
            FileInputStream in = null;
            if (m.getPicturePath() != null) {
                File file = new File(m.getPicturePath());
                in = new FileInputStream(file);
                ps.setBinaryStream(11, in, (int) file.length());
                ps.setInt(12, m.getSortID()); // 通过实体类的实例为第12个参数赋值
            } else {
                ps.setInt(11, m.getSortID()); // 通过实体类的实例为第12个参数赋值
            }
            
            int flag = ps.executeUpdate(); // 执行SQL语句，获得更新记录数
            if (flag > 0) {
                JOptionPane.showMessageDialog(null, "添加成功！");
            } else {
                JOptionPane.showMessageDialog(null, "添加失败！");
            }
            ps.close();
            conn.close(); // 关闭连接
            if (in != null) {
                in.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "添加失败！\n" + ex.getMessage());
        }
    }
    
    /**
     * 修改联系人信息的方法
     * 
     * @param m是实体类LinkMan的对象
     */
    public static void update(LinkMan m) {
        try {
            Connection conn = DAO.getConn(); // 获得连接
            String sql = null;
            if (m.getPicturePath() != null) {
                sql = "update tb_LinkMan set name=?,sex=?,employment=?,birthday=?,principalship=?,telephone=?,address=?,postalcode=?,QQ=?,email=?,picture=?,SortID=? where ID=?";
            } else {
                sql = "update tb_LinkMan set name=?,sex=?,employment=?,birthday=?,principalship=?,telephone=?,address=?,postalcode=?,QQ=?,email=?,SortID=? where ID=?";
            }
            PreparedStatement ps = conn.prepareStatement(sql); // 创建PreparedStatement对象，并传递SQL语句
            ps.setString(1, m.getName()); // 通过实体类的实例为第1个参数赋值
            ps.setString(2, m.getSex()); // 通过实体类的实例为第2个参数赋值
            ps.setString(3, m.getEmployment());
            if (m.getBirthday() == null || m.getBirthday().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "请输入出生日期。");
                conn.close();
                return;
            }
            // 创建日期格式化对象，并指定格式
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(m.getBirthday()); // 将实体类的出生日期转换为Date类型
            ps.setTimestamp(4, new Timestamp(date.getTime())); // 通过实体类的实例为第4个参数赋值
            ps.setString(5, m.getPrincipalship()); // 通过实体类的实例为第5个参数赋值
            ps.setString(6, m.getTelephone()); // 通过实体类的实例为第6个参数赋值
            ps.setString(7, m.getAddress()); // 通过实体类的实例为第7个参数赋值
            if (m.getPostalcode().trim().length() == 6) {
                ps.setString(8, m.getPostalcode()); // 通过实体类的实例为第8个参数赋值
            } else {
                JOptionPane.showMessageDialog(null, "请输入6位的邮编。");
                conn.close();
                return;
            }
            ps.setString(9, m.getQQ()); // 通过实体类的实例为第9个参数赋值
            ps.setString(10, m.getEmail()); // 通过实体类的实例为第10个参数赋值
            FileInputStream in = null;
            if (m.getPicturePath() != null) {
                File file = new File(m.getPicturePath());
                in = new FileInputStream(file);
                ps.setBinaryStream(11, in, (int) file.length());
                ps.setInt(12, m.getSortID()); // 通过实体类的实例为第12个参数赋值
                ps.setInt(13, m.getID()); // 通过实体类的实例为第13个参数赋值
            } else {
                ps.setInt(11, m.getSortID()); // 通过实体类的实例为第12个参数赋值
                ps.setInt(12, m.getID()); // 通过实体类的实例为第13个参数赋值
                
            }
            int flag = ps.executeUpdate(); // 执行SQL语句，获得更新记录数
            if (flag > 0) {
                JOptionPane.showMessageDialog(null, "修改成功！");
            } else {
                JOptionPane.showMessageDialog(null, "修改失败！");
            }
            ps.close();
            conn.close(); // 关闭连接
            if (in != null) {
                in.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "修改失败！\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    /**
     * 根据编号删除记录的方法
     * 
     * @param id编号
     */
    public static void delete(int id) {
        try {
            Connection conn = DAO.getConn(); // 获得连接
            // 创建PreparedStatement对象，并传递SQL语句
            PreparedStatement ps = conn
                    .prepareStatement("delete from tb_LinkMan  where ID=?");
            ps.setInt(1, id); // 为参数赋值
            int flag = ps.executeUpdate(); // 执行SQL语句，获得更新记录数
            if (flag > 0) {
                JOptionPane.showMessageDialog(null, "删除成功！");
            } else {
                JOptionPane.showMessageDialog(null, "删除失败！");
            }
            ps.close();
            conn.close(); // 关闭连接
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "删除失败！\n" + ex.getMessage());
        }
    }
    
    /**
     * 查询指定分类中满足条件的记录
     * @param fieldName 字段名
     * @param value 字段值
     * @param sortId 分类ID
     * @return 结果集的Vector对象
     */
    public static Vector query(String fieldName, String value, int sortId) {
        try {
            Vector vector = new Vector(); // 创建存放数据的向量
            Connection conn = DAO.getConn(); // 获得数据连接
            // 创建PreparedStatement对象，并传递SQL语句
            PreparedStatement ps = conn
                    .prepareStatement("select * from tb_LinkMan where "
                            + fieldName + " ='" + value + "' and SortID="
                            + sortId);
            ResultSet rs = ps.executeQuery(); // 执行SQL语句，获得查询结果集
            while (rs.next() && rs.getRow() > 0) { // 遍历结果集
                Vector row = new Vector(); // 创建存放记录的向量
                // 为记录向量赋值
                for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++) {
                    if (col == 1 || col == 13) { // 第1列与第13列是int类型的字段
                        row.add(String.valueOf(rs.getInt(col)));
                    } else if (col == 5) {// 第5列是datetime类型的字段
                        String dateString = new Timestamp(rs.getDate(col)
                                .getTime()).toString().substring(0, 10);
                        row.add(dateString);
                    } else if (col == 12) {// 第12列是image类型的字段
                        Blob img = (Blob) rs.getBlob(col);
                        if (img != null) {
                            ImageIcon icon = new ImageIcon(img.getBytes(1,
                                    (int) img.length()));
                            row.add(icon);
                        } else {
                            row.add(null);
                        }
                    } else {// 其他列是varchar类型的字段
                        row.add(rs.getString(col));
                    }
                }
                vector.add(row); // 将记录向量添加到数据向量
            }
            return vector; // 返回数据向量
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "查询失败！\n" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * 查询满足条件的记录
     * 
     * @param fieldName
     *            字段名
     * @param value
     *            字段值
     * @param sortId
     *            分类ID
     * @return 结果集的Vector对象
     */
    public static Vector query(String fieldName, String value) {
        try {
            Vector vector = new Vector(); // 创建存放数据的向量
            Connection conn = DAO.getConn(); // 获得数据连接
            // 创建PreparedStatement对象，并传递SQL语句
            PreparedStatement ps = conn
                    .prepareStatement("select * from tb_LinkMan where "
                            + fieldName + " ='" + value + "'");
            ResultSet rs = ps.executeQuery(); // 执行SQL语句，获得查询结果集
            while (rs.next() && rs.getRow() > 0) { // 遍历结果集
                Vector row = new Vector(); // 创建存放记录的向量
                // 为记录向量赋值
                for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++) {
                    if (col == 1 || col == 13) {
                        row.add(String.valueOf(rs.getInt(col)));
                    } else if (col == 5) {
                        String dateString = new Timestamp(rs.getDate(col)
                                .getTime()).toString().substring(0, 10);
                        row.add(dateString);
                    } else if (col == 12) {
                        Blob img = (Blob) rs.getBlob(col);
                        if (img != null) {
                            ImageIcon icon = new ImageIcon(img.getBytes(1,
                                    (int) img.length()));
                            row.add(icon);
                        } else {
                            row.add(null);
                        }
                    } else {
                        row.add(rs.getString(col));
                    }
                }
                vector.add(row); // 将记录向量添加到数据向量
            }
            return vector; // 返回数据向量
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "查询失败！\n" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * 查询全部记录
     * 
     * @return 结果集的Vector对象
     */
    public static Vector query() {
        try {
            Vector vector = new Vector(); // 创建存放数据的向量
            Connection conn = DAO.getConn(); // 获得数据连接
            // 创建PreparedStatement对象，并传递SQL语句
            PreparedStatement ps = conn
                    .prepareStatement("select * from tb_LinkMan");
            ResultSet rs = ps.executeQuery(); // 执行SQL语句，获得查询结果集
            while (rs.next() && rs.getRow() > 0) { // 遍历结果集
                Vector row = new Vector(); // 创建存放记录的向量
                // 为记录向量赋值
                for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++) {
                    if (col == 1 || col == 13) {
                        row.add(String.valueOf(rs.getInt(col)));
                    } else if (col == 5) {
                        String dateString = new Timestamp(rs.getDate(col)
                                .getTime()).toString().substring(0, 10);
                        row.add(dateString);
                    } else if (col == 12) {
                        Blob img = (Blob) rs.getBlob(col);
                        if (img != null) {
                            ImageIcon icon = new ImageIcon(img.getBytes(1,
                                    (int) img.length()));
                            row.add(icon);
                        } else {
                            row.add(null);
                        }
                    } else {
                        row.add(rs.getString(col));
                    }
                }
                vector.add(row); // 将记录向量添加到数据向量
            }
            return vector; // 返回数据向量
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "查询失败！\n" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * 按分类查询所有记录
     * 
     * @param sortId
     *            分类ID
     * @return 结果集的Vector对象
     */
    public static Vector query(int sortId) {
        try {
            Vector vector = new Vector(); // 创建存放数据的向量
            Connection conn = DAO.getConn(); // 获得数据连接
            // 创建PreparedStatement对象，并传递SQL语句
            PreparedStatement ps = conn
                    .prepareStatement("select * from tb_LinkMan  where SortID=?");
            ps.setInt(1, sortId); // 为参数赋值
            ResultSet rs = ps.executeQuery(); // 执行SQL语句，获得查询结果集
            while (rs.next() && rs.getRow() > 0) { // 遍历结果集
                Vector row = new Vector(); // 创建存放记录的向量
                // 为记录向量赋值
                for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++) {
                    if (col == 1 || col == 13) {
                        row.add(String.valueOf(rs.getInt(col)));
                    } else if (col == 5) {
                        String dateString = new Timestamp(rs.getDate(col)
                                .getTime()).toString().substring(0, 10);
                        row.add(dateString);
                    } else if (col == 12) {
                        Blob img = (Blob) rs.getBlob(col);
                        if (img != null) {
                            ImageIcon icon = new ImageIcon(img.getBytes(1,
                                    (int) img.length()));
                            row.add(icon);
                        } else {
                            row.add(null);
                        }
                    } else {
                        row.add(rs.getString(col));
                    }
                }
                vector.add(row); // 将记录向量添加到数据向量
            }
            rs.close();
            ps.close();
            conn.close(); // 关闭连接
            return vector; // 返回数据向量
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "查询失败！\n" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
