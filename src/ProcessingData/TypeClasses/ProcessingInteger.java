package ProcessingData.TypeClasses;

import Logger.Loggers.Ilogger;
import ProcessingData.Interfaces.IntegerProcess;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static CheckMethods.CheckMethods.checkInputParity;

public class ProcessingInteger implements IntegerProcess {
	private List<Integer> intList;
	private String deleteChoice;
	public ProcessingInteger(List<Integer> lst,String deleteChoice){
		intList = lst;
		this.deleteChoice = deleteChoice;
	}
	public int sum = 0;
	public int Sum () {
		for (Integer el: intList) {
			sum += el;
		}
		return sum;
	}
	public int Average() {
		return Sum()/intList.size();
	}
	public int Min() {
		int min = intList.get(0);
		for(Integer el: intList) {
			if (el < min) min = el;
		}
		return min;
	}
	public int Max() {
		int max = intList.get(0);
		for(Integer el: intList) {
			if (el > max) max = el;
		}
		return max;
	}
	public List<Integer> delete () {
		List <Integer> currList = new ArrayList<>();
		int size = intList.size();
		if (deleteChoice.equals("четные")) {
			for (int i = 0; i < size; i++) {
				if(i%2 == 0) {
					continue;
				}
				currList.add(intList.get(i));
			}
		}
		else if (deleteChoice.equals("нечетные")) {
			for (int i = 0; i < size; i++) {
				if(i%2 == 1) {
					continue;
				}
				currList.add(intList.get(i));
			}
		}
		return currList;
	}


}
