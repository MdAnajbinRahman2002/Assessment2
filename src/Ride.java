import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Iterator;
import java.util.Comparator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ride implements RideInterface {
    private String name;
    private Employee operator;
    private int maxRiders;
    private int numOfCycles;
    private Queue<Visitor> visitorQueue;
    private List<Visitor> rideHistory;
    private final Lock lock = new ReentrantLock();

    // Default constructor
    public Ride() {
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.numOfCycles = 0;
    }

    // Parameterized constructor
    public Ride(String name, Employee operator, int maxRiders) {
        this();
        this.name = name;
        this.operator = operator;
        this.maxRiders = maxRiders;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public int getMaxRiders() {
        return maxRiders;
    }

    public void setMaxRiders(int maxRiders) {
        this.maxRiders = maxRiders;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }

    public List<Visitor> getRideHistory() {
        return rideHistory;
    }

    // Implementing interface methods
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        lock.lock();
        try {
            visitorQueue.add(visitor);
            System.out.println(visitor.getName() + " added to the queue.");
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        lock.lock();
        try {
            if (visitorQueue.remove(visitor)) {
                System.out.println(visitor.getName() + " removed from the queue.");
            } else {
                System.out.println(visitor.getName() + " not found in the queue.");
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void printQueue() {
        lock.lock();
        try {
            System.out.println("Current Queue:");
            for (Visitor visitor : visitorQueue) {
                System.out.println(visitor.getName() + " (Age: " + visitor.getAge() + ", Gender: " + visitor.getGender() + ", Ticket Number: " + visitor.getTicketNumber() + ", Season Pass: " + (visitor.hasSeasonPass() ? "Yes" : "No") + ")");
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void runOneCycle() {
        lock.lock();
        try {
            if (operator == null) {
                System.out.println("No operator assigned. Ride cannot be run.");
                return;
            }
            if (visitorQueue.isEmpty()) {
                System.out.println("No visitors in the queue. Ride cannot be run.");
                return;
            }

            int riders = 0;
            while (!visitorQueue.isEmpty() && riders < maxRiders) {
                Visitor visitor = visitorQueue.poll();
                rideHistory.add(visitor);
                System.out.println(visitor.getName() + " is taking the ride.");
                riders++;
            }
            numOfCycles++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void printRideHistory() {
        lock.lock();
        try {
            System.out.println("Ride History:");
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                System.out.println(visitor.getName() + " (Age: " + visitor.getAge() + ", Gender: " + visitor.getGender() + ", Ticket Number: " + visitor.getTicketNumber() + ", Season Pass: " + (visitor.hasSeasonPass() ? "Yes" : "No") + ")");
            }
        } finally {
            lock.unlock();
        }
    }


    public void writeRideHistoryToFile(String filename) {
        lock.lock();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + "," + visitor.getTicketNumber() + "," + visitor.getAge() + "," + visitor.getGender());
                writer.newLine();
            }
            System.out.println("Ride history saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            lock.unlock();
        }
    }
// readRideHistoryFromFile: This method reads a file and restores the ride history.
// It splits each line of the file into visitor details and creates a new Visitor
// object for each entry, adding them to the ride history. It also handles errors
// and ensures safe operation with lock
    public void readRideHistoryFromFile(String filename) {
        lock.lock();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for (String line : lines) {
                String[] data = line.split(",");
                Visitor visitor = new Visitor(data[0], Integer.parseInt(data[2]), data[3], data[1], false); // Assuming hasSeasonPass is false by default
                rideHistory.add(visitor);
            }
            System.out.println("Ride history loaded from file.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public void sortRideHistory(Comparator<Visitor> comparator) {
        lock.lock();
        try {
            Collections.sort(rideHistory, comparator);
        } finally {
            lock.unlock();
        }
    }
}
