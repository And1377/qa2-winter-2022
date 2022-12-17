package pageobject.model;

public class Passenger {
    private String firstName;
    private String lastName;
    private String discount;
    private int peopleCount;
    private int childCount;
    private int bagCount;
    private String date;

    public Passenger(String firstName, String lastName, String discount, int peopleCount, int childCount, int bagCount, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.discount = discount;
        this.peopleCount = peopleCount;
        this.childCount = childCount;
        this.bagCount = bagCount;
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDiscount() {
        return discount;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public int getChildCount() {
        return childCount;
    }

    public int getBagCount() {
        return bagCount;
    }

    public String getDate() {
        return date;
    }
}
