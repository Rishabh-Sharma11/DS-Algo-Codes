package lec32_SegmentTree;

public class STSum implements STI {

	@Override
	public int operation(int l, int r) {
		return l + r;

	}

	@Override
	public int defaultVAlue() {
		return 0;
	}

}
