package codefights.interview_practice.arrays;

import java.util.*;

/**
 * Given an array a that contains only numbers in the range from 1 to a.length,
 * find the first duplicate number for which the second occurrence has the minimal
 * index. In other words, if there are more than 1 duplicated numbers,
 * return the number for which the second occurrence has a smaller index than
 * the second occurrence of the other number does. If there are no such elements,
 * return -1.
 * 1 ≤ a.length ≤ 100000,
 * 1 ≤ a[i] ≤ a.length.
 */
public class FirstDuplicate {
    static class DupBlock implements Comparable<DupBlock>{
        int dupNum;
        int distance;

        public DupBlock(int dupNum, int distance) {
            this.dupNum = dupNum;
            this.distance = distance;
        }

        public void setDupNum(int dupNum) {
            this.dupNum = dupNum;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        @Override
        public int compareTo(DupBlock o) {
            if(this.distance>o.distance)
                return 1;
            else if(this.distance<o.distance)
                return -1;
            else
                return 0;
        }
    }
    public static void main (String [] args){
        Integer testArray[]={1,1,2,3,4,1};
        //if exist duplicated store distance
        List<DupBlock> dupBlocks=new ArrayList<>();
        //search the array for duplicated num
        for (int i=0;i<testArray.length;i++){
            if(i<testArray.length-1){
                for (int j=i+1;j<testArray.length;j++){
                    Integer preNum=testArray[i];
                    Integer postNum=testArray[j];
                    if(preNum==postNum){
                        dupBlocks.add(new DupBlock(preNum,j-i-1));
                    }
                }
            }

        }
        Collections.sort(dupBlocks);
        System.out.println(dupBlocks.get(0).dupNum);
        System.out.println(firstDuplicate());

    }
    static int firstDuplicate() {
        int[]  a=new int[]{8, 4, 6, 2, 2, 4, 7, 9, 5, 8};
        //s1
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i<a.length;i++){
            if (! hashSet.contains(a[i])) {
                hashSet.add(a[i]);
            } else {
                return a[i];
            }
        }
        return -1;



        /*for(int i=0;i<a.length;i++)
            if(a[Math.abs(a[i])-1]<0)
                return Math.abs(a[i]);
            else{
                a[Math.abs(a[i])-1]=-a[Math.abs(a[i])-1];
            }
        return -1;*/
    }
}
