package com.example.a4laboratorinis;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ParserXml {

    public static List<String> ECBrate(InputStream stream) throws IOException {
        String result = "";
        List<String> list;
        list = new ArrayList<String>();
        try {
            DocumentBuilderFactory Documentfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder Documentbuilder = Documentfactory.newDocumentBuilder();
            Document document = Documentbuilder.parse(stream);

            NodeList nodes = document.getElementsByTagName(Constant.CUBE_NODE);
            for (int i = 0; i < nodes.getLength(); ++i) {
                Element cube = (Element) nodes.item(i);

                if(cube.hasAttribute("Currency")){
                    String NameCurrency = cube.getAttribute("Currency");
                    String RateCurrency = cube.getAttribute("Rate");

                    result = NameCurrency + " is " + RateCurrency;
                    list.add(result);
                }
            }
        } catch (ParserConfigurationException e) {


            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


        return list;
    }
}
