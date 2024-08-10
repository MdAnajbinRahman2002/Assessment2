public class Visitor extends Person {
    private String ticketNumber;
    private boolean hasSeasonPass;

    // Default constructor
    public Visitor() {
    }

    // Parameterized constructor
    public Visitor(String name, int age, String gender, String ticketNumber, boolean hasSeasonPass) {
        super(name, age, gender);
        this.ticketNumber = ticketNumber;
        this.hasSeasonPass = hasSeasonPass;
    }

    // Getters and Setters
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public boolean isHasSeasonPass() {
        return hasSeasonPass;
    }

    public void setHasSeasonPass(boolean hasSeasonPass) {
        this.hasSeasonPass = hasSeasonPass;
    }
}
