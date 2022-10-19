package hw1;

public class WristWatch {
    //-----------------------ATRIBUTES--------------------------
    private String brandName;
    private int wristBandSizeMm;
    private boolean analogWatchFace;
    private long serialNumber;
    private float weight;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getWristBandSizeMm() {
        return wristBandSizeMm;
    }

    public void setWristBandSizeMm(int wristBandSizeMm) {
        this.wristBandSizeMm = wristBandSizeMm;
    }

    public boolean isAnalogWatchFace() {
        return analogWatchFace;
    }

    public void setAnalogWatchFace(boolean analogWatchFace) {
        this.analogWatchFace = analogWatchFace;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
