package ua.multithreading.base.volatiles.with;

import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.SneakyThrows;
import org.omg.PortableServer.THREAD_POLICY_ID;

public class MainWithOutVolatile {
    public static void main(String[] args) {
        Source source = new Source();
        new Thread(new SetterValue(source),"ONE" ).start();
        new Thread(new SetterValue2(source),"TWO" ).start();
    }
}

class Source{
    long value = 1111111111111111111L;

    public long getValue() {
        return value;
    }

    public void setValue(long value) throws Exception {
        this.value = value;
        if(value != 1111111111111111111L)
            if(value != 222222222222222223L)
                throw new Exception(Thread.currentThread().getName() + "_____");
        System.out.println(value + " after " + Thread.currentThread().getName());
    }
}



class SetterValue implements Runnable{

    Source source;

    public SetterValue(Source source) {
        this.source = source;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (!Thread.interrupted()){
            source.setValue(222222222222222222L);
        }
    }
}

class SetterValue2 implements Runnable{
    Source source;

    public SetterValue2(Source source) {
        this.source = source;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (!Thread.interrupted()){
            source.setValue(1111111111111111111L);
        }
    }
}