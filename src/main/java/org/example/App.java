package org.example;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();

        while (true) {
            String str = scanner.nextLine();

            if (str.equals("exit")) {
                System.out.println("Application complete");
                System.exit(0);
            } else if (str.contains(".csv")) {
                parser.reedCSV(str);
            } else if (str.contains(".xml")) {
                parser.reedXML(str);
            } else {
                System.out.println("This application only processes .csv and .xml files, please specify a different file.");
            }

        }
    }
}
