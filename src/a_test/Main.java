package a_test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private final static String imByNeteasePhoneVersion0802 =  "1.3.0";

    public static void main(String[] args) {
     List<Integer> list = new ArrayList<>();
     list.add(1);
     list.add(2);
     list.add(3);

     list.add(0,0);


     list.stream().forEach(integer -> System.out.println(integer));
















    }












    public static int compareTo(String t1, String t2) {



        String[] t1Nums = t1.split("\\.");

        String[] t2Nums = t2.split("\\.");


        for(int i = 0; ; i++){
            if(i >= t1Nums.length || i >= t2Nums.length){
                if(t1Nums.length == t2Nums.length){
                    return 0;
                }

                return t1Nums.length > t2Nums.length? 1: -1;
            }


            try {
                Integer t1num = Integer.valueOf(t1Nums[i]);
                Integer t2num = Integer.valueOf(t2Nums[i]);

                if(t1num == t2num){
                    continue;
                }

                return t1num  > t2num ? 1: -1;
            }catch (Exception e){
            }




        }




    }







}
