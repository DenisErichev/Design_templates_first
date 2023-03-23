package ProcessingData;

import ProcessingData.Interfaces.IntegerProcess;
import ProcessingData.Interfaces.StringProcess;
import ProcessingData.TypeClasses.ProcessingInteger;
import ProcessingData.TypeClasses.ProcessingString;

import java.util.List;

public class ProcessData implements IprocessData{
	private List lst;
	public ProcessData(List lst) {
		this.lst = lst;
	}
	public IntegerProcess createIntProcessData(){
		return new ProcessingInteger(lst);
	}
	public StringProcess createStrProcessData(){
		return new ProcessingString(lst);
	}
}
