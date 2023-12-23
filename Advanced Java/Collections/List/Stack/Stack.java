package stacks;

public class StackCust {

	int size;
	int arr[];
	int top;
	
	public StackCust(int size) {
		this.size=size;
		this.arr = new int[size];
		this.top =-1;
	}
	
	public boolean isEmpty()
	{
		return (top ==-1);
	}
	
	public boolean isFull()
	{
		return (size-1 == top);
	}
	
	public void push( int elem)
	{
		if(!isFull())
		{
			top++;
			arr[top] = elem;
			System.out.println(" the pushed element is "+elem);
		}else {
			System.out.println("the stack is full");
		}
	}
	
	public int peek()
	{
		if(!this.isEmpty())
		{
			return arr[top];
		}else 
		{
			System.out.println("stack is empty!!");
			return -1;
		}
	}
	
	public int pop()
	{
		if(!this.isEmpty())
		{
			int popedIndx = top;
			top--;
			return arr[top];
		}else
		{
			System.out.println("Stack is empty !!");
			return -1;
		}
	}
}
