import java.util.Iterator;

public class MyLinkedList<T extends Object & Comparable<T>> implements MyList<T> {
    private Node<T> head;
    private int size;
    private Node<T> tail;
    private static class Node<T>{
        T item;
        Node<T> next;
        Node<T> prev;
        public Node(T item){
            this.item = item;
            next = null;
            prev = null;
        }
        public Node(T item, Node<T> next, Node<T> prev){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

    }
    public MyLinkedList(){
        head = tail = null;
        size = 0;
    }
    @Override
    public void add(T item) {
        Node<T> newNode = new Node<T>(item);
        if(head == null) {
            head = newNode;

        }else{
            Node<T> currentNode = head;
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.prev = currentNode;
            tail = newNode;
        }
        size++;
    }
    @Override
    public void set(int index, T item) {
        Node<T> node = head;
        while(index-- != 0 && node.next  != null){
            node = node.next;
            node.item = item;
        }

    }
    private void checkIndex(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException("Index is not correct");
    }
    @Override
    public void add(int index, T item) {
        if (head == null || index == size) {
            add(item);
            return;
        }
        checkIndex(index);

        size++;
        Node<T> node = getNodeAt(index + 1);

        Node<T> newNode = new Node<>(item, node.prev, node);
        if (node.prev != null)
            node.prev.next = newNode;
        node.prev = newNode;
        if (newNode.prev == null)
            head = newNode;
    }
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return getLastNode().item;
    }

    private Node<T> getLastNode() {
        Node<T> node = head;
        while (node.next != null)
            node = node.next;
        return node;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {
        boolean swapped;
        Node<T> node;
        if (head == null)
            return;
        do {
            swapped = false;
            node = head;

            while (node.next != null) {
                if (node.item.compareTo(node.next.item) > 0) {
                    T t = node.next.item;
                    node.next.item = node.item;
                    node.item = t;
                    swapped = true;
                }
                node = node.next;
            }
        }
        while (swapped);
    }

    @Override
    public int indexOf(T item) {
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.item.equals(item))
                return i;
            node = node.next;
        }
        return -1;
    }

    @Override
    public boolean exist(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public Object[] toArray() {
        T[] array = (T[]) new Object[size];
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            array[i] = node.item;
            node = node.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        Node<T> front;

        public Iter() {
            front = head;
        }

        public boolean hasNext() {
            return front != null;
        }

        public T next() {
            Node<T> node = front;
            front = front.next;
            return node.item;
        }
    }

    private Node<T> getNodeAt(int index) {
        checkIndex(index);
        Node<T> node = head;
        if (node == null)
            return null;
        while (--index != 0 && node.next != null)
            node = node.next;
        return node;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<T> h = head;
        while (h != null) {
            str.append(h.item).append(" ");
            h = h.next;
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }

}

