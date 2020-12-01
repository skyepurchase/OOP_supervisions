package uk.ac.cam.cl.OOP.atp45.supervision3;

import java.util.Collection;
import java.util.Collections;

public class DatabaseManager {
    // We only want one instance of a Database
    private final String filename = "some/path/somewhere.db";
    private final Object database;
    private static final DatabaseManager manager = new DatabaseManager("Hello");

    private DatabaseManager(String filename) {
        database = filename; // But obviously more than this
        // create the database if it doesn't exist
        // create a cursor
        // etc.
    }

    void addEntry(String entry) {
        // Complete Insertion
    }

    Collection<Object> getEntry(int ID) {
        // Query database
        return Collections.emptyList();
    }

    public static DatabaseManager getManager() {
        return manager;
    }
}
