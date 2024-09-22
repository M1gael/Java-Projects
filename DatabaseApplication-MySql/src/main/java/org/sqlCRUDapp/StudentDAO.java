package org.sqlCRUDapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentDAO {

    public void addStudent(String name , int age , String email){

        String sql = "INSERT INTO students (name , age , email) VALUES (? , ? , ?)";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

                pstmt.setString(1 , name);
                pstmt.setInt(2 , age);
                pstmt.setString(3 , email);

                pstmt.executeUpdate();
            }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getStudent(String name , int age , String email) throws SQLException{

        String sql  = "SELECT * FROM students";

        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery())
        {
            while (rs.next())
            {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("-----");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudentName(int id , String name ,int age ,  String email){

        String sql = "UPDATE students SET name = ? , age = ? , email = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1 , name);
            pstmt.setInt(2 , age);
            pstmt.setString(3  , email);
            pstmt.setInt(4 , id);

            pstmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String name) throws SQLException{

        String sql = "DELETE FROM students WHERE name = ?";

        try{
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            //pstmt.setInt(1 , name);

            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }




}
