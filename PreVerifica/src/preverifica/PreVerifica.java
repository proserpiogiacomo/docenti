/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preverifica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author proserpio_giacomo
 */
public class PreVerifica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
     List<Docente> docente = null;
        Parser dom = new Parser();
        try {
            docente = dom.parseDocument("/Desktop/Circolari.xml");
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println("Errore!");
        }
        // iterazione della lista e visualizzazione degli oggetti
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1 o 2:");
        String risposta=br.readLine();
        if(risposta.equals("1")){
            System.out.println("inserisci giorno settimana:");
            String r=br.readLine();
            r=Normalizer.normalize(r, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "ì");
            for(Docente doc:docente){
                if(r.equals(doc.getGiorno())){
                    System.out.println(doc.toString());
                }
            }
        }
        if(risposta.equals("2")){
            System.out.println("inserisci cognome docente:");
            String r2=br.readLine();
            r2=Normalizer.normalize(r2, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "ì");
            for(Docente doc:docente){
                if(r2.equals(doc.getCognome())){
                    System.out.println(doc.getGiorno()+";"+ doc.getOra());
                }
            }
        }

    }
}
