public class Test {
    public static void main(String[] args) {
        String endRegex = "The End\\.";

        System.out.println("The End.".matches(endRegex));; // true
        System.out.println("The End?".matches(endRegex));; // false
    }
}
