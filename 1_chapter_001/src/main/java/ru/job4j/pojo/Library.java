package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Clean code", 464);
        Book second = new Book("Java The Complete Reference ", 1312);
        Book third = new Book("Head First Java", 688);
        Book fourth = new Book("SQL Cookbook", 634);

        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = fourth;

        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getPage() + " pages");
        }

        System.out.println("=== Swapped books with index 0 and 3 ===");
        books[0] = fourth;
        books[3] = first;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getPage() + " pages");
        }

        System.out.println("=== Show a book called: Clean code ===");
        for (Book bk : books) {
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName() + " - " + bk.getPage() + " pages");
            }
        }
    }
}
