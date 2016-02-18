package db.actorDB;

/**
 * @author Sander Joos
 */
public class AuthorRepositoryFactory {

    public IAuthorRepository getActorRepository(String actorRepositoryKind){
        if(actorRepositoryKind.equals(AuthorRepositoryType.POSTGRESQL.getSimpleName())){
            return new AuthorRepositoryPostgresql();
        }
        else{
            return new AuthorRepositoryHashMap();
        }
    }

    public IAuthorRepository getActorRepository(){
        return new AuthorRepositoryHashMap();
    }
}
