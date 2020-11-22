package uk.ac.cam.cl.OOP.atp45.supervision2;

public class Question4 {
    public static void main(String[] args) {
        ParentClass _2D = new ParentClass(2);
        ChildClass _3D = new ChildClass(2, 3);

        //Running the same method results in different outputs
        System.out.println(_2D.getDistance());
        // 2.23606....
        System.out.println(_3D.getDistance());
        // 3.74165....
        System.out.println();

        // Using the same variable put a different print statement
        _2D.printX();
        // ParentClass x: 1
        _3D.printX();
        // ChildClass x: 1
    }
}

class ParentClass {
    protected final int x = 1;
    protected final int y;

    ParentClass(int y) {
        this.y = y;
    }

    public double getDistance() {
        return Math.sqrt((x*x) + (y*y));
    }

    public void printX() {
        System.out.println("ParentClass x: " + x);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class ChildClass extends ParentClass {
    private final int z;

    ChildClass(int y, int z) {
        super(y);
        this.z = z;
    }

    @Override
    public double getDistance() {
        return Math.sqrt((x*x) + (y*y) + (z*z));
    }

    @Override
    public void printX() {
        System.out.println("ChildClass x: " + x);
    }

    public int getZ() {
        return z;
    }
}
