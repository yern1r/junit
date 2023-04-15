import java.util.ArrayList;
import java.util.List;

public class Basket<T extends Fruit> {
        private List<T> fruits;

        public Basket(){
            fruits = new ArrayList<>();
        }

        public float getWeight(){
            float result = 0;
            for (T fruit:
                 fruits) {
                result += fruit.getWeight();
            }
            return result;


        }
        public void add(T fruit){
            fruits.add(fruit);
        }

        public int compare(Basket<?> another){
            return Float.compare(getWeight(),another.getWeight());
        }

        public static <U extends Fruit> void transfer(Basket src, Basket dst){
            dst.fruits.addAll(src.fruits);
            src.fruits.clear();
        }
    }
