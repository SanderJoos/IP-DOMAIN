package db.bookDB;

/**
 * Created by Sander_2 on 12/02/2016.
 */
public class BookRepositoryFactory {

    public IBookRepository getBookRepository(String bookRepositoryKind){
        if(bookRepositoryKind.equals("BookRepositoryPostgresql")){
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
