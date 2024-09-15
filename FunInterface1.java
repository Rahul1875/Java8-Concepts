package com.pack.java8;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface Space{
    int calculate(int x);
}

public class FunInterface1 {

    public static void main(String[] args){

        int a =5;
        Space s = (int x )->x*x;
        int rs1 = s.calculate(a);
        System.out.println("rs1 ==> "+rs1);

        // Predicate FI

        List<String> names = Arrays.asList("rahul" , "yadav", "cse", "cavisson","noida");
        Predicate<String> ps = (name)-> name.startsWith("r");
        for(String st : names){
            if(ps.test(st)){
                System.out.println("rs2 ==> "+st);
            }
        }

        // Consumer FI

        Consumer<Integer> display = con-> System.out.println(con);
        display.accept(15);


        // Supplier FI

        Supplier<Double> su = ()->Math.random();
        System.out.println(su.get());
    }
}
