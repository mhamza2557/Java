public class CustomerInformation {
    private String name, cnic , mobileNumber, age;
    private int credit = 5000;

    public CustomerInformation() { /* Default */ }

    public CustomerInformation(String name, String cnic, String mobileNumber, String age) {
        this.name = name;
        this.cnic = cnic;
        this.mobileNumber = mobileNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "CustomerInformation{" +
                "name='" + name + '\'' +
                ", cnic='" + cnic + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
