package uk.ac.cam.cl.OOP.atp45.supervision3;

public class Question6 {
    public static void main(String[] args) {
        DatabaseManager db = DatabaseManager.getManager();
        // Now we can access that manager object
        // but we can't create a new one
        db.addEntry("Help me!");
    }
}
