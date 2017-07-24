import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        HashMap<Integer, Boolean> visited = new HashMap<>();
        Stack<Integer> branch = new Stack<>();
        Scanner input = new Scanner(System.in);
        int N = input.nextInt(), M = input.nextInt();
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        ArrayList<Integer> temp = null; int tempNum = 0; int connectedNum = 0;
        for(int i = 0; i < M; i++){
            tempNum = input.nextInt();
           temp = new ArrayList<>();
            connectedNum = input.nextInt();
           temp.add(connectedNum);
           adjList.put(tempNum, temp);
            
           if(adjList.containsKey(connectedNum)){
               adjList.get(connectedNum).add(tempNum);
           }
           else{
               temp = new ArrayList<>();
               temp.add(tempNum);
               adjList.put(connectedNum, temp);
            }           
        }
        for(Map.Entry<Integer, ArrayList<Integer>> element : adjList.entrySet()){
            System.out.println(element.getKey() + "\t" + element.getValue());
        }
        int totalCount = 0, count = 0;
        if(adjList.get(1) != null){
            visited.put(1, true);
            branch.add(1);
            ++totalCount;
            temp.clear();
            temp = adjList.get(1);
            while(!branch.isEmpty() && totalCount != N){
                for(int i : temp){
                    if(!visited.containsKey(i)){
                        branch.push(i);
                        visited.put(i, true);
                        ++totalCount;
                    }                    
                }
                if(branch.size() == 1 && branch.peek() == 1){
                    break;
                }
                else{
                    temp.clear();
                    temp = adjList.get(branch.pop());
                    ++count;
                }
            }
        }
        input.close();
    }
}