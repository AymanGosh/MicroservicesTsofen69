package defaultMethods;

public class Rectangle implements TriangleDimensional, AbstractDimentional {
	
	@Override
	public int getArea(int w, int h) {
		return w*h;
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
