package hw1;

public class Computer {
    //-----------------------ATRIBUTES--------------------------
    private String brandName;
    private int noiseLevelDecibels;
    private int weight;
    private char classOfEnergyEfficiency;
    private float powerConsumptionWatt;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getNoiseLevelDecibels() {
        return noiseLevelDecibels;
    }

    public void setNoiseLevelDecibels(int noiseLevelDecibels) {
        this.noiseLevelDecibels = noiseLevelDecibels;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public char getClassOfEnergyEfficiency() {
        return classOfEnergyEfficiency;
    }

    public void setClassOfEnergyEfficiency(char classOfEnergyEfficiency) {
        this.classOfEnergyEfficiency = classOfEnergyEfficiency;
    }

    public float getPowerConsumptionWatt() {
        return powerConsumptionWatt;
    }

    public void setPowerConsumptionWatt(float powerConsumptionWatt) {
        this.powerConsumptionWatt = powerConsumptionWatt;
    }
}
