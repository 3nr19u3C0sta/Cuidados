import java.util.ArrayList;
import java.util.List;

public class Stream {
    public static void main(String[] args) {
        record Car(String type, String make, String model, String color) {

        }
        List<Car> cars = List.of(
                new Car("SUV", "Toyota", "RAV4", "Red"),
                new Car("Sedan", "Honda", "Civic", "Blue"),
                new Car("SUV", "Ford", "Escape", "Black"),
                new Car("Sedan", "Tesla", "Model 3", "White"),
                new Car("Donphin", "BYD", "Mini", "Gray")
        );
        List<Car> sedanCar = cars.stream().filter(car -> car.type.contains("Sedan")).toList();
        List<String> carMakeList = cars.stream().map(car -> car.make).toList();
        //List<String> carMakeModeList = cars.stream().flatMap(car -> Stream.of(car.make, car.model)).toList();
        System.out.println(cars.stream().filter(car -> car.model.contains("Mini")).count());
        System.out.println(sedanCar);
        System.out.println(carMakeList);
        //System.out.println(carMakeModeList);
    }
    
}
