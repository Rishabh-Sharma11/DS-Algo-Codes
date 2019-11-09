package lec32_SegmentTree;

public class STMax implements STI {
	@Override
	public int operation(int l, int r) {
		return Math.max(l, r);
		
	}

	@Override
	public int defaultVAlue() {
		return Integer.MIN_VALUE;
		
	}

}
