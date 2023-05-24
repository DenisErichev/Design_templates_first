import GenerateData.Data.GenerationData;

import java.util.concurrent.Semaphore;

public class Barber implements Runnable{
    private Semaphore barberLock;
    private Semaphore customerLock;
    private GenerationData process;
    public Barber(Semaphore barberLock,Semaphore customerLock,GenerationData process) {
        this.barberLock = barberLock;
        this.customerLock = customerLock;
        this.process = process;
    }
    public void run() {
        try {
            barberLock.acquire();
            process.runProcessData();
            customerLock.release();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
