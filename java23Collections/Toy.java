package java23Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Toy {
    String name;
    int fromAge;
    double price;

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                ", fromAge=" + fromAge +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        Toy car = new Toy();
        Toy dolly = new Toy();
        Toy train = new Toy();
        Map<String, Toy> toys = new HashMap();
        toys.put("Jeep", car);
        toys.put("Masha", dolly);
        toys.put("Paravoz", train);
//        Getting each entry of the map
        System.out.println("The entries in the map are : ");
        for (Map.Entry toyEntry: toys.entrySet()) {
            System.out.println(toyEntry);
        }

//        Getting each key on the map
        System.out.println();
        System.out.println("The keys in the map are : ");
        for (String toyName: toys.keySet()) {
            System.out.println(toyName);
        }
//        Getting each value on the map
        ArrayList<Toy> allToys = new ArrayList<>(toys.values());
        System.out.println();
        System.out.println("The values in the map are : ");
        for (Toy toy: allToys) {
            System.out.println(toy);
        }
    }
}
