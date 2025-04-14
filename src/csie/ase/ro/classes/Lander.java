package csie.ase.ro.classes;

import java.util.Arrays;

public class Lander extends Spacecraft {

    private String landingSite;
    private boolean hasLanded; // shows if the lander has landed; by default, this should be FALSE
    int[] temperatureReadings; // stores the temperatures registered until now

    public Lander() {
        super();
        this.landingSite = "";
        this.hasLanded = false;
        this.temperatureReadings = null;
    }

    public Lander(String landingSite, boolean hasLanded, int[] temperatureReadings) {
        this.landingSite = landingSite;
        this.hasLanded = hasLanded;
        this.temperatureReadings = temperatureReadings; // change to system.arraycopy
    }

    public Lander(String name, float weight, String landingSite, boolean hasLanded, int[] temperatureReadings) {
        super(name, weight);
        this.landingSite = landingSite;
        this.hasLanded = hasLanded;
        this.temperatureReadings = temperatureReadings; // change to system.arraycopy
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
        return temperatureReadings; // change this aswell
    }

    public void setTemperatureReadings(int[] temperatureReadings) {
        this.temperatureReadings = temperatureReadings; // change this aswell
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Lander{");
        sb.append("landingSite='").append(landingSite).append('\'');
        sb.append(", hasLanded=").append(hasLanded);
        sb.append(", temperatureReadings=").append(Arrays.toString(temperatureReadings));
        sb.append('}');
        return sb.toString();
    }
}