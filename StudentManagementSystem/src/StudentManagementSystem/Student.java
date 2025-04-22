package StudentManagementSystem;

public class Student 
{
    private int id;
    private String name;
    private int age;
    private String course;
    private String email;
    private String phone;
    private String enrollmentDate;

    public Student(String name,int age,String course, String email, String phone, String enrollmentDate)
    {
        this.name=name;
        this.age=age;
        this.course=course;
        this.email = email;
        this.phone = phone;
        this.enrollmentDate = enrollmentDate;
    }

    
    public void setName(String name) { this.name=name; }
    public void setAge(int age) { this.age=age;  }
    public void setCourse(String course) { this.course=course; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEnrollmentDate(String enrollmentDate) { this.enrollmentDate = enrollmentDate; }


    public int getId() {  return id; }
    public String getName() { return name;}
    public int getAge() { return age;}
    public String getCourse() {return course;}
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getEnrollmentDate() { return enrollmentDate; }


    public void display() {
        System.out.println("ID : " + id +
            "\nName : " + name +
            "\nAge : " + age +
            "\nCourse : " + course +
            "\nEmail : " + email +
            "\nPhone : " + phone +
            "\nEnrollment Date : " + enrollmentDate);
    }
      
}

/*public void setId(int id){   this .id=id;   }    making immutable as it has to be unique and need not to change once it is assigned
Encapsulation and constructor*/