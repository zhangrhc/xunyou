package com.zzk.frame;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JPasswordField;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import com.zzk.dao.UserDao;
import com.zzk.panel.BackgroundPanel;

import java.awt.Font;
import java.net.URL;

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
public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
    private URL url = null;// 声明图片的URL
    private Image image=null;// 声明图像对象
    private BackgroundPanel jContentPane=null;// 声明背景面板
	private JTextField tf_user = null;
	private JPasswordField pf_pwd = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JPanel jPanel = null;
	private JButton btn_ok = null;
	private JButton jButton1 = null;
	private JLabel jLabel2 = null;
	
	/**
	 * This method initializes tf_user	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTf_user() {
		if (tf_user == null) {
			tf_user = new JTextField();
			tf_user.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					pf_pwd.requestFocus();
				}
			});
		}
		return tf_user;
	}

	/**
	 * This method initializes pf_pwd	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getPf_pwd() {
		if (pf_pwd == null) {
			pf_pwd = new JPasswordField();
			pf_pwd.setEchoChar('*');
			pf_pwd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String user = tf_user.getText().trim();
					String pwd = new String(pf_pwd.getPassword());
					if (UserDao.okUser(user, pwd)){
						MainFrame thisClass = new MainFrame();
						thisClass.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
						Toolkit tookit = thisClass.getToolkit();
						Dimension dm = tookit.getScreenSize();
						thisClass.setLocation((dm.width - thisClass.getWidth())/2, (dm.height-thisClass.getHeight())/2);
						thisClass.setVisible(true);
						dispose();
					}
				}
			});
		}
		return pf_pwd;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setOpaque(false);
			jPanel.setLayout(new FlowLayout());
			jPanel.add(getBtn_ok(), null);
			jPanel.add(getJButton1(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
    private JButton getBtn_ok() {
        if (btn_ok == null) {
            btn_ok = new JButton();
            btn_ok.setText("登    录");
            btn_ok.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String user = tf_user.getText().trim();
                    String pwd = new String(pf_pwd.getPassword());
                    if (UserDao.okUser(user, pwd)) {
                        MainFrame thisClass = new MainFrame();
                        thisClass
                                .setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        Toolkit tookit = thisClass.getToolkit();
                        Dimension dm = tookit.getScreenSize();
                        thisClass.setLocation(
                                (dm.width - thisClass.getWidth()) / 2,
                                (dm.height - thisClass.getHeight()) / 2);
                        thisClass.setVisible(true);
                        dispose();
                    }
                }
            });
        }
        return btn_ok;
    }

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("退    出");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return jButton1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginFrame thisClass = new LoginFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public LoginFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(282, 197);
		Toolkit tookit = this.getToolkit();
		Dimension dm = tookit.getScreenSize();
		this.setLocation((dm.width - this.getWidth())/2, (dm.height-this.getHeight())/2);
		this.setContentPane(getJContentPane());
		this.setTitle("系统登录窗体");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.weightx = 1.0D;
			gridBagConstraints5.weighty = 1.0D;
			gridBagConstraints5.fill = GridBagConstraints.BOTH;
			gridBagConstraints5.gridwidth = 2;
			gridBagConstraints5.gridy = 0;
			jLabel2 = new JLabel();  // 该标签用于占位用，并不显示任何内容
			jLabel2.setText("");
			jLabel2.setFont(new Font("Dialog", Font.BOLD, 24));
			jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints4.gridwidth = 2;
			gridBagConstraints4.insets = new Insets(8, 0, 8, 0);
			gridBagConstraints4.weightx = 1.0D;
			gridBagConstraints4.gridy = 3;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.insets = new Insets(12, 10, 0, 0);
			gridBagConstraints3.gridy = 2;
			jLabel1 = new JLabel();
			jLabel1.setText("密    码：");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.insets = new Insets(12, 10, 0, 0);
			gridBagConstraints2.gridy = 1;
			jLabel = new JLabel();
			jLabel.setText("用    户：");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridy = 2;
			gridBagConstraints1.weightx = 0.0D;
			gridBagConstraints1.insets = new Insets(10, 10, 0, 10);
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.gridy = 1;
			gridBagConstraints.weightx = 0.0D;
			gridBagConstraints.insets = new Insets(10, 10, 0, 10);
			gridBagConstraints.gridx = 1;
		    url = LoginFrame.class.getResource("/image/login.jpg");    // 获得图片的URL
            image=new ImageIcon(url).getImage();                       // 创建图像对象 
		    jContentPane=new BackgroundPanel(image);                   // 创建背景面板
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getTf_user(), gridBagConstraints);
			jContentPane.add(getPf_pwd(), gridBagConstraints1);
			jContentPane.add(jLabel, gridBagConstraints2);
			jContentPane.add(jLabel1, gridBagConstraints3);
			jContentPane.add(getJPanel(), gridBagConstraints4);
			jContentPane.add(jLabel2, gridBagConstraints5);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="9,10"
