package hw1;

public class Phone {
    //-----------------------ATRIBUTES--------------------------
    private float screenSizeInch;
    private int amountOfMemoryGb;
    private String brandName;
    private int cameraResolutionMegapixel;
    private String serialNumber;
    private boolean microSdSlot;

    public float getScreenSizeInch() {
        return screenSizeInch;
    }

    public void setScreenSizeInch(float screenSizeInch) {
        this.screenSizeInch = screenSizeInch;
    }

    public int getAmountOfMemoryGb() {
        return amountOfMemoryGb;
    }

    public void setAmountOfMemoryGb(int amountOfMemoryGb) {
        this.amountOfMemoryGb = amountOfMemoryGb;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getCameraResolutionMegapixel() {
        return cameraResolutionMegapixel;
    }

    public void setCameraResolutionMegapixel(int cameraResolutionMegapixel) {
        this.cameraResolutionMegapixel = cameraResolutionMegapixel;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isMicroSdSlot() {
        return microSdSlot;
    }

    public void setMicroSdSlot(boolean microSdSlot) {
        this.microSdSlot = microSdSlot;
    }
}
