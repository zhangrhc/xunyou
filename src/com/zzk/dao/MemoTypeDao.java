package com.zzk.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import com.zzk.bean.MemoType;
import com.zzk.tool.SaveStateTool;
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
public class MemoTypeDao {
	/**
	 * �����ݿ��������ϵ����Ϣ�ķ���
	 * @param m ʵ����LinkMan�Ķ���
	 */
	public static void insert(MemoType m){
		try{
			Connection conn=DAO.getConn();									// �����������
			// ����PreparedStatement���󣬲�����SQL���
			PreparedStatement ps=conn.prepareStatement("insert into tb_type (MemoType) values(?)");
			ps.setString(1, m.getMemoType());									// ͨ��ʵ�����ʵ��Ϊ��1��������ֵ
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
	 * ���ݴ��б����ѡ��ı���¼������ɾ��������
	 * @param memoType ������
	 */
	public static void deleteSortName(String memoType){
		try{
			Connection conn=DAO.getConn();									// �������
			// ����PreparedStatement���󣬲�����SQL���
			PreparedStatement ps=conn.prepareStatement("delete from tb_type  where MemoType=?");
			ps.setString(1, memoType);													// Ϊ������ֵ
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
	 * ������ݿ��е����б���¼������������ID��ӳ��
	 * ����ʾ��������������Ϊ�����ʱִ��
	 */
	public static Map queryMemoTypeAndID(){
		Map typeMap = new HashMap();
		try{
			Connection conn=DAO.getConn();									// �����������
			// ����PreparedStatement���󣬲�����SQL���
			PreparedStatement ps=conn.prepareStatement("select MemoType,TypeID from tb_type");
			ResultSet rs=ps.executeQuery();								// ִ��SQL��䣬��ò�ѯ�����
			while (rs.next() && rs.getRow()>0){							// ���������
				String sortName = rs.getString(1);
				int sortId = rs.getInt(2);
				typeMap.put(sortName, sortId);
			}
			rs.close();
			ps.close();
			conn.close();													// �ر�����													// �ر�����
			SaveStateTool.setMemoTypeMap(typeMap);
			return typeMap;
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "���ݿ��쳣��\n"+ex.getMessage());
			return null;
		}
	}
	
		
	/**
	 * ͨ��������,��õ�ǰ����ID
	 * ��ΪSaveStateTool�������ID��ֵ
	 * @param typeName ������
	 */
	public static int queryCurrentTypeId(String typeName){
		try{
			Connection conn=DAO.getConn();									// �����������
			// ����PreparedStatement���󣬲�����SQL���
			PreparedStatement ps=conn.prepareStatement("select TypeID from tb_type where MemoType = ?");
			ps.setString(1, typeName);
			ResultSet rs=ps.executeQuery();								// ִ��SQL��䣬��ò�ѯ�����
			int typeId=0;
			if (rs.next() && rs.getRow()>0){							// ���������
				typeId = rs.getInt(1);
				SaveStateTool.setCurrentSingleMemoTypeId(typeId);
			}
			rs.close();
			ps.close();
			conn.close();													// �ر�����													// �ر�����
			return typeId;
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "���ݿ��쳣��\n"+ex.getMessage());
			return 0;
		}
	}
	
}
