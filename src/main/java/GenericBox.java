import javax.swing.event.ListDataListener;
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

    //we show that this method is parametered <U>
    //return type of method is U
    public static <U> U getFirstElement(List<U> list){
        return  list.get(0);
    }

    //extends U - либо тип U либо наследники тип U
    //for ex: Number : type of Number or Integer/Float/Double

    //super U - либо тип U либо родиелем тип U
    //for ex: Number : type of Number or Object(parent)
    public static <U> void transfer(List<? extends U> src , List<? super U> dst){
        dst.addAll(src);
        src.clear();
    }
    public void setArray(T[] array) {
        this.array = array;
    }
}
