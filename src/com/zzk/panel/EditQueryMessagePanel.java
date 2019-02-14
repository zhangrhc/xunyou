package com.zzk.panel;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.zzk.bean.LinkMan;
import com.zzk.dao.LinkManDao;
import com.zzk.tool.SaveStateTool;

import java.awt.FlowLayout;
import java.awt.Color;
import java.io.File;
import java.sql.Blob;
import java.sql.SQLException;
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
public class EditQueryMessagePanel extends JPanel {
    
    private static final long serialVersionUID = 1L;
    private JPanel jPanel = null;
    private JLabel jLabel = null;
    private JComboBox cmb_field = null;
    private JTextField tf_fieldValue = null;
    private JButton btn_query = null;
    private JButton jButton1 = null;
    private JPanel jPanel1 = null;
    private JLabel jLabel2 = null;
    private JScrollPane jScrollPane = null;
    private JTable tb_message = null;
    private JTextField tf_xm = null;
    private JLabel jLabel3 = null;
    private JRadioButton rb_nan = null;
    private JRadioButton rb_nv = null;
    private JLabel jLabel4 = null;
    private JTextField tf_gzdw = null;
    private JLabel jLabel5 = null;
    private JTextField tf_csrq = null;
    private JLabel jLabel6 = null;
    private JTextField tf_zw = null;
    private JLabel jLabel7 = null;
    private JTextField tf_dh = null;
    private JLabel jLabel8 = null;
    private JTextField tf_dz = null;
    private JLabel jLabel9 = null;
    private JTextField tf_yb = null;
    private JLabel jLabel10 = null;
    private JLabel jLabel11 = null;
    private JLabel jLabel12 = null;
    private JTextField tf_qq = null;
    private JTextField tf_email = null;
    private JPanel jPanel2 = null;
    private JButton btn_update = null;
    private JButton btn_save = null;
    private JButton btn_delete = null;
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JLabel lbl_picture = null;
    private JButton btn_selectPicture = null;
    private String picturePath = null;
    
