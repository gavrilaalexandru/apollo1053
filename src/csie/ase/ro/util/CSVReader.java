package csie.ase.ro.util;

import csie.ase.ro.classes.Lander;

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
                if (data.length >= 5) {
                    String name = data[0].trim();
                    float weight = Float.parseFloat(data[1].trim());
                    String landingSite = data[2].trim();
                    String celestialBody = data[3].trim();
                    String tempData = data[4].trim();

                    int[] temperatureReadings = {-9999}; // garbage value so it won't crash the program when it reaches the constructor;
                                                        // in case if temperatureData is empty; better than setting it to null

                    if (!tempData.isEmpty()) {
                        String[] temp = tempData.split(";");
                        temperatureReadings = new int[temp.length];
                        for (int i = 0; i < temp.length; i++) {
                            temperatureReadings[i] = Integer.parseInt(temp[i].trim());
                        }
                    }

                    Lander lander = new Lander(name, weight, landingSite, celestialBody, false, temperatureReadings);

                    // I added some temperatures to the .csv file just to make sure the reading part works properly.
                    landers.add(lander);
                }
            }
            System.out.println("Reading complete! Loaded " + landers.size() + " landers from CSV!");
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return landers;
    }
}
