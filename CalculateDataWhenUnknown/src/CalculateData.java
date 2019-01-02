public class CalculateData {
    double totalPercent = 100;
    double enterGivenPercent;
    double enterGivenData;
    double totalData;

    public  CalculateData() { /* Default */ }

    public CalculateData(double enterGivenPercent, double enterGivenData) {
        this.totalPercent = totalPercent;
        this.enterGivenPercent = enterGivenPercent;
        this.enterGivenData = enterGivenData;
        this.totalData = totalData;
    }

    public double CalculateDataWhenUnknownMB(double enterGivenPercent, double enterGivenData) {
        totalData = totalPercent / enterGivenPercent * enterGivenData;
        return  totalData;
    }

    public double CalculateDataWhenUnknownGB(double enterGivenPercent, double enterGivenData) {
        totalData = (totalPercent / enterGivenPercent * enterGivenData) / 1024;
        return  totalData;
    }

    public void displayData() {
        System.out.println("Total Data: " + Math.round(totalData) + " MB");
        System.out.println("Total Data: " + Math.round(totalData/1024) + " GB");
    }

}
