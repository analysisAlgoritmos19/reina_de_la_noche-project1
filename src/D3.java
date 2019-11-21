
import java.util.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class D3 {
    private TreeMap<String, Integer> results = new TreeMap<String, Integer>();
    private static final String CSV_FILE = "./sample.csv";

    public D3(TreeMap<String, Integer> results){
        this.results = results;
        generateCSV();
    }

    private void generateCSV(){
        try (
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILE));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("name", "radius", "distance"));
        ) {
            int counter = 1;
            for(Map.Entry<String, Integer> entry : results.entrySet()){
                csvPrinter.printRecord(entry.getKey(), entry.getValue(), counter);
            }
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TreeMap<String, Integer> test = new TreeMap<String, Integer>();
        for(int i = 0; i < 25; i++){
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();
            StringBuilder buffer = new StringBuilder(targetStringLength);
            for (int j = 0; j < targetStringLength; j++) {
                int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            String generatedString = buffer.toString();
            Random r = new Random();
            int num = r.nextInt(25);
            test.put(generatedString, num);
        }

        D3 d3 = new D3(test);
    }
}
