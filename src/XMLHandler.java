import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {
    private boolean hasAuthor = false;
    private boolean hasTitle = false;
    private boolean hasGenre = false;
    private boolean hasPrice = false;
    private boolean hasPublishDate = false;
    private boolean hasDescription = false;

    private List <Book> bookList = null;
    private Book book = null;

    public List <Book> getBookList() {
        return bookList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("book")) {
            String id = attributes.getValue("id");

            book = new Book();
            book.setId(id);

            if (bookList == null)
                bookList = new ArrayList < > ();
        } else if (qName.equalsIgnoreCase("author")) {
            hasAuthor = true;
        } else if (qName.equalsIgnoreCase("title")) {
            hasTitle = true;
        } else if (qName.equalsIgnoreCase("genre")) {
            hasGenre = true;
        } else if (qName.equalsIgnoreCase("price")) {
            hasPrice = true;
        } else if (qName.equalsIgnoreCase("publish_date")) {
            hasPublishDate = true;
        } else if (qName.equalsIgnoreCase("description")) {
            hasDescription = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            bookList.add(book);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (hasAuthor) {
            book.setAuthor(new String(ch, start, length));
            hasAuthor = false;
        } else if (hasTitle) {
            book.setTitle(new String(ch, start, length));
            hasTitle = false;
        } else if (hasGenre) {
            book.setGenre(new String(ch, start, length));
            hasGenre = false;
        } else if (hasPrice) {
            book.setPrice(Double.parseDouble(new String(ch, start, length)));
            hasPrice = false;
        }else if (hasPublishDate) {
            book.setPublish_date(new String(ch, start, length));
            hasPublishDate = false;
        }else if (hasDescription) {
            book.setDescription(new String(ch, start, length));
            hasDescription = false;
        }
    }
}