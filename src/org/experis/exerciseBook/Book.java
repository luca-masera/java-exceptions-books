package org.experis.exerciseBook;

public class Book {
    private String titolo;
    private int numPagine;
    private String autore;
    private String editore;

    public Book(String titolo, int numPagine, String autore, String editore) throws IllegalArgumentException {
        if (titolo.isEmpty() || autore.isEmpty() || editore.isEmpty()) {
            throw new IllegalArgumentException("Titolo, autore e editore non possono essere vuoti.");
        }
        if (numPagine <= 0) {
            throw new IllegalArgumentException("Il numero di pagine deve essere maggiore di zero.");
        }
        this.titolo = titolo;
        this.numPagine = numPagine;
        this.autore = autore;
        this.editore = editore;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getNumPagine() {
        return numPagine;
    }

    public String getAutore() {
        return autore;
    }

    public String getEditore() {
        return editore;
    }
}
