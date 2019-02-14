package com.zzk.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import com.zzk.bean.Sort;
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
public class SortDao {
	/**
	 * �����ݿ�����ӷ������ķ���
	 * ����ӷ�����ʱִ��
	 * @param m ʵ����Sort�Ķ���
	 */
	public static void insert(Sort m){
		try{
			Connection conn=DAO.getConn();									// �����������
			// ����PreparedStatement���󣬲�����SQL���
			PreparedStatement ps=conn.prepareStatement("insert into tb_sort (SortName) values(?)");
			ps.setString(1, m.getSortName());									// ͨ��ʵ�����ʵ��Ϊ��1��������ֵ
			int flag=ps.executeUpdate();									// ִ��SQL��䣬��ø��¼�¼��
			if (flag>0){
				JOptionPane.showMessageDialog(null, "��ӳɹ���");
				SaveStateTool.setSingleSortName(m.getSortName());
			}else{
				JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
			}
			ps.close();
			conn.close();													// �ر�����
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "�÷������Ѿ�����,�뻻�����ƣ�\n");
		}
	}
	/**
	 * ���ݴ��б����ѡ��ķ�����ɾ���÷���
	 * @param sortName������
	 */
	public static void deleteSortName(String sortName){
		try{
			Connection conn=DAO.getConn();									// �������
			// ����PreparedStatement���󣬲�����SQL���
			PreparedStatement ps=conn.prepareStatement("delete from tb_sort  where SortName=?");
			ps.setString(1, sortName);													// Ϊ������ֵ
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
	 * ������ݿ��е����з����������ID��ӳ��
	 * ����ʾ��������������Ϊ�����ʱִ��
	 */
	public static Map querySortNameAndID(){
		Map sortMap = new HashMap();
		try{
			Connection conn=DAO.getConn();									// �����������
			// ����PreparedStatement���󣬲�����SQL���
			PreparedStatement ps=conn.prepareStatement("select SortName,SortID from tb_sort");
			ResultSet rs=ps.executeQuery();								// ִ��SQL��䣬��ò�ѯ�����
			while (rs.next() && rs.getRow()>0){							// ���������
				String sortName = rs.getString(1);
				int sortId = rs.getInt(2);
				sortMap.put(sortName, sortId);
			}
			rs.close();
			ps.close();
			conn.close();													// �ر�����													// �ر�����
			SaveStateTool.setSortMap(sortMap);
			return sortMap;
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "���ݿ��쳣��\n"+ex.getMessage());
			return null;
		}
	}
	
		
	/**
	 * ͨ��������,��õ�ǰ����ID
	 * ��ΪSaveStateTool��ķ���ID��ֵ
	 * @param sortName������
	 */
	public static int queryCurrentSortId(String sortName){
		try{
			Connection conn=DAO.getConn();									// �����������
			// ����PreparedStatement���󣬲�����SQL���
			PreparedStatement ps=conn.prepareStatement("select SortID from tb_sort where SortName = ?");
			ps.setString(1, sortName);
			ResultSet rs=ps.executeQuery();								// ִ��SQL��䣬��ò�ѯ�����
			int sortId=0;
			if (rs.next() && rs.getRow()>0){							// ���������
				sortId = rs.getInt(1);
				SaveStateTool.setCurrentSingleSortId(sortId);
			}
			rs.close();
			ps.close();
			conn.close();													// �ر�����													// �ر�����
			return sortId;
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "���ݿ��쳣��\n"+ex.getMessage());
			return 0;
		}
	}
}
