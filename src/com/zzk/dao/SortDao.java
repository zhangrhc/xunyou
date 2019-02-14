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
public class SortDao {
	/**
	 * 向数据库中添加分类名的方法
	 * 在添加分类名时执行
	 * @param m 实体类Sort的对象
	 */
	public static void insert(Sort m){
		try{
			Connection conn=DAO.getConn();									// 获得数据连接
			// 创建PreparedStatement对象，并传递SQL语句
			PreparedStatement ps=conn.prepareStatement("insert into tb_sort (SortName) values(?)");
			ps.setString(1, m.getSortName());									// 通过实体类的实例为第1个参数赋值
			int flag=ps.executeUpdate();									// 执行SQL语句，获得更新记录数
			if (flag>0){
				JOptionPane.showMessageDialog(null, "添加成功！");
				SaveStateTool.setSingleSortName(m.getSortName());
			}else{
				JOptionPane.showMessageDialog(null, "添加失败！");
			}
			ps.close();
			conn.close();													// 关闭连接
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "该分类名已经存在,请换个名称！\n");
		}
	}
	/**
	 * 根据从列表框中选择的分类名删除该分类
	 * @param sortName分类名
	 */
	public static void deleteSortName(String sortName){
		try{
			Connection conn=DAO.getConn();									// 获得连接
			// 创建PreparedStatement对象，并传递SQL语句
			PreparedStatement ps=conn.prepareStatement("delete from tb_sort  where SortName=?");
			ps.setString(1, sortName);													// 为参数赋值
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
	 * 获得数据库中的所有分类名与分类ID的映射
	 * 在显示主窗体或主窗体成为活动窗体时执行
	 */
	public static Map querySortNameAndID(){
		Map sortMap = new HashMap();
		try{
			Connection conn=DAO.getConn();									// 获得数据连接
			// 创建PreparedStatement对象，并传递SQL语句
			PreparedStatement ps=conn.prepareStatement("select SortName,SortID from tb_sort");
			ResultSet rs=ps.executeQuery();								// 执行SQL语句，获得查询结果集
			while (rs.next() && rs.getRow()>0){							// 遍历结果集
				String sortName = rs.getString(1);
				int sortId = rs.getInt(2);
				sortMap.put(sortName, sortId);
			}
			rs.close();
			ps.close();
			conn.close();													// 关闭连接													// 关闭连接
			SaveStateTool.setSortMap(sortMap);
			return sortMap;
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "数据库异常！\n"+ex.getMessage());
			return null;
		}
	}
	
		
	/**
	 * 通过分类名,获得当前分类ID
	 * 并为SaveStateTool类的分类ID赋值
	 * @param sortName分类名
	 */
	public static int queryCurrentSortId(String sortName){
		try{
			Connection conn=DAO.getConn();									// 获得数据连接
			// 创建PreparedStatement对象，并传递SQL语句
			PreparedStatement ps=conn.prepareStatement("select SortID from tb_sort where SortName = ?");
			ps.setString(1, sortName);
			ResultSet rs=ps.executeQuery();								// 执行SQL语句，获得查询结果集
			int sortId=0;
			if (rs.next() && rs.getRow()>0){							// 遍历结果集
				sortId = rs.getInt(1);
				SaveStateTool.setCurrentSingleSortId(sortId);
			}
			rs.close();
			ps.close();
			conn.close();													// 关闭连接													// 关闭连接
			return sortId;
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "数据库异常！\n"+ex.getMessage());
			return 0;
		}
	}
}
