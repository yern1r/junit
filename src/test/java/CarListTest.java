//Test Drive Development


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class CarListTest {

    private CarList carlist;

    @Before
    public void setUp() throws Exception {
        carlist = new CarLinkedList();

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

    @Test
    public void insertInFirstPosition(){
        Car car = new Car("Tesla", 101);
        carlist.add(car, 0);
        Car carFromList = carlist.get(0);
        assertEquals("Tesla" , carFromList.getBrand());
    }

    @Test
    public void insertInMiddlePosition(){
        Car car = new Car("Tesla", 101);
        carlist.add(car, 50);
        Car carFromList = carlist.get(50);
        assertEquals("Tesla" , carFromList.getBrand());
    }

    @Test
    public void insertInLastPosition(){
        Car car = new Car("Tesla", 101);
        carlist.add(car, 100);
        Car carFromList = carlist.get(100);
        assertEquals("Tesla" , carFromList.getBrand());
    }
}