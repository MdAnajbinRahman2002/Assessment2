public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    public void partThree() {
        // Create a new Ride object
        Employee operator = new Employee("Famin", 20, "Male", "Oparetor", 1001);
        Ride rollerCoaster = new Ride("Roller Coaster", operator, 4);

        System.out.println("Operator Details: " + operator.getName() + ", Age: " + operator.getAge() + ", Gender: " + operator.getGender() + ", Position: " + operator.getPosition() + ", Employee ID: " + operator.getEmployeeId());
        // Add 5 Visitors to the Queue
        rollerCoaster.addVisitorToQueue(new Visitor("Miccy", 25, "Female", "T1111", true));
        rollerCoaster.addVisitorToQueue(new Visitor("Bobby", 28, "Male", "T1235", false));
        rollerCoaster.addVisitorToQueue(new Visitor("Shoshim", 22, "Male", "T1236", true));
        rollerCoaster.addVisitorToQueue(new Visitor("Famy", 27, "Female", "T1237", false));
        rollerCoaster.addVisitorToQueue(new Visitor("Eva", 30, "Female", "T1238", true));

        // Remove a Visitor from the Queue
        rollerCoaster.removeVisitorFromQueue(new Visitor("Bobby", 28, "Male", "T1235", false));

        // Print all Visitors in the Queue
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        // Create a new Ride object
        Employee operator = new Employee("Rocher", 35, "Female", "Operator", 1002);
        Ride waterSlide = new Ride("water slide", operator, 4);
        System.out.println("Operator Details: " + operator.getName() + ", Age: " + operator.getAge() + ", Gender: " + operator.getGender() + ", Position: " + operator.getPosition() + ", Employee ID: " + operator.getEmployeeId());
        // Add Visitors to the Ride collection (LinkedList)
        waterSlide.addVisitorToQueue(new Visitor("Speed", 26, "Male", "T1239", true));
        waterSlide.addVisitorToQueue(new Visitor("Jerry", 29, "Male", "T1240", false));
        waterSlide.addVisitorToQueue(new Visitor("Dj", 23, "Male", "T1241", true));
        waterSlide.addVisitorToQueue(new Visitor("Shila", 28, "Female", "T1242", false));
        waterSlide.runOneCycle();

        // Check if a Visitor is in the collection
        System.out.println("Did Jerry ride before? " + (waterSlide.getRideHistory().contains(new Visitor("Jerry", 29, "Male", "T1240", false))));

        // Print the number of Visitors in the collection
        System.out.println("Total riders in ride history: " + waterSlide.getRideHistory().size());

        // Print the ride history
        waterSlide.printRideHistory();
    }

    public void partFourB() {
        // Create a new Ride object
        Employee operator = new Employee("Rose", 29, "Female", "Operator", 1003);
        Ride ferrisWheel = new Ride("Circle Wheel", operator, 5);
        System.out.println("Operator Details: " + operator.getName() + ", Age: " + operator.getAge() + ", Gender: " + operator.getGender() + ", Position: " + operator.getPosition() + ", Employee ID: " + operator.getEmployeeId());
        // Add Visitors to the collection
        ferrisWheel.addVisitorToQueue(new Visitor("Harry", 24, "Male", "T1243", true));
        ferrisWheel.addVisitorToQueue(new Visitor("Ronny", 26, "Male", "T1244", false));
        ferrisWheel.addVisitorToQueue(new Visitor("Hemony", 25, "Female", "T1245", true));
        ferrisWheel.addVisitorToQueue(new Visitor("Ginny", 23, "Female", "T1246", false));
        ferrisWheel.addVisitorToQueue(new Visitor("Lilly", 22, "Female", "T1247", true));
        ferrisWheel.runOneCycle();

        // Print all Visitors in the collection before sorting
        System.out.println("Ride History before sorting:");
        ferrisWheel.printRideHistory();

        // Sort the collection using VisitorComparator
        ferrisWheel.sortRideHistory(new VisitorComparator());

        // Print all Visitors in the collection after sorting
        System.out.println("Ride History after sorting:");
        ferrisWheel.printRideHistory();
    }

    public void partFive() {
        // Create a new Ride object
        Employee operator = new Employee("Samiul", 32, "Male", "Operator", 1004);
        Ride bumperCars = new Ride("laser Fight", operator, 2);
        System.out.println("Operator Details: " + operator.getName() + ", Age: " + operator.getAge() + ", Gender: " + operator.getGender() + ", Position: " + operator.getPosition() + ", Employee ID: " + operator.getEmployeeId());
        // Add Visitors to the Queue
        bumperCars.addVisitorToQueue(new Visitor("Ifty", 25, "Male", "T1248", true));
        bumperCars.addVisitorToQueue(new Visitor("Trump", 27, "Male", "T1249", false));
        bumperCars.addVisitorToQueue(new Visitor("Kobey", 28, "Female", "T1250", true));
        bumperCars.addVisitorToQueue(new Visitor("Bill gates", 26, "Male", "T1251", false));
        bumperCars.addVisitorToQueue(new Visitor("MD Yunus", 29, "Male", "T1252", true));

        // Print all Visitors in the queue
        System.out.println("Queue before running a cycle:");
        bumperCars.printQueue();

        // Run one cycle
        bumperCars.runOneCycle();

        // Print all Visitors in the queue after one cycle
        System.out.println("Queue after running a cycle:");
        bumperCars.printQueue();

        // Print all Visitors in the ride history
        bumperCars.printRideHistory();
    }

    public void partSix() {
        // Create a new Ride object
        Employee operator = new Employee("Peter", 21, "Male", "Operator", 1005);
        Ride spiderRide = new Ride("Jumping Ride", operator, 3);
        System.out.println("Operator Details: " + operator.getName() + ", Age: " + operator.getAge() + ", Gender: " + operator.getGender() + ", Position: " + operator.getPosition() + ", Employee ID: " + operator.getEmployeeId());
        // Add Visitors to the Ride
        spiderRide.addVisitorToQueue(new Visitor("Kader", 45, "Male", "T1253", true));
        spiderRide.addVisitorToQueue(new Visitor("Sakib", 40, "Male", "T1254", false));
        spiderRide.addVisitorToQueue(new Visitor("Hasina", 35, "Female", "T1255", true));
        spiderRide.runOneCycle();

        // Write the ride history to a file
        spiderRide.writeRideHistoryToFile("rideHistory.txt");
    }

    public void partSeven() {
        // Create a new Ride object
        Ride newRide = new Ride();

        // Read the ride history from a file
        newRide.readRideHistoryFromFile("rideHistory.txt");

        // Print the number of Visitors in the LinkedList to confirm correct import
        System.out.println("Total rider in the reloaded ride history: " + newRide.getRideHistory().size());

        // Print all Visitors in the LinkedList to confirm details
        newRide.printRideHistory();
    }
}
