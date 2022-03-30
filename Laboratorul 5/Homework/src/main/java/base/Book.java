package base;

import base.Item;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Book class extended from Item
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Book extends Item {
    private String year;
    private String author;
    private String type;

    public Book(String id, String title, String location,
                String year, String author ,String type) {
        super(id, title, location, year, author);
        this.year = year;
        this.author = author;
        this.type=type;
    }

    public Book() {}

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" + "\"id\":\"" + id + "\", \"title\":\"" + title
                + "\", \"location\":\"" + location + "\", \"year\":\""
                + year + ", \"author\":\"" + author +"\", \"type\":\"" + type  + "\"}";
    }
}
