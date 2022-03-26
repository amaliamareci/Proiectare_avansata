import javax.print.attribute.standard.MediaSize;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * class containing the save and load methods
 */
public class CatalogCommands {
    public static void save(Catalog catalog, boolean overwrite) {
        try {
            StringBuilder sb = new StringBuilder(catalog.getName());
            catalog.getItems().forEach((item) -> sb.append("\n").append(item));
            String fileContent = sb.toString();
            BufferedWriter writer;
            String fullPath = catalog.getPath() + (catalog.getPath().endsWith("/") ? "" : "/") + catalog.getName() + ".txtct";
            File checkFile = new File(fullPath);
            if (checkFile.exists()) {
                if (!overwrite) {
                    System.err.print("File already exists, use this method with overwrite enabled to overwrite it\n");
                    return;
                }
            } else if (checkFile.createNewFile()) {
                System.out.print("Created save file for current catalog\n");
            } else {
                System.err.print("Could not create save file for current catalog\n");
                return;
            }
            writer = Files.newBufferedWriter(Path.of(fullPath), Charset.defaultCharset());
            writer.write(fileContent);
            writer.close();
            System.out.print("Successfully saved current catalog\n");
        } catch (IOException e) {
            System.err.print("Catalog not saved, exception: ");
            System.err.print(e.getMessage() + "\n");
        }
    }

    public static Catalog load(String path) throws MyException {
        try {
            if (!path.endsWith(".txtct")) {
                path += ".txtct";
            }

            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = br.readLine();

            Catalog catalog = new Catalog(line, path, new ArrayList<>());

            while ((line = br.readLine()) != null) {
                line = line.substring(0, line.length() - 1);
                String[] splat = line.split("\\{");
                String[] attributes = splat[1].split(",");
                System.out.println(Arrays.toString(attributes));
                switch (splat[0]) {
                    case "Book":
                        catalog.add(new Book((String) parseAttribute(attributes[0]), (String) parseAttribute(attributes[1]), (String) parseAttribute(attributes[2]), (String) parseAttribute(attributes[3]), (String) parseAttribute(attributes[4]), (String) parseAttribute(attributes[5])));
                        break;
                }
            }
            br.close();

            return catalog;
        } catch (IOException | NullPointerException e) {
            throw new MyException("Catalog not loaded, exception:\n\t" + e.getMessage() + "\n");
        }
    }

    private static Object parseAttribute(String string) {
        String attribute = string.split("=")[0].trim();
        String value = string.split("=")[1].replace("'", "").trim();
        return value;
    }

}
