public class Visitor extends Person {
    private String ticketNumber;
    private boolean seasonPass;  // This is the field representing whether the visitor has a season pass

    // Default constructor
    public Visitor() {
    }

    // Parameterized constructor
    public Visitor(String name, int age, String gender, String ticketNumber, boolean seasonPass) {
        super(name, age, gender);
        this.ticketNumber = ticketNumber;
        this.seasonPass = seasonPass;
    }

    // Getter for ticketNumber
    public String getTicketNumber() {
        return ticketNumber;
    }

    // Setter for ticketNumber
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    // Getter for seasonPass
    public boolean hasSeasonPass() {
        return seasonPass;
    }

    // Setter for seasonPass
    public void setSeasonPass(boolean seasonPass) {
        this.seasonPass = seasonPass;
    }
}

