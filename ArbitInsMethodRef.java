package src.com.pack.java8;

import java.util.Arrays;

public class ArbitInsMethodRef {

    public static void main(String[] args) {
        String[] stringArray = {"Steve", "Rick", "Aditya", "Negan", "Lucy", "Sansa", "Jon"};

        Arrays.sort(stringArray, String::compareToIgnoreCase);
        for (String str : stringArray) {
            System.out.println(str);
        }
    }
}
