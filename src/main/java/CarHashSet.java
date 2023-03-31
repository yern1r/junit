import java.util.Iterator;

public class CarHashSet implements CarSet {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;
    private Entry[] array = new Entry[INITIAL_CAPACITY];
    @Override
    public boolean add(Car car) {

        if (size >=(array.length* LOAD_FACTOR) ){
            increaseArray();
        }

        boolean added = add(car, array);

        if (added){
            size++;
        }
        return added;
    }

    private boolean add(Car car, Entry[] dst){
        int position = getElementPosition(car , dst.length);
        if (dst[position] == null){ // if in this position/index is null
            //we create new entry
            Entry entry = new Entry(car, null);
            //then put this entry in array
            dst[position] = entry;
            return true;
        } else {
            //if there is same car as our car then return false
            Entry existedElement = dst[position];
            while (true) {
                if (existedElement.value.equals(car)) {
                    return false;
                }
                //if there is null value in next table
                //put to the next the value after existed car
                else if (existedElement.next == null) {
                    existedElement.next = new Entry(car, null);
                    return true;
                } else {//then so on
                    existedElement = existedElement.next;
                }
            }
        }
    }

    private void increaseArray(){
        Entry [] newArray = new Entry[array.length * 2];
        for (Entry entry: array) {
            Entry existedElement = entry;
            while(existedElement != null){
                add(existedElement.value, newArray);
                existedElement = existedElement.next;
            }
        }
        array = newArray;
    }


    @Override
    public boolean remove(Car car) {
        int position = getElementPosition( car, array.length);
        if (array[position] == null){
            return false;
        }

        Entry beforeLast = array[position];
        Entry last = beforeLast.next;

        if (beforeLast.value.equals(car)) {
                array[position] = last;
                size--;
                return true;
        }

        while (last != null) {
             if (last.value.equals(car)) {
                 beforeLast.next = last.next;
                size--;
                return true;
            }else {
                 beforeLast  = last;
                 last = last.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
    array = new Entry[INITIAL_CAPACITY];
    size = 0;
    }



    private int getElementPosition(Car car, int arrayLength ){
        return Math.abs(car.hashCode() % arrayLength);
    }


    private static class Entry{
        private Car value;
        private Entry next;

        public Entry(Car value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public boolean contains(Car car) {

        int position = getElementPosition( car, array.length);
        if (array[position] == null){
            return false;
        }

        Entry beforeLast = array[position];
        Entry last = beforeLast.next;

        if (beforeLast.value.equals(car)) {
            return true;
        }

        while (last != null) {
            if (last.value.equals(car)) {
                return true;
            }else {
                last = last.next;
            }
        }
        return false;
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
            int index = 0;
            int arrayIndex = 0;
            Entry entry;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Car next() {
                while (array[arrayIndex] == null){
                    arrayIndex++;
                }
                if (entry == null){
                    entry = array[arrayIndex];
                }
                Car result = entry.value;
                entry = entry.next;
                if (entry == null){
                    arrayIndex ++;
                }
                index++;
                return result;
            }
        };
    }
}
