import java.util.Arrays;
import java.util.Iterator;

public class CarArrayList<T> implements CarList<T> {


    //Generics work with only linked type
    //In generics we cannot creat array with generic type
    //We can not crate a new object by new in generic type
    private Object [] array = new Object[10];
    private int size = 0;

    //O(N) - dependent on size of collection
    // time for execution dependents on size
    @Override
    public boolean add(T car, int index) {

        increaseArray();

        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        //arraycopy - take array whole part not with every single part
        System.arraycopy(array,index ,array , index + 1, size - index);

        array[index] = car;
        size++;
        return true;
    }

    // O(1) - will execute for constant time
    // and independent on size of collection
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    //O(1)
    @Override
    public boolean add(T car) {
        increaseArray();
        array[size] = car;
        size++;
        return true;
    }
    //O(N)
    @Override
    public boolean remove(T car) {
        for (int i = 0; i < size; i++){
            if (array[i].equals(car))
                return removeAt(i);
        }
        return false;
    }

    @Override
    public boolean contains(T car) {
        for (int i = 0; i < size; i++){
            if (array[i].equals(car))
                return true;
        }
        return false;
    }

    //O(N)
    @Override
    public boolean removeAt(int index) {
        checkIndex(index);

        System.arraycopy(array, index + 1 , array, index , size - 1 - index );
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Object[10];
        size = 0;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray(){
        if (size >= array.length){
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int index = 0;
            @Override
            public boolean hasNext() {
                 return index < size;
            }

            @Override
            public T next() {
                return (T)array[index++];
            }
        };
    }
}

// Getting element by index - O(1) +(advantage)
// Adding element at the end of list - O(1) +(advantage)
// Removing element - O(N) -(disadvantage)
// Adding element in the middle or in the hea(disadvantage)d of list - O(N) -(disadvantage)
// Size of array can not decrease automatically , and this take memory -(disadvantage)