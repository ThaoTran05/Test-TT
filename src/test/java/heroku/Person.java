package heroku;

public class Person {
    private String fistName, lastName;
    private double due;

    public Person(String fistName, String lastName, double due) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.due = due;
    }

    public void info(){
        System.out.printf("First Name: %s, Last Name: %s, due: %.2f%n", fistName,lastName,due);
    }

    public double getDue() {
        return due;
    }

    public String getFullName() {
        return String.format("%s %s", fistName, lastName);
    }
}
