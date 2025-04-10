public class StudentManagementSystem {
    private static int itCount = 1;
    private static int cseCount = 1;
    private static int entcCount = 1;
    private static int itDsyCount = 501;
    private static int cseDsyCount = 501;
    private static int entcDsyCount = 501;

    private String name;
    private String dob;
    private String branch;
    private int admissionYear;
    private boolean isDsyStudent;
    private String registrationNumber;
    private String bloodGroup;

    public StudentManagementSystem(String name, String dob, String branch, int admissionYear, boolean isDsyStudent, String bloodGroup) {
        this.name = name;
        this.dob = dob;
        this.branch = branch;
        this.admissionYear = admissionYear;
        this.isDsyStudent = isDsyStudent;
        this.bloodGroup = bloodGroup;
        this.registrationNumber = generateRegistrationNumber();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
        this.registrationNumber = generateRegistrationNumber();
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
        this.registrationNumber = generateRegistrationNumber();
    }

    public boolean getIsDsyStudent() {
        return isDsyStudent;
    }

    public void setIsDsyStudent(boolean isDsyStudent) {
        this.isDsyStudent = isDsyStudent;
        this.registrationNumber = generateRegistrationNumber();
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String generateRegistrationNumber() {
        String branchCode = "";

        switch (this.getBranch().toUpperCase()) {
            case "IT":
                branchCode = "BIT";
                break;
            case "CSE":
                branchCode = "BCS";
                break;
            case "ENTC":
                branchCode = "BEC";
                break;
            default:
                branchCode = "UNKNOWN";
                break;
        }

        String sequentialNumber = "";

        if (this.getIsDsyStudent()) {
            if (branchCode.equals("BIT")) {
                sequentialNumber = String.format("%03d", itDsyCount++);
            } else if (branchCode.equals("BCS")) {
                sequentialNumber = String.format("%03d", cseDsyCount++);
            } else if (branchCode.equals("BEC")) {
                sequentialNumber = String.format("%03d", entcDsyCount++);
            }
        } else {
            if (branchCode.equals("BIT")) {
                sequentialNumber = String.format("%03d", itCount++);
            } else if (branchCode.equals("BCS")) {
                sequentialNumber = String.format("%03d", cseCount++);
            } else if (branchCode.equals("BEC")) {
                sequentialNumber = String.format("%03d", entcCount++);
            }
        }

        return admissionYear + branchCode + sequentialNumber;
    }

    public static void main(String[] args) {
        StudentManagementSystem student1 = new StudentManagementSystem("Rohit", "1998-01-15", "IT", 2023, false, "A+");
        StudentManagementSystem student2 = new StudentManagementSystem("Govind", "2000-05-10", "CSE", 2023, true, "B+");
        StudentManagementSystem student3 = new StudentManagementSystem("Bhavesh", "1999-11-20", "ENTC", 2023, false, "O+");
        StudentManagementSystem student4 = new StudentManagementSystem("Aizen", "2001-03-25", "IT", 2023, true, "AB+");

        System.out.println(" Student 1\n Name: " + student1.getName() + "\n Blood Group: " + student1.getBloodGroup() + "\n Registration Number: " + student1.getRegistrationNumber());
        System.out.println(" Student 2\n Name: " + student2.getName() + "\n Blood Group: " + student2.getBloodGroup() + "\n Registration Number: " + student2.getRegistrationNumber());
        System.out.println(" Student 3\n Name: " + student3.getName() + "\n Blood Group: " + student3.getBloodGroup() + "\n Registration Number: " + student3.getRegistrationNumber());
        System.out.println(" Student 4\n Name: " + student4.getName() + "\n Blood Group: " + student4.getBloodGroup() + "\n Registration Number: " + student4.getRegistrationNumber());

        student1.setBranch("CSE");
        student2.setBranch("ENTC");

        System.out.println("\nUpdated Student 1 - Name: " + student1.getName() + ", Blood Group: " + student1.getBloodGroup() + ", Registration Number: " + student1.getRegistrationNumber());
        System.out.println("Updated Student 2 - Name: " + student2.getName() + ", Blood Group: " + student2.getBloodGroup() + ", Registration Number: " + student2.getRegistrationNumber());
    }
}