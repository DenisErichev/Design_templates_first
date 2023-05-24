package ProcessingData.Interfaces;

import Logger.Loggers.Ilogger;

import java.util.List;

public interface IntegerProcess {
	int Sum ();
	int Average();
	int Min();
	int Max();
	List<Integer> delete();
}
