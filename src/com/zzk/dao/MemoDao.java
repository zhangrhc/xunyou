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
import com.zzk.bean.Memo;
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
public class MemoDao {
	private static boolean flag = false;
	private static String startDate = null;
	private static String endDate = null;
	/**
	 * �����ݿ��������ϵ����Ϣ�ķ���
	 * @param m ʵ����Memo�Ķ���
	 */
	public static void insert(Memo m){
		try{
			Connection conn=DAO.getConn();									// �����������
			// ����PreparedStatement���󣬲�����SQL���
			PreparedStatement ps=conn.prepareStatement("insert into tb_Memo (name,matter,MatterDate,TypeID) values(?,?,?,?)");
			ps.setString(1, m.getName());									// ͨ��ʵ�����ʵ��Ϊ��1��������ֵ
			ps.setString(2, m.getMatter());									// ͨ��ʵ�����ʵ��Ϊ��2��������ֵ
			// �������ڸ�ʽ�����󣬲�ָ����ʽ
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(m.getMatterDate());						// ��ʵ����ĳ�������ת��ΪDate����
			ps.setTimestamp(3, new Timestamp(date.getTime()));				// ͨ��ʵ�����ʵ��Ϊ��3��������ֵ
			ps.setInt(4, m.getTypeID());									// ͨ��ʵ�����ʵ��Ϊ��4��������ֵ
			int flag=ps.executeUpdate();									// ִ��SQL��䣬��ø��¼�¼��
			if (flag>0){
				JOptionPane.showMessageDialog(null, "��ӳɹ���");
			}else{
				JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
			}
			ps.close();
			conn.close();													// �ر�����
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "���ʧ�ܣ�\n"+ex.getMessage());
		}
	}
	/**
	 * �޸���ϵ����Ϣ�ķ���
	 * @param m ʵ����Memo�Ķ���
	 */
	public static void update(Memo m){
		try{
			Connection conn=DAO.getConn();									// �������
			String sql="update tb_Memo set name=?,matter=?,MatterDate=?,TypeID=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);				// ����PreparedStatement���󣬲�����SQL���
			ps.setString(1, m.getName());									// ͨ��ʵ�����ʵ��Ϊ��1��������ֵ
			ps.setString(2, m.getMatter());									// ͨ��ʵ�����ʵ��Ϊ��2��������ֵ
			// �������ڸ�ʽ�����󣬲�ָ����ʽ
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(m.getMatterDate());						// ��ʵ����ĳ�������ת��ΪDate����
			ps.setTimestamp(3, new Timestamp(date.getTime()));				// ͨ��ʵ�����ʵ��Ϊ��3��������ֵ
			ps.setInt(4, m.getTypeID());									// ͨ��ʵ�����ʵ��Ϊ��4��������ֵ
			ps.setInt(5,m.getId());									// ͨ��ʵ�����ʵ��Ϊ��13��������ֵ
			int flag=ps.executeUpdate();									// ִ��SQL��䣬��ø��¼�¼��
			if (flag>0){
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
			}else{
				JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
			}
			ps.close();
			conn.close();													// �ر�����
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�\n"+ex.getMessage());
			ex.printStackTrace();
		}
	}
	/**
	 * ���ݱ��ɾ����¼�ķ���
	 * @param id ���
	 */
	public static void delete(int id){
		try{
			Connection conn=DAO.getConn();									// �������
			// ����PreparedStatement���󣬲�����SQL���
			PreparedStatement ps=conn.prepareStatement("delete from tb_Memo  where id=?");
			ps.setInt(1, id);													// Ϊ������ֵ
			int flag=ps.executeUpdate();									// ִ��SQL��䣬��ø��¼�¼��
			if (flag>0){
				JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
			}else{
				JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
			}
			ps.close();
			conn.close();													// �ر�����
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�\n"+ex.getMessage());
		}
	}
	/**
	 * ��ѯ���������ļ�¼
	 * @param fieldName	�ֶ���
	 * @param value	�ֶ�ֵ
	 * @param typeId ����¼����ID
	 * @return	�������Vector����
	 */
	public static Vector query(String fieldName,String sign,String value,int typeId){
		try{
			Vector vector=new Vector();									// ����������ݵ�����
			Connection conn=DAO.getConn();									// �����������
			String sql = "select * from tb_Memo where ";
			if (typeId>0){
				sql = sql+"TypeID="+typeId+" and ";
			}
			if (sign.equals("like")){
				sql = sql+fieldName+" " +sign+" '%"+value+"%'";
			}else{
				sql = sql+fieldName+" " +sign+" '"+value+"'";
			}
			Date date1=null;
			Date date2=null;
			if (MemoDao.flag){
				// �������ڸ�ʽ�����󣬲�ָ����ʽ
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				date1 = format1.parse(MemoDao.startDate);						// ��ʵ����ĳ�������ת��ΪDate����
				//ps.setTimestamp(4, new Timestamp(date1.getTime()));				// ͨ��ʵ�����ʵ��Ϊ��4��������ֵ
				// �������ڸ�ʽ�����󣬲�ָ����ʽ
				SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
				date2 = format2.parse(MemoDao.endDate);						// ��ʵ����ĳ�������ת��ΪDate����
				//ps.setTimestamp(4, new Timestamp(date1.getTime()));				// ͨ��ʵ�����ʵ��Ϊ��4��������ֵ
				sql = sql + " and MatterDate between ? and ?";
			}
			// ����PreparedStatement���󣬲�����SQL���
			PreparedStatement ps=conn.prepareStatement(sql);
			if (MemoDao.flag){
				ps.setTimestamp(1, new Timestamp(date1.getTime()));
				ps.setTimestamp(2, new Timestamp(date2.getTime()));
			}
			ResultSet rs=ps.executeQuery();								// ִ��SQL��䣬��ò�ѯ�����
			while (rs.next() && rs.getRow()>0){							// ���������
				Vector row=new Vector();					// ������ż�¼������
				// Ϊ��¼������ֵ
				for (int col=1;col<=rs.getMetaData().getColumnCount();col++){
					if (col==1 || col==5){
						row.add(String.valueOf(rs.getInt(col)));
					}else if (col==4){
						String dateString=new Timestamp(rs.getDate(col).getTime()).toString().substring(0,10);
						row.add(dateString);
					}else{
						row.add(rs.getString(col));
					}
				}
				vector.add(row);											// ����¼������ӵ���������
			}
			MemoDao.flag = false;
			MemoDao.startDate = null;
			MemoDao.endDate = null;
			rs.close();
			ps.close();
			conn.close();
			return vector;													// ������������
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "��ѯʧ�ܣ�\n"+ex.getMessage());
			return null;
		}
	}
	
	/**
	 * ��ѯ���������ļ�¼
	 * @param fieldName	�ֶ���
	 * @param value	�ֶ�ֵ
	 * @param typeId ����¼����ID
	 * @return	�������Vector����
	 */
	public static void query(boolean flag,String startDate,String endDate){
		MemoDao.flag = flag;
		MemoDao.startDate = startDate;
		MemoDao.endDate = endDate;
	}
	
	/**
	 * ��ѯȫ����¼
	 * @return �������Vector����
	 */
	public static Vector query(){
		try{
			Vector vector=new Vector();									// ����������ݵ�����
			Connection conn=DAO.getConn();									// �����������
			// ����PreparedStatement���󣬲�����SQL���
			PreparedStatement ps=conn.prepareStatement("select * from tb_Memo");
			ResultSet rs=ps.executeQuery();								// ִ��SQL��䣬��ò�ѯ�����
			while (rs.next() && rs.getRow()>0){								// ���������
				Vector row=new Vector();									// ������ż�¼������
				// Ϊ��¼������ֵ
				for (int col=1;col<=rs.getMetaData().getColumnCount();col++){
					if (col==1 || col==5){
						row.add(String.valueOf(rs.getInt(col)));
					}else if (col==4){
						String dateString=new Timestamp(rs.getDate(col).getTime()).toString().substring(0,10);
						row.add(dateString);
					}else{
						row.add(rs.getString(col));
					}
				}
				vector.add(row);											// ����¼������ӵ���������
			}
			rs.close();
			ps.close();
			conn.close();
			return vector;													// ������������
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "��ѯʧ�ܣ�\n"+ex.getMessage());
			return null;
		}
	}
	/**
	 * �������ѯ���м�¼
	 * @param typeId ����¼����ID
	 * @return  �������Vector����
	 */
	public static Vector query(int typeId){
		try{
			Vector vector=new Vector();									// ����������ݵ�����
			Connection conn=DAO.getConn();									// �����������
			// ����PreparedStatement���󣬲�����SQL���
			PreparedStatement ps=conn.prepareStatement("select * from tb_Memo  where TypeID=?");
			ps.setInt(1, typeId);											// Ϊ������ֵ
			ResultSet rs=ps.executeQuery();								// ִ��SQL��䣬��ò�ѯ�����
			while (rs.next() && rs.getRow()>0){							// ���������
				Vector row=new Vector();									// ������ż�¼������
				// Ϊ��¼������ֵ
				for (int col=1;col<=rs.getMetaData().getColumnCount();col++){
					if (col==1 || col==5){
						row.add(String.valueOf(rs.getInt(col)));
					}else if (col==4){
						String dateString=new Timestamp(rs.getDate(col).getTime()).toString().substring(0,10);
						row.add(dateString);
					}else{
						row.add(rs.getString(col));
					}
				}
				vector.add(row);											// ����¼������ӵ���������
			}
			rs.close();
			ps.close();
			conn.close();													// �ر�����
			return vector;													// ������������
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "��ѯʧ�ܣ�\n"+ex.getMessage());
			return null;
		}
	}
}
