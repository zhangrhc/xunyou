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
public class LinkManDao {
    /**
     * �����ݿ��������ϵ����Ϣ�ķ���
     * 
     * @param m
     *            ʵ����LinkMan�Ķ���
     */
    public static void insert(LinkMan m) {
        try {
            Connection conn = DAO.getConn(); // �����������
            
            String sql = null;
            if (m.getPicturePath() != null) {
                sql = "insert into tb_LinkMan (name,sex,employment,birthday,principalship,telephone,address,postalcode,QQ,email,picture,SortID) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            } else {
                sql = "insert into tb_LinkMan (name,sex,employment,birthday,principalship,telephone,address,postalcode,QQ,email,SortID) values(?,?,?,?,?,?,?,?,?,?,?)";
            }
            
            // ����PreparedStatement���󣬲�����SQL���
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, m.getName()); // ͨ��ʵ�����ʵ��Ϊ��1��������ֵ
            ps.setString(2, m.getSex()); // ͨ��ʵ�����ʵ��Ϊ��2��������ֵ
            ps.setString(3, m.getEmployment());
            if (m.getBirthday() == null || m.getBirthday().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "������������ڡ�");
                conn.close();
                return;
            }
            // �������ڸ�ʽ�����󣬲�ָ����ʽ
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(m.getBirthday()); // ��ʵ����ĳ�������ת��ΪDate����
            ps.setTimestamp(4, new Timestamp(date.getTime())); // ͨ��ʵ�����ʵ��Ϊ��4��������ֵ
            ps.setString(5, m.getPrincipalship()); // ͨ��ʵ�����ʵ��Ϊ��5��������ֵ
            ps.setString(6, m.getTelephone()); // ͨ��ʵ�����ʵ��Ϊ��6��������ֵ
            ps.setString(7, m.getAddress()); // ͨ��ʵ�����ʵ��Ϊ��7��������ֵ
            if (m.getPostalcode().trim().length() == 6) {
                ps.setString(8, m.getPostalcode()); // ͨ��ʵ�����ʵ��Ϊ��8��������ֵ
            } else {
                JOptionPane.showMessageDialog(null, "������6λ���ʱࡣ");
                conn.close();
                return;
            }
            ps.setString(9, m.getQQ()); // ͨ��ʵ�����ʵ��Ϊ��9��������ֵ
            ps.setString(10, m.getEmail()); // ͨ��ʵ�����ʵ��Ϊ��10��������ֵ
            
            FileInputStream in = null;
            if (m.getPicturePath() != null) {
                File file = new File(m.getPicturePath());
                in = new FileInputStream(file);
                ps.setBinaryStream(11, in, (int) file.length());
                ps.setInt(12, m.getSortID()); // ͨ��ʵ�����ʵ��Ϊ��12��������ֵ
            } else {
                ps.setInt(11, m.getSortID()); // ͨ��ʵ�����ʵ��Ϊ��12��������ֵ
            }
            
