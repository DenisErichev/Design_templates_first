package GenerateData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateIntData implements Igenerable {
	private List<Integer> intList = new ArrayList<>();

	public GenerateIntData(){}
	public void generateData(int amountData){
		Random random = new Random();
		int delay;
		for(int i=0;i<amountData;i++) {
			delay = random.nextInt(2,3);
			intList.add(random.nextInt(1,100000));
			System.out.println(intList.get(i));
			if(i == amountData-1) {
				break;
			}
			try {
				Thread.sleep(delay*1000);
			}catch (InterruptedException ex){}
		}
	}
	public List getList(){
		return intList;
	}

	@Override
	public boolean checkList() {
		return intList.isEmpty();
	}
}
