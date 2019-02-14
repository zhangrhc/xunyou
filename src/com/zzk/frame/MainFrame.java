package com.zzk.frame;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JList;

import com.zzk.dao.MemoTypeDao;
import com.zzk.dao.SortDao;
import com.zzk.list.button.MemoTypeListItemButton;
import com.zzk.list.button.SortListItemButton;
import com.zzk.panel.AddMemoPanel;
import com.zzk.panel.AddMessagePanel;
import com.zzk.panel.EditQueryMemoPanel;
import com.zzk.panel.EditQueryMessagePanel;
import com.zzk.tool.SaveStateTool;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
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
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JToolBar jToolBar = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JSplitPane jSplitPane = null;
	private JTabbedPane jTabbedPane = null;
	private JScrollPane jScrollPane = null;
	private JScrollPane jScrollPane1 = null;
	private JPanel jPanel1 = null;
	private JToolBar jToolBar1 = null;
	private JButton jButton3 = null;
	private JButton jButton4 = null;
	private JList lst_sort = null;
	private JList lst_memo = null;
	private AddMessagePanel messagePanel = null;
	private AddMemoPanel memoPanel = null;
	private EditQueryMessagePanel editQueryMessagePanel = null;
	private EditQueryMemoPanel editQueryMemoPanel = null;
	private static Map sortMap = null;
	private static Map typeMap = null;
	private JButton jButton2 = null;
	private JButton jButton5 = null;
	private JButton jButton6 = null;
	private JButton jButton7 = null;
	private JButton jButton8 = null;
	
	
	/**
	 * This method initializes jToolBar	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getJToolBar() {
		if (jToolBar == null) {
			jToolBar = new JToolBar();
			jToolBar.add(getJButton());
			jToolBar.addSeparator();
			jToolBar.add(getJButton1());
			jToolBar.addSeparator();
			jToolBar.add(getJButton7());
			jToolBar.addSeparator();
			jToolBar.add(getJButton8());
			jToolBar.addSeparator();
			jToolBar.add(getJButton6());
		}
		return jToolBar;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("");
			jButton.setIcon(new ImageIcon(getClass().getResource("/image/btn_icon/1_03.gif")));
			jButton.setRolloverIcon(new ImageIcon(getClass().getResource("/image/btn_icon/2_03.gif")));
			jButton.setToolTipText("添加分类");
			jButton.setMargin(new Insets(0, 0, 0, 0));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTabbedPane.setSelectedIndex(0);
					AddSortFrame thisClass = new AddSortFrame();
					thisClass.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					Toolkit tookit = thisClass.getToolkit();
					Dimension dm = tookit.getScreenSize();
					thisClass.setLocation((dm.width - thisClass.getWidth())/2, (dm.height-thisClass.getHeight())/2);
					thisClass.setVisible(true);
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
			jButton1.setText("");
			jButton1.setToolTipText("添加备忘录");
			jButton1.setIcon(new ImageIcon(getClass().getResource("/image/btn_icon/1_05.gif")));
			jButton1.setRolloverIcon(new ImageIcon(getClass().getResource("/image/btn_icon/2_05.gif")));
			jButton1.setMargin(new Insets(0, 0, 0, 0));
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTabbedPane.setSelectedIndex(1);
					AddMemoTypeFrame thisClass = new AddMemoTypeFrame();
					thisClass.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					Toolkit tookit = thisClass.getToolkit();
					Dimension dm = tookit.getScreenSize();
					thisClass.setLocation((dm.width - thisClass.getWidth())/2, (dm.height-thisClass.getHeight())/2);
					thisClass.setVisible(true);
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jSplitPane	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getJSplitPane() {
		if (jSplitPane == null) {
			jSplitPane = new JSplitPane();
			jSplitPane.setDividerLocation(120);
			jSplitPane.setRightComponent(getJPanel1());
			jSplitPane.setLeftComponent(getJTabbedPane());
		}
		return jSplitPane;
	}

	/**
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setTabPlacement(JTabbedPane.TOP);
			jTabbedPane.addTab("分类", null, getJScrollPane(), null);
			jTabbedPane.addTab("备忘录", null, getJScrollPane1(), null);
			jTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					if (jTabbedPane.getSelectedIndex()==0){
						jPanel1.remove(getEditQueryMemoPanel());
						jPanel1.remove(getMessagePanel());
						jPanel1.remove(getMemoPanel());
						jPanel1.add(getEditQueryMessagePanel(),BorderLayout.CENTER);
						jSplitPane.setDividerLocation(121);
						jSplitPane.setDividerLocation(120);
						jPanel1.validate();
					}else{
						
						jPanel1.remove(getMemoPanel());
						jPanel1.remove(getEditQueryMessagePanel());
						jPanel1.remove(getMessagePanel());
						jPanel1.add(getEditQueryMemoPanel(),BorderLayout.CENTER);
						jSplitPane.setDividerLocation(121);	// 改变分隔条的位置到121处
						jSplitPane.setDividerLocation(120);	// 改变分隔条的位置到120处，即恢复到原来位置
						jPanel1.validate();
						
					}
				}
			});
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getLst_sort());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getLst_memo());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(new BorderLayout());
			jPanel1.add(getJToolBar1(), BorderLayout.NORTH);
			jPanel1.add(getMessagePanel(),BorderLayout.CENTER);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jToolBar1	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getJToolBar1() {
		if (jToolBar1 == null) {
			jToolBar1 = new JToolBar();
			jToolBar1.add(getJButton3());
			jToolBar1.add(getJButton2());
			jToolBar1.addSeparator();
			jToolBar1.add(getJButton4());
			jToolBar1.add(getJButton5());
		}
		return jToolBar1;
	}

	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("");
			jButton3.setToolTipText("添加联系人信息");
			jButton3.setMargin(new Insets(0, 0, 0, 0));
			jButton3.setRolloverIcon(new ImageIcon(getClass().getResource("/image/btn_icon/2_18.gif")));
			jButton3.setIcon(new ImageIcon(getClass().getResource("/image/btn_icon/1_18.gif")));
			jButton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTabbedPane.setSelectedIndex(0);
					jPanel1.remove(getEditQueryMemoPanel());
					jPanel1.remove(getEditQueryMessagePanel());
					jPanel1.remove(getMemoPanel());
					jPanel1.add(getMessagePanel(),BorderLayout.CENTER);
					jSplitPane.setDividerLocation(121);
					jSplitPane.setDividerLocation(120);
					jPanel1.validate();
					SaveStateTool.setMessageEditAndQueryClicked(false);
				}
			});
		}
		return jButton3;
	}

	/**
	 * This method initializes jButton4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setText("");
			jButton4.setMargin(new Insets(0, 0, 0, 0));
			jButton4.setRolloverIcon(new ImageIcon(getClass().getResource("/image/btn_icon/2_22.gif")));
			jButton4.setToolTipText("添加备忘录信息");
			jButton4.setIcon(new ImageIcon(getClass().getResource("/image/btn_icon/1_22.gif")));
			jButton4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTabbedPane.setSelectedIndex(1);
					jPanel1.remove(getEditQueryMemoPanel());
					jPanel1.remove(getEditQueryMessagePanel());
					jPanel1.remove(getMessagePanel());
					jPanel1.add(getMemoPanel(),BorderLayout.CENTER);
					jSplitPane.setDividerLocation(121);
					jSplitPane.setDividerLocation(120);
					jPanel1.validate();
					SaveStateTool.setMemoEditAndQueryClicked(false);
				}
			});
		}
		return jButton4;
	}

	/**
	 * This method initializes lst_sort	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getLst_sort() {
		if (lst_sort == null) {
			lst_sort = new JList();
			lst_sort.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (lst_sort.getSelectedIndex()>=0){
						String sortName = (String)lst_sort.getSelectedValue();
						int currentSortId=SortDao.queryCurrentSortId(sortName);
						SaveStateTool.setSingleSortName(sortName);
						SaveStateTool.setCurrentSingleSortId(currentSortId);
						SaveStateTool.setMessageEditAndQueryClicked(true);
						getEditQueryMessagePanel().requestFocus();
					}
				}
			});
		}
		return lst_sort;
	}

	/**
	 * This method initializes lst_memo	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getLst_memo() {
		if (lst_memo == null) {
			lst_memo = new JList();
			lst_memo.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (lst_memo.getSelectedIndex()>=0){
						String typeName = (String)lst_memo.getSelectedValue();
						int currentTypeId=MemoTypeDao.queryCurrentTypeId(typeName);
						SaveStateTool.setSingleMemoTypeName(typeName);
						SaveStateTool.setCurrentSingleMemoTypeId(currentTypeId);
						SaveStateTool.setMemoEditAndQueryClicked(true);
						getEditQueryMemoPanel().requestFocus();
					}
				}
			});
		}
		return lst_memo;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("");
			jButton2.setMargin(new Insets(0, 0, 0, 0));
			jButton2.setIcon(new ImageIcon(getClass().getResource("/image/btn_icon/1_20.gif")));
			jButton2.setRolloverIcon(new ImageIcon(getClass().getResource("/image/btn_icon/2_20.gif")));
			jButton2.setToolTipText("查询和编辑联系人信息");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTabbedPane.setSelectedIndex(0);
					SaveStateTool.setMessageEditAndQueryClicked(true);
					jPanel1.remove(getEditQueryMessagePanel());
					jPanel1.remove(getMessagePanel());
					jPanel1.remove(getMemoPanel());
					jPanel1.remove(getEditQueryMemoPanel());
					jPanel1.add(getEditQueryMessagePanel(),BorderLayout.CENTER);
					jSplitPane.setDividerLocation(121);
					jSplitPane.setDividerLocation(120);
					jPanel1.validate();
					SaveStateTool.setMessageEditAndQueryClicked(true);
					getEditQueryMessagePanel().requestFocus();
					
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jButton5	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setText("");
			jButton5.setMargin(new Insets(0, 0, 0, 0));
			jButton5.setIcon(new ImageIcon(getClass().getResource("/image/btn_icon/1_24.gif")));
			jButton5.setRolloverIcon(new ImageIcon(getClass().getResource("/image/btn_icon/2_24.gif")));
			jButton5.setToolTipText("查询和编辑备忘录信息");
			jButton5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTabbedPane.setSelectedIndex(1);
					SaveStateTool.setMemoEditAndQueryClicked(true);
					jPanel1.remove(getMessagePanel());
					jPanel1.remove(getMemoPanel());
					jPanel1.remove(getEditQueryMessagePanel());
					jPanel1.add(getEditQueryMemoPanel(),BorderLayout.CENTER);
					jSplitPane.setDividerLocation(121);
					jSplitPane.setDividerLocation(120);
					jPanel1.validate();
					getEditQueryMemoPanel().requestFocus();
				}
			});
		}
		return jButton5;
	}

	/**
	 * This method initializes jButton6	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton6() {
		if (jButton6 == null) {
			jButton6 = new JButton();
			jButton6.setText("");
			jButton6.setToolTipText("退出系统");
			jButton6.setIcon(new ImageIcon(getClass().getResource("/image/btn_icon/1_11.gif")));
			jButton6.setRolloverIcon(new ImageIcon(getClass().getResource("/image/btn_icon/2_11.gif")));
			jButton6.setMargin(new Insets(0, 0, 0, 0));
			jButton6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int flag = JOptionPane.showConfirmDialog(null, "确实要退出系统吗?","确认对话框",JOptionPane.YES_NO_OPTION);
					if (flag == JOptionPane.YES_OPTION){
						System.exit(0);
					}
				}
			});
		}
		return jButton6;
	}

	/**
	 * This method initializes jButton7	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton7() {
		if (jButton7 == null) {
			jButton7 = new JButton();
			jButton7.setText("");
			jButton7.setIcon(new ImageIcon(getClass().getResource("/image/btn_icon/1_07.gif")));
			jButton7.setRolloverIcon(new ImageIcon(getClass().getResource("/image/btn_icon/2_07.gif")));
			jButton7.setToolTipText("添加用户");
			jButton7.setMargin(new Insets(0, 0, 0, 0));
			jButton7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					AddUserFrame thisClass = new AddUserFrame();
					thisClass.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					Toolkit tookit = thisClass.getToolkit();
					Dimension dm = tookit.getScreenSize();
					thisClass.setLocation((dm.width - thisClass.getWidth())/2, (dm.height-thisClass.getHeight())/2);
					thisClass.setVisible(true);
				}
			});
		}
		return jButton7;
	}

	/**
	 * This method initializes jButton8	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton8() {
		if (jButton8 == null) {
			jButton8 = new JButton();
			jButton8.setText("");
			jButton8.setIcon(new ImageIcon(getClass().getResource("/image/btn_icon/1_09.gif")));
			jButton8.setRolloverIcon(new ImageIcon(getClass().getResource("/image/btn_icon/2_09.gif")));
			jButton8.setToolTipText("修改密码");
			jButton8.setMargin(new Insets(0, 0, 0, 0));
			jButton8.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					UpdatePasswordFrame thisClass = new UpdatePasswordFrame();
					thisClass.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					Toolkit tookit = thisClass.getToolkit();
					Dimension dm = tookit.getScreenSize();
					thisClass.setLocation((dm.width - thisClass.getWidth())/2, (dm.height-thisClass.getHeight())/2);
					thisClass.setVisible(true);
				}
			});
		}
		return jButton8;
	}


	/**
	 * This is the default constructor
	 */
	public MainFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(860, 520);
		this.setContentPane(getJContentPane());
		this.setTitle("讯友桌面通讯录");
		this.setResizable(false);
		
		//////
		
		DefaultListModel sortModel = new DefaultListModel();
		lst_sort.setModel(sortModel);
		SortListItemButton sort=new SortListItemButton();
		lst_sort.setCellRenderer(sort);
		
		DefaultListModel memoTypeModel = new DefaultListModel();
		lst_memo.setModel(memoTypeModel);
		MemoTypeListItemButton memoType=new MemoTypeListItemButton();
		lst_memo.setCellRenderer(memoType);
		this.addWindowListener(new java.awt.event.WindowAdapter() {   
			public void windowClosing(java.awt.event.WindowEvent e) {    
				int flag = JOptionPane.showConfirmDialog(null, "确实要退出系统吗?","确认对话框",JOptionPane.YES_NO_OPTION);
				if (flag == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}   
			/* 
			 * 主窗体成为活动窗体的事件
			 */
            public void windowActivated(java.awt.event.WindowEvent e) {
                Map sortNameMap = SortDao.querySortNameAndID();
                DefaultListModel sortModel = (DefaultListModel) lst_sort
                        .getModel();
                sortModel.removeAllElements();
                Set set = sortNameMap.keySet();
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    sortModel.addElement((String) it.next());
                }
                lst_sort.setModel(sortModel);
                SortListItemButton sortCellRender = new SortListItemButton();
                lst_sort.setCellRenderer(sortCellRender);
                Map memoTypeNameMap = MemoTypeDao.queryMemoTypeAndID();
                DefaultListModel memoTypeModel = (DefaultListModel) lst_memo
                        .getModel();
                memoTypeModel.removeAllElements();
                Set set1 = memoTypeNameMap.keySet();
                Iterator it1 = set1.iterator();
                while (it1.hasNext()) {
                    memoTypeModel.addElement((String) it1.next());
                }
                lst_memo.setModel(memoTypeModel);
                MemoTypeListItemButton memoCellRender = new MemoTypeListItemButton();
                lst_memo.setCellRenderer(memoCellRender);
            }
        });
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJToolBar(), BorderLayout.NORTH);
			jContentPane.add(getJSplitPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}


	/**
	 * @return the messagePanel
	 */
	public AddMessagePanel getMessagePanel() {
		if (messagePanel == null) {
			messagePanel = new AddMessagePanel();
		}
		return messagePanel;
	}

	/**
	 * @return the memoPanel
	 */
	public AddMemoPanel getMemoPanel() {
		if (memoPanel == null) {
			memoPanel = new AddMemoPanel();
		}
		return memoPanel;
	}


	/**
	 * @return the sortMap
	 */
	public static Map getSortMap() {
		if (sortMap == null){
			sortMap = new HashMap();
		}
		return sortMap;
	}


	/**
	 * @return the typeMap
	 */
	public static Map getTypeMap() {
		if (typeMap == null){
			typeMap = new HashMap();
		}
		return typeMap;
	}


	/**
	 * @return the editQueryMessagePanel
	 */
	public EditQueryMessagePanel getEditQueryMessagePanel() {
		if (editQueryMessagePanel == null){
			editQueryMessagePanel = new EditQueryMessagePanel();
		}
		return editQueryMessagePanel;
	}


	/**
	 * @return the editQueryMemoPanel
	 */
	public EditQueryMemoPanel getEditQueryMemoPanel() {
		if (editQueryMemoPanel == null){
			editQueryMemoPanel = new EditQueryMemoPanel();
		}
		return editQueryMemoPanel;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
