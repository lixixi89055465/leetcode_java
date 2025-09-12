package leetcode.a000;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人: @author xxxxxx 
 * 创建时间: 2025年08月01日 10:55
 * 项目名称: leetcode_java
 * 文件名称: S118
 * 文件描述: @Description: 
 * site:
 * All rights Reserved, Designed By xxxxxx 
 *
 * @Copyright: 
 */

public class S118 {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> ans = new ArrayList<>(numRows);
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(1);
        ans.add(tmpList);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(1);
            for (int j = 1; j < i; j++) {
                res.add(tmpList.get(j - 1) + tmpList.get(j));
            }
            res.add(1);
            ans.add(res);
            tmpList = res;
        }
        return ans;
    }

    public static void main(String[] args) {
        S118 solve = new S118();
        int numRows = 5;
        solve.generate(numRows);
    }
}

