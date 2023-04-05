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

public class GenerationData {
    private int amountData;
    private String type;
    private Igenerable igenerable;

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
        IprocessData iprocessData = new ProcessData(this.igenerable.getList());
        if (this.type.equals("строковое")) {
            StringProcess stringProcess = iprocessData.createStrProcessData();
            ilogger = new StringLogger(stringProcess.firstHandler(), stringProcess.getCountWord(), stringProcess.getWordStrings(), stringProcess.getCountSymbols());
        } else if (this.type.equals("целое")) {
            IntegerProcess integerProcess = iprocessData.createIntProcessData();
            ilogger = new IntegerLogger(integerProcess.Sum(), (double)integerProcess.Average(), integerProcess.Max(), integerProcess.Min(), integerProcess.delete());
        }

        return ilogger;
    }

    public void answer() {
        Logger logger = new Logger(this.runProcessData());
        logger.getLogger().printAnswer();
    }
}
