public class Book extends Item {
    private String author;
    private String year;
    private String type;

    public Book(String name, String id, String path, String author, String year, String type) throws MyException {
        super(name, id, path);
        this.author = author;
        this.year = year;
        this.type = type;
    }

    public Book(String author, String year, String type) {
        this.author = author;
        this.year = year;
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sir = new StringBuilder("Book{");
        sir.append("name='").append(name).append('\'');
        sir.append(", id='").append(id).append('\'');
        sir.append(", path='").append(path).append('\'');
        sir.append(", author='").append(author).append('\'');
        sir.append(", year='").append(year).append('\'');
        sir.append(", type='").append(type).append('\'');
        sir.append('}');
        return sir.toString();
    }
}
