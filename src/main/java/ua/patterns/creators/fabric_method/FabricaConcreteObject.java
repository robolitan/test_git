package ua.patterns.creators.fabric_method;

public class FabricaConcreteObject {

    public SomeObject getSomeObject(Class aClass){
        if(aClass.equals(ConcreteObject.class)){
            return new ConcreteObject();
        }
        if(aClass.equals(ConcreteObject2.class)){
            return new ConcreteObject2();
        }
        return null;
    }
}
