package hw1;

public class Headphones {
    //-----------------------ATRIBUTES--------------------------
    private int soundDriverDIametr;
    private float weight;
    private String brandName;
    private Boolean detachableCable;
    private int impedance;

    public int getSoundDriverDIametr() {
        return soundDriverDIametr;
    }

    public void setSoundDriverDIametr(int soundDriverDIametr) {
        this.soundDriverDIametr = soundDriverDIametr;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Boolean getDetachableCable() {
        return detachableCable;
    }

    public void setDetachableCable(Boolean detachableCable) {
        this.detachableCable = detachableCable;
    }

    public int getImpedance() {
        return impedance;
    }

    public void setImpedance(int impedance) {
        this.impedance = impedance;
    }
}
