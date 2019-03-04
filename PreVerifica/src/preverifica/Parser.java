/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preverifica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author proserpio_giacomo
 */
public class Parser {
     private List link;

    public Parser() {
        link = new ArrayList();
    }

    public List parseDocument(String filename)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        Docente docente;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "libro"
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                docente= getDocente(element);
                link.add(docente);
            }
        }
        return link;
    }

    private Docente getDocente(Element element) {
        Docente docente;
        NodeList nodelist;

        String codice="",cognome="", giorno="", ora="";
        Element td;

        nodelist = element.getElementsByTagName("td");
        if (nodelist != null && nodelist.getLength() > 0) {
        for (int i = 0; i < nodelist.getLength(); i++) {
        td = (Element) nodelist.item(i);
        if(td!=null){
        if(codice=="" || codice==null){
        codice=getTextValue(td);
        }else if(cognome=="" || cognome==null){
        cognome=getTextValue(td);
        }else if(giorno=="" || giorno==null){
        giorno=getTextValue(td);
        }else if(ora=="" || ora==null){
         ora=getTextValue(td);
        }
        }
        }
        }
        docente = new Docente(codice, ora, cognome, giorno);
        return docente;
    }
    
    // restituisce il valore testuale dell’elemento figlio specificato
 private String getTextValue(Element element) {
        String value = null;
        if (element != null ) {
        Node el = element.getFirstChild();
        if(el!=null){
           value = el.getNodeValue();
        }
        }       
        return value;
         }
    
}

