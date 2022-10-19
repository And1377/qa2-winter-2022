package hw1;

public class ElectricUnicycle {
    //-----------------------ATRIBUTES--------------------------
    private String brandName;
    private float weight;
    private int maxSpeed;
    private int batteryCapacityWh;
    private int wheelDiameter;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getBatteryCapacityWh() {
        return batteryCapacityWh;
    }

    public void setBatteryCapacityWh(int batteryCapacityWh) {
        this.batteryCapacityWh = batteryCapacityWh;
    }

    public int getWheelDiameter() {
        return wheelDiameter;
    }

    public void setWheelDiameter(int wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    }
}
