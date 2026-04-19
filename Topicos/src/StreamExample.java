import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class StreamExample {
    Integer valor(Integer integer){
        return integer;
    }
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
        List<List<String>> carMakeModelList = cars.stream().map(car -> List.of(car.make, car.model)).toList();
        Stream<String> chamada = Stream.of("Alvaro","Barbara","Caio","Bruno");
        Stream<String> chamaOrdenado = chamada.sorted();
        Collector<Object, TreeSet<Object>, TreeSet<Object>> pessoaCarCollector = Collector.of(
                () -> new TreeSet<>(),
                (set, pessoa) -> set.add(pessoa.toString()),
                (set1, set2) -> { set1.addAll(set2); return set1; }
        );
        List<String> nomes = List.of("Alvaro", "Barbara", "Caio", "Bruno");
        TreeSet<Object> resultado = nomes.stream().collect(pessoaCarCollector);
        System.out.println(resultado); // [Alvaro, Barbara, Bruno, Caio] (ordenado!)

        Collector<Object, int[], Integer> somaValores = Collector.of(
                () -> new int[]{0},
                (soma, valor) -> soma[0] += (Integer) valor,
                (soma1, soma2) -> {
                    soma1[0] += soma2[0];
                    return soma1;
                },
                soma -> soma[0]
        );
        Collector<Object, StringBuilder, String> somaNomes = Collector.of(
                () -> new StringBuilder(),
                (sb, nome) -> sb.append(nome.toString()),
                (sb1, sb2) -> sb1.append(sb2),
                StringBuilder::toString
        );

        System.out.println(pessoaCarCollector);
        System.out.println(cars.stream().filter(car -> car.model.contains("Mini")).count());
        System.out.println(sedanCar);
        System.out.println(carMakeList);
        System.out.println(carMakeModelList);
        System.out.println(chamaOrdenado.toList());

    }
}
