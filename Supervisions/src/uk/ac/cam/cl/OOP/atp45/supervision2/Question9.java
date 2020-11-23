package uk.ac.cam.cl.OOP.atp45.supervision2;

import com.sun.tools.javac.Main;

import java.util.*;

public class Question9 {
    public static void main(String[] args) {
        // This is just setup to show the functionality of the code.
        ArrayList<Department> departments = new ArrayList<>();

        ArrayList<Item> foodItems = new ArrayList<>();
        foodItems.add(new Item("Chocolate", 2.50, 0.20, "30-11-20"));
        foodItems.add(new Item("Ice cream tub", 4.00, 0.20, "5-12-20"));

        List<String> foodKeys = Arrays.asList("Storage");

        ArrayList<String> BillTasks = new ArrayList<>();
        BillTasks.add("Aisle 2");
        BillTasks.add("Aisle 3");

        ArrayList<Assistant> foodAssistants = new ArrayList<>();
        foodAssistants.add(new Assistant("Joe Bloggs", "cashier"));
        foodAssistants.add(new Assistant("Bill Sanders", "stacker", BillTasks));
        foodAssistants.add(new Assistant("Nunya B. Snis", "professional slacker"));

        ArrayList<Assistant> clotheAssistants = new ArrayList<>();
        clotheAssistants.add(new Assistant("Jolene Bloggs", "cashier"));
        clotheAssistants.add(new Assistant("Buck Sanders", "stacker"));
        clotheAssistants.add(new Assistant("Iva Harry Chesticov ", "amateur slacker"));

        departments.add(new Department(foodItems, new Manager("Andy", foodKeys, "No one knows"), foodAssistants));
        departments.add(new Department(new Manager("Ricky", "Hidden from Karen"), clotheAssistants));

        Shop Mainsburies = new Shop(departments, new StoreManager("Big Kahoona", foodKeys, "The Entrance"), 1000000);

        // Here is the execution of the program
        Mainsburies.open(); // Open the store

        System.out.println(Mainsburies.getBalance() + "\n");

        // Get all the employees to get the evaluation of the store
        StoreManager storeManager = Mainsburies.getStoreManager();

        ArrayList<Assistant> all_assistants = new ArrayList<>();
        ArrayList<Manager> managers = new ArrayList<>();
        for (Department department : Mainsburies.getDepartments()) {
            managers.add(department.getManager());
            all_assistants.addAll(department.getAssistants());
        }

        System.out.println(storeManager.getEvaluation(managers, all_assistants));

        // I didn't implement user input so I just had a list of item names (only Chocolate exists)
        // I could have used command line arguments but I wanted it to be dynamic so did neither
        String[] items = new String[]{"Peterhouse jumper", "Peterhouse lanyard", "Chocolate", "Beans"};

        // This is checking if the item exists and then buying it if it does
        for (String item : items) {
            for (Department department : Mainsburies.getDepartments()) {
                Item foundItem = department.findItem(item);
                if (foundItem != null) {
                    department.buyItem(foundItem);
                    System.out.println("Bought " + item);
                    System.out.println("Careful this expires on " + foundItem.getExpirationDate() + "\n");
                } else {
                    System.out.println(item + " is out of stock.");
                }
            }
        }

        Mainsburies.close(); // Close the store

        System.out.println(Mainsburies.getBalance()); // To show the bought item was paid for
    }
}

class Shop {
    private ArrayList<Department> departments;
    private StoreManager storeManager;
    private boolean open;
    private double balance;

    Shop(final ArrayList<Department> departments, final StoreManager storeManager, final double balance) {
        this.departments = departments;
        this.storeManager = storeManager;
        this.balance = balance;
    }

    public boolean isOpen() {
        return open;
    }

    public double getBalance() {
        return balance;
    }

    private void updateBalance(final double amount) {
        balance += amount;
    }

    private void payEmployees() {
        for (Department department : departments) {
            department.payEmployees();
        }
    }

    public void open() {
        System.out.println("Mainsburies is now open for business!\n");

        storeManager.startDay();

        for (Department department : departments) {
            ArrayList<Assistant> assistants = department.getAssistants();
            for (Assistant assistant : assistants) {
                assistant.startDay();
            }

            Manager manager = department.getManager();
            manager.startDay();

            manager.assignTasks(assistants);
        }

        open = true;
    }

    public void close() {
        System.out.println("Mainsburies has closed for the day.\n");

        for (Department department : departments) {
            updateBalance(department.getProfit());
        }

        payEmployees();

        open = false;
    }

    public StoreManager getStoreManager() {
        return storeManager;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }
}

class Department {
    private ArrayList<Item> stock;
    private Manager manager;
    private ArrayList<Assistant> assistants;
    private double profit = 0;

    Department(final ArrayList<Item> stock, final Manager manager, final ArrayList<Assistant> assistants) {
        this.stock = stock;
        this.manager = manager;
        this.assistants =  assistants;
    }

    Department(final Manager manager, final ArrayList<Assistant> assistants) {
        this.stock = new ArrayList<>();
        this.manager = manager;
        this.assistants =  assistants;
    }

