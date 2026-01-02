import java.util.ArrayList;
import java.util.List;

class Tuple {
    private int index;
    private int value;

    public Tuple(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + index + ", " + value + ")";
    }
}

class MyArrayList {
    private List<Tuple> list;

    public MyArrayList() {
        list = new ArrayList<>();
    }

    public void set(int index, int value) {
        Tuple existingTuple = findTupleByIndex(index);
        
        if (existingTuple != null) existingTuple.setValue(value);
        else list.add(new Tuple(index, value));
    }

    public void delete(int index) {
        Tuple tupleToRemove = findTupleByIndex(index);
        if (tupleToRemove != null) list.remove(tupleToRemove);
    }

    public Integer get(int index) {
        Tuple tuple = findTupleByIndex(index);
        return tuple != null ? tuple.getValue() : null;
    }

    private Tuple findTupleByIndex(int index) {
        for (Tuple tuple : list)
            if (tuple.getIndex() == index) return tuple;
    
        return null;
    }

    public void display() {
        System.out.println("ArrayList contents:");
        for (Tuple tuple : list) System.out.println(tuple);
    }

    public List<Tuple> dump() {
        return new ArrayList<>(list);
    }

    public void clear() {
        list.clear();
    }

    public boolean containsIndex(int index) {
        return findTupleByIndex(index) != null;
    }

    public int size() {
        return list.size();
    }
}

public class Main {
    public static void main(String[] args) {
        MyArrayList MyList = new MyArrayList();

        System.out.println("=== Seting values ===");
        MyList.set(0, 6547);
        MyList.set(7, 2);
        MyList.set(3, 100);
        MyList.display();

        System.out.println("\n=== Updating value ===");
        MyList.set(0, 9999);
        MyList.display();

        System.out.println("\n=== Getting values ===");
        System.out.println("Value at index 0: " + MyList.get(0));
        System.out.println("Value at index 7: " + MyList.get(7));
        System.out.println("Value at index 5 (doesn't exist): " + MyList.get(5));

        System.out.println("\n=== Deleting value ===");
        MyList.delete(7);
        MyList.display();

        System.out.println("\n=== Checking index existence ===");
        System.out.println("Does index 3 exist? " + MyList.containsIndex(3));
        System.out.println("Does index 7 exist? " + MyList.containsIndex(7));

        System.out.println("\n=== General information ===");
        System.out.println("Number of ArrayList: " + MyList.size());

        System.out.println("\n=== All ArrayList ===");
        List<Tuple> allArrayList = MyList.dump();
        for (Tuple tuple : allArrayList) System.out.println(tuple);
    }
}