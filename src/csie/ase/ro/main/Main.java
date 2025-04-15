package csie.ase.ro.main;

import csie.ase.ro.classes.*;
import csie.ase.ro.util.BinaryReader;
import csie.ase.ro.util.BinaryWriter;
import csie.ase.ro.util.CSVReader;
import csie.ase.ro.util.CSVWriter;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("🛰 Mission Control – Apollo1053 has landed!");

        System.out.println("-------------------------------------------------");
        Lander l1 = new Lander("Apollo1", 100000, "Fra Mauro", "Mars", false, new int[]{10, 12, 15, 19});
        System.out.println(l1);
        l1.setName("Apollo2");
        l1.setTemperatureReadings(new int[]{12, 15, 19, 21});
        System.out.println(l1);
        float weight1 = l1.getWeight();
        System.out.println(weight1);
        System.out.println("-------------------------------------------------");

        String readFromCSV = "src/csie/ase/ro/dataFiles/landers.csv";
        List<Lander> landerList = CSVReader.readFromCSV(readFromCSV);

        System.out.println("-------------------------------------------------");
        landerList.get(2).land();
        System.out.println(landerList.get(2).isHasLanded());
        landerList.get(4).land();
        landerList.get(0).land();

        System.out.println("-------------------------------------------------");
        System.out.println("L1 has an average temp of " + l1.calculateAvgTemp() + " °C!");

        System.out.println("-------------------------------------------------");
        String writeToCSV = "src/csie/ase/ro/dataFiles/landedLanders.csv";
        CSVWriter.writeToCSV(landerList, writeToCSV);

        System.out.println("-------------------------------------------------");
        String serializeFile = "src/csie/ase/ro/dataFiles/lander.data";
        try {
            landerList.get(1).serialize(serializeFile);
            Lander l2 = new Lander();
            l2.deserialize(serializeFile);
            System.out.println(l2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------------------------------");
        Set<Lander> landerTreeSet = new TreeSet<>(landerList);
        String binaryFile = "src/csie/ase/ro/dataFiles/lander.bin";
        BinaryWriter.writeBinary(binaryFile, landerTreeSet);

        Set<Lander> moreLanders = BinaryReader.readBinary(binaryFile);
        for (Lander l : moreLanders) {
            System.out.println(l);
        }

        System.out.println("-------------------------------------------------");
        Iterator<Lander> it = moreLanders.iterator();
        it.next();
        Lander l3 = it.next();
        System.out.println("The second lightest lander is " + l3 + ".");

        System.out.println("-------------------------------------------------");

    }
}
