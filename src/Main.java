import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        MyArrayList<Integer> aL = new MyArrayList();
        aL.add(1);
        aL.add(9);
        aL.add(2);
        aL.add(5);
        aL.add(7);
        aL.add(10);
        System.out.println("Test of the MyArrayList: ");
        System.out.println("My array list:");
        aL.printArr();
        System.out.println("Size of array list: " + aL.size());
        System.out.println("Get element at index 3: " + aL.get(3));
        System.out.println("Get last element of array list: " + aL.getLast());
        System.out.println("Get first element of array list: " + aL.getFirst());
        aL.remove(4);
        System.out.println("Remove element at index 4: ");
        aL.printArr();
        aL.removeLast();
        System.out.println("Remove last element of array list: ");
        aL.printArr();
        aL.removeFirst();
        System.out.println("Remove first element of array list: ");
        aL.printArr();
        aL.addFirst(2);
        aL.addLast(7);
        System.out.println("Add first and last element of array list: ");
        aL.printArr();
        System.out.println(aL.indexOf(7));
        aL.add(1);
        aL.add(9);
        aL.add(2);
        aL.set(3,11);
        System.out.println("Set element at index 3: ");
        aL.printArr();
        aL.sort();
        System.out.println("Sort array list: ");
        aL.printArr();
        System.out.println("Exist of element 11: " + aL.exist(11));


        System.out.println("Test of the MyLinkedList: ");



        MyList ll = new MyLinkedList<>();
        ll.add(2);
        ll.add(1);
        ll.add(67);
        ll.add(4);
        ll.add(3);
        ll.add(21);
        System.out.println("My linked list: " + ll.toString());
        ll.removeFirst();
        ll.removeLast();
        System.out.println("Remove first and last element of linked list: " + ll.toString());
        ll.add(0,34);
        ll.addLast(2);
        System.out.println("Add element at index 0 and last element of linked list: " + ll.toString());
        ll.remove(3);
        System.out.println("Remove element at index 0: " + ll.toString());
        ll.addFirst(11);
        System.out.println("Add first element of linked list: " + ll.toString());
        ll.set(3, 1);
        System.out.println("Set element at index 3: " + ll.toString());
        System.out.println("Get element at index 2: "+ll.get(2));

        System.out.println("Get first element:" + ll.getFirst());
        ll.addFirst(2);
        ll.size();
        System.out.println("Size of linked list: " + ll.size());


        System.out.println("MyLinkedList:"+ll.toString());






    }
}