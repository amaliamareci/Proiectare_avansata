package base;
import base.Item;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exception.MyException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Catalog class with an ArrayList of items and add method
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Catalog {
    private ArrayList<Item> items = new ArrayList<>();

    public void add(Item i)throws MyException {
        try {
            AtomicBoolean exists = new AtomicBoolean(false);
            items.forEach((item) -> exists.set(Objects.equals(item.getId(), i.getId()) && Objects.equals(item.getLocation(), i.getLocation()) && Objects.equals(item.getTitle(), i.getTitle())));
            if (exists.get()) {
                throw new MyException("The item already exists in this catalog");
            } else {
                items.add(i);
            }
        }
        catch (NullPointerException e) {
            System.err.print(e.getMessage() + "\n");
        }
    }


    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
