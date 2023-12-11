package org.example;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;


public class AppTest {

    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(baos));

    }

    @Test
    public void reedXML() throws IOException, ParserConfigurationException, SAXException {
        String expect = "Duplicate addresses:\r\n" +
                "Братск, Большая Октябрьская улица, 65. Count duplicate - 4\r\n";
        Parser parser = new Parser();
        String str = "C:\\Users\\Ivan\\IdeaProjects\\untitled\\src\\test\\resources\\1.xml";
        parser.reedXML(str);
        Assert.assertEquals(expect,baos.toString());
    }


    @Test
    public void reedCSV() throws IOException, ParserConfigurationException, SAXException {
        Parser parser = new Parser();
        String expect = "";
        String str = "C:\\Users\\Ivan\\IdeaProjects\\untitled\\src\\test\\resources\\2.csv";
        parser.reedCSV(str);
        System.setOut(new PrintStream(baos));
        Assert.assertEquals(expect,baos.toString());
    }

    @After
    public void setStandardOut() {
        System.setOut(new PrintStream(standardOut));
    }
}

