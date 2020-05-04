package com.example;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Scanner;


public class homework1 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        String line = scan.nextLine();

        while(!line.isEmpty()){
            arrayList.add(line);
            line = scan.nextLine();
        }

        ArrayList<String> reversed = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            String res = reverseIP(arrayList.get(i));

            try
            {
                InetAddress dnsresult[] = InetAddress.getAllByName(res + ".zen.spamhaus.org");

                System.out.print("The IP address: " + reverseIP(res) +
                        " is found in the following Spamhaus public IP zone: ");

                if(dnsresult.length > 1)
                    System.out.print("\n");

                for (int j = 0; j < dnsresult.length; j++) {
                    String s = dnsresult[j].toString();
                    System.out.println(s.substring(s.lastIndexOf("/") + 1) +
                            getZoneAndDescription(s.substring(s.lastIndexOf("/") + 1)));
                }
            }
            catch(Exception e)
            {
                System.out.println("The IP address: " + reverseIP(res) +
                        " is NOT found in the Spamhaus blacklists.");
            }

        }

    }

    public static String reverseIP(String IPaddress) {

        int index1 = IPaddress.indexOf(".", -1);
        String s1 = IPaddress.substring(0, index1);

        int index2 = IPaddress.indexOf(".", index1 + 1);
        String s2 = IPaddress.substring(index1 + 1, index2);

        int index3 = IPaddress.indexOf(".", index2 + 1);
        String s3 = IPaddress.substring(index2 + 1, index3);

        String s4 = IPaddress.substring(index3 + 1, IPaddress.length());

        return s4 + "." + s3 + "." + s2 + "." + s1;
    }

    public static String getZoneAndDescription(String IPaddress){

        switch (IPaddress){
            case "127.0.0.2" : return " - SBL - Spamhaus SBL Data";
            case "127.0.0.3" : return " - SBL - Spamhaus SBL CSS Data";
            case "127.0.0.4" : return " - XBL - CBL Data";
            case "127.0.0.9" : return " - SBL - Spamhaus DROP/EDROP Data";
            case "127.0.0.10" : return " - PBL - ISP Maintained";
            case "127.0.0.11" : return " - PBL - Spamhaus Maintained";
        }
        return "";
    }

}
