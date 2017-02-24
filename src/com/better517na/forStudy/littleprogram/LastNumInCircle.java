/*
 * 文件名：LastNumInCircle.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： LastNumInCircle.java
 * 修改人：tianzhong
 * 修改时间：2016年6月6日
 * 修改内容：新增
 */
package com.better517na.forStudy.littleprogram;

/**
 * TODO 求圈子里的最后一个数字.
 * 
 * 规则:n个数字（0,1,…,n-1）形成一个圆圈，从数字0开始，
 * 
 * 每次从这个圆圈中删除第m个数字（第一个为当前数字本身， 第二个为当前数字的下一个数字）。
 * 
 * 当一个数字删除后，从被删除数字的下一个继续删除第m个数字。 求出在这个圆圈中剩下的最后一个数字
 * 
 * 例: 3:4; 4:5; 5:3.
 * 
 * @author tianzhong
 */
public class LastNumInCircle {
    public static void main(String[] args) {
        System.out.println("让我们开始这个无聊又愚蠢的小游戏吧...\n");
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] flag = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; // 初始化，所有位置的数字均未被干掉
        int count = nums.length;
        int m = 3;
        int i = 0;

        while (count >= 1) {
            m = 20;

            for (int j = i + 1; m > 0; j++) {
                if (j >= flag.length) {
                    j -= flag.length;
                }

                if (flag[j] == 1) {// 1说明这个位置的数字还没被干掉
                    if (count == 1) { // count为1说明只剩下一个数字，此处的目的是找出那个没有被干掉的数字的位置
                        i = j;
                        break;
                    }
                    m--;
                }

                i = j;
            }

            flag[i] = 0;

            count--;
        }

        System.out.println("剩下的数字: " + nums[i]);
    }
}
