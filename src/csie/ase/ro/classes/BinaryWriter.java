package csie.ase.ro.classes;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class BinaryWriter {
    public static void writeBinary(String fileName, Set<Lander> landersTreeSet) {
        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            dataOutputStream.writeInt(landersTreeSet.size()); // how many landers are we writing
            for (Lander l : landersTreeSet) {
                dataOutputStream.writeUTF(l.getName());
                dataOutputStream.writeFloat(l.getWeight());
                dataOutputStream.writeUTF(l.getLandingSite());
                dataOutputStream.writeUTF(l.getCelestialBody());
                dataOutputStream.writeBoolean(l.isHasLanded());

                int[] temperatures = l.getTemperatureReadings();
                dataOutputStream.writeInt(temperatures.length);
                for (int temp : temperatures) {
                    dataOutputStream.writeInt(temp);
                }
            }
            System.out.println("Binary write complete! Saved " + landersTreeSet.size() + " landers in binary!");
        } catch (IOException e) {
            throw new RuntimeException("Error writing to binary file: " + e.getMessage());
        }
    }
}