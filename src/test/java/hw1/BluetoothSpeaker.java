package hw1;

public class BluetoothSpeaker {
    //-----------------------ATRIBUTES--------------------------
    private String brandName;
    private int powerOutputWats;
    private float weight;
    private String colour;
    private String shellMaterial;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getPowerOutputWats() {
        return powerOutputWats;
    }

    public void setPowerOutputWats(int powerOutputWats) {
        this.powerOutputWats = powerOutputWats;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getShellMaterial() {
        return shellMaterial;
    }

    public void setShellMaterial(String shellMaterial) {
        this.shellMaterial = shellMaterial;
    }
}
