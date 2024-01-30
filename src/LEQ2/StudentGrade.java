package LEQ2;

public class StudentGrade implements Comparable<StudentGrade> {
    //private variables
    private String firstName, lastName;
    private int grade;

    public StudentGrade(){}//constructor with no parameters
//constructor with parameters
    public StudentGrade(String fN, String lN, int grade){
        this.firstName = fN;
        this.lastName = lN;
        this.grade = grade;
    }
//setter methods
    public void setFirstName(String fN){
        this.firstName = fN;
    }

    public void setLastName(String lN){
        this.lastName = lN;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }
//getter methods
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getGrade(){
        return grade;
    }
//toString method
    public String toString(){
        return String.format("%s %s : %d\n",firstName, lastName, grade);
    }
//custom compare to method
    public int compareTo(StudentGrade x){
        if(this.grade > x.getGrade()){
            return 1;
        } else if (this.grade < x.getGrade()) {
            return -1;
        }
        else{
            return 0;
        }
    }

}
