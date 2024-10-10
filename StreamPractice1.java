package src.com.pack.java8;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice1 {

    public static void main(String[] args) {

        //Questions
        // https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062

        // find out all the even numbers that exist in the list
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
        /*System.out.println(
                list.stream().filter(x-> x%2==0).collect(Collectors.toList())
        );*/
        //list.stream().filter(x->x%2==0).sorted().forEach(System.out::println);

        // find out all the numbers starting with 1
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32,100);
        /*System.out.println(
                myList.stream().map(s-> s.toString()).filter(s-> s.startsWith("1")).collect(Collectors.toList())
        );*/

        // find min/max in a list stream
        int min = myList.stream().min(Comparator.comparing(Integer::intValue)).get();
        //System.out.println(min);


        // find duplicate elements in a given integers list
        List<Integer> myList2 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> set = new HashSet();
        /*System.out.println(
                myList2.stream().filter(n -> !set.add(n)).collect(Collectors.toList())
        );*/


        //find the first element of the list using Stream
        List<Integer> myList3 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        /*myList3.stream()
                .findFirst()
                .ifPresent(System.out::println);*/
        
        // https://www.javaguides.net/2024/02/java-8-program-to-find-frequency-of-each-character-in-given-string.html
        String strCount = "i love java";
        Map<Character, Long> mapStr = strCount.chars()
                .filter(c-> c != ' ')
                .mapToObj(c->Character.valueOf((char) c))
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));

        
        // find the first repeated character in it using Stream
        String input = "Java articles are Awesome";
        Character result = input.chars().mapToObj(c-> Character.toLowerCase(Character.valueOf((char) c)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x-> x.getValue() > 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();

        // System.out.println(result);

        Set<Integer> seen = new HashSet<>();
        OptionalInt first = input.chars().filter(x-> !seen.add(x)).findFirst();
        if (first.isPresent()) {
           // System.out.println((char) first.getAsInt());
        }



        // Given an integer array nums, return true if any value appears at least twice in the array,
        // and return false if every element is distinct.

        int[] nums = new int[]{1,2,3,1};
        List<Integer> myList4 = Arrays.stream(nums)
                 .boxed()
                .collect(Collectors.toList());
        Set<Integer> set2 = new HashSet<>(myList4);
        if(set2.size() == myList4.size()) {
            System.out.println("false");
        }
       // System.out.println("true");


        // How to use map to convert object into Uppercase in Java 8
        String[] names = new String[]{"aa", "bb"};
        List<String> nameLst = Arrays.stream(names)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        //System.out.println(nameLst);


        // program to print the count of each character in a String
        String str = "rahul";
        Map<String, Long> map = Arrays.stream(str.split("")).map(String::toLowerCase)
                .collect(Collectors.groupingBy(s->s, LinkedHashMap::new, Collectors.counting()));

        //System.out.println(map);


        //check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object
        List<Integer> myList5 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        //Optional.ofNullable(myList5).ifPresent(System.out::println);


        // convert a List of objects into a Map by considering duplicated keys and store them in sorted order
        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11L));
        noteLst.add(new Notes(2, "note2", 22L));
        noteLst.add(new Notes(3, "note3", 33L));
        noteLst.add(new Notes(4, "note4", 44L));
        noteLst.add(new Notes(5, "note5", 55L));
        noteLst.add(new Notes(6, "note4", 66L));

        Map<String, Long> map1 = noteLst.stream().sorted(Comparator.comparingLong(Notes::getZ).reversed())
                .collect(Collectors.toMap(Notes::getY, Notes::getZ, (old, newValue) -> old, LinkedHashMap::new));

        //System.out.println(map1);

        //count each element/word from the String ArrayList in Java8
        List<String> names2 = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> map2 = names2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(map2);


        // find only duplicate elements with its count from the String ArrayList in Java8
        List<Integer> names3 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Map<Integer,Long> namesCount = names3.stream().filter(x-> Collections.frequency(names3,x)>1)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(namesCount);

        // Find the age of a person in years if the birthday has given
        LocalDate date = LocalDate.of(1995, 07, 18);
        //System.out.println(ChronoUnit.YEARS.between(date, LocalDate.now()));

        // last element of an array
        List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
        String res = listOfStrings.stream().skip(listOfStrings.size()-1).findFirst().get();
        //System.out.println(res);

        // First 10 odd numbers
        /*Stream.iterate(new int[] {1, 3}, f -> new int[] {f[1], f[1]+2})
                .limit(10)
                .map(f -> f[0])
                .forEach(i -> System.out.print(i+" "));*/

        // Fibonacci series
        /*Stream.iterate(new int[] {0, 1}, f -> new int[] {f[1], f[0]+f[1]})
                .limit(10)
                .map(f -> f[0])
                .forEach(i -> System.out.print(i+" "));*/
    }
}

class Notes {
    int x;
    String y;
    Long z;
    public Notes(int x, String y, Long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public Long getZ() {
        return z;
    }

    public void setZ(Long z) {
        this.z = z;
    }
}
