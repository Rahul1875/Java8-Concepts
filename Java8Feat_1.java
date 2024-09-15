package src.com.pack.java8;

import java.util.*;

public class Java8Feat_1 {

    public static void main(String[] args){

        //StringJoiner-----------------------------------
        StringJoiner stringJoiner = new StringJoiner("-","[","]");
        stringJoiner.add("rahul");
        stringJoiner.add("yadav");
        stringJoiner.add("cse");
        stringJoiner.add("cavisson");
        System.out.println(stringJoiner);

        StringJoiner stringJoiner1 = new StringJoiner("=");
        stringJoiner1.add("noida");
        stringJoiner1.add("UP");
        System.out.println(stringJoiner1);

        System.out.println(stringJoiner.merge(stringJoiner1));

        //Parallel Sorting---------------------------------
        int[] arr = {3,5,1,7,9,6,13,11};
        //  Arrays.parallelSort(arr);
        Arrays.parallelSort(arr, 3,6);
        for(int x : arr){
            System.out.println(x);
        }

        //Optional Class------------------------------------
        String[] str = new String[10];
        Optional<String> opt = Optional.ofNullable(str[8]);
        if (opt.isPresent()) {
            String st = str[8].substring(2, 5);
            System.out.println(st);
        }
        str[9] = "AgraIsCool";
        Optional<String> isNull2 = Optional.ofNullable(str[9]);
        if (isNull2.isPresent()) {
            //Getting the substring
            String str2 = str[9].substring(2, 5);
            //Displaying substring
            System.out.print("Substring is: " + str2);
        } else {
            System.out.println("Cannot get the substring from an empty string");
        }

        //ForEachOrdered---------------------------------
        List<String> list = new ArrayList<>();
        list.add("rahul");
        list.add("california");
        list.add("yadav");
        list.add("cse");
        list.add("cavisson");
        // list.forEach(s -> System.out.println(s));

        list.stream().filter(f-> f.startsWith("c")).parallel().forEach(System.out::println);
        System.out.println("--------------");
        list.stream().filter(f->f.startsWith("c")).parallel().forEachOrdered(System.out::println);


        //reduce imp--------------------------------------
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = integers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);



    }
}
