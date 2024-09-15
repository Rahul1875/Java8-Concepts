package src.com.pack.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamIntOp {

    public static void main(String[] args){

        List<String> list = new ArrayList<>();
        list.add("rahul");
        list.add("yadav");
        list.add("cse");
        list.add("cavisson");

        List map = list.stream().map(x->x.concat("noida")).collect(Collectors.toList());
        List filter = list.stream().filter(x->x.startsWith("c")).collect(Collectors.toList());
        List sorter = list.stream().sorted().collect(Collectors.toList());
        list.stream().filter(x->x.startsWith("c")).forEach(System.out::println);
        list.stream().filter(x->x.startsWith("c")).reduce((x,y)->x+y).ifPresent(System.out::println);

        System.out.println("map ==> "+map);
        System.out.println("filter ==> "+filter);
        System.out.println("sorted ==> "+sorter);
       // System.out.println("collect ==> "+collect);


        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(6);
        list2.add(10);
        list2.add(15);

        List reduced = list2.stream().reduce(Integer::sum).stream().collect(Collectors.toList());
        System.out.println("reduced ==> "+reduced);

        int reduced2 = list2.stream().reduce(Integer::sum).get();
        System.out.println("reduced2 ==> "+reduced2);

        int reduced3 = list2.stream().map(x->x+x).reduce(Integer::sum).get();
        System.out.println("reduced3 ==> "+reduced3);
    }

}
