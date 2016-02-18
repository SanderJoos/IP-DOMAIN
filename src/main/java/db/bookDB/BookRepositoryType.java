package db.bookDB;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sander Joos
 */
public enum BookRepositoryType {
    HASHMAP("db.bookDB.BookRepositoryHashMap","hashMap"),
    POSTGRESQL("db.bookDB.BookRepositoryPostgresql","postgresql");

    private final String className;
    private final String simpleName;

    BookRepositoryType(String className, String simpleName){
        this.className = className;
        this.simpleName = simpleName;
    }

    private static final Map<String, BookRepositoryType> map;
    static{
        map = new HashMap<String, BookRepositoryType>();
        for(BookRepositoryType a : BookRepositoryType.values()){
            map.put(a.simpleName, a);
        }
    }

    public static BookRepositoryType findBySimpleName(String type){
        return map.get(type);
    }

    public String getClassName(){
        return className;
    }

    public String getSimpleName(){
        return simpleName;
    }
}
