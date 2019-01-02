import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Test {
    static Login login1 = new Login();
    static RouteInformation rN1 = new RouteInformation();
    static CustomerInformation cN1 = new CustomerInformation();
    static ETicket eTicket = new ETicket(rN1, cN1, login1);
    static Scanner input = new Scanner(System.in);
    static int selector;

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println("Today Date: " + date);

        eTicket.getLogin().loginAccount();


        do {
            switchCase();
        } while (selector >= 5);
    }

    public static void profile(){
        String fileName = "Profile.txt";
        String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            while((line = br.readLine()) != null) {
                System.out.println(line);
            } br.close();
        } catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    public static void switchCase() {
        System.out.println("Select: \n → 1.Book Ticket \n → 2.Route Information \n → 3.Check Balance \n → 4.Profile \n → 5.Logout");
        selector = input.nextInt();
        switch (selector) {
            case 1: {
                System.out.println("Enter Seat or Birth: ");
                String seatOrBirth = input.next();

                System.out.println("Enter Passengers:");
                int passenger = input.nextInt();

                System.out.println("Enter Train Type");
                String trainType = input.next();

                eTicket.ticketBooking(seatOrBirth, passenger, trainType);

                System.out.println();
                switchCase();
                break;

            }

            case 2: {
                System.out.println("Enter Station Go From: ");
                String fromStation = input.next();

                System.out.println("Enter Station Goto: ");
                String toStation = input.next();

                System.out.println("Enter Train Name: ");
                String trainName = input.next();

                eTicket.routeInformation.routeGet(fromStation, toStation, trainName);

                System.out.println();
                switchCase();

                break;
            }

            case 3: {
                var credit = eTicket.getCustomerInformation().getCredit();
                System.out.println("Your Credit:" + credit);
                System.out.println();
                switchCase();
            }

            case 4: {
                profile();
                System.out.println();
                System.out.println("Enter 1 For Menu");
                int a = input.nextInt();

                if (a == 1) {
                    switchCase();
                }
            }

            case 5: {
                System.out.println("Logout Successfully");
                System.out.println("Login: ");
                eTicket.getLogin().loginAccount();
            }
        }
    }
}