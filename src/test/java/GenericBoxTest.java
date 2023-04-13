import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GenericBoxTest {

    @Test
    public void testBox(){
    GenericBox<Integer> box = new GenericBox<>(5,6,7);
    GenericBox<Float> box2 = new GenericBox<>(5f,6f,7f);
    assertEquals(0,box.compare(box2));
    }

    @Test
    public void wildcardMarkList(){
        //Number is parent of Integer, Integer extend Number
        // but -> collection of Number is not parent for collection of Integer
        List<Integer> numbers = new ArrayList<>();
        GenericBox.method(numbers);
    }

}