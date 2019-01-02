import java.io.*;
import java.util.Date;

public class OilChange {
    private Date dateCreated = new Date();
    private String vehicleNumber;
    private String kmValue;

    public OilChange(String vehicleNumber, String kmValue) {
        this.vehicleNumber = vehicleNumber;
        this.kmValue = kmValue;
    }

    public void textFileWriter() {
        try(FileWriter fw = new FileWriter("KMFile.MHamza2557", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)){
            out.println(kmValue + " KM of " + vehicleNumber);
            out.println("Date Created: " + dateCreated);
            out.println();
        } catch (IOException e) { e.getMessage(); }
    }

    public static void textFileOpener(){
        try {
            ProcessBuilder pb = new ProcessBuilder("notepad.exe", "KMFile.MHamza2557");
            pb.start();
        } catch (Exception e) { e.getMessage(); }
    }
}
