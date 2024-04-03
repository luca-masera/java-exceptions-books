package org.experis.exerciseBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);

        System.out.print("Quanti libri vuoi? ");
        int numLibri = scan.nextInt();
        scan.nextLine();
        Book[] books = new Book[numLibri];
        for (int i = 0; i < numLibri; i++) {
            try {
                System.out.println("Inserisci i dati del libro " + (i + 1) + ":");
                System.out.print("Titolo: ");
                String titolo = scan.nextLine();
                System.out.print("Numero di pagine: ");
                int numPagine = scan.nextInt();
                scan.nextLine();
                System.out.print("Autore: ");
                String autore = scan.nextLine();
                System.out.print("Editore: ");
                String editore = scan.nextLine();
                Book book = new Book(titolo, numPagine, autore, editore);
                books[i] = book;
            }
            catch (IllegalArgumentException e) {
            System.out.println("Errore, qualcosa è andato storto: " + e.getMessage() + " Riprova.");
            i--;
            }
        }
        scan.close();

        try (Scanner fileScanner = new Scanner(new File("./resources/libri.txt"))) {
            System.out.println("Dati dei libri letti dal file:");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + e.getMessage());

        }
    }
}
