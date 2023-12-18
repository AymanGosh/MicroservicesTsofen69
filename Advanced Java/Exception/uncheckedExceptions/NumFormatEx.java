public class NumFormatEx {
	public static void main(String[] args) {
		int n = 0;
		try {
			n = Integer.parseInt("test");
		} catch (NumberFormatException exception) {
			System.out.println("Exception Object " + exception);
			System.out.println("Message " + exception.getMessage());
			System.out.println("StackTrace: ");
			exception.printStackTrace();
			n = 10;
		}
		System.out.println(n);
	}
}