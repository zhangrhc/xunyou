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
public class MemoTypeDao {
	/**
	 * 向数据库中添加联系人信息的方法
	 * @param m 实体类LinkMan的对象
	 */
	public static void insert(MemoType m){
		try{
			Connection conn=DAO.getConn();									// 获得数据连接
			// 创建PreparedStatement对象，并传递SQL语句
			PreparedStatement ps=conn.prepareStatement("insert into tb_type (MemoType) values(?)");
			ps.setString(1, m.getMemoType());									// 通过实体类的实例为第1个参数赋值
			int flag=ps.executeUpdate();									// 执行SQL语句，获得更新记录数
			if (flag>0){
				JOptionPane.showMessageDialog(null, "添加成功！");
			}else{
				JOptionPane.showMessageDialog(null, "添加失败！");
			}
			ps.close();
			conn.close();													// 关闭连接
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "添加失败！\n"+ex.getMessage());
		}
	}
	
	/**
	 * 根据从列表框中选择的备忘录类型名删除该类型
	 * @param memoType 类型名
	 */
	public static void deleteSortName(String memoType){
		try{
			Connection conn=DAO.getConn();									// 获得连接
			// 创建PreparedStatement对象，并传递SQL语句
			PreparedStatement ps=conn.prepareStatement("delete from tb_type  where MemoType=?");
			ps.setString(1, memoType);													// 为参数赋值
			int flag=ps.executeUpdate();									// 执行SQL语句，获得更新记录数
			if (flag>0){
				JOptionPane.showMessageDialog(null, "删除成功！");
			}else{
				JOptionPane.showMessageDialog(null, "删除失败！");
			}
			ps.close();
			conn.close();													// 关闭连接
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "删除失败！\n"+ex.getMessage());
		}
	}
	/**
	 * 获得数据库中的所有备忘录类型名与类型ID的映射
	 * 在显示主窗体或主窗体成为活动窗体时执行
	 */
	public static Map queryMemoTypeAndID(){
		Map typeMap = new HashMap();
		try{
			Connection conn=DAO.getConn();									// 获得数据连接
			// 创建PreparedStatement对象，并传递SQL语句
			PreparedStatement ps=conn.prepareStatement("select MemoType,TypeID from tb_type");
			ResultSet rs=ps.executeQuery();								// 执行SQL语句，获得查询结果集
			while (rs.next() && rs.getRow()>0){							// 遍历结果集
				String sortName = rs.getString(1);
				int sortId = rs.getInt(2);
				typeMap.put(sortName, sortId);
			}
			rs.close();
			ps.close();
			conn.close();													// 关闭连接													// 关闭连接
			SaveStateTool.setMemoTypeMap(typeMap);
			return typeMap;
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "数据库异常！\n"+ex.getMessage());
			return null;
		}
	}
	
		
	/**
	 * 通过分类名,获得当前类型ID
	 * 并为SaveStateTool类的类型ID赋值
	 * @param typeName 分类名
	 */
	public static int queryCurrentTypeId(String typeName){
		try{
			Connection conn=DAO.getConn();									// 获得数据连接
			// 创建PreparedStatement对象，并传递SQL语句
			PreparedStatement ps=conn.prepareStatement("select TypeID from tb_type where MemoType = ?");
			ps.setString(1, typeName);
			ResultSet rs=ps.executeQuery();								// 执行SQL语句，获得查询结果集
			int typeId=0;
			if (rs.next() && rs.getRow()>0){							// 遍历结果集
				typeId = rs.getInt(1);
				SaveStateTool.setCurrentSingleMemoTypeId(typeId);
			}
			rs.close();
			ps.close();
			conn.close();													// 关闭连接													// 关闭连接
			return typeId;
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "数据库异常！\n"+ex.getMessage());
			return 0;
		}
	}
	
}
