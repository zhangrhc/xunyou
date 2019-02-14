package com.zzk.panel;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import com.zzk.bean.Memo;
import com.zzk.dao.MemoDao;
import com.zzk.tool.SaveStateTool;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
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
public class AddMemoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JTextField tf_name = null;
	private JLabel jLabel2 = null;
	private JScrollPane jScrollPane = null;
	private JTextArea ta_matter = null;
	private JLabel jLabel3 = null;
	private JTextField tf_date = null;
	private JPanel jPanel = null;
	private JButton btn_add = null;
	private JButton btn_save = null;
	/**
	 * This is the default constructor
	 */
	public AddMemoPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
		gridBagConstraints31.gridx = 0;
		gridBagConstraints31.gridwidth = 2;
		gridBagConstraints31.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints31.insets = new Insets(8, 0, 8, 0);
		gridBagConstraints31.gridy = 5;
		GridBagConstraints gridBagConstraints30 = new GridBagConstraints();
		gridBagConstraints30.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints30.gridy = 4;
		gridBagConstraints30.weightx = 1.0;
		gridBagConstraints30.insets = new Insets(10, 10, 0, 10);
		gridBagConstraints30.gridx = 1;
		GridBagConstraints gridBagConstraints29 = new GridBagConstraints();
		gridBagConstraints29.gridx = 0;
		gridBagConstraints29.insets = new Insets(12, 10, 0, 0);
		gridBagConstraints29.gridy = 4;
		jLabel3 = new JLabel();
		jLabel3.setText("时    间：");
		GridBagConstraints gridBagConstraints28 = new GridBagConstraints();
		gridBagConstraints28.fill = GridBagConstraints.BOTH;
		gridBagConstraints28.gridy = 2;
		gridBagConstraints28.weightx = 1.0;
		gridBagConstraints28.weighty = 3.0D;
		gridBagConstraints28.insets = new Insets(10, 10, 0, 10);
		gridBagConstraints28.gridheight = 2;
		gridBagConstraints28.gridx = 1;
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.gridx = 0;
		gridBagConstraints3.insets = new Insets(12, 10, 0, 0);
		gridBagConstraints3.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints3.gridy = 2;
		jLabel2 = new JLabel();
		jLabel2.setText("事    件：");
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints2.gridy = 1;
		gridBagConstraints2.weightx = 1.0;
		gridBagConstraints2.insets = new Insets(10, 10, 0, 10);
		gridBagConstraints2.gridx = 1;
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.insets = new Insets(12, 10, 0, 0);
		gridBagConstraints1.gridy = 1;
		jLabel1 = new JLabel();
		jLabel1.setText("姓    名：");
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.weightx = 1.0D;
		gridBagConstraints.weighty = 0.0D;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.gridy = 0;
		jLabel = new JLabel();
		//jLabel.setText("");
		jLabel.setOpaque(true);
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setBackground(new Color(188, 92, 198));
		jLabel.setText("");
		jLabel.setIcon(new ImageIcon(getClass().getResource("/image/备忘录信息.jpg")));
		//jLabel.setFont(new Font("Dialog", Font.BOLD, 36));
		this.setSize(520, 352);
		this.setLayout(new GridBagLayout());
		this.add(jLabel, gridBagConstraints);
		this.add(jLabel1, gridBagConstraints1);
		this.add(getTf_name(), gridBagConstraints2);
		this.add(jLabel2, gridBagConstraints3);
		this.add(getJScrollPane(), gridBagConstraints28);
		this.add(jLabel3, gridBagConstraints29);
		this.add(getTf_date(), gridBagConstraints30);
		this.add(getJPanel(), gridBagConstraints31);
		btn_save.setEnabled(false);
	}

	/**
	 * This method initializes tf_name	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTf_name() {
		if (tf_name == null) {
			tf_name = new JTextField();
		}
		return tf_name;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getTa_matter());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes ta_matter	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTa_matter() {
		if (ta_matter == null) {
			ta_matter = new JTextArea();
		}
		return ta_matter;
	}

	/**
	 * This method initializes tf_date	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTf_date() {
		if (tf_date == null) {
			tf_date = new JTextField();
		}
		return tf_date;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setHgap(25);
			jPanel = new JPanel();
			jPanel.setLayout(flowLayout);
			jPanel.add(getBtn_add(), null);
			jPanel.add(getBtn_save(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes btn_add	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn_add() {
		if (btn_add == null) {
			btn_add = new JButton();
			btn_add.setText("添    加");
			btn_add.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					btn_add.setEnabled(false);
					btn_save.setEnabled(true);
				}
			});
		}
		return btn_add;
	}

	/**
	 * This method initializes btn_save	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn_save() {
		if (btn_save == null) {
			btn_save = new JButton();
			btn_save.setText("保    存");
			btn_save.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int typeId = SaveStateTool.getCurrentSingleMemoTypeId();
					if (typeId == 0){
						JOptionPane.showMessageDialog(null, "没有选择备忘录类型，请先选择备忘录类型。");
						return;
					}else{
						String xm = tf_name.getText().trim();
						String nr = ta_matter.getText().trim();
						String rq = tf_date.getText().trim();
						Memo memo = new Memo();
						memo.setName(xm);
						memo.setMatter(nr);
						memo.setMatterDate(rq);
						memo.setTypeID(typeId);
						MemoDao.insert(memo);
					}
					btn_add.setEnabled(true);
					btn_save.setEnabled(false);
				
				}
			});
		}
		return btn_save;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
