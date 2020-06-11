package ua.multithreading.concurrent.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class MainCompletableFuture {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start...");

        CompletableFuture<Double> firstFuture = CompletableFuture.supplyAsync(
                () -> 20.0
        );

        CompletableFuture<Double> secondFuture = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 10.0;
                }
        );

        CompletableFuture<Double> result = secondFuture.thenCombine(firstFuture,
                (x1, x2) -> x1 / x2
        );


        new Thread(() -> {
            while (!result.isDone()) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        ).start();


        TimeUnit.SECONDS.sleep(3);
        System.out.println("finish...");
    }
}
