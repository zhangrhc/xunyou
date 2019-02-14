package com.zzk.frame;

import javax.swing.SwingUtilities;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.zzk.bean.MemoType;
import com.zzk.bean.Sort;
import com.zzk.dao.MemoTypeDao;
import com.zzk.dao.SortDao;

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
public class AddMemoTypeFrame extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JTextField tf_memoType = null;
	private JButton jButton = null;
	private JButton jButton1 = null;

	/**
	 * This method initializes tf_memoType	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTf_memoType() {
		if (tf_memoType == null) {
			tf_memoType = new JTextField();
			tf_memoType.setBounds(new Rectangle(102, 66, 168, 27));
		}
		return tf_memoType;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(38, 111, 84, 29));
			jButton.setText("确    定");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String memoTypeName = tf_memoType.getText().trim();
					if (memoTypeName!=null && !memoTypeName.equals("")){
						MemoType memoType = new MemoType();
						memoType.setMemoType(memoTypeName);
						MemoTypeDao.insert(memoType);
						MemoTypeDao.queryMemoTypeAndID();
						MemoTypeDao.queryCurrentTypeId(memoTypeName);
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "请输入备忘录类型名。");
					}
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(146, 110, 86, 30));
			jButton1.setText("返    回");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jButton1;
	}

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				AddMemoTypeFrame thisClass = new AddMemoTypeFrame();
//				thisClass.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//				thisClass.setVisible(true);
//			}
//		});
//	}

	/**
	 * This is the default constructor
	 */
	public AddMemoTypeFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 194);
		this.setModal(true);
		this.setContentPane(getJContentPane());
		this.setTitle("添加备忘录类型窗体");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(15, 65, 85, 27));
			jLabel1.setText("备忘录类型：");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(35, 11, 213, 46));
			jLabel.setFont(new Font("Dialog", Font.BOLD, 24));
			jLabel.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel.setText("添加备忘录类型");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getTf_memoType(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
