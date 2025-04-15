package csie.ase.ro.classes;

import csie.ase.ro.interfaces.TemperatureCalc;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class Lander extends Spacecraft implements TemperatureCalc {

    private String landingSite;
    private String celestialBody;
    private boolean hasLanded; // shows if the lander has landed; by default, this should be FALSE
    int[] temperatureReadings; // stores the temperatures registered until now

    public Lander() {
        super();
        this.landingSite = "";
        this.celestialBody = "";
        this.hasLanded = false;
        this.temperatureReadings = null;
    }

    @Override
    public void land() {
        this.hasLanded = true;
        System.out.println(getName() + " has landed at " + getLandingSite() + "on the planet " + getCelestialBody());
    }

    public Lander(String landingSite, String celestialBody, boolean hasLanded, int[] temperatureReadings) {
        this.landingSite = landingSite;
        this.celestialBody = celestialBody;
        this.hasLanded = hasLanded;
        this.temperatureReadings = new int[temperatureReadings.length];
        System.arraycopy(temperatureReadings, 0, this.temperatureReadings, 0, temperatureReadings.length);
    }

    public Lander(String name, float weight, String landingSite, String celestialBody, boolean hasLanded, int[] temperatureReadings) {
        super(name, weight);
        this.landingSite = landingSite;
        this.celestialBody = celestialBody;
        this.hasLanded = hasLanded;
        this.temperatureReadings = new int[temperatureReadings.length];
        System.arraycopy(temperatureReadings, 0, this.temperatureReadings, 0, temperatureReadings.length);
    }

    public String getCelestialBody() {
        return celestialBody;
    }

    public void setCelestialBody(String celestialBody) {
        this.celestialBody = celestialBody;
    }

    public String getLandingSite() {
        return landingSite;
    }

    public void setLandingSite(String landingSite) {
        this.landingSite = landingSite;
    }

    public boolean isHasLanded() {
        return hasLanded;
    }

    public void setHasLanded(boolean hasLanded) {
        this.hasLanded = hasLanded;
    }

    public int[] getTemperatureReadings() {
        int[] copy = new int[temperatureReadings.length];
        System.arraycopy(temperatureReadings, 0, copy, 0, temperatureReadings.length);
        return copy;
    }

    public void setTemperatureReadings(int[] temperatureReadings) {
        this.temperatureReadings = new int[temperatureReadings.length];
        System.arraycopy(temperatureReadings, 0, this.temperatureReadings, 0, temperatureReadings.length);
    }

    public void serialize(String fileName) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.close(); // or try with resources
        System.out.println("Serialize complete!");
    }

    public void deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Lander l = (Lander)objectInputStream.readObject();
        this.landingSite = l.landingSite;
        this.celestialBody = l.celestialBody;
        this.hasLanded = l.hasLanded;
        this.setTemperatureReadings(l.getTemperatureReadings());
        this.setName(l.getName());
        this.setWeight(l.getWeight()); // spacecraft class has to be serializable for this to work (to get super attr)
        objectInputStream.close(); // or try with resources
        System.out.println("Deserialize complete!");
    }

    @Override
    public String toString() {
        return "Lander{" +
                "landingSite='" + landingSite + '\'' +
                ", celestialBody='" + celestialBody + '\'' +
                ", hasLanded=" + hasLanded +
                ", temperatureReadings=" + Arrays.toString(temperatureReadings) +
                "} " + super.toString();
    }

    @Override
    public float calculateAvgTemp() {
        if (temperatureReadings.length == 0) return 0.0f;
        float sum = 0.0f;
        for (int temp : temperatureReadings) {
            sum += temp;
        }
        return sum / temperatureReadings.length;
    }

    @Override
    public int compareTo(@NotNull Spacecraft o) {
        return Float.compare(getWeight(), o.getWeight());
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        float avgTemp = calculateAvgTemp();
//        if (celestialBody != null) {
//            for (char letter : celestialBody.toCharArray()) {
//                hash = hash + 31 * letter + (int)avgTemp; // don't know how to make this hash code implementation work without making major changes to mission manager class
//            }                                             // the problem is with avgTemp for different landers with the same celestial body
//        }
//        return hash;
//    }

    @Override
    public int hashCode() {
        return celestialBody != null ? celestialBody.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Lander lander = (Lander) obj;
        return Objects.equals(celestialBody, lander.celestialBody);
    }
}