package defaultMethods;

public interface TriangleDimensional {
    int getWidth();
    int getHeight();
	static  int getArea(int w, int h){
      	return w*h/2; 
    } 
}
