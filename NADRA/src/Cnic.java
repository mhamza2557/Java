public class Cnic extends Nadra implements TypeService {
    private boolean bForm;
    private int age;
    private String cnicType;

    public Cnic(String fatherName,String motherName, String typeService,boolean bForm, int age, String cnicType) {
        super(fatherName, motherName, typeService);
        this.bForm = bForm;
        this.age = age;
        this.cnicType = cnicType;
    }

    public boolean isbForm() {
        return bForm;
    }

    public void setbForm(boolean bForm) {
        this.bForm = bForm;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCnicType() {
        return cnicType;
    }

    public void setCnicType(String cnicType) {
        this.cnicType = cnicType;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public int typeService() {
        if (fatherName != "" && motherName != "" && bForm == true  && age >= 18) {
            if (cnicType.equals("CNIC")) {
                if (typeService.equals("Normal")) {
                    fee = 0;
                } else if (typeService.equals("Urgent")) {
                    fee = 1150;
                } else if (typeService.equals("Executive")) {
                    fee = 2150;
                }
            } else if (cnicType.equals("SNIC")) {
                if (typeService.equals("Normal")) {
                    fee = 750;
                } else if (typeService.equals("Urgent")) {
                    fee = 1500;
                } else if (typeService.equals("Executive")) {
                    fee = 2500;
                }
            }
        }
        return fee;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Age: " + age);
        System.out.println("CNIC Type: " + typeService);
    }
}
