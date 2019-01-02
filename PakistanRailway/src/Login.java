import java.util.Scanner;

public class Login {

    Scanner input = new Scanner(System.in);
    Test test = new Test();

    public void loginAccount() {
        System.out.println("Enter UserName: ");
        String userName = input.next();

        System.out.println("Enter Password: ");
        String password = input.next();

        if (userName.equals("admin") && password.equals("123")) {
            System.out.println("______________WELCOME TO PAKISTAN RAILWAY______________\n______________TICKET BOOKING SYSTEM______________");
        } else {
            System.out.println("Invalid UserName or Password");
            //Recalling Method()
            loginAccount();
        }
    }
}
