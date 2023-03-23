package GenerateData.Data;


import GenerateData.GenerateIntData;
import GenerateData.GenerateStringData;
import GenerateData.Igenerable;
import Logger.Loggers.Ilogger;
import Logger.Loggers.IntegerLogger;
import Logger.Loggers.StringLogger;
import ProcessingData.Interfaces.IntegerProcess;
import ProcessingData.Interfaces.StringProcess;
import ProcessingData.ProcessData;

public class GenerationData {
    private int amountData;
    private String type;
    private Igenerable igenerable;
    private Logger.Logger logger;

    public GenerationData(int amountData, String type) {
        this.amountData = amountData;
        this.type = type;
    }

    public void generateCurrData() {
        if (this.type.equals("строковое")) {
            this.igenerable = new GenerateStringData();
        } else if (this.type.equals("целое")) {
            this.igenerable = new GenerateIntData();
        }

        this.igenerable.generateData(this.amountData);
    }

    public Ilogger runProcessData() {
        Ilogger ilogger = null;
        if (this.type.equals("строковое")) {
            StringProcess stringProcess = (new ProcessData(this.igenerable.getList())).createStrProcessData();
            ilogger = new StringLogger(stringProcess.firstHandler(), stringProcess.getCountWord(), stringProcess.getWordStrings(), stringProcess.getCountSymbols());
        } else if (this.type.equals("целое")) {
            IntegerProcess integerProcess = (new ProcessData(this.igenerable.getList())).createIntProcessData();
            ilogger = new IntegerLogger(integerProcess.Sum(), (double)integerProcess.Average(), integerProcess.Max(), integerProcess.Min(), integerProcess.delete());
        }

        return ilogger;
    }

    public void answer() {
        this.logger = new Logger.Logger(this.runProcessData());
        this.logger.getLogger().printAnswer();
    }
}
