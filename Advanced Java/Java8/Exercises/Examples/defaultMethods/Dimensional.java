package defaultMethods;

public interface Dimensional {
    int getWidth();
    int getHeight();
	default  int getArea(int w, int h){
      	return w*h; 
    } 
}
