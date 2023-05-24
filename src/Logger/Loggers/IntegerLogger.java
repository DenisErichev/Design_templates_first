package Logger.Loggers;

import java.util.List;

public class IntegerLogger implements Ilogger {

	private int Sum;
	private double Average;
	private int Max;
	private  int Min;
	private List<Integer> del;
	public IntegerLogger(int Sum, double Average, int Max, int Min, List<Integer> del){
		this.Sum = Sum;
		this.Average = Average;
		this.Max = Max;
		this.Min = Min;
		this.del = del;
	}
	public void printAnswer() {
		System.out.println();
		System.out.println("Сумма равна " + Sum);
		System.out.println("Среднее значение равно " + Average);
		System.out.println("Максимальное значение равно " + Max);
		System.out.println("Минимальное значение " + Min);
		System.out.println("Полученная последовательность: ");
		for (int i = 0; i < del.size(); i++) {
			System.out.print(del.get(i) + " ");
		}
		System.out.println();
	}
}
