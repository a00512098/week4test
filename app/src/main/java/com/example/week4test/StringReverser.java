package com.example.week4test;

public class StringReverser {
    public static final String LONG_STRING = "This is a long st1213213ring that 34535335 is trying to3453435 waste time in the execution method";


    public static String reverse(String str) {
        if (str.length() == 2) {
            return reverseTuple(str);
        } else if (str.length() == 1) {
            return str;
        }

        // Check if the string is even
        int pivot = str.length()%2 == 0 ? str.length()/2 : str.length()/2 + 1;
        String left = str.substring(0, pivot);
        String right = str.substring(pivot);

        return reverse(right) + reverse(left);
    }

    private static String reverseTuple(String tuple) {
        StringBuilder builder = new StringBuilder();
        builder.append(tuple.charAt(1));
        builder.append(tuple.charAt(0));
        return builder.toString();
    }


    public static void main(String[] args) {
        System.out.println(reverse(LONG_STRING));
        System.out.println(reverse("425"));
    }
}
