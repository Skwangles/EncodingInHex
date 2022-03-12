package com.skwangles;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //As per tony's instructions - takes from stdin, outputs to stdout
        try {
            String entry = scanner.nextLine();//Whole contents copied at once
            if (args.length <= 0 || Objects.equals(args[0], "0")) {
                byte[] bytes = entry.getBytes();
                String s = convertByteArrayToHex(bytes);
                System.out.println(s);
            } else {
                System.out.println("-"+ entry + "-");
                convertHexToBinary(entry);
            }
        }
        catch (Exception e){
            //sketchy stuff
        }
    }

    public static String convertByteArrayToHex( byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (byte b: bytes) {
            hex.append(String.format("%02X ", b));//Converts to individual pairs of hex - hex value will have 0 added infront if it is too small
        }
        return hex.toString();
    }

    public static void convertHexToBinary(String Hex){
        String[] HexArray = Hex.split(" ");
        for (String s : HexArray) {
            String fullBin = hex_char_to_bin(s.charAt(0)) + hex_char_to_bin(s.charAt(1));
            System.out.print(fullBin);
        }

    }

    private static String hex_char_to_bin(char c)
    {
        return switch (Character.toUpperCase(c)) {
            case '0' -> "0000";
            case '1' -> "0001";
            case '2' -> "0010";
            case '3' -> "0011";
            case '4' -> "0100";
            case '5' -> "0101";
            case '6' -> "0110";
            case '7' -> "0111";
            case '8' -> "1000";
            case '9' -> "1001";
            case 'A' -> "1010";
            case 'B' -> "1011";
            case 'C' -> "1100";
            case 'D' -> "1101";
            case 'E' -> "1110";
            case 'F' -> "1111";
            default -> "....";
        };
    }
}

