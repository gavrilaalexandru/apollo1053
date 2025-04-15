package csie.ase.ro.main;

import csie.ase.ro.classes.CSVReader;
import csie.ase.ro.classes.CSVWriter;
import csie.ase.ro.classes.Lander;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("🛰 Mission Control – Apollo1053 has landed!");

        System.out.println("-------------------------------------------------");
        Lander l1 = new Lander("Apollo1", 100000, "Fra Mauro", false, new int[]{10, 12, 15, 19});
        System.out.println(l1);
        l1.setName("Apollo2");
        l1.setTemperatureReadings(new int[]{12, 15, 19, 21});
        System.out.println(l1);
        float weight1 = l1.getWeight();
        System.out.println(weight1);
        System.out.println("-------------------------------------------------");

        String readFromCSV = "src/landers.csv";
        List<Lander> landerList = CSVReader.readFromCSV(readFromCSV);

        System.out.println("-------------------------------------------------");
        landerList.get(2).land();
        System.out.println(landerList.get(2).getHasLanded());
        landerList.get(4).land();
        landerList.get(0).land();

        System.out.println("-------------------------------------------------");
        System.out.println("L1 has an average temp of " + l1.calculateAvgTemp() + " °C!");

        System.out.println("-------------------------------------------------");
        String writeToCSV = "src/landedLanders.csv";
        CSVWriter.writeToCSV(landerList, writeToCSV);
    }
}
