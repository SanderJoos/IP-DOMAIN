package db.bookDB;

/**
 * @author Sander Joos
 *
 * simple factory for 2 different kinds of repositories, not closed
 */
public class BookRepositoryFactory {

    public IBookRepository getBookRepository(String bookRepositoryKind){
        if(bookRepositoryKind.equals(BookRepositoryType.POSTGRESQL.getSimpleName())){
            return new BookRepositoryRelationalDB("IP-DomainPU");
        }
        else{
            return new BookRepositoryInMemory();
        }
    }
}
