package ua.patterns.creators.abstractfabrice;

public class FabricaDoctor {

    Doctor getDoctor(Class<Doctor> clazz){
        return clazz.equals(AnimalDoctorImpl.class)? new AnimalDoctorImpl(): null;
    }
}
