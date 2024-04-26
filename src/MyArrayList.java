import java.util.Iterator;


public class MyArrayList<T extends Object & Comparable<T>> implements MyList<T> {
    private T[] array;
    private int size;

    public MyArrayList() {
        array = (T[]) new Object[10];
        size = 0;
    }

    @Override
    public void add(T element) {
        if (size >= array.length) {
            increaseBuffer();

        }
        array[size++] = element;
    }

    private void increaseBuffer() {
        T[] newArray = (T[]) new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException("Index is not correct");
        T oldValue = array[index];
        array[index] = item;

    }

    @Override
    public void add(int index, T item) {
        if (size >= array.length) increaseBuffer();
        checkIndex(index);
        array[index] = item;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(size - 1, item);

    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public T getFirst() {
        return get(0);

    }

    @Override
    public T getLast() {
        return array[size - 1];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
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
        for (int i = 0; i < size - 1; i++)
            for (int j = i + 1; j < size; j++)
                if (array[i].compareTo(array[j]) > 0) {
                    T t = array[j];
                    array[j] = array[i];
                    array[i] = t;
                }

    }
    public int indexOf(T item){
        if(item == null){
            for(int i = 0; i < size; i++){
                if(array[i] == null){
                    return i;
                }
            }
        }else{
            for(int i = 0; i < size; i++){
                if(array[i].equals(item)){
                    return i;
                }
            }
        }
        return -1;

    }
    public int lastIndexOf (T item){
        for(int i = size - 1; i >= 0; i--)
            if(item ==(array[i]))
                return i;
        return -1;
    }
    @Override
    public boolean exist(T item) {
        return indexOf(item) >= 0;

    }
    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;

    }
    @Override
    public void clear() {
        array = (T[]) new Object[10];
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public Iterator<T> iterator() {
        return iterator();
    }


    public void printArr() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
