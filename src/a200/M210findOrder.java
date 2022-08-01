package a200;

import javax.swing.table.TableRowSorter;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> edges;
    int[] visited;
    int[] result;
    boolean valid = true;
    int index;

    public int[] findOrder(int numCourses, int[][] prequisties) {
        edges=new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        visited=new int[numCourses];
        result=new int[numCourses];
        index=numCourses-1;
        for(int[]info:prequisties){
            edges.get(info[1]).add(info[0]);
        }
        for(int i=0;i<numCourses&&valid;i++){
            if(visited[i]==0){
                dfs(i);
            }
        }
        if(!valid){
            return new int[0];
        }
        return result;

    }
    public void dfs(int u) {
        visited[u]=1;
        for(int v:edges.get(u)){
            if (visited[v] == 0) {
                dfs(v);
                if (!valid ){
                    return;
                }
            }
            else if(visited[v]==1){
                valid=false;
                return;
            }
        }
        visited[u]=2;
        result[index--]=u;
    }

}

public class M210findOrder {
    public static void main(String[] args) {
        Solution solve=new Solution();
        int numCourses = 4;
        int [][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[] result=solve.findOrder(numCourses,prerequisites);
        System.out.println(result);

    }
}
