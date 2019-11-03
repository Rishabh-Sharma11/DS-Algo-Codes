package lec19_StackAndQueue;

public class DynamicQueue extends Queue {

	public void enqueue(int item) throws Exception {
		if (isFull()) {
			int[] na = new int[data.length * 2];
//			int vf = 0;
//			for (int i = front; i < size(); i++, vf++) {
//				na[vf] = data[i];
//
//			}
//			vf++;
//			for (int i = 0; i < front; i++, vf++) {
//				na[vf] = data[i];
//			}

			for (int i = 0; i < size; i++) {
				int idx = (i + front) % data.length;
				na[i] = data[idx];
			}

			data = na;
			front = 0;

		}
		super.enqueue(item);
	}

}
