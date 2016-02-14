package db.actorDB;

/**
 * @Author Sander Joos
 */
public class AuthorRepositoryFactory {

    public IAuthorRepository getActorRepository(String actorRepositoryKind){
        if(actorRepositoryKind.equals("AuthorRepositoryPostgresql")){
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
