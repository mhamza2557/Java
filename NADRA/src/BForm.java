public class BForm extends Nadra implements TypeService{
    private boolean birthCertificate;
    private int countBrothers;
    private int countSisters;

    public BForm(String fatherName, String motherName, String typeService, boolean birthCertificate, int countBrothers, int countSisters) {
        super(fatherName, motherName,typeService);
        this.birthCertificate = birthCertificate;
        this.countBrothers = countBrothers;
        this.countSisters = countSisters;

    }

    public boolean isBirthCertificate() {
        return birthCertificate;
    }

    public void setBirthCertificate(boolean birthCertificate) {
        this.birthCertificate = birthCertificate;
    }

    public int getCountBrothers() {
        return countBrothers;
    }

    public void setCountBrothers(int countBrothers) {
        this.countBrothers = countBrothers;
    }

    public int getCountSisters() {
        return countSisters;
    }

    public void setCountSisters(int countSisters) {
        this.countSisters = countSisters;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public void eligibleUser() {
         {
            System.out.println("You are eligible to B-Form");
        }
    }

    @Override
    public int typeService() {
        if (fatherName != "" && motherName != "" && birthCertificate == true) {
            if (typeService.equals("Normal")) {
                fee = 4250;
            } else if (typeService.equals("Urgent")) {
                fee = 6350;
            } else if (typeService.equals("Executive")) {
                fee = 8450;
            }
        }
        return fee;
    }


    @Override
    public void printDetails() {
        System.out.println("Father's Name" + fatherName);
        System.out.println("Mother's Name" + motherName);
        System.out.println("Birth Certificate" + birthCertificate);
        System.out.println("Total Brothers" + countBrothers);
        System.out.println("Total Sisters" + countSisters);
        System.out.println("Total Fee" + fee);
    }
}