package csie.ase.ro.classes;

import java.io.*;
import java.util.List;

public class CSVWriter {
    public static void writeToCSV(List<Lander> landers, String fileName) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {
            StringBuilder header = new StringBuilder();
            int count = 0;
            header.append("Name").append(",").append("LandingSite").append(",").append("CelestialBody").append(",").append("AverageTemperature").append(",").append("TemperatureReadings");
            bufferedWriter.write(header.toString());
            bufferedWriter.newLine();
            for (Lander lander : landers) {
                if (lander.isHasLanded()) {
                    StringBuilder line = new StringBuilder();
                    line.append(lander.getName()).append(",");
                    line.append(lander.getLandingSite()).append(",");
                    line.append(lander.getCelestialBody()).append(",");
                    line.append(lander.calculateAvgTemp()).append(",");

                    if (lander.getTemperatureReadings().length > 0) {
                        for (int i = 0; i < lander.getTemperatureReadings().length; i++) {
                            line.append(lander.getTemperatureReadings()[i]);
                            if (i < lander.getTemperatureReadings().length - 1) {
                                line.append(";");
                            }
                        }
                    }
                    else {
                        line.append("No readings");
                    }

                    bufferedWriter.write(line.toString());
                    bufferedWriter.newLine();
                    count++;
                }
            }
            System.out.println("Writing complete! Saved " + count + " landers to CSV!");
        } catch (IOException e) {
            throw new RuntimeException("Error writing to CSV file: " + e.getMessage());
        }
    }
}
