package org.example;


import org.example.model.Address;

import java.util.*;

public class AddressService {
    private Set<Address> addressSet = new HashSet();
    private Map<Address, Integer> duplicateAddress = new HashMap<>();


    public void getDuplicatesAddress(String city, String street, int home, int floor) {
        Address address = new Address(city,street,home,floor);

        if(addressSet.contains(address)){

            if(!duplicateAddress.containsKey(address)) {
                duplicateAddress.put(address, 1);
            }else {
                int countDuplicate = 0;
                Set<Map.Entry<Address, Integer>> duplicate = duplicateAddress.entrySet();
                for(Map.Entry<Address, Integer> k : duplicate){
                    countDuplicate = k.getValue();
                }
                duplicateAddress.replace(address,countDuplicate,countDuplicate+1);
            }
        }
        addressSet.add(address);

    }

    public void countDuplicate() {
        Set<Map.Entry<Address, Integer>> duplicates = duplicateAddress.entrySet();
        if(!duplicates.isEmpty()) {
            System.out.println("Duplicate addresses:");

        }
        for(Map.Entry<Address, Integer> d : duplicates) {
            System.out.println(d.getKey().getCity()
                    + ", " + d.getKey().getStreet()
                    + ", " + d.getKey().getHouse()
                    +  ". Count duplicate - " + d.getValue() );
        }
    }
    public void countFloorsInCity() {
        String city = "";
        int[]floors = new int[]{0,0,0,0,0};
        Set<Address> addressTreeSet = new TreeSet<>(addressSet);
        for(Address a : addressTreeSet) {
            if (city.equals("")) {
                city = a.getCity();
                floors[a.getFloor() - 1] +=1 ;

            } else if (!city.isEmpty() && !city.equals(a.getCity())) {
                outputInConsole(city, floors[0],floors[1],floors[2],floors[3],floors[4]);
                city = a.getCity();
                Arrays.fill(floors, 0);
                floors[a.getFloor() - 1] +=1 ;

            } else {
                floors[a.getFloor() - 1] +=1 ;
            }
        }
        Arrays.fill(floors, 0);
    }
    private void outputInConsole(String city, int one, int two, int three, int four, int five ) {
        System.out.println("In city: " + city + "\n" +
                " one-story houses: " + one + "\n" +
                " two-story houses: " + two + "\n" +
                " three-story houses: " + three + "\n" +
                " four-story houses: " + four + "\n" +
                " five-story houses: " + five + "\n");
    }
    public void clear() {
        addressSet.clear();
        duplicateAddress.clear();
    }

}
