package codefights.interview_practice.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicate {

    public static void main(String[] args){
        HashSet<Integer> singleSet=new HashSet<>();
        Integer[] array={1,2,2,3,3,4,4};
        List<Integer> pos=new ArrayList<>();
        for (int i=array.length-1;i>=0;i--){
            if(!singleSet.contains(array[i])){
                singleSet.add(array[i]);
                pos.add(i);
            }else{
                continue;
            }
        }
        System.out.println(singleSet.size());
        Collections.reverse(pos);
        for (Integer i:pos){
            System.out.println(i);
        }
    }
}
