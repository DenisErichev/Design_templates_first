import GenerateData.Data.GenerationData;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Barber implements Runnable{
    private Semaphore barberLock;
    private Semaphore customerLock;
//    private GenerationData process;
    private List<GenerationData> process;
    int count;
    public Barber(Semaphore barberLock, Semaphore customerLock, List<GenerationData> process) {
        this.barberLock = barberLock;
        this.customerLock = customerLock;
        this.process = process;
        this.count = process.size();
    }
    public void run() {
        int i=0;
        while (count>0) {
            try {
                barberLock.acquire();
                process.get(i).runProcessData();
                customerLock.release();
                i++;
                count--;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
