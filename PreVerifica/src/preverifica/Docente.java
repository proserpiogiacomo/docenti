/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preverifica;

/**
 *
 * @author proserpio_giacomo
 */
public class Docente {
    private String codice;
    private String ora;
    private String cognome;
    private String giorno;

    public Docente(){
        this.codice = "";
        this.ora = "";
        this.cognome = "";
        this.giorno = "";
    }
    public Docente(String codice, String ora, String cognome, String giorno) {
        this.codice = codice;
        this.ora = ora;
        this.cognome = cognome;
        this.giorno = giorno;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }
    public String toString(){
        return codice+"-"+ora+"-"+cognome+"-"+giorno;
    }
}
