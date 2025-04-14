package csie.ase.ro.main;

import csie.ase.ro.classes.CSVReader;
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

        String csvPathFile = "src/landers.csv";
        List<Lander> landerList = CSVReader.readFromCSV(csvPathFile);

    }
}
