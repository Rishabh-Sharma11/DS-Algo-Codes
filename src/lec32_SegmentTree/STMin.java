package lec32_SegmentTree;

public class STMin implements STI {
	@Override
	public int operation(int l, int r) {
		return Math.min(l, r);
		
	}

	@Override
	public int defaultVAlue() {
		return Integer.MAX_VALUE;
		
	}

}
