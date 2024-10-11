/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;
import model.Category;
public class UserDao
{
    
    public static void save(User user)
    {
        String query="insert into user (name,email,mobile_no,address,password,status)values('"+user.getName()+"','"+user.getEmail()+"','"+user.getMob_no()+"','"+user.getAddress()+"','"+user.getPassword()+"','false')";
        DbOperations.setDataOrDelete(query, "Registered sucessfully.Wait for admin approval.");
    }
    public static User login(String email,String password)
    {
        User user=null;
        try
        {
            ResultSet rs=DbOperations.getData("SELECT * FROM user WHERE email='" + email + "' AND password='" + password + "'");
            while(rs.next())
            {
                user=new User();
                user.setStatus(rs.getString("status"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        return user;
    
    }
    public static void changeStatus(String email,String status)
    {
        String query="update user set status='"+status+"'where email='"+email+"'";
        DbOperations.setDataOrDelete(query,"status changed successfully");
    }
    
    public static ArrayList<User>getAllRecords(String email){
         ArrayList<User>arrayList=new ArrayList<>();
         try{
             ResultSet rs =DbOperations.getData("select *from user where email like '%"+email+"%'");
             while(rs.next()){
                 User user = new User();
                 user.setId(rs.getInt("id"));
                 user.setName(rs.getString("name"));
                 user.setEmail(rs.getString("email"));
                 user.setMob_no(rs.getString("mobile_no"));
                 user.setAddress(rs.getString("address"));
                 user.setStatus(rs.getString("status"));
                 arrayList.add(user);
             }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return arrayList;
    }
}
