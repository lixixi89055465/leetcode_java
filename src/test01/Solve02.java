package test01;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人: @author lixiang
 * 创建时间: 2025年09月09日 19:40
 * 项目名称: leetcode_java
 * 文件名称: Solve02
 * 文件描述: @Description:
 * site:
 * 给出一组数字，返回该组数字的所有排列
 * 例如：
 * [1,2,3]的所有排列如下
 * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], [3,2,1].
 */
public class Solve02 {
    public static void swap(int[]arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    public static void dfs(int[]arr,int index,List<List<Integer>>res){
        if (index == arr.length) {
            ArrayList<Integer> tmp = new ArrayList<>(arr.length);
            for (int i : arr) {
               tmp.add(i);
            }
            res.add(tmp);
            return;
        }
        for (int i = index;  i<arr.length ; i++) {
            swap(arr,index,i);
            dfs(arr,index+1,res);
            swap(arr,index,i);
        }
    }
    public static List<List<Integer>> process(int[] arr) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        dfs(arr,0,res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        List<List<Integer>> res = process(arr);
        System.out.println(res);
        for (List<Integer> re : res) {
            for (Integer i : re) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }
}
