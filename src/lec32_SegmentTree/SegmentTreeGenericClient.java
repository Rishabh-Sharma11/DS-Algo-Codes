package lec32_SegmentTree;

public class SegmentTreeGenericClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -2, 8, 9, 10, 6, 5, 4 };
		SegmentTreeGeneric st = new SegmentTreeGeneric(arr, new STMax());
		st.display();
		System.out.println(st.query(2, 6));
		st.update(4, 16);
		st.display();
		System.out.println(st.query(0, 6));

	}

}
