import GenerateData.Data.GenerationData;
import GenerateData.GenerateIntData;

import java.util.concurrent.Semaphore;

public class Customer implements Runnable{
    private GenerationData generationData;
    private int value = 2;
    public Customer(GenerationData generationData) {
        this.generationData = generationData;
    }

    @Override
    public void run() {
        try{
            generationData.acceptWalkInCustomer();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
