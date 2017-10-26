/*
 * �ļ���MainTest.java
 * ��Ȩ��Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * ������ MainTest.java
 * �޸��ˣ�tianzhong
 * �޸�ʱ�䣺2016��3��23��
 * �޸����ݣ�����
 */
package com.better517na.forstudy.frameworks.poi;

import java.util.List;

/**
 * TODO ������һ�仰������.
 * 
 * @author tianzhong
 */
public class MainTest {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\tianzhong\\Desktop\\�豸����ģ��.xlsx";
        try {
            List<EquipmentVo> list = ExcelHelper.parseEquipmentExcel(filePath);

            System.out.println(list.isEmpty());

            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
