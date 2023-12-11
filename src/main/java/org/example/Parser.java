package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class Parser {

    public void reedCSV(String path) throws IOException {

        String[] HEADERS = {"city", "street", "house", "floor"};
        try {
            Reader in = new FileReader(path);


        AddressService addressService = new AddressService();

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setDelimiter(";")
                .setHeader(HEADERS)
                .setSkipHeaderRecord(true)
                .build();

        Iterable<CSVRecord> records = csvFormat.parse(in);

        for (CSVRecord record : records) {
            String city = record.get("city");
            String street = record.get("street");
            int house = Integer.parseInt(record.get("house"));
            int floor = Integer.parseInt(record.get("floor"));
            addressService.getDuplicatesAddress(city, street, house, floor);

        }
        addressService.countDuplicate();
        addressService.countFloorsInCity();
        addressService.addressSet.clear();
        addressService.duplicateAddress.clear();
        }catch (FileNotFoundException e) {
            String message =
            e.getMessage() + " The specified file does not exist in this directory, please specify a different path.";
            System.out.println(message);
        }
    }

    public void reedXML(String path) throws IOException, ParserConfigurationException, SAXException {
        AddressService addressService = new AddressService();
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(path);
            Node root = parse.getDocumentElement();

            NodeList addressList = root.getChildNodes();
            for (int i = 0; i < addressList.getLength(); i++) {
                Node addresses = addressList.item(i);
                if (addresses.getAttributes() != null) {

                    addressService.getDuplicatesAddress(addresses.getAttributes().item(0).getTextContent(),
                            addresses.getAttributes().item(3).getTextContent(),
                            Integer.parseInt(addresses.getAttributes().item(2).getTextContent()),
                            Integer.parseInt(addresses.getAttributes().item(1).getTextContent()));
                }
            }
            addressService.countDuplicate();
            addressService.countFloorsInCity();
            addressService.addressSet.clear();
            addressService.duplicateAddress.clear();
        }catch (FileNotFoundException e){

            String message =
                   e.getMessage() + " The specified file does not exist in this directory, please specify a different path.";
            System.out.println(message);
        }
    }

}

