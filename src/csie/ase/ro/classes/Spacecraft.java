package csie.ase.ro.classes;

public abstract class Spacecraft {

    private String name;
    private float weight; // measured in kg

    public Spacecraft() {
        this.name = "";
        this.weight = -1000;
    }

    public Spacecraft(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public abstract void land();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Spacecraft{");
        sb.append("name='").append(name).append('\'');
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}