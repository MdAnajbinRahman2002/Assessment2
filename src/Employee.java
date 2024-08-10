public class Employee extends Person {
    private String position;
    private int employeeId;

    // Default constructor
    public Employee() {
    }

    // Parameterized constructor
    public Employee(String name, int age, String gender, String position, int employeeId) {
        super(name, age, gender);
        this.position = position;
        this.employeeId = employeeId;
    }

    // Getters and Setters
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}

