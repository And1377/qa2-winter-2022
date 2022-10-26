package hw1;

import org.junit.jupiter.api.Test;

public class ObjectPracticeMy {
    @Test
    public void workingWithRoomStuff(){
        Backpack firstItem = new Backpack();
        firstItem.setBrand("Nike");
        firstItem.setColour("Blue");
        System.out.println("Brand is:");
        System.out.println(firstItem.getBrand());
        System.out.println("Colour is:");
        System.out.println(firstItem.getColour());

        Keyboard secondItem = new Keyboard();
        secondItem.setNumberOfKeys(100);
        secondItem.setLayout("qwerty");
        System.out.println("Number of keys is:");
        System.out.println(secondItem.getNumberOfKeys());
        System.out.println("Layout is:");
        System.out.println(secondItem.getLayout());

        BluetoothSpeaker thirdItem = new BluetoothSpeaker();
        thirdItem.setColour("Black");
        thirdItem.setBrandName("Bose");
        System.out.println("Brand is:");
        System.out.println(thirdItem.getBrandName());
        System.out.println("Colour is:");
        System.out.println(thirdItem.getColour());

        Computer forthItem = new Computer();
        forthItem.setClassOfEnergyEfficiency('A');
        forthItem.setWeight(10);
        System.out.println("Energy efficiency class is:");
        System.out.println(forthItem.getClassOfEnergyEfficiency());
        System.out.println("Weight is:");
        System.out.println(forthItem.getWeight());

        ElectricUnicycle fifthItem = new ElectricUnicycle();
        fifthItem.setBrandName("Gotway");
        fifthItem.setMaxSpeed(80);
        System.out.println("Brand name is:");
        System.out.println(fifthItem.getBrandName());
        System.out.println("Max speed is:");
        System.out.println(fifthItem.getMaxSpeed());

        Headphones sixthItem = new Headphones();
        sixthItem.setImpedance(90);
        sixthItem.setDetachableCable(true);
        System.out.println("Impedance is:");
        System.out.println(sixthItem.getImpedance());
        System.out.println("Detachable cable:");
        System.out.println(sixthItem.getDetachableCable());

        Phone seventhItem = new Phone();
        seventhItem.setCameraResolutionMegapixel(40);
        seventhItem.setSerialNumber("AB4643373CZ");
        System.out.println("Camera resolution is:");
        System.out.println(seventhItem.getCameraResolutionMegapixel());
        System.out.println("Serial number is:");
        System.out.println(seventhItem.getSerialNumber());

        Speakers eightItem = new Speakers();
        eightItem.setBluetooth(true);
        eightItem.setShellMaterial("plastic");
        System.out.println("Shell material is:");
        System.out.println(eightItem.getShellMaterial());
        System.out.println("Bluetooth module on board:");
        System.out.println(eightItem.getBluetooth());

        Teacup ninthItem = new Teacup();
        ninthItem.setColour("white");
        ninthItem.setEmpty(true);
        System.out.println("Cup colour is:");
        System.out.println(ninthItem.getColour());
        System.out.println("Cup empty:");
        System.out.println(ninthItem.isEmpty());

       WristWatch tenthItem = new WristWatch();
       tenthItem.setBrandName("Casio");
       tenthItem.setWeight(142);
        System.out.println("Brand name is:");
        System.out.println(tenthItem.getBrandName());
        System.out.println("Watch weight is:");
        System.out.println(tenthItem.getWeight());
    }


}
