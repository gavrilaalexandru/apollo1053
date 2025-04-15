package csie.ase.ro.util;

import csie.ase.ro.classes.Lander;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class BinaryReader {
    public static Set<Lander> readBinary(String fileName) {
        Set<Lander> landerTreeSet = new TreeSet<Lander>();
        try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fileName))) {
            int landerCount = dataInputStream.readInt();

            for (int i = 0; i < landerCount; i++) {
                String name = dataInputStream.readUTF();
                float weight = dataInputStream.readFloat();
                String landingSite = dataInputStream.readUTF();
                String celestialBody = dataInputStream.readUTF();
                boolean hasLanded = dataInputStream.readBoolean();

                int tempCount = dataInputStream.readInt();
                int[] temperatures = new int[tempCount];

                for (int j = 0; j < tempCount; j++) {
                    temperatures[j] = dataInputStream.readInt();
                }

                Lander lander = new Lander(name, weight, landingSite, celestialBody, hasLanded, temperatures);
                landerTreeSet.add(lander);
            }
            System.out.println("Reading complete! Loaded " + landerTreeSet.size() + " landers from binary!");
        } catch (IOException e) {
            throw new RuntimeException("Error reading from binary file: " + e.getMessage());
        }
        return landerTreeSet;
    }
}