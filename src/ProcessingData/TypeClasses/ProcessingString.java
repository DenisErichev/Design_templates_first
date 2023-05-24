package ProcessingData.TypeClasses;


import ProcessingData.Interfaces.StringProcess;

import java.util.ArrayList;
import java.util.List;

public class ProcessingString implements StringProcess {

	private List<String> lst;
	private List<Integer> countWord = new ArrayList<>();
	public ProcessingString(List<String> sList){
		lst = sList;
	}
	public String firstHandler(){
		String gluedString = "";
		for(String el: lst) {
			gluedString += el;
		}
		return gluedString;
	}
	public List<Integer> getCountWord(){
		for(String el: lst) {
			int count = el.split(" ").length;
			//длина одной строки без пробелов
			countWord.add(count);
		}
		return countWord;
	}
	public int getWordStrings() {
		int allCountWord = 0;
		for(Integer el: countWord){
			allCountWord+=el;
		}
		return allCountWord;
	}
	public int getCountSymbols(){
		int allCountSymbols = 0;
		for(int i=0;i<lst.size();i++) {
			allCountSymbols+= lst.get(i).length() - countWord.get(i);
		}
		return allCountSymbols;
	}

}