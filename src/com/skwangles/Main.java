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
                    out.write(Integer.parseInt(Integer.toHexString(c)));
                }
            } catch (Exception e) {
                System.out.println("Error occured: " + e.toString());
            }
        }
        else{
            //--Dehexing
            try (FileInputStream in = new FileInputStream(args[0]); FileOutputStream out = new FileOutputStream(args[1])) {
                int c;
                while ((c = in.read()) != -1) {
                    out.write(Integer.parseInt(Integer.toBinaryString(c)));
                }
            } catch (Exception e) {
                System.out.println("Error occured: " + e.toString());
            }
        }
    }
}
