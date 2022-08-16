package a1400;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S1408stringMatching {


    static class Solution {
        public List<String> stringMatching(String[] words) {
            List<String> result = new ArrayList<>(16);
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length; j++) {
                    if (i != j && words[j].contains(words[i])) {
                        result.add(words[i]);
                        break;
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solve=new Solution();
//        String[] words= {"mass","as","hero","superhero"};
        String[] words= {"leetcoder","leetcode","od","hamlet","am"};
        List<String> result=solve.stringMatching(words);
        result.forEach(System.out::println);
    }
}
