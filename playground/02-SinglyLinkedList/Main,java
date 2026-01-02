class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) head = tail = newNode;
        else tail = (tail.next = newNode);

        size++;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);

        newNode.next = head;
        head = newNode;

        if (tail == null) tail = head;

        size++;
    }

    public void insertAt(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            addFirst(value);
            return;
        }

        if (index == size) {
            add(value);
            return;
        }

        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) current = current.next;

        Node<T> newNode = new Node<>(value);
        newNode.next = current.next;
        current.next = newNode;

        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<T> current = head;
        for (int i = 0; i < index; i++) current = current.next;

        return current.value;
    }

    public boolean exist(T value) {
        Node<T> current = head;

        while (current != null) {
            if (Objects.equals(value, current.value)) return true;
            current = current.next;
        }
        return false;
    }

    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            head = head.next;
            if (head == null) tail = null;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) current = current.next;

            current.next = current.next.next;

            if (index == size - 1) tail = current;
        }

        size--;
    }

    public int size() {
        return size;
    }

    public void displayStructure() {
        if (head == null) {
            System.out.println("HEAD -> <null>");
            System.out.println("Tail: null");
            System.out.println("Size: 0");
            return;
        }

        Node<T> current = head;
        int index = 0;

        System.out.println("\nLinkedList Structure:");

        while (current != null) {
            System.out.print("Node[" + index + "] | value=" + current.value  + " | next=" + (
                current.next != null ? current.next.value : "<null>"
            ) + "\n");

            current = current.next;
            index++;
        }

        System.out.println("HEAD -> " + head.value);
        System.out.println("TAIL -> " + tail.value);
        System.out.println("SIZE -> " + size);
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        System.out.println("=== Test 1: add (1, 20, 30) ===");
        list.add(10);
        list.add(20);
        list.add(30);
        list.displayStructure();

        System.out.println("\n=== Test 2: addFirst (5) ===");
        list.addFirst(5);
        list.displayStructure();

        System.out.println("\n=== Test 3: insertAt (index: 2, value: 15) ===");
        list.insertAt(2, 15);
        list.displayStructure();

        System.out.println("\n=== Test 4: remove (0, 2) ===");
        System.out.print("\nBefore Remove:");
        list.displayStructure();

        list.remove(0);   // remove head
        list.remove(2);   // remove middle

        System.out.print("\nAfter Remove:");
        list.displayStructure();

        System.out.println("\n=== Test 5: get (0, 1, last) ===");
        System.out.println("get(0) = " + list.get(0));
        System.out.println("get(1) = " + list.get(1));
        System.out.println("get(last) = " + list.get(list.size() - 1));

        System.out.println("\n=== Test 6: exist (5, 15, 30, 100) ===");
        int[] testValues = {5, 15, 30, 100};
        for (int val : testValues) System.out.println("exist(" + val + ") = " + list.exist(val));
    }
}
