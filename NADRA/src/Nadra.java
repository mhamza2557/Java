public abstract class Nadra implements TypeService {
    protected String fatherName;
    protected String motherName;
    protected String typeService;
    protected int fee;


    public Nadra(String fatherName, String motherName,String typeService) {
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.typeService = typeService;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
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

    @Override
    public void printDetails() {
        System.out.println("Father's Name" + fatherName);
        System.out.println("Mother's Name" + motherName);
    }
}
