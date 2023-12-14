package org.example;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        String messageException = "Oops, something went wrong ";

        while (true) {
            String str = scanner.nextLine();
            String[] tokens = str.split("\\.");

            if (tokens.length<1 &&str.equals("exit")) {
                scanner.close();
                System.out.println("Application complete");
                System.exit(0);
            } else if (tokens[tokens.length-1].equalsIgnoreCase("csv")) {
                try {


                    parser.reedCSV(str);
                } catch (IOException e) {
                    System.out.println(messageException + e.getMessage());;
                }
            } else if (tokens[tokens.length-1].equalsIgnoreCase("xml")) {
                try {


                    parser.reedXML(str);
                } catch (IOException e) {
                    System.out.println(messageException + e.getMessage());
                } catch (ParserConfigurationException e) {
                    System.out.println(messageException + e.getMessage());
                } catch (SAXException e) {
                    System.out.println(messageException + e.getMessage());
                }
            } else {
                System.out.println("This application only processes .csv and .xml files, please specify a different file.");
            }

        }
    }
}
