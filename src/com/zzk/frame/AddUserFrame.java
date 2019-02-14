package com.zzk.frame;

import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Rectangle;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
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
public class AddUserFrame extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JTextField tf_username = null;
	private JLabel jLabel2 = null;
	private JPasswordField pf_pwd = null;
	private JPasswordField pf_okPwd = null;
	private JButton jButton = null;
	private JButton jButton1 = null;

	/**
	 * This method initializes tf_username	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTf_username() {
		if (tf_username == null) {
			tf_username = new JTextField();
			tf_username.setBounds(new Rectangle(106, 26, 203, 22));
		}
		return tf_username;
	}

	/**
	 * This method initializes pf_pwd	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getPf_pwd() {
		if (pf_pwd == null) {
			pf_pwd = new JPasswordField();
			pf_pwd.setBounds(new Rectangle(106, 59, 202, 22));
			pf_pwd.setEchoChar('*');
		}
		return pf_pwd;
	}

	/**
	 * This method initializes pf_okPwd	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getPf_okPwd() {
		if (pf_okPwd == null) {
			pf_okPwd = new JPasswordField();
			pf_okPwd.setBounds(new Rectangle(106, 91, 201, 22));
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
			jButton.setBounds(new Rectangle(58, 130, 84, 28));
			jButton.setText("保    存");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String user = tf_username.getText().trim();
					String pwd = new String(pf_pwd.getPassword()).trim();
					String okPwd = new String(pf_okPwd.getPassword()).trim();
					if (user.length()==0 || pwd.length()==0 || okPwd.length()==0){
						JOptionPane.showMessageDialog(null, "用户名或密码不能为空");
						return;
					}
					UserDao.addUser(user, pwd, okPwd);
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
			jButton1.setBounds(new Rectangle(185, 129, 84, 29));
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
//				AddUserFrame thisClass = new AddUserFrame();
//				thisClass.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//				thisClass.setVisible(true);
//			}
//		});
//	}

	/**
	 * This is the default constructor
	 */
	public AddUserFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(353, 212);
		this.setModal(true);
		this.setContentPane(getJContentPane());
		this.setTitle("添加用户窗体");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(24, 89, 75, 24));
			jLabel2.setText("确认密码：");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(30, 55, 65, 25));
			jLabel1.setText("密      码：");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(29, 24, 68, 24));
			jLabel.setText("用      户：");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getTf_username(), null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getPf_pwd(), null);
			jContentPane.add(getPf_okPwd(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
