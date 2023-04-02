import java.util.Objects;

public class Car /*implements Comparable<Car>*/ {

    private String brand;
    private int number;

//⌘N for the Generate menu and then select Constructor , Getter , Setter or Getter and Setter


    public Car(String brand, int number) {
        this.brand = brand;
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

            //checking is it Car object?
            // if (obj instanceof Car){} same
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o; //down-castling
        return number == car.number && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, number);
    }

    public int getNumber() {
        return number;
    }

    //SOLID
    //проектирование системы на уровне абстракции,
    // а не реализации
    // сначала интерфейс - объявить все методы
    //потом уже реализация


    //if there is no access
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", number=" + number +
                '}';
    }

    /*@Override
    public int compareTo(Car o) {
        if (number < o.number){
            return -1;
        }else if (number > o.number){
            return 1;
        }else {
            return 0;
        }

        //return brand.compareTo(o.brand);

    }*/
}
