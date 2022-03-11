package com.skwangles;
import java.io.*;
import java.io.Reader.*;

public class Main {
    public static void main(String[] args) throws IOException {
	    // Arg[0] is the location to the 'encode' file, optionally the second will be the output location
        if(args.length < 3 || args[2] == "0") {//If value of
            try (FileInputStream in = new FileInputStream(args[0]); FileOutputStream out = new FileOutputStream(args[1])) {
                int c;
                while ((c = in.read()) != -1) {
                    String binary = Integer.toBinaryString(c);
                    out.write(getHexValue(binary.substring(0, 4)));
                    out.write(getHexValue(binary.substring(binary.length() - 4)));
                }
            } catch (Exception e) {
                System.out.println("Error occured: " + e.toString());
            }
        }
        else{
            //Dehexing, broken atm
            try (InputStream in = new FileInputStream(args[0]); FileOutputStream out = new FileOutputStream(args[1])){
                 Reader reader = new InputStreamReader(in);
                 // buffer for efficiency
                 Reader buffer = new BufferedReader(reader);
                handleCharacters(buffer, out);
            }
        }
    }

    public static char getHexValue(String nibble){
       return convertToHexValue(getSumOfNibble(nibble));
    }

    public static int getSumOfNibble(String nibble){
        if(nibble.length() != 4){
            return -1;
        }
        return Integer.valueOf(String.valueOf(nibble.charAt(0)))*8 + Integer.valueOf(String.valueOf(nibble.charAt(1)))*4 + Integer.valueOf(String.valueOf(nibble.charAt(2)))*2 + Integer.valueOf(String.valueOf(nibble.charAt(3)));
    }

    public static char convertToHexValue(int sum){
        String HexValues = "0123456789ABCDEF";
        return HexValues.charAt(sum);
    }



    ///Start of dehexing - broken atm
    private static void handleCharacters(Reader reader, FileOutputStream out)
            throws IOException {

        int r;
        String nibble1 = "";
        String nibble2 = "";
        int switcher = 0;
        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            if(switcher == 0) {
                nibble1 = nibbleFromHex(ch);
                switcher = 1;
            }
            else{
                nibble2 = nibbleFromHex(ch);
                String fullByte = nibble1 + nibble2;
                Integer b = Integer.parseInt(fullByte);
                out.write(b);
                switcher = 0;
            }
        }
    }

    private static String nibbleFromHex(char Hex){
        String HexValues = "0123456789ABCDEF";
        String[] nibbles = {"0000", "0001", "0010", "0011", "0100", "0101", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        int index = HexValues.indexOf(Hex);
        return nibbles[index];
    }

    //
    //End of dehexing
    //
}
