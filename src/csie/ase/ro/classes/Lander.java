package csie.ase.ro.classes;

import csie.ase.ro.interfaces.TemperatureCalc;

import java.util.Arrays;

public class Lander extends Spacecraft implements TemperatureCalc {

    private String landingSite;
    private boolean hasLanded; // shows if the lander has landed; by default, this should be FALSE
    int[] temperatureReadings; // stores the temperatures registered until now

    public Lander() {
        super();
        this.landingSite = "";
        this.hasLanded = false;
        this.temperatureReadings = null;
    }

    @Override
    public void land() {
        this.hasLanded = true;
        System.out.println(getName() + " has landed at " + getLandingSite());
    }

    public Lander(String landingSite, boolean hasLanded, int[] temperatureReadings) {
        this.landingSite = landingSite;
        this.hasLanded = hasLanded;
        this.temperatureReadings = new int[temperatureReadings.length];
        System.arraycopy(temperatureReadings, 0, this.temperatureReadings, 0, temperatureReadings.length);
    }

    public Lander(String name, float weight, String landingSite, boolean hasLanded, int[] temperatureReadings) {
        super(name, weight);
        this.landingSite = landingSite;
        this.hasLanded = hasLanded;
        this.temperatureReadings = new int[temperatureReadings.length];
        System.arraycopy(temperatureReadings, 0, this.temperatureReadings, 0, temperatureReadings.length);
    }

    public String getLandingSite() {
        return landingSite;
    }

    public void setLandingSite(String landingSite) {
        this.landingSite = landingSite;
    }

    public boolean getHasLanded() {
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

    @Override
    public String toString() {
        return "Lander{" +
                "landingSite='" + landingSite + '\'' +
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
}