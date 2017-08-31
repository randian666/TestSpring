package com.springapp.mvc;

import java.util.Stack;

/**
 * Created by liuxun on 2017/8/18.
 */
public class MainTest {
    public static void main(String[] args) {
//        int j=0;
//        Integer i=new Integer(0);
//        System.out.println(j==i);
//        System.out.println(i.equals(j));
        int[] input=new int[]{0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,64,66,
                68,70,72,74,76,78,80,82,84,86,88,90,92,94,96,98,100,102,104,106,108,110,112,114,116,118,
                120,122,124,126,128,130,132,134,136,138,140,142,144,146,148,150,
                152,154,156,158,160,162,164,166,168,170,172,174,176,178,180,182};
        int[] result = twoSum(input, 16021);
        for (int n:result){
            System.out.println(n);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<=nums.length-1;j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }
}
