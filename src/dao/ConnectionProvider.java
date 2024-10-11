/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author DELL
 */
import java.sql.*;
public class ConnectionProvider
{
   public static Connection getCon()
   {
       try
       {
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe","root","nikita25");
           return con;
       }
       catch(Exception e)
       {
           System.out.println(e);
           return null;
       }
   }
}
