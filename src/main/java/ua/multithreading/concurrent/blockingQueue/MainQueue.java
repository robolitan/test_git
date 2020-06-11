package ua.multithreading.concurrent.blockingQueue;

import java.util.Random;
import java.util.concurrent.*;

public class MainQueue {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        BlockingQueue start, studying, finish;
        service.execute(new JustComeStudent(start = new StudentQueue()));
        service.execute(new StudentStudying(start, studying = new StudentQueue()));
        service.execute(new StudentGo(studying, finish = new StudentQueue()));
        service.execute(new ConsumerStudent(finish));
        TimeUnit.SECONDS.sleep(20);
        System.out.println("finish");
        service.shutdown();

        Student.class.getClassLoader();
    }
}

class Student {
    enum State {READY, STUDYING, GO}

    private State currentState = State.READY;
    private final int ID;

    public Student(int Idn) {
        System.out.println("new student was created");
        this.ID = Idn;
    }

    public void changeToStudying() {
        currentState = State.STUDYING;
    }

    public void changeToGo() {
        currentState = State.GO;
    }

    @Override
    public String toString() {
        return "Student{" +
                "currentState=" + currentState +
                ", ID=" + ID +
                '}';
    }
}

class StudentQueue extends LinkedBlockingQueue {
}

class JustComeStudent implements Runnable {
    private BlockingQueue<Student> justComeQueue;
    private int count;

    public JustComeStudent(BlockingQueue<Student> justComeQueue) {
        this.justComeQueue = justComeQueue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                TimeUnit.MILLISECONDS.sleep(10 * new Random().nextInt(100));
                justComeQueue.add(new Student(count++));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class StudentStudying implements Runnable {
    private BlockingQueue<Student> justComeQueue, studying;
    private int count;

    public StudentStudying(BlockingQueue justComeQueue,
                           BlockingQueue studying) {
        this.justComeQueue = justComeQueue;
        this.studying = studying;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                TimeUnit.MILLISECONDS.sleep(10 * new Random().nextInt(50));
                Student take = justComeQueue.take();
                take.changeToStudying();
                studying.add(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class StudentGo implements Runnable {
    private BlockingQueue<Student> studying, finishStuding;
    private int count;

    public StudentGo(BlockingQueue studying, BlockingQueue finishStuding) {
        this.finishStuding = finishStuding;
        this.studying = studying;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                TimeUnit.MILLISECONDS.sleep(10 * new Random().nextInt(20));
                Student take = studying.take();
                take.changeToGo();
                finishStuding.add(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ConsumerStudent implements Runnable {
    BlockingQueue<Student> queue;

    public ConsumerStudent(BlockingQueue finishStudying) {
        this.queue = finishStudying;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

