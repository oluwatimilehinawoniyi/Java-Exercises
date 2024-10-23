package Library_System;

public class Library {
    public static void main(String[] args) {
        Book book = new Book("J.K Rowlings", "Harry Potter");
        new Return(book);
        new Borrow(book);
    }
}
