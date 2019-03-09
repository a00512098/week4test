package com.example.week4test;

public class Encoder {
    // This regex checks for chars with numbers
    private static final String regex = "[^A-Z0-9]+|(?<=[A-Z])(?=[0-9])|(?<=[0-9])(?=[A-Z])";

    public static String encode(String message) {
        StringBuilder builder = new StringBuilder();
        String[] splitted = message.split(regex);
        for (int i = 0; i < message.length(); i++) {
            swapChar(message.charAt(i));
        }
        String[] array = message.split(regex);
        for(String str : array) {
            System.out.println(str);
        }

        return message;
    }

    public static void main(String[] args) {
        encode("239283iokhhuh30292k;kjijo2oj23joij2oijo3");
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

        return (char) (decoded-1);
    }
}
