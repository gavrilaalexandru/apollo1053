package csie.ase.ro.util;

import csie.ase.ro.classes.Lander;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissionManager {
    public static Map<Lander, Integer> missionManager(String fileName, List<Lander> landerList) {
        Map<Lander, Integer> landerIntegerMap = new HashMap<Lander, Integer>();

        for (Lander lander : landerList) {
            if (!landerIntegerMap.containsKey(lander)) {
                landerIntegerMap.put(lander, 1);
            }
            else {
                landerIntegerMap.put(lander, landerIntegerMap.get(lander) + 1);
            }
        }

        try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {
            StringBuilder header = new StringBuilder();
            int count = 0;
            header.append("CelestialBody").append(",").append("LandingSite").append(",").append("MissionCount").append(",").append("MissionCode");
            bufferedWriter.write(header.toString());
            bufferedWriter.newLine();

            for (Map.Entry<Lander, Integer> entry : landerIntegerMap.entrySet()) {
                StringBuilder line = new StringBuilder();
                Lander lander = entry.getKey();
                int missionCount = entry.getValue();

                line.append(lander.getCelestialBody()).append(",");
                line.append(lander.getLandingSite()).append(",");
                line.append(missionCount).append(",");
                line.append(lander.hashCode());

                bufferedWriter.write(line.toString());
                bufferedWriter.newLine();
                count++;
            }
            System.out.println("Report complete!");
        } catch (IOException e) {
            throw new RuntimeException("Error writing the report " + e.getMessage());
        } ;
        return landerIntegerMap;
    }
}
