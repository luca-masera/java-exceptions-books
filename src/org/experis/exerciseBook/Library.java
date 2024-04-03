package org.experis.exerciseBook;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);

        System.out.print("Quanti libri vuoi? ");
        int numLibri = scan.nextInt();

        Book[] books = new Book[numLibri];

        scan.close();
    }
}
