package di;

public class UserService {
    private Printer printer;
    
    // Constructor injection
    public UserService(Printer printer) {
        this.printer = printer;
    }
    
    // Default constructor for setter injection
    public UserService() {
    }
    
    // Setter injection
    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
    
    public void processUser(String username) {
        printer.print("Processing user: " + username);
    }
} 