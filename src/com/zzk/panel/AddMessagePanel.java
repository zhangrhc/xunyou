package com.zzk.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.zzk.bean.LinkMan;
import com.zzk.dao.LinkManDao;
import com.zzk.tool.SaveStateTool;

import java.awt.Font;
import java.awt.FlowLayout;
import java.io.File;

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
public class AddMessagePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextField tf_xm = null;
    private JLabel jLabel1 = null;
    private JRadioButton rb_nan = null;
    private JRadioButton rb_nv = null;
    private JLabel jLabel2 = null;
    private JTextField tf_gzdw = null;
    private JLabel jLabel3 = null;
    private JTextField tf_csrq = null;
    private JLabel jLabel4 = null;
    private JTextField tf_zw = null;
    private JLabel jLabel5 = null;
    private JTextField tf_dh = null;
    private JLabel jLabel6 = null;
    private JTextField tf_dz = null;
    private JLabel jLabel7 = null;
    private JTextField tf_yb = null;
    private JLabel jLabel8 = null;
    private JLabel jLabel9 = null;
    private JTextField tf_qq = null;
    private JLabel jLabel10 = null;
    private JTextField tf_email = null;
    private JButton btn_selectPicture = null;
    private JLabel jLabel11 = null;
    private JPanel jPanel = null;
    private JButton btn_add = null;
    private JButton btn_save = null;
    private ButtonGroup buttonGroup = new ButtonGroup(); // @jve:decl-index=0:
    private JLabel lbl_picture = null;
    private String picturePath = null;
    
    /**
     * This is the default constructor
     */
    public AddMessagePanel() {
        super();
        initialize();
    }
    
    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
        gridBagConstraints24.gridx = 4;
        gridBagConstraints24.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints24.fill = GridBagConstraints.BOTH;
        gridBagConstraints24.gridheight = 4;
        gridBagConstraints24.gridwidth = 2;
        gridBagConstraints24.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints24.gridy = 4;
        lbl_picture = new JLabel();
        lbl_picture.setText(" ");
        lbl_picture.setBackground(new Color(128, 111, 223));
        lbl_picture.setOpaque(true);
        GridBagConstraints gridBagConstraints32 = new GridBagConstraints();
        gridBagConstraints32.gridx = 0;
        gridBagConstraints32.gridwidth = 7;
        gridBagConstraints32.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints32.insets = new Insets(8, 0, 8, 0);
        gridBagConstraints32.gridy = 8;
        GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
        gridBagConstraints23.gridx = 0;
        gridBagConstraints23.fill = GridBagConstraints.BOTH;
        gridBagConstraints23.gridwidth = 7;
        gridBagConstraints23.weighty = 2.0D;
        gridBagConstraints23.gridy = 0;
        jLabel11 = new JLabel();
        jLabel11.setText("");
        jLabel11.setOpaque(true);
        jLabel11.setFont(new Font("Dialog", Font.BOLD, 36));
        jLabel11.setBackground(new Color(188, 92, 198));
        jLabel11.setIcon(new ImageIcon(getClass().getResource("/image/联系人信息.jpg")));
        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
        gridBagConstraints22.gridx = 6;
        gridBagConstraints22.insets = new Insets(6, 10, 0, 12);
        gridBagConstraints22.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints22.gridy = 6;
        GridBagConstraints gridBagConstraints211 = new GridBagConstraints();
        gridBagConstraints211.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints211.gridy = 7;
        gridBagConstraints211.weightx = 0.0D;
        gridBagConstraints211.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints211.gridwidth = 2;
        gridBagConstraints211.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints211.gridx = 1;
        GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
        gridBagConstraints20.gridx = 0;
        gridBagConstraints20.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints20.weighty = 0.0D;
        gridBagConstraints20.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints20.gridy = 7;
        jLabel10 = new JLabel();
        jLabel10.setText("E-Mail：");
        GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
        gridBagConstraints19.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints19.gridy = 6;
        gridBagConstraints19.weightx = 0.0D;
        gridBagConstraints19.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints19.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints19.gridwidth = 2;
        gridBagConstraints19.gridx = 1;
        GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
        gridBagConstraints18.gridx = 0;
        gridBagConstraints18.insets = new Insets(12, 10, 0, 0);
        gridBagConstraints18.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints18.gridy = 6;
        jLabel9 = new JLabel();
        jLabel9.setText("QQ号码：");
        GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
        gridBagConstraints16.gridx = 3;
        gridBagConstraints16.insets = new Insets(12, 10, 0, 0);
        gridBagConstraints16.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints16.gridy = 4;
        jLabel8 = new JLabel();
        jLabel8.setText("照      片：");
        GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
        gridBagConstraints15.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints15.gridy = 5;
        gridBagConstraints15.weightx = 24.0D;
        gridBagConstraints15.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints15.gridwidth = 2;
        gridBagConstraints15.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints15.gridx = 1;
        GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
        gridBagConstraints14.gridx = 0;
        gridBagConstraints14.insets = new Insets(12, 10, 0, 0);
        gridBagConstraints14.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints14.gridy = 5;
        jLabel7 = new JLabel();
        jLabel7.setText("邮       编：");
        GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
        gridBagConstraints13.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints13.gridy = 4;
        gridBagConstraints13.weightx = 0.0D;
        gridBagConstraints13.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints13.gridwidth = 2;
        gridBagConstraints13.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints13.gridx = 1;
        GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
        gridBagConstraints12.gridx = 0;
        gridBagConstraints12.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints12.insets = new Insets(12, 10, 0, 0);
        gridBagConstraints12.weighty = 0.0D;
        gridBagConstraints12.gridy = 4;
        jLabel6 = new JLabel();
        jLabel6.setText("地        址：");
        GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
        gridBagConstraints11.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints11.gridy = 3;
        gridBagConstraints11.weightx = 0.0D;
        gridBagConstraints11.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints11.gridwidth = 3;
        gridBagConstraints11.insets = new Insets(10, 10, 0, 10);
        gridBagConstraints11.gridx = 4;
        GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
        gridBagConstraints10.gridx = 3;
        gridBagConstraints10.insets = new Insets(12, 10, 0, 0);
        gridBagConstraints10.weighty = 0.0D;
        gridBagConstraints10.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints10.gridy = 3;
        jLabel5 = new JLabel();
        jLabel5.setText("电      话：");
        GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
        gridBagConstraints9.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints9.gridy = 3;
        gridBagConstraints9.weightx = 0.0D;
        gridBagConstraints9.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints9.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints9.gridwidth = 2;
        gridBagConstraints9.gridx = 1;
        GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
        gridBagConstraints8.gridx = 0;
        gridBagConstraints8.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints8.insets = new Insets(12, 10, 0, 0);
        gridBagConstraints8.weighty = 0.0D;
        gridBagConstraints8.gridy = 3;
        jLabel4 = new JLabel();
        jLabel4.setText("职        务：");
        GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
        gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints7.gridy = 2;
        gridBagConstraints7.weightx = 0.0D;
        gridBagConstraints7.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints7.insets = new Insets(10, 10, 0, 10);
        gridBagConstraints7.gridwidth = 3;
        gridBagConstraints7.gridx = 4;
        GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
        gridBagConstraints6.gridx = 3;
        gridBagConstraints6.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints6.insets = new Insets(12, 10, 0, 0);
        gridBagConstraints6.gridy = 2;
        jLabel3 = new JLabel();
        jLabel3.setText("出生日期：");
        GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
        gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints5.gridy = 2;
        gridBagConstraints5.weightx = 0.0D;
        gridBagConstraints5.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints5.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints5.gridwidth = 2;
        gridBagConstraints5.gridx = 1;
        GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
        gridBagConstraints4.gridx = 0;
        gridBagConstraints4.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints4.weightx = 0.0D;
        gridBagConstraints4.weighty = 0.0D;
        gridBagConstraints4.insets = new Insets(12, 10, 0, 0);
        gridBagConstraints4.ipady = 0;
        gridBagConstraints4.gridy = 2;
        jLabel2 = new JLabel();
        jLabel2.setText("工作单位：");
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.gridx = 5;
        gridBagConstraints3.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints3.insets = new Insets(8, 5, 0, 10);
        gridBagConstraints3.gridy = 1;
        GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
        gridBagConstraints21.gridx = 4;
        gridBagConstraints21.anchor = GridBagConstraints.CENTER;
        gridBagConstraints21.insets = new Insets(8, 5, 0, 0);
        gridBagConstraints21.weightx = 1.0D;
        gridBagConstraints21.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints21.gridy = 1;
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.gridx = 3;
        gridBagConstraints2.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints2.insets = new Insets(12, 10, 0, 0);
        gridBagConstraints2.gridy = 1;
        jLabel1 = new JLabel();
        jLabel1.setText("性      别：");
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints1.gridy = 1;
        gridBagConstraints1.weightx = 0.0D;
        gridBagConstraints1.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints1.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints1.gridwidth = 2;
        gridBagConstraints1.gridx = 1;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.0D;
        gridBagConstraints.weighty = 0.0D;
        gridBagConstraints.insets = new Insets(12, 10, 0, 0);
        gridBagConstraints.gridy = 1;
        jLabel = new JLabel();
        jLabel.setText("姓        名：");
        this.setSize(722, 424);
        this.setLayout(new GridBagLayout());
        this.add(jLabel, gridBagConstraints);
        this.add(getTf_xm(), gridBagConstraints1);
        this.add(jLabel1, gridBagConstraints2);
        this.add(getRb_nan(), gridBagConstraints21);
        this.add(getRb_nv(), gridBagConstraints3);
        this.add(jLabel2, gridBagConstraints4);
        this.add(getTf_gzdw(), gridBagConstraints5);
        this.add(jLabel3, gridBagConstraints6);
        this.add(getTf_csrq(), gridBagConstraints7);
        this.add(jLabel4, gridBagConstraints8);
        this.add(getTf_zw(), gridBagConstraints9);
        this.add(jLabel5, gridBagConstraints10);
        this.add(getTf_dh(), gridBagConstraints11);
        this.add(jLabel6, gridBagConstraints12);
        this.add(getTf_dz(), gridBagConstraints13);
        this.add(jLabel7, gridBagConstraints14);
        this.add(getTf_yb(), gridBagConstraints15);
        this.add(jLabel8, gridBagConstraints16);
        this.add(jLabel9, gridBagConstraints18);
        this.add(getTf_qq(), gridBagConstraints19);
        this.add(jLabel10, gridBagConstraints20);
        this.add(getTf_email(), gridBagConstraints211);
        this.add(getBtn_selectPicture(), gridBagConstraints22);
        this.add(jLabel11, gridBagConstraints23);
        this.add(getJPanel(), gridBagConstraints32);
        this.add(lbl_picture, gridBagConstraints24);
        btn_save.setEnabled(false);
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
                                Dimension size = lbl_picture.getSize();
                                lbl_picture.setIcon(icon);
                                lbl_picture.setSize(size);
                            }
                        }
                    });
        }
        return btn_selectPicture;
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
                    btn_save.setEnabled(true);
                    btn_add.setEnabled(false);
                    tf_xm.requestFocus();
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
                    int sortId = SaveStateTool.getCurrentSingleSortId();
                    if (sortId == 0) {
                        JOptionPane.showMessageDialog(null, "没有选择分类，请先选择分类。");
                        return;
                    } else {
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
                        linkMan.setPicturePath(picturePath);
                        linkMan.setSortID(sortId);
                        LinkManDao.insert(linkMan);
                    }
                    btn_add.setEnabled(true);
                    btn_save.setEnabled(false);
                }
            });
        }
        return btn_save;
    }
    
} // @jve:decl-index=0:visual-constraint="10,10"
