package StudentManagementSystem;

import java.sql.*;

public class StudentService 
{
 

    public void addStudent(Student student)
    {
      String query = "INSERT INTO Students( name, age, course, email, phone, enrollmentdate) VALUES (?, ?, ?, ?, ?, ?)";
      

      try(Connection con=DBConnection.connect();
       PreparedStatement ps=con.prepareStatement(query))
      {
        ps.setString(1, student.getName());
        ps.setInt(2, student.getAge());
        ps.setString(3, student.getCourse());
        ps.setString(4, student.getEmail());
        ps.setString(5, student.getPhone());
        ps.setString(6, student.getEnrollmentDate());
        int rows=ps.executeUpdate();
        if (rows > 0)
            System.out.println("Student added successfully!");
        else
            System.out.println("Failed to add student.");


      }
      catch(SQLException e)
      {
        e.printStackTrace();
      }
    }


    public void displayStudents()
    {
        try(Connection con=DBConnection.connect();
            Statement  s=con.createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM Students;"))
        {
          boolean found=false;
          while (rs.next()) 
          {

            Student stu=new Student(
            rs.getString("name"),
            rs.getInt("age"),
            rs.getString("course"),
            rs.getString("email"),
            rs.getString("phone"),
            rs.getString("enrollmentDate"));
            stu.display();
            found=true;
          }
         
          if (!found) {
            System.out.println("No students found.");
        }

        }

        catch(SQLException e)
        {
          e.printStackTrace();
        }

    }


    public Student searchStudent(int id)
    {
     
      String sql = "SELECT * FROM students WHERE id = ?";
      try (Connection con = DBConnection.connect();
           PreparedStatement pst = con.prepareStatement(sql)) {
  
          pst.setInt(1, id);
          ResultSet rs = pst.executeQuery();
          if (rs.next()) {
              return new Student(
                      rs.getString("name"),
                      rs.getInt("age"),
                      rs.getString("course"),
                      rs.getString("email"),
                      rs.getString("phone"),
                      rs.getString("enrollmentDate")
              );
          }
  
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return null;
    }
    public boolean updateStudent(int id, String name, int age, String course, String email, String phone, String enrollmentDate) 
      {
        String sql = "UPDATE students SET name=?, age=?, course=?, email=?, phone=?, enrollmentDate=? WHERE id=?";
        try (Connection con = DBConnection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {
    
            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, course);
            pst.setString(4, email);
            pst.setString(5, phone);
            pst.setString(6, enrollmentDate);
            pst.setInt(7, id);
    
            int rows = pst.executeUpdate();
            return rows > 0;
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteStudent(int id)
    {
      String sql = "DELETE FROM students WHERE id=?";
      try (Connection con = DBConnection.connect();
           PreparedStatement pst = con.prepareStatement(sql)) {
  
          pst.setInt(1, id);
          int rows = pst.executeUpdate();
          return rows > 0;
  
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return false;
    }
   


    
}