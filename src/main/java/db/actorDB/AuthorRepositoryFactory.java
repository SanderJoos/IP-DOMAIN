package db.actorDB;

/**
 * @author Sander Joos
 */
public class AuthorRepositoryFactory {

    //TODO replace actors

    public IAuthorRepository getAuthorRepository(String actorRepositoryKind){
        if(actorRepositoryKind.equals(AuthorRepositoryType.POSTGRESQL.getSimpleName())){
            return new AuthorRepositoryPostgresql();
        }
        else{
            return new AuthorRepositoryHashMap();
        }
    }
}