    public Item findItem(final String name) {
        for (Item item : stock) {
            if (item.getName() == name) {
                return item;
            }
        }
        return null;
    }

    public void buyItem(final Item item) {
        stock.remove(item);
        replenishStock(item);
        profit += item.getPrice();
    }

    public void payEmployees() {
        for (Assistant assistant : assistants) {
            assistant.payDay();
        }
        manager.payDay();
    }

    private void replenishStock (Item item) {
        stock.add(item);
    }

    public double getProfit() {
        return profit;
    }

    public Manager getManager() {
        return manager;
    }

    public ArrayList<Assistant> getAssistants() {
        return assistants;
    }
}

class Item {
    private final String name;
    private final double price;
    private final double taxRate;
    private final String expirationDate;

    Item(final String name, final double price, final double taxRate, final String expirationDate) {
        this.name = name;
        this.price = price;
        this.taxRate = taxRate;
        this.expirationDate = expirationDate;
    }

    public double getPrice() {
        return price;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getName() {
        return name;
    }
}

abstract class Employee {
    protected final String name;
    protected double salary;
    protected double balance;
    protected long phoneNumber;
    protected int workHours;
    protected ArrayList<String> tasks;

    protected Employee(final String name) {
        this.name = name;

        ArrayList<String> relax = new ArrayList<>();
        relax.add("Relax...you weren't set any tasks!");
        tasks = relax;
    }

    public void payDay() {
        balance += salary;
    }

    public void setTasks(final ArrayList<String> newTasks) {
        if (tasks.get(0) == "Relax...you weren't set any tasks!") {
            tasks = newTasks;
        } else {
            tasks.addAll(newTasks);
        }
    }

    public int getEvaluation() {
        if (tasks.size() == 0) {
            return 10;
        } else {
            return -1;
        }
    }

    protected boolean completeTasks() {
        if (tasks.get(0) == "Relax...you weren't set any tasks!") {
            return false;
        } else {
            ArrayList<String> relax = new ArrayList<>();
            relax.add("Relax...you weren't set any tasks!");
            tasks = relax;
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public abstract void startDay();
}

class Manager extends Employee {
    private final List<String> keys;
    private final String office;

    Manager(final String name, final List<String> keys, final String office) {
        super(name);
        this.keys = keys;
        this.office = office;
    }

    Manager(final String name, final String office) {
        super(name);
        this.keys = Collections.emptyList();
        this.office = office;
    }

    public int getEvaluation(final ArrayList<Assistant> assistants) {
        if (tasks.size() == 0) {
            return 100 + evaluateAssistants(assistants);
        } else {
            return -10 + evaluateAssistants(assistants);
        }
    }

    private int evaluateAssistants(final ArrayList<Assistant> assistants) {
        int evaluation = 0;
        for (Assistant assistant : assistants) {
            evaluation += assistant.getEvaluation();
        }
        return evaluation;
    }

    public void assignTasks(final ArrayList<Assistant> assistants) {
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("Work Harder!!!");

        for (Assistant assistant : assistants) {
            assistant.setTasks(tasks);
            System.out.println(assistant.getName() + ": Aw man! I wanted to relax!!\n");
        }
    }

    @Override
    public void startDay() {
        if (completeTasks()) {
            System.out.println(getName() + ": My day has started and I completed all managerial tasks, Yay me!\n");
        } else {
            System.out.println(getName() + ": I have no tasks, big managerial win!!\n");
        }
    }
}

class StoreManager extends Manager {

    StoreManager(String name, List<String> keys, String office) {
        super(name, keys, office);
    }

    public int getEvaluation(final ArrayList<Manager> managers, final ArrayList<Assistant> assistants) {
        if (tasks.size() == 0) {
            return 1000 + evaluateManagers(managers, assistants);
        } else {
            return -100 + evaluateManagers(managers, assistants);
        }
    }

    private int evaluateManagers(final ArrayList<Manager> managers, final ArrayList<Assistant> assistants) {
        int evaluation = 0;
        for (Manager manager : managers) {
            evaluation += manager.getEvaluation(assistants);
        }
        return evaluation;
    }

    @Override
    public void startDay() {
        if (completeTasks()) {
            System.out.println(getName() + ": My day has started and I completed all store tasks, Big Whoop!\n");
        } else {
            System.out.println(getName() + ": I have no tasks, that's suspicious.\n");
        }
    }
}

class Assistant extends Employee {
    private final String role;

    Assistant(final String name, final String role, final ArrayList<String> tasks) {
        super(name);
        this.role = role;
        this.tasks = tasks;
    }

    Assistant(final String name, final String role) {
        super(name);
        this.role = role;
        this.tasks = new ArrayList<>();
        this.tasks.add("Relax...you weren't set any tasks!");
    }

    @Override
    public void startDay() {
        if (completeTasks()) {
            System.out.println(getName() + ": My day has started and I completed all my tasks, Fantastic!\n");
        } else {
            System.out.println(getName() + ": I have no tasks, Getting paid for nothing!!\n");
        }
    }
}