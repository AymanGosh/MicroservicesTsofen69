import javax.swing.*;

public class Calc {
	public static void main(String[] args) {

		String firstNum = JOptionPane.showInputDialog("firstNum");
		String secondNum = JOptionPane.showInputDialog("secondNum");

		int num1 = Integer.parseInt(firstNum);
		int num2 = Integer.parseInt(secondNum);
		int div = 0;

		try {
			div = num1 / num2;
			JOptionPane.showMessageDialog(null, "the div value is " + div, "as a result", JOptionPane.PLAIN_MESSAGE);
		} catch (ArithmeticException exception) {
			JOptionPane.showMessageDialog(null, "can't divide by Zero");
			System.err.println("/ by 0");
		}

		JOptionPane.showMessageDialog(null, "SW continues ");

	}
}