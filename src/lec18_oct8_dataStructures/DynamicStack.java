package lec18_oct8_dataStructures;

public class DynamicStack extends Stack {
	public void push(int item) throws Exception {
		
		if(isFull()) {
			int[]na=new int[data.length*2];
			for(int i=0;i<size();i++) {
				na[i]=data[i];
			}
			data=na;
		}
		
		super.push(item);
	}

}
