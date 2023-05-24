package ProcessingData;

import ProcessingData.Interfaces.IntegerProcess;
import ProcessingData.Interfaces.StringProcess;
import ProcessingData.TypeClasses.ProcessingInteger;
import ProcessingData.TypeClasses.ProcessingString;

import java.util.List;

public class ProcessData implements IprocessData{
	private List lst;
	private String deleteChoice = "";
	public ProcessData(List lst,String deleteChoice) {
		this.lst = lst;
		this.deleteChoice = deleteChoice;
	}
	public IntegerProcess createIntProcessData(){
		return new ProcessingInteger(lst,deleteChoice);
	}
	public StringProcess createStrProcessData(){
		return new ProcessingString(lst);
	}
}
