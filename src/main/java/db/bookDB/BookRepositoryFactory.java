package db.bookDB;

/**
 * @author Sander Joos
 *
 * simple factory for 2 different kinds of repositories, not closed
 */
public class BookRepositoryFactory {

    public IBookRepository getBookRepository(String bookRepositoryKind){
        if(bookRepositoryKind.equals(BookRepositoryType.POSTGRESQL.getSimpleName())){
            return new BookRepositoryPostgresql();
        }
        else{
            return new BookRepositoryHashMap();
        }
    }

    public IBookRepository getBookRepository(){
        return new BookRepositoryHashMap();
    }
}
