import java.math.BigDecimal;

public class Order {
    //one line comment

//    Integer a = -2147483648;
//    int aa;
//    Long b = 923372036854775807L;
//    long bb = 34324;
//    Float c = 15.67f;
//    float cc = 16.67f;
//
//    Double d = 15.67;
//    String text = "some text here";
//    Character e = 'h';
//    char ee = ' ';
//    Boolean f = true;
//    Boolian g = false;
//
//    BigDecimal  bigDecimal = new BigDecimal("13.46");


    //----------------ATRIBUTES--------------------

   private double totalPrice;
   private double weight;
   private double volume;
   private int itemCount;
   private double width;
   private double height;
   private String address;

    //-----------------------------GETTERS/SETTERS--------------------------------


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
