import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Animal[] animals = new Animal[4];
        animals[0] = new Cat("Fluff");
        animals[1] = new Dog("Pluto");
        animals[2] = new Cat("Bars");
        animals[3] = new Dog("Fidel");
        for (int i = 0; i < animals.length; i++) {
            Class<?> clazz = animals[i].getClass();
            Field [] fields = clazz.getDeclaredFields();
            System.out.printf("Object %s has following fields:\n",clazz.getName());
            for (int j = 0; j < fields.length; j++) {
                fields[j].setAccessible(true);
                System.out.printf("Field: %s, value: %s\n", fields[j].getName(), fields[j].get(animals[i]));
            }
            Method [] methods = clazz.getDeclaredMethods();
            for (int j = 0; j < methods.length; j++) {
                if(methods[j].getName().equals("makeSound")){
                    System.out.println("Can make sound:");
                    methods[j].invoke(animals[i]);
                }
            }
        }
    }
}
