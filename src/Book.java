import java.util.List;

public class Book extends Exception {
    private String title;
    private List<Author> authors;

    public Book(String title, List<Author> authors) throws EmptyAuthorListException {
        this.title = title;
        if (authors == null) throw new EmptyAuthorListException("There are no authors in the list");

        this.authors = authors;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public List<Author> getAuthors() throws EmptyAuthorListException {
        if (authors == null) {
            throw new EmptyAuthorListException("There are no authors in the list");
        }

        return authors;
    }

    public void setAuthors(List<Author> authors) throws EmptyAuthorListException {
        if (authors == null) {
            throw new EmptyAuthorListException("There are no authors in the list");
        }

        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
