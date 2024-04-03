package org.experis.exerciseBook;

import java.io.*;

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
        try (PrintWriter writer = new PrintWriter(new FileWriter("./resource/libri.txt"))) {
            for (Book book : books) {
                writer.println("Titolo: " + book.getTitolo());
                writer.println("Numero di pagine: " + book.getNumPagine());
                writer.println("Autore: " + book.getAutore());
                writer.println("Editore: " + book.getEditore());
                writer.println(); // Blank line between books
            }
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura su file: " + e.getMessage());
        }

        // Lettura dei dati dei libri dal file e stampa a video
        try (Scanner fileScanner = new Scanner(new File("./resource/libri.txt"))) {
            System.out.println("\nDati dei libri letti dal file:");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + e.getMessage());
        }
    }

}

