package Library_System;

class Return implements  Runnable{
    private Book book;

    Return(Book book) {
        this.book = book;
        new Thread(this, "Return Book").start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                book.returnItem();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Borrow implements Runnable {
    Book book;

    Borrow(Book book) {
        this.book = book;
        new Thread(this, "Borrow Book").start();
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                book.borrow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
