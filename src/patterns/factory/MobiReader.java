package patterns.factory;

public class MobiReader implements Reader {
    @Override
    public void display(Book book) {
        String mobiString = book.getContent();
        String content = mobiString.replace("{mobi}", " ");
        System.out.println(content);
    }
}
