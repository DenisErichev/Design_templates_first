package GenerateData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateStringData implements Igenerable {
	private List<String> strList = new ArrayList<>();
	public GenerateStringData(){}
	public void generateData(int amountData){
		Random random = new Random();
		int delay;
		for(int i=0;i<amountData;i++) {
			delay = random.nextInt(3,10);
			strList.add(generateRandomString());
			System.out.println(strList.get(i));
			if(i == amountData-1) {
				break;
			}
			try {
				Thread.sleep(delay*1000);
			}catch (InterruptedException ex){}
		}
	}
	public String generateRandomString(){
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		Random random = new Random();
		int targetStringLength;
		int randomStrLen = random.nextInt(2,10);
		String str = "";
		for(int i=0;i<randomStrLen;i++) {
			targetStringLength = random.nextInt(2,6);
			String generatedString = random.ints(leftLimit, rightLimit + 1)//поток псевдослуч.чисел
				.limit(targetStringLength)//выборка элементов конкретной длины
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)//полученную выборку представляем в строковый вид
				.toString();
			str += generatedString+" ";
		}
		return str;
	}
	public List getList(){
		return strList;
	}

}
