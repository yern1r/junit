import java.util.List;
import java.util.Set;
//Entry{K key, V value, Entry next;}
// it give as opportunity to use key as index (modified hashset?)
//no for each for map
//HashSet and Hash map elements has no order
//TreeSet and TreeMap has sorted order
//LinkedHashSet and LinkedHashMap elements have stable order as in the begging
public interface CarMap {
    void put(CarOwner key , Car value);

    Car get(CarOwner key);

    Set<CarOwner> keySet();

    List<Car> values();

    boolean remove(CarOwner key);

    int size();

    void clear();

}
