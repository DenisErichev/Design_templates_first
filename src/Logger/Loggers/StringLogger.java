package Logger.Loggers;

import java.util.List;

public class StringLogger implements Ilogger {
	private int allCountWord = 0;
	private int allCountSymbols = 0;
	private String gluedString ="";
	private List<Integer> countWord;
	public StringLogger(String gluedString, List<Integer> countWord, int allCountWord, int allCountSymbols){
		this.gluedString = gluedString;
		this.countWord = countWord;
		this.allCountWord = allCountWord;
		this.allCountSymbols = allCountSymbols;
	}
	public void printAnswer() {
		System.out.println();
		System.out.println("Склеенная строка:");
		System.out.println(gluedString);
		System.out.println("Количество слов в каждой строке: ");
		for(int i=0;i<countWord.size();i++) {
			System.out.println("Строка №"+(i+1)+": "+countWord.get(i));
		}
		System.out.println("Общее количество слов: " + allCountWord);
		System.out.println("Общее количество символов по всем строкам списка: "+allCountSymbols);
	}
}
