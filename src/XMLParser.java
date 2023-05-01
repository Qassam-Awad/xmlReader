import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLParser {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            saxParser.parse(new File("book.xml"), handler);
            List <Book> bookList = handler.getBookList();

            System.out.println("Please Enter Book ID: ");
            Scanner in = new Scanner(System.in);
            String id = in.nextLine();

            for (Book book: bookList){
                if(Objects.equals(book.getId(), id)){
                    System.out.println(book);
                    break;
                }

            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}