package com.cui.bookreadingfeel.xiaohui;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        try (Socket s = new Socket("time-a.nist.gov", 13);
        Scanner in = new Scanner(s.getInputStream(), "UTF-8")) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
                InetAddress inetAddress = InetAddress.getLocalHost();
                System.out.println(inetAddress.toString());
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}