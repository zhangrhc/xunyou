package com.zzk.tool;
import java.util.Map;
/**
 * ��Ȩ����: �����л�������ѧԱ
 * 
 * ������ڣ� 2013-05-15
 * 
 * ��Ŀ������ ��̴ʵ�
 * 
 * ���������� www.hygj.com
 * 
 * �����ˣ� ����
 *
 */
public class SaveStateTool {
    // �洢��������-->����ID����ӳ��
    private static Map sortMap = null; 
    // �洢������¼������-->����ID����ӳ��
    private static Map memoTypeMap = null; 
    // �洢����������������ӷ��ര���л�ã����ڻ�����������
    private static String singleSortName = null;
    // �洢��������¼������������ӱ���¼���ʹ����л�ã����ڻ�����������
    private static String singleMemoTypeName = null;
    // ��ǰ����ID����sortMapӳ���л��
    private static int currentSingleSortId = 0;
    // ��ǰ����ID����memoTypeMapӳ���л��
    private static int currentSingleMemoTypeId = 0;
    // ���浱ǰ�������Ƿ�Ϊ����ѯ�ͱ༭��ϵ����Ϣ����ť������������Ϊtrue
    private static boolean messageEditAndQueryClicked = false;
    // ���浱ǰ�������Ƿ�Ϊ����ѯ�ͱ༭����¼��Ϣ����ť������������Ϊtrue
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
