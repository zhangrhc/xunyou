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
public class MemoDao {
	private static boolean flag = false;
	private static String startDate = null;
	private static String endDate = null;
	/**
	 * 向数据库中添加联系人信息的方法
	 * @param m 实体类Memo的对象
	 */
	public static void insert(Memo m){
		try{
			Connection conn=DAO.getConn();									// 获得数据连接
			// 创建PreparedStatement对象，并传递SQL语句
			PreparedStatement ps=conn.prepareStatement("insert into tb_Memo (name,matter,MatterDate,TypeID) values(?,?,?,?)");
			ps.setString(1, m.getName());									// 通过实体类的实例为第1个参数赋值
			ps.setString(2, m.getMatter());									// 通过实体类的实例为第2个参数赋值
			// 创建日期格式化对象，并指定格式
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(m.getMatterDate());						// 将实体类的出生日期转换为Date类型
			ps.setTimestamp(3, new Timestamp(date.getTime()));				// 通过实体类的实例为第3个参数赋值
			ps.setInt(4, m.getTypeID());									// 通过实体类的实例为第4个参数赋值
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
	 * 修改联系人信息的方法
	 * @param m 实体类Memo的对象
	 */
	public static void update(Memo m){
		try{
			Connection conn=DAO.getConn();									// 获得连接
			String sql="update tb_Memo set name=?,matter=?,MatterDate=?,TypeID=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);				// 创建PreparedStatement对象，并传递SQL语句
			ps.setString(1, m.getName());									// 通过实体类的实例为第1个参数赋值
			ps.setString(2, m.getMatter());									// 通过实体类的实例为第2个参数赋值
			// 创建日期格式化对象，并指定格式
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(m.getMatterDate());						// 将实体类的出生日期转换为Date类型
			ps.setTimestamp(3, new Timestamp(date.getTime()));				// 通过实体类的实例为第3个参数赋值
			ps.setInt(4, m.getTypeID());									// 通过实体类的实例为第4个参数赋值
			ps.setInt(5,m.getId());									// 通过实体类的实例为第13个参数赋值
			int flag=ps.executeUpdate();									// 执行SQL语句，获得更新记录数
			if (flag>0){
				JOptionPane.showMessageDialog(null, "修改成功！");
			}else{
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
			ps.close();
			conn.close();													// 关闭连接
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "修改失败！\n"+ex.getMessage());
			ex.printStackTrace();
		}
	}
	/**
	 * 根据编号删除记录的方法
	 * @param id 编号
	 */
	public static void delete(int id){
		try{
			Connection conn=DAO.getConn();									// 获得连接
			// 创建PreparedStatement对象，并传递SQL语句
			PreparedStatement ps=conn.prepareStatement("delete from tb_Memo  where id=?");
			ps.setInt(1, id);													// 为参数赋值
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
	 * 查询满足条件的记录
	 * @param fieldName	字段名
	 * @param value	字段值
	 * @param typeId 备忘录类型ID
	 * @return	结果集的Vector对象
	 */
	public static Vector query(String fieldName,String sign,String value,int typeId){
		try{
			Vector vector=new Vector();									// 创建存放数据的向量
			Connection conn=DAO.getConn();									// 获得数据连接
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
				// 创建日期格式化对象，并指定格式
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				date1 = format1.parse(MemoDao.startDate);						// 将实体类的出生日期转换为Date类型
				//ps.setTimestamp(4, new Timestamp(date1.getTime()));				// 通过实体类的实例为第4个参数赋值
				// 创建日期格式化对象，并指定格式
				SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
				date2 = format2.parse(MemoDao.endDate);						// 将实体类的出生日期转换为Date类型
				//ps.setTimestamp(4, new Timestamp(date1.getTime()));				// 通过实体类的实例为第4个参数赋值
				sql = sql + " and MatterDate between ? and ?";
			}
			// 创建PreparedStatement对象，并传递SQL语句
			PreparedStatement ps=conn.prepareStatement(sql);
			if (MemoDao.flag){
				ps.setTimestamp(1, new Timestamp(date1.getTime()));
				ps.setTimestamp(2, new Timestamp(date2.getTime()));
			}
			ResultSet rs=ps.executeQuery();								// 执行SQL语句，获得查询结果集
			while (rs.next() && rs.getRow()>0){							// 遍历结果集
				Vector row=new Vector();					// 创建存放记录的向量
				// 为记录向量赋值
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
				vector.add(row);											// 将记录向量添加到数据向量
			}
			MemoDao.flag = false;
			MemoDao.startDate = null;
			MemoDao.endDate = null;
			rs.close();
			ps.close();
			conn.close();
			return vector;													// 返回数据向量
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "查询失败！\n"+ex.getMessage());
			return null;
		}
	}
	
	/**
	 * 查询满足条件的记录
	 * @param fieldName	字段名
	 * @param value	字段值
	 * @param typeId 备忘录类型ID
	 * @return	结果集的Vector对象
	 */
	public static void query(boolean flag,String startDate,String endDate){
		MemoDao.flag = flag;
		MemoDao.startDate = startDate;
		MemoDao.endDate = endDate;
	}
	
	/**
	 * 查询全部记录
	 * @return 结果集的Vector对象
	 */
	public static Vector query(){
		try{
			Vector vector=new Vector();									// 创建存放数据的向量
			Connection conn=DAO.getConn();									// 获得数据连接
			// 创建PreparedStatement对象，并传递SQL语句
			PreparedStatement ps=conn.prepareStatement("select * from tb_Memo");
			ResultSet rs=ps.executeQuery();								// 执行SQL语句，获得查询结果集
			while (rs.next() && rs.getRow()>0){								// 遍历结果集
				Vector row=new Vector();									// 创建存放记录的向量
				// 为记录向量赋值
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
				vector.add(row);											// 将记录向量添加到数据向量
			}
			rs.close();
			ps.close();
			conn.close();
			return vector;													// 返回数据向量
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "查询失败！\n"+ex.getMessage());
			return null;
		}
	}
	/**
	 * 按分类查询所有记录
	 * @param typeId 备忘录类型ID
	 * @return  结果集的Vector对象
	 */
	public static Vector query(int typeId){
		try{
			Vector vector=new Vector();									// 创建存放数据的向量
			Connection conn=DAO.getConn();									// 获得数据连接
			// 创建PreparedStatement对象，并传递SQL语句
			PreparedStatement ps=conn.prepareStatement("select * from tb_Memo  where TypeID=?");
			ps.setInt(1, typeId);											// 为参数赋值
			ResultSet rs=ps.executeQuery();								// 执行SQL语句，获得查询结果集
			while (rs.next() && rs.getRow()>0){							// 遍历结果集
				Vector row=new Vector();									// 创建存放记录的向量
				// 为记录向量赋值
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
				vector.add(row);											// 将记录向量添加到数据向量
			}
			rs.close();
			ps.close();
			conn.close();													// 关闭连接
			return vector;													// 返回数据向量
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "查询失败！\n"+ex.getMessage());
			return null;
		}
	}
}
