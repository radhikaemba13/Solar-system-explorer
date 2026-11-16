import java.util.*;

class ParkingAllocation {

    static class ParkingSlot {
        String slotId;
        String vehicleType;
        boolean available;

        ParkingSlot(String slotId, String vehicleType,
                    boolean available) {
            this.slotId = slotId;
            this.vehicleType = vehicleType;
            this.available = available;
        }

        boolean isAvailableFor(String type) {
            return vehicleType.equalsIgnoreCase(type)
                && available;
        }
    }

    public static void main(String[] args) {
        List<ParkingSlot> slots = Arrays.asList(
            new ParkingSlot("S1", "Car", true),
            new ParkingSlot("S2", "Bike", false),
            new ParkingSlot("S3", "Car", true),
            new ParkingSlot("S4", "Bike", true),
            new ParkingSlot("S5", "Car", false)
        );

        System.out.println("Available car parking slots:");

        for (ParkingSlot slot : slots) {
            if (slot.isAvailableFor("Car")) {
                System.out.println(slot.slotId);
            }
        }
    }
}