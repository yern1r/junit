//Test Drive Development


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class CarListTest {

    private CarList carlist;

    @Before
    public void setUp() throws Exception {
        carlist = new CarArrayList();

        for (int i = 0; i < 100 ; i++){
            carlist.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdd100ElementsThenSizeMustBe100(){

        assertEquals(100, carlist.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased(){

        assertTrue(carlist.removeAt(5));
        assertEquals(99,carlist.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased(){
        Car toyota = new Car("Toyota", 150);
        carlist.add(toyota);
        assertEquals(101, carlist.size());
        assertTrue(carlist.remove(toyota));
        assertEquals(100, carlist.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenreurnFalse(){
        Car toyota = new Car("Toyota" , 150);
        assertFalse(carlist.remove(toyota));
        assertEquals(100,carlist.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0(){
        carlist.clear();
        assertEquals(0, carlist.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoxThenThrownException(){
        carlist.get(100);
    }

    @Test
    public void methodGetReturnRightValue(){
        Car car = carlist.get(0);
        assertEquals("Brand0", car.getBrand());
    }

}