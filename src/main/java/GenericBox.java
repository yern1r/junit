import java.io.Serializable;
import java.util.List;

//extends - is like limit
public class GenericBox<T extends Number & Comparable<T> & Serializable> {
    private T[] array;

    public GenericBox(T... array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public double average(){
        double result = 0;
        for (T element: array) {
            result += ((Number)element).doubleValue();
        }
        return  result / array.length;
    }

    //wildcard - ?
    public int compare(GenericBox<?> another){
        if (average() > another.average()){
            return 1;
        }else if(average() == another.average()){
            return 0;
        }else {
            return -1;
        }
    }

    //public void method(List<Number> numbers){
    //}

    public static void method(List<? extends Number> numbers){

    }

    public void setArray(T[] array) {
        this.array = array;
    }
}
