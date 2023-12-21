public class CustomException<T> extends Exception {
    private T additionalInfo;

    public CustomException(String message, T additionalInfo) {
        super(message);
        this.additionalInfo = additionalInfo;
    }

    public T getAdditionalInfo() {
        return additionalInfo;
    }

    public static void main(String[] args) {
        try {
            // Example of throwing a custom exception with additional information
            throw new CustomException<Integer>("Custom Exception Occurred", 42);
        } catch (CustomException<Integer> e) {
            System.out.println("Exception Message: " + e.getMessage());
            System.out.println("Additional Info: " + e.getAdditionalInfo());
        }
    }
}
