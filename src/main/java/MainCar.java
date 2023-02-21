//primitive type(int, boolean, float, double)
//linked type/non-primitive type(String, List, Car , Box)
//Stack(1 megabyte) and Heap(RAM)

//int a = 5; Car car (= null) => Stack ,
// links to the object located in Stack

// new Car (...) => Heap ,
// objects located in heap

//Garbage Collector will remove/delete/clear
//when there is no links from Stack

// when we use '==' to compare
//we are comparing address of links not a value
public class MainCar {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", 1);
        Car car2 = new Car("BMW", 1);
            //Car car2 = car1;
        //car2 = car1;
        //car2.setNumber(5);
        //System.out.println(car1.getNumber());

            //compare the links of address
        //System.out.println(car1 == car2);

        System.out.println(car1.equals(car2));
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        //when by equals() it is equal
        //so hashcode also equal
        //if override equals = override hashcode

        //if hash-codes are different
        // so they are objects are different

        //if hash-codes are same it is not means
        // that object's values are equals
        // hash-codes are int type
        // therefore they can be same randomly
    }
}
