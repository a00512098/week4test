package com.example.week4test;

import static com.example.week4test.StringReverser.LONG_STRING;

public class Encoder {
    // This regex checks for chars with numbers
    private static final String regex = "[^A-Z0-9]+|(?<=[A-Z])(?=[0-9])|(?<=[0-9])(?=[A-Z])";

    public static String encode(String message) {
        System.out.println("The original String was: " + message);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            builder.append(swapChar(message.charAt(i)));
        }

        // Check for numbers
        String enconded = builder.toString();
        String[] splitted = message.split(regex);
        for(String str : splitted) {
            if (str.length() > 0) {
                enconded = enconded.replaceFirst(str, StringReverser.reverse(str));
            }
        }

        System.out.println("The enconded String is : " + enconded);

        return enconded;
    }

    public static void main(String[] args) {
        encode("hello425world");
        encode(LONG_STRING);
    }
    private static char swapChar(char decoded) {
        switch (decoded) {
            case 'a':
            case 'A':
                return '1';
            case 'e':
            case 'E':
                return '2';
            case 'i':
            case 'I':
                return '3';
            case 'o':
            case 'O':
                return '4';
            case 'u':
            case 'U':
                return '5';
            case 'y':
            case 'Y':
                return ' ';
            case ' ':
                return 'y';
        }
        // if the char is a letter return previous letter
        // else return the same char
        boolean constraint = (decoded > 64 && decoded < 91) || (decoded > 96 && decoded < 123);
        return constraint ? (char) (decoded-1) : decoded;
    }
}
