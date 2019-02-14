package com.zzk.frame;

import javax.swing.SwingUtilities;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.zzk.bean.Sort;
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
public class AddSortFrame extends JDialog {
    
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JLabel jLabel = null;
    private JLabel jLabel1 = null;
    private JTextField tf_sort = null;
    private JButton btn_ok = null;
    private JButton btn_return = null;
    
    /**
     * This method initializes tf_sort
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getTf_sort() {
        if (tf_sort == null) {
            tf_sort = new JTextField();
            tf_sort.setBounds(new Rectangle(99, 63, 168, 26));
        }
        return tf_sort;
    }
    
    /**
     * This method initializes btn_ok
     * 
     * @return javax.swing.JButton
     */
    private JButton getBtn_ok() {
        if (btn_ok == null) {
            btn_ok = new JButton();
            btn_ok.setBounds(new Rectangle(45, 104, 74, 26));
            btn_ok.setText("确    定");
            btn_ok.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String sortName = tf_sort.getText().trim();
                    if (sortName != null && !sortName.equals("")) {
                        Sort sort = new Sort();
                        sort.setSortName(sortName);
                        SortDao.insert(sort);
                        SortDao.querySortNameAndID();
                        SortDao.queryCurrentSortId(sortName);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "请输入分类名称。");
                    }
                }
            });
        }
        return btn_ok;
    }
    
    /**
     * This method initializes btn_return
     * 
     * @return javax.swing.JButton
     */
    private JButton getBtn_return() {
        if (btn_return == null) {
            btn_return = new JButton();
            btn_return.setBounds(new Rectangle(161, 103, 78, 26));
            btn_return.setText("返    回");
            btn_return.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    dispose();
                }
            });
        }
        return btn_return;
    }
    
    /**
     * @param args
     */
    // public static void main(String[] args) {
    // // TODO Auto-generated method stub
    // SwingUtilities.invokeLater(new Runnable() {
    // public void run() {
    // AddSortFrame thisClass = new AddSortFrame();
    // thisClass.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    // thisClass.setVisible(true);
    // }
    // });
    // }
    
    /**
     * This is the default constructor
     */
    public AddSortFrame() {
        super();
        initialize();
    }
    
    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(300, 185);
        this.setModal(true);
        this.setContentPane(getJContentPane());
        this.setTitle("添加分类名称窗体");
    }
    
    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jLabel1 = new JLabel();
            jLabel1.setBounds(new Rectangle(16, 63, 78, 26));
            jLabel1.setText("分类名称：");
            jLabel = new JLabel();
            jLabel.setBounds(new Rectangle(40, 8, 210, 46));
            jLabel.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel.setFont(new Font("Dialog", Font.BOLD, 24));
            jLabel.setText("添加分类名称");
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(jLabel, null);
            jContentPane.add(jLabel1, null);
            jContentPane.add(getTf_sort(), null);
            jContentPane.add(getBtn_ok(), null);
            jContentPane.add(getBtn_return(), null);
        }
        return jContentPane;
    }
    
} // @jve:decl-index=0:visual-constraint="10,10"
