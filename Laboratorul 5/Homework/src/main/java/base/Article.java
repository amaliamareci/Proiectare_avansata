package base;

import base.Item;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Article class extended from Item
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Article extends Item {
    private String year;
    private String author;


    public Article(String id, String title, String location,
                String year, String author) {
        super(id, title, location, year, author);
        this.year = year;
        this.author = author;
    }

    public Article() {}

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

    @Override
    public String toString() {
        return "{" + "\"id\":\"" + id + "\", \"title\":\"" + title
                + "\", \"location\":\"" + location + "\", \"year\":\""
                + year + ", \"author\":\"" + author + "\"}";
    }
}
