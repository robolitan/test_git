package ua.multithreading.base.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainCallable {
    public static void main(String[] args) {
        ArrayList<Future> listOfResult = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 4; i++) {
            Future<Integer> submit = executorService.submit(new FibonacciTask(i + 50));
            listOfResult.add(submit);
        }
        Future<Boolean> submit = executorService.submit(new FinishTaskIdentifier(listOfResult));
        while (!submit.isDone()){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("NOT YET");
        }
        listOfResult.forEach(MainCallable::print);
        executorService.shutdown();
    }

    private static void print(Future x) {
        try{
            System.out.println(x.get());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class FibonacciTask implements Callable<Integer> {
    private int count;
    private static int countID = 0;
    private int ID = countID++;

    public FibonacciTask(int n) {
        this.count = n;
    }

    private int fibonacci(int x) {
        if (x <= 0) return 1;
        return fibonacci(x - 1) + fibonacci(x - 2);
    }

    @Override
    public Integer call() throws Exception {
        return fibonacci(count);
    }
}

class FinishTaskIdentifier implements Callable<Boolean>{
    private List<? extends Future> listOfResult = new ArrayList();

    public FinishTaskIdentifier(List<? extends Future> listOfResult) {
        System.out.println(listOfResult.size());
        this.listOfResult = listOfResult;
    }

    private void isDone(){
        boolean flag = false;
        while (!flag) {
            flag = true;
            for (Future future : listOfResult) {
                if(!future.isDone()){
                    flag = false;
                    break;
                }
            }
        }
    }
    
    @Override
    public Boolean call() throws Exception {
        isDone();
        System.out.println("ALL TASKS IS DONE");
        return true;
    }
}