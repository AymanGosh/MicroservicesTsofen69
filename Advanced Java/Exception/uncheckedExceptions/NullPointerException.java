public class NullPointerException {
    public static void main(String[] args) {
        String text = null;

        try {
            // Attempting to invoke a method on a null object
            int length = text.length();
            System.out.println("Length: " + length);
        } catch (NullPointerException e) {
            System.err.println("Error: Null pointer encountered. Please check your object references.");
        }
    }
}
