import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarCollectionTest {

    private CarCollection carCollection;

    @Before
    public void setUp() throws Exception {
        carCollection = new CarArrayList();
        for (int i = 0; i < 100; i++){
            carCollection.add(new Car("Brand" + i , i ));
        }
    }

    @Test
    public void contains(){
        assertTrue(carCollection.contains(new Car("Brand20",20)));
        assertFalse(carCollection.contains(new Car("Brand200",20)));
    }

    @Test
    public void testForEach(){
        int index = 0 ;
        for (Car car:
             carCollection) {
            index++;
        }
        assertEquals(100,index);
    }
}