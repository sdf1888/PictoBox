import application.UserServices;

import java.util.Scanner;

public class User {

    private String username;
    private UserServices userService;

    public User(){
        this.userService = new UserServices();
    }

    private void setUsername(String username){
        this.username = username;
    }

    public static void main(String[] args){
        User user = new User();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: \n");

        user.setUsername(scanner.nextLine());
    }
}