    /**
     * This is the default constructor
     */
    public EditQueryMessagePanel() {
        super();
        initialize();
    }
    
    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        GridBagConstraints gridBagConstraints37 = new GridBagConstraints();
        gridBagConstraints37.gridx = 0;
        gridBagConstraints37.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints37.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints37.weightx = 1.0D;
        gridBagConstraints37.gridy = 3;
        GridBagConstraints gridBagConstraints36 = new GridBagConstraints();
        gridBagConstraints36.gridx = 0;
        gridBagConstraints36.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints36.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints36.insets = new Insets(2, 0, 0, 0);
        gridBagConstraints36.weightx = 1.0D;
        gridBagConstraints36.gridy = 2;
        GridBagConstraints gridBagConstraints35 = new GridBagConstraints();
        gridBagConstraints35.fill = GridBagConstraints.BOTH;
        gridBagConstraints35.gridy = 1;
        gridBagConstraints35.weightx = 1.0;
        gridBagConstraints35.weighty = 1.0D;
        gridBagConstraints35.insets = new Insets(6, 10, 0, 10);
        gridBagConstraints35.gridx = 0;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0D;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        gridBagConstraints.gridy = 0;
        this.setSize(520, 352);
        this.setLayout(new GridBagLayout());
        this.add(getJPanel(), gridBagConstraints);
        this.add(getJScrollPane(), gridBagConstraints35);
        this.add(getJPanel1(), gridBagConstraints36);
        this.add(getJPanel2(), gridBagConstraints37);
        
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                Vector title = new Vector();
                title.add("编号");
                title.add("姓名");
                title.add("性别");
                title.add("工作单位");
                title.add("出生日期");
                title.add("职务");
                title.add("电话");
                title.add("地址");
                title.add("邮编");
                title.add("QQ号码");
                title.add("电子邮件");
                title.add("照片");
                title.add("分类编号");
                Vector value = null;
                if (SaveStateTool.isMessageEditAndQueryClicked()) {
                    if (SaveStateTool.getCurrentSingleSortId() != 0) {
                        value = LinkManDao.query(SaveStateTool
                                .getCurrentSingleSortId());
                    } else {
                        value = LinkManDao.query();
                    }
                }
                DefaultTableModel model = new DefaultTableModel(value, title);
                tb_message.setModel(model);
                if (tb_message.getRowCount() > 0) {
                    tb_message.setRowSelectionInterval(0, 0);
                }
                if (model.getRowCount() > 0) {
                    int selectRow = tb_message.getSelectedRow();
                    if (selectRow >= 0) {
                        tf_xm.setText((String) model.getValueAt(selectRow, 1));
                        if (((String) model.getValueAt(selectRow, 2))
                                .equals("男")) {
                            rb_nan.setSelected(true);
                        } else {
                            rb_nv.setSelected(true);
                        }
                        tf_gzdw
                                .setText((String) model
                                        .getValueAt(selectRow, 3));
                        tf_csrq
                                .setText((String) model
                                        .getValueAt(selectRow, 4));
                        tf_zw.setText((String) model.getValueAt(selectRow, 5));
                        tf_dh.setText((String) model.getValueAt(selectRow, 6));
                        tf_dz.setText((String) model.getValueAt(selectRow, 7));
                        tf_yb.setText((String) model.getValueAt(selectRow, 8));
                        tf_qq.setText((String) model.getValueAt(selectRow, 9));
                        tf_email.setText((String) model.getValueAt(selectRow,
                                10));
                        ImageIcon icon = (ImageIcon) model.getValueAt(
                                selectRow, 11);
                        lbl_picture.setIcon(icon);
                    } else {
                        selectRow = 0;
                        tf_xm.setText((String) model.getValueAt(selectRow, 1));
                        if (((String) model.getValueAt(selectRow, 2))
                                .equals("男")) {
                            rb_nan.setSelected(true);
                        } else {
                            rb_nv.setSelected(true);
                        }
                        tf_gzdw
                                .setText((String) model
                                        .getValueAt(selectRow, 3));
                        tf_csrq
                                .setText((String) model
                                        .getValueAt(selectRow, 4));
                        tf_zw.setText((String) model.getValueAt(selectRow, 5));
                        tf_dh.setText((String) model.getValueAt(selectRow, 6));
                        tf_dz.setText((String) model.getValueAt(selectRow, 7));
                        tf_yb.setText((String) model.getValueAt(selectRow, 8));
                        tf_qq.setText((String) model.getValueAt(selectRow, 9));
                        tf_email.setText((String) model.getValueAt(selectRow,
                                10));
                        ImageIcon icon = (ImageIcon) model.getValueAt(
                                selectRow, 11);
                        lbl_picture.setIcon(icon);
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
            GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
            gridBagConstraints6.gridx = 9;
            gridBagConstraints6.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints6.insets = new Insets(0, 10, 0, 10);
            gridBagConstraints6.gridy = 0;
            GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
            gridBagConstraints5.gridx = 7;
            gridBagConstraints5.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints5.insets = new Insets(0, 10, 0, 10);
            gridBagConstraints5.gridy = 0;
            GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
            gridBagConstraints4.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints4.gridy = 0;
            gridBagConstraints4.weightx = 1.0D;
            gridBagConstraints4.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints4.insets = new Insets(4, 10, 0, 0);
            gridBagConstraints4.gridwidth = 3;
            gridBagConstraints4.gridx = 4;
            GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
            gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints2.gridy = 0;
            gridBagConstraints2.weightx = 0.0D;
            gridBagConstraints2.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints2.gridwidth = 3;
            gridBagConstraints2.insets = new Insets(0, 0, 0, 0);
            gridBagConstraints2.gridx = 1;
            GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
            gridBagConstraints1.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints1.gridy = 0;
            gridBagConstraints1.insets = new Insets(4, 18, 0, 0);
            gridBagConstraints1.gridx = 0;
            jLabel = new JLabel();
            jLabel.setText("查询条件：");
            jPanel = new JPanel();
            jPanel.setLayout(new GridBagLayout());
            jPanel.add(jLabel, gridBagConstraints1);
            jPanel.add(getCmb_field(), gridBagConstraints2);
            jPanel.add(getTf_fieldValue(), gridBagConstraints4);
            jPanel.add(getBtn_query(), gridBagConstraints5);
            jPanel.add(getJButton1(), gridBagConstraints6);
        }
        return jPanel;
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
            cmb_field.addItem("工作单位");
            cmb_field.addItem("职务");
            cmb_field.addItem("电话");
            cmb_field.addItem("QQ号码");
        }
        return cmb_field;
    }
    
    /**
     * This method initializes tf_fieldValue
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getTf_fieldValue() {
        if (tf_fieldValue == null) {
            tf_fieldValue = new JTextField();
        }
        return tf_fieldValue;
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
                    String fieldName = (String) cmb_field.getSelectedItem();
                    String field = null;
                    if (fieldName.equals("姓名")) {
                        field = "name";
                    } else if (fieldName.equals("工作单位")) {
                        field = "employment";
                    } else if (fieldName.equals("职务")) {
                        field = "principalship";
                    } else if (fieldName.equals("电话")) {
                        field = "telephone";
                    } else {
                        field = "QQ";
                    }
                    String fieldValue = (String) tf_fieldValue.getText().trim();
                    Vector title = new Vector();
                    title.add("编号");
                    title.add("姓名");
                    title.add("性别");
                    title.add("工作单位");
                    title.add("出生日期");
                    title.add("职务");
                    title.add("电话");
                    title.add("地址");
                    title.add("邮编");
                    title.add("QQ号码");
                    title.add("电子邮件");
                    title.add("照片");
                    title.add("分类编号");
                    Vector value = null;
                    int sortId = SaveStateTool.getCurrentSingleSortId();
                    if (sortId != 0) {
                        value = LinkManDao.query(field, fieldValue, sortId);
                    } else {
                        value = LinkManDao.query(field, fieldValue);
                    }
                    DefaultTableModel model = new DefaultTableModel(value,
                            title);
                    tb_message.setModel(model);
                    if (tb_message.getRowCount() > 0) {
                        tb_message.setRowSelectionInterval(0, 0);
                    }
                    if (model.getRowCount() > 0) {
                        int selectRow = tb_message.getSelectedRow();
                        if (selectRow >= 0) {
                            tf_xm.setText((String) model.getValueAt(selectRow,
                                    1));
                            if (((String) model.getValueAt(selectRow, 2))
                                    .equals("男")) {
                                rb_nan.setSelected(true);
                            } else {
                                rb_nv.setSelected(true);
                            }
                            tf_gzdw.setText((String) model.getValueAt(
                                    selectRow, 3));
                            tf_csrq.setText((String) model.getValueAt(
                                    selectRow, 4));
                            tf_zw.setText((String) model.getValueAt(selectRow,
                                    5));
                            tf_dh.setText((String) model.getValueAt(selectRow,
                                    6));
                            tf_dz.setText((String) model.getValueAt(selectRow,
                                    7));
                            tf_yb.setText((String) model.getValueAt(selectRow,
                                    8));
                            tf_qq.setText((String) model.getValueAt(selectRow,
                                    9));
                            tf_email.setText((String) model.getValueAt(
                                    selectRow, 10));
                            ImageIcon icon = (ImageIcon) model.getValueAt(
                                    selectRow, 11);
                            lbl_picture.setIcon(icon);
                        } else {
                            selectRow = 0;
                            tf_xm.setText((String) model.getValueAt(selectRow,
                                    1));
                            if (((String) model.getValueAt(selectRow, 2))
                                    .equals("男")) {
                                rb_nan.setSelected(true);
                            } else {
                                rb_nv.setSelected(true);
                            }
                            tf_gzdw.setText((String) model.getValueAt(
                                    selectRow, 3));
                            tf_csrq.setText((String) model.getValueAt(
                                    selectRow, 4));
                            tf_zw.setText((String) model.getValueAt(selectRow,
                                    5));
                            tf_dh.setText((String) model.getValueAt(selectRow,
                                    6));
                            tf_dz.setText((String) model.getValueAt(selectRow,
                                    7));
                            tf_yb.setText((String) model.getValueAt(selectRow,
                                    8));
                            tf_qq.setText((String) model.getValueAt(selectRow,
                                    9));
                            tf_email.setText((String) model.getValueAt(
                                    selectRow, 10));
                            ImageIcon icon = (ImageIcon) model.getValueAt(
                                    selectRow, 11);
                            lbl_picture.setIcon(icon);
                        }
                        
                    }
                }
            });
        }
        return btn_query;
    }
    
    /**
     * This method initializes jButton1
     * 
     * @return javax.swing.JButton
     */
    private JButton getJButton1() {
        if (jButton1 == null) {
            jButton1 = new JButton();
            jButton1.setText("全  部");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    Vector title = new Vector();
                    title.add("编号");
                    title.add("姓名");
                    title.add("性别");
                    title.add("工作单位");
                    title.add("出生日期");
                    title.add("职务");
                    title.add("电话");
                    title.add("地址");
                    title.add("邮编");
                    title.add("QQ号码");
                    title.add("电子邮件");
                    title.add("照片");
                    title.add("分类编号");
                    Vector value = LinkManDao.query();
                    
                    DefaultTableModel model = new DefaultTableModel(value,
                            title);
                    tb_message.setModel(model);
                    if (tb_message.getRowCount() > 0) {
                        tb_message.setRowSelectionInterval(0, 0);
                    }
                    if (model.getRowCount() > 0) {
                        int selectRow = tb_message.getSelectedRow();
                        if (selectRow >= 0) {
                            tf_xm.setText((String) model.getValueAt(selectRow,
                                    1));
                            if (((String) model.getValueAt(selectRow, 2))
                                    .equals("男")) {
                                rb_nan.setSelected(true);
                            } else {
                                rb_nv.setSelected(true);
                            }
                            tf_gzdw.setText((String) model.getValueAt(
                                    selectRow, 3));
                            tf_csrq.setText((String) model.getValueAt(
                                    selectRow, 4));
                            tf_zw.setText((String) model.getValueAt(selectRow,
                                    5));
                            tf_dh.setText((String) model.getValueAt(selectRow,
                                    6));
                            tf_dz.setText((String) model.getValueAt(selectRow,
                                    7));
                            tf_yb.setText((String) model.getValueAt(selectRow,
                                    8));
                            tf_qq.setText((String) model.getValueAt(selectRow,
                                    9));
                            tf_email.setText((String) model.getValueAt(
                                    selectRow, 10));
                            ImageIcon icon = (ImageIcon) model.getValueAt(
                                    selectRow, 11);
                            lbl_picture.setIcon(icon);
                        } else {
                            selectRow = 0;
                            tf_xm.setText((String) model.getValueAt(selectRow,
                                    1));
                            if (((String) model.getValueAt(selectRow, 2))
                                    .equals("男")) {
                                rb_nan.setSelected(true);
                            } else {
                                rb_nv.setSelected(true);
                            }
                            tf_gzdw.setText((String) model.getValueAt(
                                    selectRow, 3));
                            tf_csrq.setText((String) model.getValueAt(
                                    selectRow, 4));
                            tf_zw.setText((String) model.getValueAt(selectRow,
                                    5));
                            tf_dh.setText((String) model.getValueAt(selectRow,
                                    6));
                            tf_dz.setText((String) model.getValueAt(selectRow,
                                    7));
                            tf_yb.setText((String) model.getValueAt(selectRow,
                                    8));
                            tf_qq.setText((String) model.getValueAt(selectRow,
                                    9));
                            tf_email.setText((String) model.getValueAt(
                                    selectRow, 10));
                            ImageIcon icon = (ImageIcon) model.getValueAt(
                                    selectRow, 11);
                            lbl_picture.setIcon(icon);
                        }
                        
                    }
                }
            });
        }
        return jButton1;
    }
    
    /**
     * This method initializes jPanel1
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel1() {
        if (jPanel1 == null) {
            GridBagConstraints gridBagConstraints34 = new GridBagConstraints();
            gridBagConstraints34.gridx = 6;
            gridBagConstraints34.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints34.gridheight = 1;
            gridBagConstraints34.insets = new Insets(0, 10, 0, 10);
            gridBagConstraints34.gridy = 5;
            GridBagConstraints gridBagConstraints29 = new GridBagConstraints();
            gridBagConstraints29.gridx = 4;
            gridBagConstraints29.gridheight = 4;
            gridBagConstraints29.gridwidth = 2;
            gridBagConstraints29.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints29.fill = GridBagConstraints.BOTH;
            gridBagConstraints29.insets = new Insets(2, 10, 0, 0);
            gridBagConstraints29.weightx = 1.0D;
            gridBagConstraints29.weighty = 1.0D;
            gridBagConstraints29.gridy = 3;
            lbl_picture = new JLabel();
            lbl_picture.setText(" ");
            lbl_picture.setBackground(new Color(128, 111, 223));
            lbl_picture.setToolTipText("单击可以选择照片");
            lbl_picture.setOpaque(true);
            GridBagConstraints gridBagConstraints33 = new GridBagConstraints();
            gridBagConstraints33.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints33.gridy = 6;
            gridBagConstraints33.weightx = 1.0D;
            gridBagConstraints33.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints33.gridwidth = 1;
            gridBagConstraints33.insets = new Insets(2, 10, 0, 0);
            gridBagConstraints33.gridx = 1;
            GridBagConstraints gridBagConstraints32 = new GridBagConstraints();
            gridBagConstraints32.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints32.gridy = 5;
            gridBagConstraints32.weightx = 1.0D;
            gridBagConstraints32.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints32.gridwidth = 2;
            gridBagConstraints32.insets = new Insets(4, 10, 0, 0);
            gridBagConstraints32.gridx = 1;
            GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
            gridBagConstraints31.gridx = 0;
            gridBagConstraints31.insets = new Insets(4, 10, 0, 0);
            gridBagConstraints31.gridy = 6;
            jLabel12 = new JLabel();
            jLabel12.setText("E-Mail：");
            GridBagConstraints gridBagConstraints30 = new GridBagConstraints();
            gridBagConstraints30.gridx = 0;
            gridBagConstraints30.insets = new Insets(4, 10, 0, 0);
            gridBagConstraints30.gridy = 5;
            jLabel11 = new JLabel();
            jLabel11.setText("QQ号码：");
            GridBagConstraints gridBagConstraints28 = new GridBagConstraints();
            gridBagConstraints28.gridx = 3;
            gridBagConstraints28.insets = new Insets(4, 10, 0, 0);
            gridBagConstraints28.gridy = 3;
            jLabel10 = new JLabel();
            jLabel10.setText("照      片：");
            GridBagConstraints gridBagConstraints27 = new GridBagConstraints();
            gridBagConstraints27.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints27.gridy = 4;
            gridBagConstraints27.weightx = 80.0D;
            gridBagConstraints27.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints27.gridwidth = 2;
            gridBagConstraints27.insets = new Insets(4, 10, 0, 0);
            gridBagConstraints27.gridx = 1;
            GridBagConstraints gridBagConstraints26 = new GridBagConstraints();
            gridBagConstraints26.gridx = 0;
            gridBagConstraints26.insets = new Insets(4, 10, 0, 0);
            gridBagConstraints26.gridy = 4;
            jLabel9 = new JLabel();
            jLabel9.setText("邮      编：");
            GridBagConstraints gridBagConstraints25 = new GridBagConstraints();
            gridBagConstraints25.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints25.gridy = 3;
            gridBagConstraints25.weightx = 1.0D;
            gridBagConstraints25.gridwidth = 1;
            gridBagConstraints25.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints25.insets = new Insets(4, 10, 0, 0);
            gridBagConstraints25.gridx = 1;
            GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
            gridBagConstraints24.gridx = 0;
            gridBagConstraints24.insets = new Insets(4, 10, 0, 0);
            gridBagConstraints24.gridy = 3;
            jLabel8 = new JLabel();
            jLabel8.setText("地      址：");
            GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
            gridBagConstraints23.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints23.gridy = 2;
            gridBagConstraints23.weightx = 1.0D;
            gridBagConstraints23.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints23.gridwidth = 3;
            gridBagConstraints23.insets = new Insets(4, 10, 0, 10);
            gridBagConstraints23.gridx = 4;
            GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
            gridBagConstraints22.gridx = 3;
            gridBagConstraints22.insets = new Insets(4, 10, 0, 0);
            gridBagConstraints22.gridy = 2;
            jLabel7 = new JLabel();
            jLabel7.setText("电      话：");
            GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
            gridBagConstraints21.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints21.gridy = 2;
            gridBagConstraints21.weightx = 1.0D;
            gridBagConstraints21.gridwidth = 2;
            gridBagConstraints21.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints21.insets = new Insets(4, 10, 0, 0);
            gridBagConstraints21.gridx = 1;
            GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
            gridBagConstraints20.gridx = 0;
            gridBagConstraints20.insets = new Insets(4, 10, 0, 0);
            gridBagConstraints20.gridy = 2;
            jLabel6 = new JLabel();
            jLabel6.setText("职      务：");
            GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
            gridBagConstraints19.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints19.gridy = 1;
            gridBagConstraints19.weightx = 1.0D;
            gridBagConstraints19.gridwidth = 3;
            gridBagConstraints19.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints19.insets = new Insets(2, 10, 0, 10);
            gridBagConstraints19.gridx = 4;
            GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
            gridBagConstraints18.gridx = 3;
            gridBagConstraints18.insets = new Insets(4, 10, 0, 0);
            gridBagConstraints18.gridy = 1;
            jLabel5 = new JLabel();
            jLabel5.setText("出生日期：");
            GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
            gridBagConstraints17.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints17.gridy = 1;
            gridBagConstraints17.weightx = 1.0D;
            gridBagConstraints17.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints17.gridwidth = 2;
            gridBagConstraints17.insets = new Insets(2, 10, 0, 0);
            gridBagConstraints17.gridx = 1;
            GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
            gridBagConstraints16.gridx = 0;
            gridBagConstraints16.insets = new Insets(4, 10, 0, 0);
            gridBagConstraints16.gridy = 1;
            jLabel4 = new JLabel();
            jLabel4.setText("工作单位：");
            GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
            gridBagConstraints15.gridx = 5;
            gridBagConstraints15.insets = new Insets(2, 5, 0, 0);
            gridBagConstraints15.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints15.weightx = 1.0D;
            gridBagConstraints15.gridy = 0;
            GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
            gridBagConstraints14.gridx = 4;
            gridBagConstraints14.insets = new Insets(2, 5, 0, 0);
            gridBagConstraints14.weightx = 5.0D;
            gridBagConstraints14.anchor = GridBagConstraints.CENTER;
            gridBagConstraints14.fill = GridBagConstraints.NONE;
            gridBagConstraints14.gridy = 0;
            GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
            gridBagConstraints13.gridx = 3;
            gridBagConstraints13.anchor = GridBagConstraints.CENTER;
            gridBagConstraints13.insets = new Insets(4, 10, 0, 0);
            gridBagConstraints13.gridy = 0;
            jLabel3 = new JLabel();
            jLabel3.setText("性      别：");
            GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
            gridBagConstraints12.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints12.gridy = 0;
            gridBagConstraints12.weightx = 1.0D;
            gridBagConstraints12.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints12.insets = new Insets(2, 10, 0, 0);
            gridBagConstraints12.gridwidth = 2;
            gridBagConstraints12.gridx = 1;
            GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
            gridBagConstraints11.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints11.gridy = 0;
            gridBagConstraints11.insets = new Insets(4, 10, 0, 0);
            gridBagConstraints11.gridx = 0;
            jLabel2 = new JLabel();
            jLabel2.setText("姓      名：");
            jPanel1 = new JPanel();
            jPanel1.setLayout(new GridBagLayout());
            jPanel1.add(jLabel2, gridBagConstraints11);
            jPanel1.add(getTf_xm(), gridBagConstraints12);
            jPanel1.add(jLabel3, gridBagConstraints13);
            jPanel1.add(getRb_nan(), gridBagConstraints14);
            jPanel1.add(getRb_nv(), gridBagConstraints15);
            jPanel1.add(jLabel4, gridBagConstraints16);
            jPanel1.add(getTf_gzdw(), gridBagConstraints17);
            jPanel1.add(jLabel5, gridBagConstraints18);
            jPanel1.add(getTf_csrq(), gridBagConstraints19);
            jPanel1.add(jLabel6, gridBagConstraints20);
            jPanel1.add(getTf_zw(), gridBagConstraints21);
            jPanel1.add(jLabel7, gridBagConstraints22);
            jPanel1.add(getTf_dh(), gridBagConstraints23);
            jPanel1.add(jLabel8, gridBagConstraints24);
            jPanel1.add(getTf_dz(), gridBagConstraints25);
            jPanel1.add(jLabel9, gridBagConstraints26);
            jPanel1.add(getTf_yb(), gridBagConstraints27);
            jPanel1.add(jLabel10, gridBagConstraints28);
            jPanel1.add(jLabel11, gridBagConstraints30);
            jPanel1.add(jLabel12, gridBagConstraints31);
            jPanel1.add(getTf_qq(), gridBagConstraints32);
            jPanel1.add(getTf_email(), gridBagConstraints33);
            jPanel1.add(lbl_picture, gridBagConstraints29);
            jPanel1.add(getBtn_selectPicture(), gridBagConstraints34);
        }
        return jPanel1;
    }
    
    /**
     * This method initializes jScrollPane
     * 
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getJScrollPane() {
        if (jScrollPane == null) {
            jScrollPane = new JScrollPane();
            jScrollPane.setViewportView(getTb_message());
        }
        return jScrollPane;
    }
    
    /**
     * This method initializes tb_message
     * 
     * @return javax.swing.JTable
     */
    private JTable getTb_message() {
        Vector title = new Vector();
        title.add("编号");
        title.add("姓名");
        title.add("性别");
        title.add("工作单位");
        title.add("出生日期");
        title.add("职务");
        title.add("电话");
        title.add("地址");
        title.add("邮编");
        title.add("QQ号码");
        title.add("电子邮件");
        title.add("照片");
        title.add("分类编号");
        Vector value = null;
        if (tb_message == null) {
            if (SaveStateTool.isMessageEditAndQueryClicked()) {
                if (SaveStateTool.getCurrentSingleSortId() != 0) {
                    value = LinkManDao.query(SaveStateTool
                            .getCurrentSingleSortId());
                } else {
                    value = LinkManDao.query();
                }
            }
            tb_message = new JTable(value, title);
            tb_message.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    DefaultTableModel model = (DefaultTableModel) tb_message
                            .getModel();
                    tb_message.setModel(model);
                    if (model.getRowCount() > 0) {
                        int selectRow = tb_message.getSelectedRow();
                        if (selectRow >= 0) {
                            tf_xm.setText((String) model.getValueAt(selectRow,
                                    1));
                            if (((String) model.getValueAt(selectRow, 2))
                                    .equals("男")) {
                                rb_nan.setSelected(true);
                            } else {
                                rb_nv.setSelected(true);
                            }
                            tf_gzdw.setText((String) model.getValueAt(
                                    selectRow, 3));
                            tf_csrq.setText((String) model.getValueAt(
                                    selectRow, 4));
                            tf_zw.setText((String) model.getValueAt(selectRow,
                                    5));
                            tf_dh.setText((String) model.getValueAt(selectRow,
                                    6));
                            tf_dz.setText((String) model.getValueAt(selectRow,
                                    7));
                            tf_yb.setText((String) model.getValueAt(selectRow,
                                    8));
                            tf_qq.setText((String) model.getValueAt(selectRow,
                                    9));
                            tf_email.setText((String) model.getValueAt(
                                    selectRow, 10));
                            ImageIcon icon = (ImageIcon) model.getValueAt(
                                    selectRow, 11);
                            lbl_picture.setIcon(icon);
                        } else {
                            selectRow = 0;
                            tf_xm.setText((String) model.getValueAt(selectRow,
                                    1));
                            if (((String) model.getValueAt(selectRow, 2))
                                    .equals("男")) {
                                rb_nan.setSelected(true);
                            } else {
                                rb_nv.setSelected(true);
                            }
                            tf_gzdw.setText((String) model.getValueAt(
                                    selectRow, 3));
                            tf_csrq.setText((String) model.getValueAt(
                                    selectRow, 4));
                            tf_zw.setText((String) model.getValueAt(selectRow,
                                    5));
                            tf_dh.setText((String) model.getValueAt(selectRow,
                                    6));
                            tf_dz.setText((String) model.getValueAt(selectRow,
                                    7));
                            tf_yb.setText((String) model.getValueAt(selectRow,
                                    8));
                            tf_qq.setText((String) model.getValueAt(selectRow,
                                    9));
                            tf_email.setText((String) model.getValueAt(
                                    selectRow, 10));
                            ImageIcon icon = (ImageIcon) model.getValueAt(
                                    selectRow, 11);
                            lbl_picture.setIcon(icon);
                        }
                    }
                }
            });
        }
        return tb_message;
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
     * This method initializes rb_nan
     * 
     * @return javax.swing.JRadioButton
     */
    private JRadioButton getRb_nan() {
        if (rb_nan == null) {
            rb_nan = new JRadioButton();
            rb_nan.setText("男");
            rb_nan.setSelected(true);
            buttonGroup.add(rb_nan);
        }
        return rb_nan;
    }
    
    /**
     * This method initializes rb_nv
     * 
     * @return javax.swing.JRadioButton
     */
    private JRadioButton getRb_nv() {
        if (rb_nv == null) {
            rb_nv = new JRadioButton();
            rb_nv.setText("女");
            buttonGroup.add(rb_nv);
        }
        return rb_nv;
    }
    
    /**
     * This method initializes tf_gzdw
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getTf_gzdw() {
        if (tf_gzdw == null) {
            tf_gzdw = new JTextField();
        }
        return tf_gzdw;
    }
    
    /**
     * This method initializes tf_csrq
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getTf_csrq() {
        if (tf_csrq == null) {
            tf_csrq = new JTextField();
        }
        return tf_csrq;
    }
    
    /**
     * This method initializes tf_zw
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getTf_zw() {
        if (tf_zw == null) {
            tf_zw = new JTextField();
        }
        return tf_zw;
    }
    
    /**
     * This method initializes tf_dh
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getTf_dh() {
        if (tf_dh == null) {
            tf_dh = new JTextField();
        }
        return tf_dh;
    }
    
    /**
     * This method initializes tf_dz
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getTf_dz() {
        if (tf_dz == null) {
            tf_dz = new JTextField();
        }
        return tf_dz;
    }
    
    /**
     * This method initializes tf_yb
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getTf_yb() {
        if (tf_yb == null) {
            tf_yb = new JTextField();
        }
        return tf_yb;
    }
    
    /**
     * This method initializes tf_qq
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getTf_qq() {
        if (tf_qq == null) {
            tf_qq = new JTextField();
        }
        return tf_qq;
    }
    
    /**
     * This method initializes tf_email
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getTf_email() {
        if (tf_email == null) {
            tf_email = new JTextField();
        }
        return tf_email;
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
                    DefaultTableModel model = (DefaultTableModel) tb_message
                            .getModel();
                    int id = 0;
                    if (model.getRowCount() > 0) {
                        int selectRow = tb_message.getSelectedRow();
                        if (selectRow >= 0) {
                            id = Integer.parseInt((String) model.getValueAt(
                                    selectRow, 0));
                            
                        }
                        int sortId = Integer.parseInt((String) model
                                .getValueAt(selectRow, 12));
                        String xm = tf_xm.getText().trim();
                        String xb = rb_nan.isSelected() ? "男" : "女";
                        String gzdw = tf_gzdw.getText().trim();
                        String csrq = tf_csrq.getText().trim();
                        String zw = tf_zw.getText().trim();
                        String dh = tf_dh.getText().trim();
                        String dz = tf_dz.getText().trim();
                        String yb = tf_yb.getText().trim();
                        String qq = tf_qq.getText().trim();
                        String email = tf_email.getText().trim();
                        LinkMan linkMan = new LinkMan();
                        linkMan.setID(id);
                        linkMan.setName(xm);
                        linkMan.setSex(xb);
                        linkMan.setEmployment(gzdw);
                        linkMan.setBirthday(csrq);
                        linkMan.setPrincipalship(zw);
                        linkMan.setTelephone(dh);
                        linkMan.setAddress(dz);
                        linkMan.setPostalcode(yb);
                        linkMan.setQQ(qq);
                        linkMan.setEmail(email);
                        if (picturePath != null) {
                            linkMan.setPicturePath(picturePath);
                        }
                        linkMan.setSortID(sortId);
                        LinkManDao.update(linkMan);
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
                    DefaultTableModel model = (DefaultTableModel) tb_message
                            .getModel();
                    int id = 0;
                    if (model.getRowCount() > 0) {
                        int selectRow = tb_message.getSelectedRow();
                        if (selectRow >= 0) {
                            id = Integer.parseInt((String) model.getValueAt(
                                    selectRow, 0));
                            int option = JOptionPane.showConfirmDialog(null,
                                    "确实要删除吗？");
                            if (option == JOptionPane.YES_OPTION) {
                                LinkManDao.delete(id);
                            }
                        }
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "没有数据。");
                    }
                    requestFocus();
                }
            });
        }
        return btn_delete;
    }
    
    /**
     * This method initializes btn_selectPicture
     * 
     * @return javax.swing.JButton
     */
    private JButton getBtn_selectPicture() {
        if (btn_selectPicture == null) {
            btn_selectPicture = new JButton();
            btn_selectPicture.setText("选择");
            btn_selectPicture
                    .addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            JFileChooser fileChooser = new JFileChooser(); // 创建文件对话框
                            // 创建文件过滤
                            FileFilter filter = new FileNameExtensionFilter(
                                    "图像文件(*.gif;*.jpg;*.jpeg;*.png)", "gif",
                                    "jpg", "jpeg", "png");
                            fileChooser.setFileFilter(filter); // 为文件对话框设置文件过滤器
                            int returnValue = fileChooser.showOpenDialog(null);// 打开文件选择对话框
                            if (returnValue == JFileChooser.APPROVE_OPTION) { // 判断是否选择了文件
                                File file = fileChooser.getSelectedFile(); // 获得文件对象
                                if (file.length() / 1024.0 > 50.0) {
                                    JOptionPane.showMessageDialog(null,
                                            "请选择小于等于50KB的图片文件。");
                                    return;
                                }
                                picturePath = file.getAbsolutePath();
                                Icon icon = new ImageIcon(picturePath);
                                lbl_picture.setIcon(icon);
                            }
                        }
                    });
        }
        return btn_selectPicture;
    }
    
} // @jve:decl-index=0:visual-constraint="10,10"
