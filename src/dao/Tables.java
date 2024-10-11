
package dao;

import javax.swing.JOptionPane;
public class Tables
{
    public static void main(String[] args) {
    try
    {

    /*String userTable = "create table user(id int AUTO_INCREMENT primary key,name varchar(200),email varchar(200),address varchar(200),password varchar(200),mobile_no varchar(15),status varchar(20),unique(email))";
    DbOperations.setDataOrDelete (userTable, "User table creted Successfully");*/
    //String adminDetails = "insert into user(name,email,address,password,mobile_no,status)values('admin','admin@gmail.com','India','admin123','1234567890','true')";
     //DbOperations.setDataOrDelete (adminDetails, "Admin Details Added Successfully");
     /*String categoryTable = "create table category(id int AUTO_INCREMENT primary key,name varchar(200))";
     DbOperations.setDataOrDelete (categoryTable , "Category table created Successfully");
     String ProductTable="create table product(id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price varchar(200))";
     DbOperations.setDataOrDelete (ProductTable , "Product table created Successfully");
     String billTable = "create table bill(id int primary key,name varchar(200),mobile_no varchar(200),email varchar(200),date varchar(50),total varchar(200),createBy varchar(200))";
     DbOperations.setDataOrDelete (billTable , "Bill Table created Successfully");*/
    }
    catch (Exception e) 
    {
        JOptionPane.showMessageDialog(null,e);
    }
    }
}
