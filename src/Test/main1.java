package Test;

public class main1 {
    public static void main(String[] args) {

        for(int i = 0; i < 5; i ++) {
            Book book = new Book();
            book.setId("book"+i);
            book.setName("Book"+i);
            book.setNum(2*i);
            Books.bookList.add(book);
        }

    }
}
