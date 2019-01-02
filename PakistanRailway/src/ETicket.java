import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ETicket {
    /*
    private String departureDate;
    private String train;
    private String fromStation;
    private String toStation;
    */

    //Aggregation & Protected used because Only ETicket between RouteInformation Class Inherited
    protected RouteInformation routeInformation;

    private final CustomerInformation customerInformation;
    private final Login login;
    //import from Scanner Class
    Scanner input = new Scanner(System.in);

    //List of CustomerInformation
    List<CustomerInformation> customerList  = new ArrayList<>();

    public ETicket(RouteInformation routeInformation, CustomerInformation customerInformation, Login login) {
        this.routeInformation = routeInformation;
        this.customerInformation = customerInformation;
        this.login = login;
    }

    public RouteInformation getRouteInformation() {
        return routeInformation;
    }

    public void setRouteInformation(RouteInformation routeInformation) {
        this.routeInformation = routeInformation;
    }

    public CustomerInformation getCustomerInformation() {
        return customerInformation;
    }

    public Login getLogin() {
        return login;
    }

    //Exception used because .parse() method called
    private void departureDate() {
        try {
            long beforeDateLong = System.currentTimeMillis() - 1000*60*60*24;
            Date beforeDate = new Date(beforeDateLong);
            Date date1;

            do {
                System.out.println("Enter Departure Date: ");
                String departureDate = input.next();
                date1 = new SimpleDateFormat("dd-MM-yy").parse(departureDate);

                if (beforeDate.after(date1)) {
                    System.out.println("Date is invalid!");
                } else {
                    System.out.println(date1);
                }
            } while (beforeDate.after(date1));

        } catch (ParseException ex) {
            System.out.println("Exception Message: " + ex);

            //Recalling Method()
            departureDate();
        }
    }

    //Enter Seat/Birth, Pessenger & Train Type
    public void ticketBooking(String seatType, int passenger, String trainType) {
        var fare = 1;
        String name = null, cnic = null, mobileNumber = null, age = null;

        for (int i = 0; i < passenger; i++) {
            System.out.println("Enter Name: ");
            name = input.next();

            System.out.println("Enter CNIC: ");
            cnic = input.next();

            System.out.println("Enter Mobile Number: ");
            mobileNumber = input.next();

            System.out.println("Enter Your Age: ");
            age = input.next();

            //CustomerInformation Object Initialization
            CustomerInformation c1 = new CustomerInformation(name,cnic,mobileNumber,age);
            customerList.add(c1);

        }

        System.out.println("S.no |" + "Passenger Name |" + "Passenger CNIC |" + "Passenger Mobile Number |" + "Passenger Age ");

        for (int i = 0; i < customerList.size(); i++) {
            System.out.println((i+1)+ " ." + " " + customerList.get(i).getName() + "  | " + customerList.get(i).getCnic() + "  | " + customerList.get(i).getMobileNumber() + "  | " + customerList.get(i).getAge());
        }

        //Calling Date's Method()
        departureDate();
        if (seatType.equals("Birth") && passenger <= 60) {
            if (trainType.equals("Business")) {
                fare = 4430 * passenger;
            } else if (trainType.equals("Standard")) {
                fare = 3100 * passenger;
            } else if (trainType.equals("Economy")) {
                fare = 1570;
            }
            if (fare > getCustomerInformation().getCredit()) {
                System.out.println("Your credit is too low");
            } else {
                System.out.println("Your Booking " + seatType + " fare: " + fare + " Rs");
            }

        } else if (passenger > 60) {
            System.out.println("Error 404! \nYour Birth is invalid");
        } else if (seatType.equals("Seat") && passenger <= 18) {
            if (trainType.equals("Business")) {
                fare = 4430 * passenger;
            } else if (trainType.equals("Standard")) {
                fare = 3100 * passenger;
            } else if (trainType.equals("Economy")) {
                fare = 1470 * passenger;
            }

            if (fare > getCustomerInformation().getCredit()) {
                System.out.println("Your credit is too low");
            } else {
                System.out.println("Your Booking " + seatType + " fare: " + fare + " Rs");
            }

        } else if (passenger > 18) {
            System.out.println("Error 404! \nYour Seat is invalid");
        }

        if (fare < getCustomerInformation().getCredit()) {
            var credit = getCustomerInformation().getCredit() - fare;
            getCustomerInformation().setCredit(credit);
        } else {

        }

    }



    @Override
    public String toString() {
        return "ETicket{" +
                "routeInformation=" + routeInformation +
                ", customerInformation=" + customerInformation +
                ", input=" + input +
                ", customerList=" + customerList +
                '}';
    }
}
