package a_test;

import zcy_lesson.code_01.Code_09_Comparator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * jh
 * 2019年04月15日  23：56
 * [10,1,11,2,12,3,11]
 * 4
 */
public class Main {


    public static String toHex(long time) {
        return Integer.toHexString((int) time);
    }

    public static void main(String[] args) {

        String ss = "Hello";

        String[] aa = ss.split("");

        String[] bb = {"H", "e", "l", "l", "o"};


        String[] strings = {"Hello", "World"};

        //Arrays.stream接收一个数组返回一个流
        List<Stream<String>> streamList = Arrays.asList(strings).stream().
                map(str -> str.split("")).
                map(str -> Arrays.stream(str)).
                collect(Collectors.toList());

        //分步写(map)

        Stream<String[]> stream = Arrays.asList(strings).stream().
                map(str -> str.split(""));

        Stream<Stream<String>> streamStream = stream.map(strings1 -> Arrays.stream(strings1));
        List<Stream<String>> streamList1 = streamStream.collect(Collectors.toList());


        List<String> stringList = Arrays.asList(strings).stream().
                map(str -> str.split("")).
                flatMap(str -> Arrays.stream(str))
                .collect(Collectors.toList());


        //分步写(流只能消费一次)(flatMap)
        Stream<String[]> stream1 = Arrays.asList(strings).stream().
                map(str -> str.split(""));

        Stream<String> stringStream = stream1.flatMap(strings1 -> Arrays.stream(strings1));

        List<String> stringList1 = stringStream.collect(Collectors.toList());

    }

    public static Date getDateFromString(String strDate) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(strDate);
        } catch (Exception e) {
        }
        return date;
    }

}




