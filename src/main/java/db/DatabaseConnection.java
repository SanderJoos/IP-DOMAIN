package db;

import exceptions.DatabaseException;

/**
 * Created by Sander Joos on 11/02/2016.
 */

public abstract class DatabaseConnection {
    
    public abstract void closeConnection() throws DatabaseException;

}