            int flag = ps.executeUpdate(); // ִ��SQL��䣬��ø��¼�¼��
            if (flag > 0) {
                JOptionPane.showMessageDialog(null, "��ӳɹ���");
            } else {
                JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
            }
            ps.close();
            conn.close(); // �ر�����
            if (in != null) {
                in.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "���ʧ�ܣ�\n" + ex.getMessage());
        }
    }
    
    /**
     * �޸���ϵ����Ϣ�ķ���
     * 
     * @param m��ʵ����LinkMan�Ķ���
     */
    public static void update(LinkMan m) {
        try {
            Connection conn = DAO.getConn(); // �������
            String sql = null;
            if (m.getPicturePath() != null) {
                sql = "update tb_LinkMan set name=?,sex=?,employment=?,birthday=?,principalship=?,telephone=?,address=?,postalcode=?,QQ=?,email=?,picture=?,SortID=? where ID=?";
            } else {
                sql = "update tb_LinkMan set name=?,sex=?,employment=?,birthday=?,principalship=?,telephone=?,address=?,postalcode=?,QQ=?,email=?,SortID=? where ID=?";
            }
            PreparedStatement ps = conn.prepareStatement(sql); // ����PreparedStatement���󣬲�����SQL���
            ps.setString(1, m.getName()); // ͨ��ʵ�����ʵ��Ϊ��1��������ֵ
            ps.setString(2, m.getSex()); // ͨ��ʵ�����ʵ��Ϊ��2��������ֵ
            ps.setString(3, m.getEmployment());
            if (m.getBirthday() == null || m.getBirthday().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "������������ڡ�");
                conn.close();
                return;
            }
            // �������ڸ�ʽ�����󣬲�ָ����ʽ
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(m.getBirthday()); // ��ʵ����ĳ�������ת��ΪDate����
            ps.setTimestamp(4, new Timestamp(date.getTime())); // ͨ��ʵ�����ʵ��Ϊ��4��������ֵ
            ps.setString(5, m.getPrincipalship()); // ͨ��ʵ�����ʵ��Ϊ��5��������ֵ
            ps.setString(6, m.getTelephone()); // ͨ��ʵ�����ʵ��Ϊ��6��������ֵ
            ps.setString(7, m.getAddress()); // ͨ��ʵ�����ʵ��Ϊ��7��������ֵ
            if (m.getPostalcode().trim().length() == 6) {
                ps.setString(8, m.getPostalcode()); // ͨ��ʵ�����ʵ��Ϊ��8��������ֵ
            } else {
                JOptionPane.showMessageDialog(null, "������6λ���ʱࡣ");
                conn.close();
                return;
            }
            ps.setString(9, m.getQQ()); // ͨ��ʵ�����ʵ��Ϊ��9��������ֵ
            ps.setString(10, m.getEmail()); // ͨ��ʵ�����ʵ��Ϊ��10��������ֵ
            FileInputStream in = null;
            if (m.getPicturePath() != null) {
                File file = new File(m.getPicturePath());
                in = new FileInputStream(file);
                ps.setBinaryStream(11, in, (int) file.length());
                ps.setInt(12, m.getSortID()); // ͨ��ʵ�����ʵ��Ϊ��12��������ֵ
                ps.setInt(13, m.getID()); // ͨ��ʵ�����ʵ��Ϊ��13��������ֵ
            } else {
                ps.setInt(11, m.getSortID()); // ͨ��ʵ�����ʵ��Ϊ��12��������ֵ
                ps.setInt(12, m.getID()); // ͨ��ʵ�����ʵ��Ϊ��13��������ֵ
                
            }
            int flag = ps.executeUpdate(); // ִ��SQL��䣬��ø��¼�¼��
            if (flag > 0) {
                JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
            } else {
                JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
            }
            ps.close();
            conn.close(); // �ر�����
            if (in != null) {
                in.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    /**
     * ���ݱ��ɾ����¼�ķ���
     * 
     * @param id���
     */
    public static void delete(int id) {
        try {
            Connection conn = DAO.getConn(); // �������
            // ����PreparedStatement���󣬲�����SQL���
            PreparedStatement ps = conn
                    .prepareStatement("delete from tb_LinkMan  where ID=?");
            ps.setInt(1, id); // Ϊ������ֵ
            int flag = ps.executeUpdate(); // ִ��SQL��䣬��ø��¼�¼��
            if (flag > 0) {
                JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
            } else {
                JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
            }
            ps.close();
            conn.close(); // �ر�����
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�\n" + ex.getMessage());
        }
    }
    
    /**
     * ��ѯָ�����������������ļ�¼
     * @param fieldName �ֶ���
     * @param value �ֶ�ֵ
     * @param sortId ����ID
     * @return �������Vector����
     */
    public static Vector query(String fieldName, String value, int sortId) {
        try {
            Vector vector = new Vector(); // ����������ݵ�����
            Connection conn = DAO.getConn(); // �����������
            // ����PreparedStatement���󣬲�����SQL���
            PreparedStatement ps = conn
                    .prepareStatement("select * from tb_LinkMan where "
                            + fieldName + " ='" + value + "' and SortID="
                            + sortId);
            ResultSet rs = ps.executeQuery(); // ִ��SQL��䣬��ò�ѯ�����
            while (rs.next() && rs.getRow() > 0) { // ���������
                Vector row = new Vector(); // ������ż�¼������
                // Ϊ��¼������ֵ
                for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++) {
                    if (col == 1 || col == 13) { // ��1�����13����int���͵��ֶ�
                        row.add(String.valueOf(rs.getInt(col)));
                    } else if (col == 5) {// ��5����datetime���͵��ֶ�
                        String dateString = new Timestamp(rs.getDate(col)
                                .getTime()).toString().substring(0, 10);
                        row.add(dateString);
                    } else if (col == 12) {// ��12����image���͵��ֶ�
                        Blob img = (Blob) rs.getBlob(col);
                        if (img != null) {
                            ImageIcon icon = new ImageIcon(img.getBytes(1,
                                    (int) img.length()));
                            row.add(icon);
                        } else {
                            row.add(null);
                        }
                    } else {// ��������varchar���͵��ֶ�
                        row.add(rs.getString(col));
                    }
                }
                vector.add(row); // ����¼������ӵ���������
            }
            return vector; // ������������
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "��ѯʧ�ܣ�\n" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * ��ѯ���������ļ�¼
     * 
     * @param fieldName
     *            �ֶ���
     * @param value
     *            �ֶ�ֵ
     * @param sortId
     *            ����ID
     * @return �������Vector����
     */
    public static Vector query(String fieldName, String value) {
        try {
            Vector vector = new Vector(); // ����������ݵ�����
            Connection conn = DAO.getConn(); // �����������
            // ����PreparedStatement���󣬲�����SQL���
            PreparedStatement ps = conn
                    .prepareStatement("select * from tb_LinkMan where "
                            + fieldName + " ='" + value + "'");
            ResultSet rs = ps.executeQuery(); // ִ��SQL��䣬��ò�ѯ�����
            while (rs.next() && rs.getRow() > 0) { // ���������
                Vector row = new Vector(); // ������ż�¼������
                // Ϊ��¼������ֵ
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
                vector.add(row); // ����¼������ӵ���������
            }
            return vector; // ������������
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "��ѯʧ�ܣ�\n" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * ��ѯȫ����¼
     * 
     * @return �������Vector����
     */
    public static Vector query() {
        try {
            Vector vector = new Vector(); // ����������ݵ�����
            Connection conn = DAO.getConn(); // �����������
            // ����PreparedStatement���󣬲�����SQL���
            PreparedStatement ps = conn
                    .prepareStatement("select * from tb_LinkMan");
            ResultSet rs = ps.executeQuery(); // ִ��SQL��䣬��ò�ѯ�����
            while (rs.next() && rs.getRow() > 0) { // ���������
                Vector row = new Vector(); // ������ż�¼������
                // Ϊ��¼������ֵ
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
                vector.add(row); // ����¼������ӵ���������
            }
            return vector; // ������������
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "��ѯʧ�ܣ�\n" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * �������ѯ���м�¼
     * 
     * @param sortId
     *            ����ID
     * @return �������Vector����
     */
    public static Vector query(int sortId) {
        try {
            Vector vector = new Vector(); // ����������ݵ�����
            Connection conn = DAO.getConn(); // �����������
            // ����PreparedStatement���󣬲�����SQL���
            PreparedStatement ps = conn
                    .prepareStatement("select * from tb_LinkMan  where SortID=?");
            ps.setInt(1, sortId); // Ϊ������ֵ
            ResultSet rs = ps.executeQuery(); // ִ��SQL��䣬��ò�ѯ�����
            while (rs.next() && rs.getRow() > 0) { // ���������
                Vector row = new Vector(); // ������ż�¼������
                // Ϊ��¼������ֵ
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
                vector.add(row); // ����¼������ӵ���������
            }
            rs.close();
            ps.close();
            conn.close(); // �ر�����
            return vector; // ������������
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "��ѯʧ�ܣ�\n" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
