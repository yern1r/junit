public class Car {

    private String brand;
    private int number;

//⌘N for the Generate menu and then select Constructor , Getter , Setter or Getter and Setter


    public Car(String brand, int number) {
        this.brand = brand;
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public int getNumber() {
        return number;
    }

    //SOLID
    //проектирование системы на уровне абстракции,
    // а не реализации
    // сначала интерфейс - объявить все методы
    //потом уже реализация
}
