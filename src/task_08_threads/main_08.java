package task_08_threads;

public class main_08 implements IObs {
    // thread will send progress to main, and update progress
    public static void main(String[] args) {
        new main_08();
    }


    public main_08() {
        Thread t1 = new Thread(new MyRunnable(this, "t1"));
        Thread t2 = new Thread(new MyRunnable(this, "t2"));
        Thread t3 = new Thread(new MyRunnable(this, "t3"));
        t1.start();
        try {
            t1.join(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
        t3.start();
    }


    @Override
    public void callMe(String name, int call) {
        System.out.println("call me: " + name + " " + call);
    }
}


interface IObs {
    public void callMe(String name, int call);
}



class MyRunnable implements Runnable {
    private final int maxCounter = 100;
    private final IObs obs;
    private final String name;
    private int counter = 0;


    public MyRunnable(IObs obs, String name) {
        this.obs = obs;
        this.name = name;
    }


    @Override
    public void run() {
        try {
            while (counter++ < maxCounter) {
                Thread.sleep(30);
                this.obs.callMe(name, counter);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
