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



}
