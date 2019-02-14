package com.zzk.frame;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Dimension;
import javax.swing.JButton;

import com.zzk.dao.UserDao;

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
public class UpdatePasswordFrame extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabel1 = null;
	private JPasswordField pf_oldPwd = null;
	private JLabel jLabel2 = null;
	private JPasswordField pf_newPwd = null;
	private JLabel jLabel3 = null;
	private JPasswordField pf_okPwd = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	/**
	 * This method initializes pf_oldPwd	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getPf_oldPwd() {
		if (pf_oldPwd == null) {
			pf_oldPwd = new JPasswordField();
			pf_oldPwd.setBounds(new Rectangle(99, 15, 215, 25));
			pf_oldPwd.setEchoChar('*');
		}
		return pf_oldPwd;
	}

	/**
	 * This method initializes pf_newPwd	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getPf_newPwd() {
		if (pf_newPwd == null) {
			pf_newPwd = new JPasswordField();
			pf_newPwd.setBounds(new Rectangle(100, 51, 214, 26));
			pf_newPwd.setEchoChar('*');
		}
		return pf_newPwd;
	}

	/**
	 * This method initializes pf_okPwd	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getPf_okPwd() {
		if (pf_okPwd == null) {
			pf_okPwd = new JPasswordField();
			pf_okPwd.setBounds(new Rectangle(101, 89, 213, 26));
			pf_okPwd.setEchoChar('*');
		}
		return pf_okPwd;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(40, 128, 98, 31));
			jButton.setText("修    改");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String oldPwd = new String(pf_oldPwd.getPassword()).trim();
					String newPwd = new String(pf_newPwd.getPassword()).trim();
					String okPwd = new String(pf_okPwd.getPassword()).trim();
					if (oldPwd.length()==0 || newPwd.length()==0 || okPwd.length()==0){
						JOptionPane.showMessageDialog(null, "密码不能为空。");
						return;
					}
					UserDao.updateUser(oldPwd, newPwd, okPwd);
					dispose();
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
			jButton1.setBounds(new Rectangle(195, 129, 97, 32));
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
//				UpdatePasswordFrame thisClass = new UpdatePasswordFrame();
//				thisClass.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//				thisClass.setVisible(true);
//			}
//		});
//	}

	/**
	 * This is the default constructor
	 */
	public UpdatePasswordFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(354, 210);
		this.setModal(true);
		this.setContentPane(getJContentPane());
		this.setTitle("修改用户密码窗体");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(23, 89, 76, 26));
			jLabel3.setText("确认密码：");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(26, 51, 67, 26));
			jLabel2.setText("新 密 码：");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(26, 16, 66, 24));
			jLabel1.setText("原 密 码：");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getPf_oldPwd(), null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getPf_newPwd(), null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(getPf_okPwd(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
