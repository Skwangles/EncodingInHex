package com.skwangles;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //As per tony's instructions - takes from stdin, outputs to stdout
            String entry = scanner.next();//Whole contents copied at once
            byte[] bytes = entry.getBytes();
            String s = convertArrayToHex(bytes);
            System.out.println(s);

    }

    public static String convertArrayToHex( byte[] bytes) {
        StringBuilder hex = "";
        for (byte b: bytes) {
                hex.append(String.format("%02X ", b));//Converts to individual pairs of hex - hex value will have 0 added infront if it is too small
            }
        return hex.toString();
    }
}
