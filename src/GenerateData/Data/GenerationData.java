package GenerateData.Data;


import GenerateData.GenerateIntData;
import GenerateData.GenerateStringData;
import GenerateData.Igenerable;
import Logger.Loggers.Ilogger;
import Logger.Logger;
import Logger.Loggers.IntegerLogger;
import Logger.Loggers.StringLogger;
import ProcessingData.Interfaces.IntegerProcess;
import ProcessingData.Interfaces.StringProcess;
import ProcessingData.IprocessData;
import ProcessingData.ProcessData;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GenerationData{
    public int amountData;
    private String type1;
    private String type2;
    private List<String> lsType = new ArrayList<>();
    public Igenerable igenerable;
    private List<Igenerable> lstIgenerable = new ArrayList<>();
    private Lock lock;
    private Semaphore barberChair;
    private List<Ilogger> lstIlog = new ArrayList<>();
    private AtomicInteger waitingCustomerCount;
    private int noOfWaitingChairs;
    private Semaphore barberLock;
    private Semaphore customerLock;
    public Logger logger;
    private String deleteChoice = "";

    public GenerationData(int noOfWaitingChairs, Semaphore barberLock, Semaphore customerLock,String type1,int amountData,String deleteChoice) {
        this.waitingCustomerCount = new AtomicInteger(0);
        this.noOfWaitingChairs = noOfWaitingChairs;
        this.amountData = amountData;
        this.type1 = type1;
        this.lock = new ReentrantLock();
        this.barberChair = new Semaphore(1);
        this.barberLock = barberLock;
        this.customerLock = customerLock;
        this.deleteChoice = deleteChoice;
    }
    public void acceptWalkInCustomer()  {
        lock.lock();
        if(isFull()) {
            lock.unlock();
        }
        this.generateCurrData();
        waitingCustomerCount.incrementAndGet();
        lock.unlock();
        try{
            barberChair.acquire();
            waitingCustomerCount.decrementAndGet();
            barberLock.release();
            customerLock.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.answer();
        barberChair.release();
    }
    private boolean isFull() {
        return waitingCustomerCount.get() == noOfWaitingChairs && logger != null;
    }
    public void answer() {
        logger.getLogger().printAnswer();
    }
    public void generateCurrData() {
        if (this.type1.contains("строковое")) {
            this.igenerable = new GenerateStringData();
            lstIgenerable.add(this.igenerable);
            igenerable.generateData(amountData);
        }
        else if (this.type1.contains("целое")) {
            this.igenerable = new GenerateIntData();
            lstIgenerable.add(this.igenerable);
            igenerable.generateData(amountData);
        }

    }

    public void runProcessData() {
        lsType.add(type1);
        Ilogger ilogger = null;
        IprocessData iprocessData = null;
        if (this.lsType.contains("строковое")) {
            for(int i=0;i<lstIgenerable.size();i++) {
                if(lstIgenerable.get(i) instanceof GenerateStringData) {
                    iprocessData = new ProcessData((List) this.lstIgenerable.get(i).getList(),deleteChoice);
                    break;
                }
            }
            StringProcess stringProcess = iprocessData.createStrProcessData();
            ilogger = new StringLogger(stringProcess.firstHandler(), stringProcess.getCountWord(), stringProcess.getWordStrings(), stringProcess.getCountSymbols());
            lstIlog.add(ilogger);
            logger = new Logger(ilogger);
        }
        else if (this.lsType.contains("целое")) {
            for(int i=0;i<lstIgenerable.size();i++) {
                if(lstIgenerable.get(i) instanceof GenerateIntData) {
                    iprocessData = new ProcessData((List) this.lstIgenerable.get(i).getList(),deleteChoice);
                    break;
                }
            }
            IntegerProcess integerProcess = iprocessData.createIntProcessData();
            ilogger = new IntegerLogger(integerProcess.Sum(), (double)integerProcess.Average(), integerProcess.Max(), integerProcess.Min(), integerProcess.delete());
            logger = new Logger(ilogger);
        }
    }


}

