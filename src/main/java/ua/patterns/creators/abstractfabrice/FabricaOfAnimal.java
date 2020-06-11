package ua.patterns.creators.abstractfabrice;

public class FabricaOfAnimal {
    Animal getAnimal(Class<Animal> clazz){
        return clazz.equals(Dog.class)? new Dog(): new Cat();
    }
}
