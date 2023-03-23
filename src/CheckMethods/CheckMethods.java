package CheckMethods;

import java.util.Scanner;

public class CheckMethods {
	public static String checkInputCommand(String type, Scanner sc) {
		type = sc.next();
		if(type.equals("строковое")){
			return type;
		}else if(type.equals("целое")) {
			return type;
		}else{
			System.out.println("Ошибка ввода!");
			System.out.println("Нужно ввести команду: строковое или целое");
			return checkInputCommand(type, sc);
		}
	}
	public static String checkInputParity(String type, Scanner sc) {
		type = sc.next();
		if(type.equals("четные")){
			return type;
		}else if(type.equals("нечетные")) {
			return type;
		}else{
			System.out.println("Ошибка ввода!");
			System.out.println("Нужно ввести команду: четные или нечетные");
			return checkInputParity(type, sc);
		}
	}
	public static int checkInputNum() {
		Scanner scan = new Scanner(System.in);
		int value = 0;
		if(scan.hasNextInt()){
			value = scan.nextInt();
			return value;
		}
		else{
			System.out.println("Ошибка ввода!");
			System.out.print("Нужно ввести целочисленное значение:");
			return checkInputNum();
		}
	}
}
