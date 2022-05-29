/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javaCode;

import java.util.*;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        int[][]matrix = {{1,5,9},{10,11},{12,13,15}};
        int k = 6;
        kthSmallest(matrix,k);

        int[]arr={1,2,3};
        subsets(arr);

    }

    static public List<List<Integer>> subsets(int[] arr){
        List<Integer> input = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
        List<List<Integer>> subset = new ArrayList<>();
        findSubsets(subset, input, new ArrayList<>(), 0);

        Collections.sort(subset, (o1, o2) -> {
            int n = Math.min(o1.size(), o2.size());
            for (int i = 0; i < n; i++) {
                if (o1.get(i) == o2.get(i)){
                    continue;
                }else{
                    return o1.get(i) - o2.get(i);
                }
            }
            return 1;
        });

        return subset;
    }
    public static void findSubsets(List<List<Integer>> subset, List<Integer> nums, ArrayList<Integer> output, int index)
    {
        // Base Condition
        if (index == nums.size()) {
            subset.add(output);
            return;
        }

        // Not Including Value which is at Index
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);

        // Including Value which is at Index
        output.add(nums.get(index));
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
    }

    static public void kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> nm=new PriorityQueue<>();
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                nm.add(matrix[i][j]);
            }
        }
        System.out.println(nm);

        while(k-->1)
        {
            nm.poll();
        }
        System.out.println(nm.poll());
    }


}
