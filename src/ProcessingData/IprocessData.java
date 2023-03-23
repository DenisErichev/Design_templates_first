package ProcessingData;

import ProcessingData.Interfaces.IntegerProcess;
import ProcessingData.Interfaces.StringProcess;

public interface IprocessData {
	IntegerProcess createIntProcessData();
	StringProcess createStrProcessData();
}
