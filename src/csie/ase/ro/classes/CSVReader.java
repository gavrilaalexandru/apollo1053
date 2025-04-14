package csie.ase.ro.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<Lander> readFromCSV(String fileName) {
        List<Lander> landers = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    if (line.contains("LandingSite")) {
                        continue;
                    }
                }
                String[] data = line.split(",");
                if (data.length >= 4) {
                    String name = data[0].trim();
                    float weight = Float.parseFloat(data[1].trim());
                    String landingSite = data[2].trim() + " - " + data[3].trim();

                    Lander lander = new Lander(name, weight, landingSite, false, null);

                    // temp reading

                    landers.add(lander);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        System.out.println("Reading complete! Loaded " + landers.size() + " landers from CSV!");
        return landers;
    }
}
