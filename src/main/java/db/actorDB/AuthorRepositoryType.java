package db.actorDB;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sander Joos
 */
public enum AuthorRepositoryType {
    HASHMAP("db.actorDB.AuthorRepositoryHashMap","hashMap"),
    POSTGRESQL("db.actorDB.AuthorRepositoryPostgresql","postgresql");

    private final String className;
    private final String simpleName;

    AuthorRepositoryType(String className, String simpleName){
        this.className = className;
        this.simpleName = simpleName;
    }

    private static final Map<String, AuthorRepositoryType> map;
    static{
        map = new HashMap<String, AuthorRepositoryType>();
        for(AuthorRepositoryType a : AuthorRepositoryType.values()){
            map.put(a.simpleName, a);
        }
    }

    public static AuthorRepositoryType findBySimpleName(String type){
        return map.get(type);
    }

    public String getClassName(){
        return className;
    }

    public String getSimpleName(){
        return simpleName;
    }

}
