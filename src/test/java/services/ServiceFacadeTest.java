package services;

import entities.Author;
import entities.Book;
import org.junit.Before;
import org.junit.Test;

import java.lang.invoke.SerializedLambda;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Sander Joos
 */
public class ServiceFacadeTest {

    private ServiceFacade service;

    public static Book book1;
    public static Book book2;

    public static Author author1;
    public static Author author2;
    @Before
    public void setUp(){
        this.service = new ServiceFacade();
        author1 = new Author("Patrick","Rothfuss");
        author2 = new Author("Brandon","Sanderson");
        book1 = new Book("De naam van de wind","1",10);
        book2 = new Book("De wet van staal","2",10);
        service.addAuthor(author1);
        service.addAuthor(author2);
        service.addBook(book1);
        service.addBook(book2);
    }

    @Test
    public void testGetAllAuthors_returns_all_authors(){
        List<Author> authors = service.getAllAuthors();
        assertTrue(authors.contains(author1) && authors.contains(author2));
    }

    @Test
    public void testGetAuthor_returns_correct_author(){
        assertEquals(author1,service.getAuthor(author1.getLastName()));
    }

    @Test
    public void testGetBooksFromAuthor_by_lastName_returns_books(){
        service.addBookToAuthor(author1,book1);
        service.addBookToAuthor(author1,book2);
        List<Book> books= service.getBooksFromAuthor(author1.getLastName());
        assertTrue(books.contains(book1) && books.contains(book2));
    }

    @Test
    public void testGetBooksFromAuthor1_by_name_and_lastName(){
        service.addBookToAuthor(author1,book1);
        service.addBookToAuthor(author1,book2);
        List<Book> books= service.getBooksFromAuthor(author1.getName(), author1.getLastName());
        assertTrue(books.contains(book1) && books.contains(book2));
    }

    @Test
    public void testAddAuthor_adds_author(){
        List<Author> authors = service.getAllAuthors();
        assertTrue(authors.contains(author1));
    }

    @Test
    public void testDeleteAuthor_by_author_object(){
        service.deleteAuthor(author2);
        List<Author> authors = service.getAllAuthors();
        assertTrue(authors.contains(author1) && !authors.contains(author2));
    }

    @Test
    public void testDeleteAuthor1_by_lastName(){
        service.deleteAuthor(author2.getLastName());
        List<Author> authors = service.getAllAuthors();
        assertTrue(authors.contains(author1) && !authors.contains(author2));
    }

    @Test
    public void testGetAllBooks(){
        List<Book> books = service.getAllBooks();
        assertTrue(books.contains(book1) && books.contains(book2));
    }

    @Test
    public void testGetBook_by_title(){
        assertEquals(book1,service.getBook(book1.getTitle()));
    }

    @Test
    public void testGetBookByISBN(){
        assertEquals(book1,service.getBookByISBN(book1.getISBN()));
    }

    @Test
    public void testGetAuthor_by_title(){
        service.addBookToAuthor(author1,book1);
        assertEquals(author1, service.getAuthorByTitle(book1.getTitle()));
    }

    @Test
    public void testGetAuthorByISBN(){
        service.addBookToAuthor(author1,book1);
        assertEquals(author1, service.getAuthorByISBN(book1.getISBN()));
    }

    @Test
    public void testAddBook(){
        List<Book> books = service.getAllBooks();
        assertTrue(books.contains(book1) && books.contains(book2));
    }

    @Test
    public void testDeleteBook_by_Object(){
        service.deleteBook(book2);
        List<Book> books = service.getAllBooks();
        assertTrue(books.contains(book1) && !books.contains(book2));
    }

    @Test
    public void testDeleteBookByISBN(){
        service.deleteBookByISBN(book2.getISBN());
        List<Book> books = service.getAllBooks();
        assertTrue(books.contains(book1) && !books.contains(book2));
    }

    @Test
    public void testDeleteBook_by_title(){
        service.deleteBook(book2.getTitle());
        List<Book> books = service.getAllBooks();
        assertTrue(books.contains(book1) && !books.contains(book2));
    }

    @Test
    public void testGetAverageScoreForAuthor(){
        service.addBookToAuthor(author1,book1);
        assertTrue(10 == service.getAverageScoreForAuthor(author1.getLastName()));
    }
}