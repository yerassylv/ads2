
public class Main {

    public static void main(String[] args) {

        MyArrayList<Integer> aL = new MyArrayList();
        aL.add(1);
        aL.add(9);
        aL.add(2);
        aL.add(5);
        aL.add(7);
        aL.add(10);
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








    }
}