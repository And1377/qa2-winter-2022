package pageobject.model;

import org.apache.commons.lang3.RandomStringUtils;

public class Passenger {
    private String firstName;
    private String lastName;

    public Passenger(String firstName, String lastName) {
//        if (firstName.equals("random")) {
//            this.firstName = RandomStringUtils.randomAlphabetic(10);
//        } else {
//            this.firstName = firstName;
//        }

     this.firstName = firstName.equals("random") ?
             RandomStringUtils.randomAlphabetic(10) :
             firstName;
     //               |-------expression---------|---------------true---------------------------|--false---|

        this.lastName = lastName;
    }

    //    private String discount;
//    private int peopleCount;
//    private int childCount;
//    private int bagCount;
//    private String date;

//    public Passenger(String firstName, String lastName, String discount, int peopleCount, int childCount, int bagCount, String date) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.discount = discount;
//        this.peopleCount = peopleCount;
//        this.childCount = childCount;
//        this.bagCount = bagCount;
//        this.date = date;
//    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

//    public String getDiscount() {
//        return discount;
//    }
//
//    public int getPeopleCount() {
//        return peopleCount;
//    }
//
//    public int getChildCount() {
//        return childCount;
//    }
//
//    public int getBagCount() {
//        return bagCount;
//    }
//
//    public String getDate() {
//        return date;
//    }
}
