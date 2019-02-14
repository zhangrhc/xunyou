package com.zzk.panel;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.zzk.bean.Memo;
import com.zzk.dao.MemoDao;
import com.zzk.tool.SaveStateTool;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.util.Vector;

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
public class EditQueryMemoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel = null;
	private JScrollPane jScrollPane = null;
	private JTable tb_memo = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JButton btn_update = null;
	private JLabel jLabel = null;
	private JComboBox cmb_field = null;
	private JComboBox cmb_sign = null;
	private JTextField tf_value = null;
	private JButton btn_all = null;
	private JCheckBox cb_dateSign = null;
	private JTextField tf_startDate = null;
	private JLabel jLabel1 = null;
	private JTextField tf_endDate = null;
	private JButton btn_query = null;
	private JLabel jLabel2 = null;
	private JTextField tf_xm = null;
	private JLabel jLabel3 = null;
	private JTextField tf_rq = null;
	private JLabel jLabel4 = null;
	private JButton btn_save = null;
	private JButton btn_delete = null;
	private JScrollPane jScrollPane1 = null;
	private JTextArea ta_nr = null;
	/**
	 * This is the default constructor
	 */
	public EditQueryMemoPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.gridx = 0;
		gridBagConstraints3.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints3.insets = new Insets(6, 0, 10, 0);
		gridBagConstraints3.gridy = 3;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints2.fill = GridBagConstraints.BOTH;
		gridBagConstraints2.weightx = 1.0D;
		gridBagConstraints2.weighty = 1.0D;
		gridBagConstraints2.insets = new Insets(6, 0, 0, 0);
		gridBagConstraints2.gridy = 2;
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.weighty = 1.0D;
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.gridy = 1;
		gridBagConstraints1.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints1.insets = new Insets(6, 10, 0, 10);
		gridBagConstraints1.gridheight = 1;
		gridBagConstraints1.weightx = 1.0;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 1.0D;
		gridBagConstraints.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints.gridy = 0;
		this.setSize(520, 352);
		this.setLayout(new GridBagLayout());
		this.add(getJPanel(), gridBagConstraints);
		this.add(getJScrollPane(), gridBagConstraints1);
		this.add(getJPanel1(), gridBagConstraints2);
		this.add(getJPanel2(), gridBagConstraints3);
		this.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent e) {
				Vector title = new Vector();
				title.add("编号");
				title.add("姓名");
				title.add("事件内容");
				title.add("事件日期");
				title.add("类型编号");
				Vector value = null;
				if (SaveStateTool.isMemoEditAndQueryClicked()) {
					if (SaveStateTool.getCurrentSingleMemoTypeId() != 0) {
						value = MemoDao.query(SaveStateTool.getCurrentSingleMemoTypeId());
					} else {
						value = MemoDao.query();
					}
				}
				DefaultTableModel model = new DefaultTableModel(value, title);
				tb_memo.setModel(model);
				if (tb_memo.getRowCount()>0){
					tb_memo.setRowSelectionInterval(0,0);
				}
				if (model.getRowCount()>0){
					int selectRow = tb_memo.getSelectedRow();
					if (selectRow>=0){
						tf_xm.setText((String)model.getValueAt(selectRow,1));
						ta_nr.setText((String)model.getValueAt(selectRow,2));
						tf_rq.setText((String)model.getValueAt(selectRow,3));
					}else{
						selectRow=0;
						tf_xm.setText((String)model.getValueAt(selectRow,1));
						ta_nr.setText((String)model.getValueAt(selectRow,2));
						tf_rq.setText((String)model.getValueAt(selectRow,3));
					}
				}
			}
		});
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 9;
			gridBagConstraints13.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints13.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints13.insets = new Insets(0, 10, 0, 10);
			gridBagConstraints13.gridy = 1;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints12.gridy = 1;
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints12.gridwidth = 3;
			gridBagConstraints12.insets = new Insets(4, 10, 0, 0);
			gridBagConstraints12.gridx = 5;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 4;
			gridBagConstraints11.insets = new Insets(0, 10, 0, 0);
			gridBagConstraints11.gridy = 1;
			jLabel1 = new JLabel();
			jLabel1.setText("终止日期：");
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints10.gridy = 1;
			gridBagConstraints10.weightx = 1.0;
			gridBagConstraints10.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints10.gridwidth = 3;
			gridBagConstraints10.insets = new Insets(4, 0, 0, 0);
			gridBagConstraints10.gridx = 1;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 0;
			gridBagConstraints9.insets = new Insets(2, 10, 0, 0);
			gridBagConstraints9.gridy = 1;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 9;
			gridBagConstraints8.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints8.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints8.insets = new Insets(0, 10, 0, 10);
			gridBagConstraints8.gridy = 0;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints7.gridy = 0;
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints7.gridwidth = 4;
			gridBagConstraints7.insets = new Insets(4, 10, 0, 0);
			gridBagConstraints7.gridx = 5;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints6.gridy = 0;
			gridBagConstraints6.weightx = 0.0D;
			gridBagConstraints6.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints6.insets = new Insets(0, 10, 0, 0);
			gridBagConstraints6.gridx = 4;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints5.gridy = 0;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints5.gridwidth = 3;
			gridBagConstraints5.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints5.gridx = 1;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.insets = new Insets(4, 18, 0, 0);
			gridBagConstraints4.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints4.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("查询条件：");
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(jLabel, gridBagConstraints4);
			jPanel.add(getCmb_field(), gridBagConstraints5);
			jPanel.add(getCmb_sign(), gridBagConstraints6);
			jPanel.add(getTf_value(), gridBagConstraints7);
			jPanel.add(getBtn_all(), gridBagConstraints8);
			jPanel.add(getCb_dateSign(), gridBagConstraints9);
			jPanel.add(getTf_startDate(), gridBagConstraints10);
			jPanel.add(jLabel1, gridBagConstraints11);
			jPanel.add(getTf_endDate(), gridBagConstraints12);
			jPanel.add(getBtn_query(), gridBagConstraints13);
		}
		return jPanel;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getTb_memo());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes tb_memo	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTb_memo() {
		
		Vector title = new Vector();
		title.add("编号");
		title.add("姓名");
		title.add("事件内容");
		title.add("事件日期");
		title.add("类型编号");
		Vector value = null;
		if (tb_memo == null) {
			if (SaveStateTool.isMemoEditAndQueryClicked()){
				if (SaveStateTool.getCurrentSingleMemoTypeId()!=0){
					value = MemoDao.query(SaveStateTool.getCurrentSingleMemoTypeId());
				}else{
					value = MemoDao.query();
				}
			}
			tb_memo = new JTable(value, title);
			tb_memo.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					DefaultTableModel model = (DefaultTableModel)tb_memo.getModel();
					tb_memo.setModel(model);
//					if (tb_memo.getRowCount()>0){
//						tb_memo.setRowSelectionInterval(0,0);
//					}
					if (model.getRowCount()>0){
						int selectRow = tb_memo.getSelectedRow();
						if (selectRow>=0){
							tf_xm.setText((String)model.getValueAt(selectRow,1));
							ta_nr.setText((String)model.getValueAt(selectRow,2));
							tf_rq.setText((String)model.getValueAt(selectRow,3));
						}else{
							selectRow=0;
							tf_xm.setText((String)model.getValueAt(selectRow,1));
							ta_nr.setText((String)model.getValueAt(selectRow,2));
							tf_rq.setText((String)model.getValueAt(selectRow,3));
						}
					}
				}
			});
		}
		return tb_memo;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.fill = GridBagConstraints.BOTH;
			gridBagConstraints19.gridy = 1;
			gridBagConstraints19.weightx = 1.0;
			gridBagConstraints19.weighty = 1.0;
			gridBagConstraints19.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints19.gridwidth = 3;
			gridBagConstraints19.insets = new Insets(10, 10, 0, 10);
			gridBagConstraints19.gridheight = 2;
			gridBagConstraints19.gridx = 1;
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 0;
			gridBagConstraints18.insets = new Insets(10, 10, 0, 0);
			gridBagConstraints18.gridy = 1;
			jLabel4 = new JLabel();
			jLabel4.setText("事件内容：");
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints17.gridy = 0;
			gridBagConstraints17.weightx = 1.0;
			gridBagConstraints17.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints17.insets = new Insets(0, 10, 0, 10);
			gridBagConstraints17.gridx = 3;
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.gridx = 2;
			gridBagConstraints16.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints16.insets = new Insets(0, 10, 0, 0);
			gridBagConstraints16.gridy = 0;
			jLabel3 = new JLabel();
			jLabel3.setText("时      间：");
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints15.gridy = 0;
			gridBagConstraints15.weightx = 1.0;
			gridBagConstraints15.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints15.insets = new Insets(0, 10, 0, 0);
			gridBagConstraints15.gridx = 1;
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.gridx = 0;
			gridBagConstraints14.insets = new Insets(0, 10, 0, 0);
			gridBagConstraints14.gridy = 0;
			jLabel2 = new JLabel();
			jLabel2.setText("姓      名：");
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.add(jLabel2, gridBagConstraints14);
			jPanel1.add(getTf_xm(), gridBagConstraints15);
			jPanel1.add(jLabel3, gridBagConstraints16);
			jPanel1.add(getTf_rq(), gridBagConstraints17);
			jPanel1.add(jLabel4, gridBagConstraints18);
			jPanel1.add(getJScrollPane1(), gridBagConstraints19);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setHgap(25);
			jPanel2 = new JPanel();
			jPanel2.setLayout(flowLayout);
			jPanel2.add(getBtn_update(), null);
			jPanel2.add(getBtn_save(), null);
			jPanel2.add(getBtn_delete(), null);
		}
		return jPanel2;
	}

	/**
	 * This method initializes btn_update	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn_update() {
		if (btn_update == null) {
			btn_update = new JButton();
			btn_update.setText("修    改");
			btn_update.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					btn_update.setEnabled(false);
					btn_save.setEnabled(true);
				}
			});
		}
		return btn_update;
	}

	/**
	 * This method initializes cmb_field	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCmb_field() {
		if (cmb_field == null) {
			cmb_field = new JComboBox();
			cmb_field.addItem("姓名");
			cmb_field.addItem("事件内容");
		}
		return cmb_field;
	}

	/**
	 * This method initializes cmb_sign	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCmb_sign() {
		if (cmb_sign == null) {
			cmb_sign = new JComboBox();
			cmb_sign.addItem("=");
			cmb_sign.addItem("like");
		}
		return cmb_sign;
	}

	/**
	 * This method initializes tf_value	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTf_value() {
		if (tf_value == null) {
			tf_value = new JTextField();
		}
		return tf_value;
	}

	/**
	 * This method initializes btn_all	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn_all() {
		if (btn_all == null) {
			btn_all = new JButton();
			btn_all.setText("全  部");
			btn_all.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Vector title = new Vector();
					title.add("编号");
					title.add("姓名");
					title.add("事件内容");
					title.add("事件日期");
					title.add("类型编号");
					Vector value = MemoDao.query();
					DefaultTableModel model = new DefaultTableModel(value, title);
					tb_memo.setModel(model);
					if (tb_memo.getRowCount()>0){
						tb_memo.setRowSelectionInterval(0,0);
					}
					if (model.getRowCount()>0){
						int selectRow = tb_memo.getSelectedRow();
						if (selectRow>=0){
							tf_xm.setText((String)model.getValueAt(selectRow,1));
							ta_nr.setText((String)model.getValueAt(selectRow,2));
							tf_rq.setText((String)model.getValueAt(selectRow,3));
						}else{
							selectRow=0;
							tf_xm.setText((String)model.getValueAt(selectRow,1));
							ta_nr.setText((String)model.getValueAt(selectRow,2));
							tf_rq.setText((String)model.getValueAt(selectRow,3));
						}
					}
				}
			});
		}
		return btn_all;
	}

	/**
	 * This method initializes cb_dateSign	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getCb_dateSign() {
		if (cb_dateSign == null) {
			cb_dateSign = new JCheckBox();
			cb_dateSign.setText("起始日期：");
		}
		return cb_dateSign;
	}

	/**
	 * This method initializes tf_startDate	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTf_startDate() {
		if (tf_startDate == null) {
			tf_startDate = new JTextField();
		}
		return tf_startDate;
	}

	/**
	 * This method initializes tf_endDate	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTf_endDate() {
		if (tf_endDate == null) {
			tf_endDate = new JTextField();
		}
		return tf_endDate;
	}

	/**
	 * This method initializes btn_query	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn_query() {
		if (btn_query == null) {
			btn_query = new JButton();
			btn_query.setText("查  询");
			btn_query.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String field = (String)cmb_field.getSelectedItem();
					if (field.equals("姓名")){
						field = "name";
					}else{
						field = "matter";
					}
					String sign = (String)cmb_sign.getSelectedItem();
					String value = tf_value.getText().trim();
					if (cb_dateSign.isSelected()){
						String startDate = tf_startDate.getText().trim();
						String endDate = tf_endDate.getText().trim();
						MemoDao.query(true, startDate, endDate);
					}
					int typeId = SaveStateTool.getCurrentSingleMemoTypeId();
					
					
					Vector title = new Vector();
					title.add("编号");
					title.add("姓名");
					title.add("事件内容");
					title.add("事件日期");
					title.add("类型编号");
					Vector vec = MemoDao.query(field, sign, value, typeId);
						
					DefaultTableModel model = new DefaultTableModel(vec, title);
					tb_memo.setModel(model);
					if (tb_memo.getRowCount()>0){
						tb_memo.setRowSelectionInterval(0,0);
					}
					if (model.getRowCount()>0){
						int selectRow = tb_memo.getSelectedRow();
						if (selectRow>=0){
							tf_xm.setText((String)model.getValueAt(selectRow,1));
							ta_nr.setText((String)model.getValueAt(selectRow,2));
							tf_rq.setText((String)model.getValueAt(selectRow,3));
						}else{
							selectRow=0;
							tf_xm.setText((String)model.getValueAt(selectRow,1));
							ta_nr.setText((String)model.getValueAt(selectRow,2));
							tf_rq.setText((String)model.getValueAt(selectRow,3));
						}
					}
					
				}
			});
		}
		return btn_query;
	}

	/**
	 * This method initializes tf_xm	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTf_xm() {
		if (tf_xm == null) {
			tf_xm = new JTextField();
		}
		return tf_xm;
	}

	/**
	 * This method initializes tf_rq	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTf_rq() {
		if (tf_rq == null) {
			tf_rq = new JTextField();
		}
		return tf_rq;
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
					DefaultTableModel model = (DefaultTableModel)tb_memo.getModel();
					int id = 0;
					if (model.getRowCount()>0){
						int selectRow = tb_memo.getSelectedRow();
						if (selectRow>=0){
							id =  Integer.parseInt((String)model.getValueAt(selectRow,0));
							
						}
						int memoTypeId = Integer.parseInt((String)model.getValueAt(selectRow,4));
						String xm = tf_xm.getText().trim();
						String nr = ta_nr.getText().trim();
						String rq = tf_rq.getText().trim();
						Memo memo = new Memo();
						memo.setId(id);
						memo.setName(xm);
						memo.setMatter(nr);
						memo.setMatterDate(rq);
						memo.setTypeID(memoTypeId);
						MemoDao.update(memo);
						btn_update.setEnabled(true);
						btn_save.setEnabled(false);
						requestFocus();
					}
				}
			});
		}
		return btn_save;
	}

	/**
	 * This method initializes btn_delete	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn_delete() {
		if (btn_delete == null) {
			btn_delete = new JButton();
			btn_delete.setText("删    除");
			btn_delete.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DefaultTableModel model = (DefaultTableModel)tb_memo.getModel();
					int id = 0;
					if (model.getRowCount()>0){
						int selectRow = tb_memo.getSelectedRow();
						if (selectRow>=0){
							id =  Integer.parseInt((String)model.getValueAt(selectRow,0));
							int option = JOptionPane.showConfirmDialog(null, "确实要删除吗？");
							if (option == JOptionPane.YES_OPTION){
								MemoDao.delete(id);
							}
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "没有数据。");
					}
					requestFocus();
				}
			});
		}
		return btn_delete;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getTa_nr());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes ta_nr	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTa_nr() {
		if (ta_nr == null) {
			ta_nr = new JTextArea();
		}
		return ta_nr;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
