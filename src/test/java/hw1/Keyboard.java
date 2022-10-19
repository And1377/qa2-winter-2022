package hw1;

public class Keyboard {
    //-----------------------ATRIBUTES--------------------------
    private String BrandName;
    private String layout;
    private int numberOfKeys;
    private Float width;
    private boolean mechanicalKeys;

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public int getNumberOfKeys() {
        return numberOfKeys;
    }

    public void setNumberOfKeys(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public boolean isMechanicalKeys() {
        return mechanicalKeys;
    }

    public void setMechanicalKeys(boolean mechanicalKeys) {
        this.mechanicalKeys = mechanicalKeys;
    }
}
