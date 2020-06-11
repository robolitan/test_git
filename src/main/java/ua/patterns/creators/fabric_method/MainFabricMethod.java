package ua.patterns.creators.fabric_method;

public class MainFabricMethod {
    public static void main(String[] args) {
        FabricaConcreteObject fco = new FabricaConcreteObject();
        System.out.println(fco.getSomeObject(ConcreteObject.class).getClass().getName());
        System.out.println(fco.getSomeObject(ConcreteObject2.class).getClass().getName());
    }
}
