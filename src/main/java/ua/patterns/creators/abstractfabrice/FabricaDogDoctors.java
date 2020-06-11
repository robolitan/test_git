package ua.patterns.creators.abstractfabrice;

public class FabricaDogDoctors implements AbstractFabric {
    @Override
    public FabricaOfAnimal getFabricaAnimal() {
        return new FabricaOfAnimal();
    }

    @Override
    public FabricaDoctor getFabricaDoctor() {
        return null;
    }
}
