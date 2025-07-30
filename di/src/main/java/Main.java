package di;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Constructor Injection ===");
        Printer printer1 = new Printer();
        UserService userService1 = new UserService(printer1);
        userService1.processUser("John");
        
        System.out.println("\n=== Setter Injection ===");
        Printer printer2 = new Printer();
        UserService userService2 = new UserService();
        userService2.setPrinter(printer2);
        userService2.processUser("Jane");
    }
} 