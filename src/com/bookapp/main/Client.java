package com.bookapp.main;

import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;
import com.bookapp.service.BookImpl;
import com.bookapp.service.BookInter;
import com.bookapp.bean.Book;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        BookInter library = new BookImpl();

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.println("Book Title :");
            String title = input.next();

            System.out.println("Author Name :");
            String author = input.next();

            System.out.println("Category :");
            String category = input.next();

            System.out.println("Book ID :");
            int bookId = input.nextInt();

            System.out.println("Book Price :");
            int price = input.nextInt();

            Book myBook = new Book(title, author, category, bookId, price);

            library.addBook(myBook);
        }

        while (true) {
            int choice;

            System.out.println("To print all books press 1");
            System.out.println("To get books by author press 2");
            System.out.println("To get books by category press 3");
            System.out.println("To exit the program press 4");

            choice = input.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println(library.getAllBooks());
                    break;
                }
                case 2: {
                    try {
                        System.out.println("Enter Author Name");
                        String author = input.next();
                        System.out.println(library.getBookbyAuthor(author));
                    } catch (AuthorNotFoundException e) {
                        System.out.println("Author could not be found");
                    }
                    break;
                }
                case 3: {
                    try {
                        System.out.println("Enter category :");
                        String category = input.next();
                        System.out.println(library.getBookbycategory(category));
                    } catch (CategoryNotFoundException e) {
                        System.out.println("Category could not be found");
                    }
                    break;
                }
                case 4: {
                    System.exit(1);
                }
                default:
                    System.out.println("Enter a valid input");
                    break;

            }
        }
    }
}
