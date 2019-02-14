package com.zzk.tool;
import java.util.Map;
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
public class SaveStateTool {
    // 存储“分类名-->分类ID”的映射
    private static Map sortMap = null; 
    // 存储“备忘录类型名-->类型ID”的映射
    private static Map memoTypeMap = null; 
    // 存储单个分类名，从添加分类窗体中获得，并在活动主窗体中添加
    private static String singleSortName = null;
    // 存储单个备忘录类型名，从添加备忘录类型窗体中获得，并在活动主窗体中添加
    private static String singleMemoTypeName = null;
    // 当前分类ID，从sortMap映射中获得
    private static int currentSingleSortId = 0;
    // 当前类型ID，从memoTypeMap映射中获得
    private static int currentSingleMemoTypeId = 0;
    // 保存当前单击的是否为“查询和编辑联系人信息”按钮，是则将其设置为true
    private static boolean messageEditAndQueryClicked = false;
    // 保存当前单击的是否为“查询和编辑备忘录信息”按钮，是则将其设置为true
    private static boolean memoEditAndQueryClicked = false;
    
    public static Map getSortMap() {
        return sortMap;
    }
    
    public static void setSortMap(Map sortMap) {
        SaveStateTool.sortMap = sortMap;
    }
    
    public static Map getMemoTypeMap() {
        return memoTypeMap;
    }
    
    public static void setMemoTypeMap(Map memoTypeMap) {
        SaveStateTool.memoTypeMap = memoTypeMap;
    }
    
    public static String getSingleSortName() {
        return singleSortName;
    }
    
    public static void setSingleSortName(String singleSortName) {
        SaveStateTool.singleSortName = singleSortName;
    }
    
    public static String getSingleMemoTypeName() {
        return singleMemoTypeName;
    }
    
    public static void setSingleMemoTypeName(String singleMemoTypeName) {
        SaveStateTool.singleMemoTypeName = singleMemoTypeName;
    }
    
    public static int getCurrentSingleSortId() {
        return currentSingleSortId;
    }
    
    public static void setCurrentSingleSortId(int currentSingleSortId) {
        SaveStateTool.currentSingleSortId = currentSingleSortId;
    }
    
    public static int getCurrentSingleMemoTypeId() {
        return currentSingleMemoTypeId;
    }
    
    public static void setCurrentSingleMemoTypeId(int currentSingleMemoTypeId) {
        SaveStateTool.currentSingleMemoTypeId = currentSingleMemoTypeId;
    }
    
    public static boolean isMessageEditAndQueryClicked() {
        return messageEditAndQueryClicked;
    }
    
    public static void setMessageEditAndQueryClicked(
            boolean messageEditAndQueryClicked) {
        SaveStateTool.messageEditAndQueryClicked = messageEditAndQueryClicked;
    }
    
    public static boolean isMemoEditAndQueryClicked() {
        return memoEditAndQueryClicked;
    }
    
    public static void setMemoEditAndQueryClicked(
            boolean memoEditAndQueryClicked) {
        SaveStateTool.memoEditAndQueryClicked = memoEditAndQueryClicked;
    }
    
}
