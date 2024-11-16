package Phone;

public class Phone {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String accountNumber;
    private int localCallTime;
    private int longDistanceCallTime;

    public Phone(int id, String lastName, String firstName, String middleName,
                 String accountNumber, int localCallTime, int longDistanceCallTime) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.accountNumber = accountNumber;
        this.localCallTime = localCallTime;
        this.longDistanceCallTime = longDistanceCallTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getLocalCallTime() {
        return localCallTime;
    }

    public void setLocalCallTime(int localCallTime) {
        this.localCallTime = localCallTime;
    }

    public int getLongDistanceCallTime() {
        return longDistanceCallTime;
    }

    public void setLongDistanceCallTime(int longDistanceCallTime) {
        this.longDistanceCallTime = longDistanceCallTime;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", localCallTime=" + localCallTime +
                ", longDistanceCallTime=" + longDistanceCallTime +
                '}';
    }
}
