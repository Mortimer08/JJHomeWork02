public class Dog extends Animal{
    private String color;
    private boolean chipped;
    public Dog (String name){
        this.name = name;
    }
    public void makeSound(){
        System.out.println("Bark!");
    }
}
