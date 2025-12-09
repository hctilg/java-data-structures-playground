import java.util.Arrays;

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

    public void setIndex(int index) {
        this.index = index;
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

class MahiDynamicArray {
    private Tuple[] array;
    private int size;
    private int capacity;
    private static final int INITIAL_CAPACITY = 10;
    private static final double GROWTH_FACTOR = 1.5;

    public MahiDynamicArray() {
        this.capacity = INITIAL_CAPACITY;
        this.array = new Tuple[capacity];
        this.size = 0;
    }

    public MahiDynamicArray(int initialCapacity) {
        if (initialCapacity <= 0)
            throw new IllegalArgumentException("Initial capacity must be positive");

        this.capacity = initialCapacity;
        this.array = new Tuple[capacity];
        this.size = 0;
    }

    public void set(int index, int value) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Index cannot be negative: " + index);

        // if the index is greater than the current capacity, expand the array
        if (index >= capacity) ensureCapacity(index + 1);
        if (index >= size) size = index + 1;

        if (array[index] != null) array[index].setValue(value);
        else array[index] = new Tuple(index, value);
    }

    public void delete(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        array[index] = null;

        // if the index was the last element, decrease the size
        if (index == size - 1) updateSize();
    }

    public Integer get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[index] != null ? array[index].getValue() : null;
    }

    public void add(int value) {
        set(size, value);
    }

    // ensure sufficient capacity
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > capacity) {
            int newCapacity = Math.max((int)(capacity * GROWTH_FACTOR), minCapacity);
            array = Arrays.copyOf(array, newCapacity);
            capacity = newCapacity;
        }
    }

    private void updateSize() {
        int newSize = size;
        while (newSize > 0 && array[newSize - 1] == null) newSize--;
        size = newSize;
    }

    // compact the array (remove empty gaps in the middle)
    public void compact() {
        Tuple[] newArray = new Tuple[capacity];
        int newSize = 0;

        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                newArray[newSize] = array[i];
                newArray[newSize].setIndex(newSize);
                newSize++;
            }
        }

        array = newArray;
        size = newSize;
    }

    public void display() {
        System.out.println("Dynamic Array contents (size=" + size + ", capacity=" + capacity + "):");
        for (int i = 0; i < size; i++)
            System.out.println("[" + i + "] = " + ( (array[i] != null) ? array[i] : "null" ));
    }

    public Tuple[] dump() {
        return Arrays.copyOf(array, size);
    }

    public void clear() {
        Arrays.fill(array, 0, size, null);
        size = 0;
    }

    public boolean containsIndex(int index) {
        return index >= 0 && index < size && array[index] != null;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // linear search to find a value
    public int indexOf(int value) {
        for (int i = 0; i < size; i++)
            if (array[i] != null && array[i].getValue() == value) return i;

        return -1;
    }

    // insert at a specific position with shifting elements
    public void insertAt(int index, int value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        if (size == capacity) ensureCapacity(capacity + 1);

        // shift elements to the right
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
            if (array[i] != null) array[i].setIndex(i);
        }

        array[index] = new Tuple(index, value);
        size++;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 1: Basic Operations ===");
        MahiDynamicArray arr = new MahiDynamicArray(5);

        arr.set(0, 6547);
        arr.set(2, 100);
        arr.set(1, 500);
        arr.display();

        System.out.println("\nValue at index 0: " + arr.get(0));
        System.out.println("Value at index 1: " + arr.get(1));
        System.out.println("Value at index 2: " + arr.get(2));

        System.out.println("\n=== Test 2: Auto-expansion ===");
        System.out.println("Initial capacity: " + arr.capacity());

        arr.set(10, 999); // // index 10 which is beyond the initial capacity
        System.out.println("After setting at index 10:");
        System.out.println("New capacity: " + arr.capacity());
        System.out.println("New size: " + arr.size());
        arr.display();

        System.out.println("\n=== Test 3: Add and Remove ===");
        arr.add(111);
        arr.add(222);
        arr.display();

        System.out.println("\n=== Test 4: Insert with Shift ===");
        arr.insertAt(1, 777);
        System.out.println("After inserting 777 at index 1:");
        arr.display();

        System.out.println("\n=== Test 5: Compaction ===");
        arr.delete(1);
        arr.delete(3);
        System.out.println("After deleting indices 1 and 3:");
        arr.display();

        arr.compact();
        System.out.println("After compaction:");
        arr.display();

        System.out.println("\n=== Test 6: Search ===");
        System.out.println("Index of value 100: " + arr.indexOf(100));
        System.out.println("Index of value 999: " + arr.indexOf(999));
        System.out.println("Index of value 9999: " + arr.indexOf(9999));

        System.out.println("\n=== Test 7: Dump and Display ===");

        System.out.println("\n ------ Dump ------ \n");
        Tuple[] allArrayList = arr.dump();
        String joined = Arrays.stream(allArrayList)
            .map(t -> t == null ? "null" : t.toString())
            .collect(java.util.stream.Collectors.joining(", "));
        System.out.println("[" + joined + "]");

        System.out.println("\n ------ Display ------ \n");
        arr.display();

        System.out.println("\n=== Test 8: Clear ===");
        arr.clear();
        System.out.println("After clear - Size: " + arr.size());
        System.out.println("Is empty: " + arr.isEmpty());
    }
}
