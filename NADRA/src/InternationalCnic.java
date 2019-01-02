public class InternationalCnic extends Nadra implements TypeService {
    private boolean passport;

    public InternationalCnic(String fatherName, String motherName,String typeService, boolean passport) {
        super(fatherName, motherName, typeService);
        this.passport = passport;
    }

    public boolean isPassport() {
        return passport;
    }

    public void setPassport(boolean passport) {
        this.passport = passport;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public void eligibleUser() {
        if (fatherName != "" && motherName != "" && passport == true) {
            System.out.println("You are eligible to Overseas CNIC");
        }
    }

    @Override
    public int typeService() {
        if (typeService.equals("Normal")) {
            fee = 2000;
        } else if (typeService.equals("Urgent")) {
            fee = 3200;
        } else if (typeService.equals("Executive")) {
            fee = 4350;
        }

        return fee;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Passport: " + passport);
        System.out.println("CNIC Type: " + typeService);

    }
}
