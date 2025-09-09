public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();

        // Test getNonZeroLengthString
        String name = input.getNonZeroLengthString("Enter your name");
        System.out.println("You entered: " + name);

        // Test getInt with range 1-100
        int age = input.getInt("Enter your age", 1, 100);
        System.out.println("You entered: " + age);

        // Test getDouble with range 0.0-1000.0
        double price = input.getDouble("Enter a price", 0.0, 1000.0);
        System.out.println("You entered: " + price);

        // Test getYNConfirm
        boolean confirm = input.getYNConfirm("Do you want to continue?");
        System.out.println("You answered: " + (confirm ? "Yes" : "No"));

        System.out.println("All SafeInputObj methods tested successfully!");
    }
}
