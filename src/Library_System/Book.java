package Library_System;

public class Book implements LibraryItem {
    String author;
    String title;
    boolean isAvailable = true;

    Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    synchronized public void borrow() {
        while(!isAvailable)
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting to borrow: " + title);
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptionException caught!");
            }

        System.out.println(Thread.currentThread().getName() + " borrowed the book: " + title);
        isAvailable = false;
        notify();
    }

    synchronized public void returnItem() {
        while(isAvailable)
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting to return: " + title);
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptionException caught!");
            }

        System.out.println(Thread.currentThread().getName() + " returned the book: " + title);
        isAvailable = true;
        notify();
    }
}
