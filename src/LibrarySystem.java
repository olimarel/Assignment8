import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<Book> books;
    private List<User> users;
    private List<Lending> lendings;

    public LibrarySystem() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.lendings = new ArrayList<>();
    }

    public void addBookWithTitleAndAuthorlist(String title, List<Author> authors) throws EmptyAuthorListException {
        Book book = new Book(title, authors);
        books.add(book);
    }

    public void addStudentUser(String name, boolean FeePaid) {
        Student student = new Student(name, FeePaid);
        users.add(student);
    }

    public void addFacultyMemberUser(String name, String department) {
        FacultyMember facultyMember = new FacultyMember(name, department);
        users.add(facultyMember);
    }

    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new UserOrBookDoesNotExistException("Book does not exist");
    }

    public User findUserByName(String name) throws UserOrBookDoesNotExistException {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        throw new UserOrBookDoesNotExistException("User does not exist");
    }

    public void borrowBook(Book book, User user) {
        Lending lending = new Lending(book, user);
        lendings.add(lending);
    }

    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) {
        Lending lending = new Lending(book, facultyMember);
        lending.setDueDate(newDueDate);
        lendings.add(lending);
    }

    public void returnBook(User user, Book book) {
        Lending lending = new Lending(book, user);
        lendings.remove(lending);
    }
}
