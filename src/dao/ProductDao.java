/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;
import java.sql.*;
public class ProductDao
{
    public static void save(Product product)
    {
        String query="insert into product (name,category,price) values('"+product.getName()+"','"+product.getCategory()+"','"+product.getPrice()+"')";
        DbOperations.setDataOrDelete(query,"Product Added Succeessfully");
    }
    public static ArrayList <Product> getAllRecords()
    {
       ArrayList<Product>list=new ArrayList();
       try
       {
           String query="select * from product";
           ResultSet rs=DbOperations.getData(query);
           while(rs.next())
           {
               Product product=new Product();
               product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
               product.setCategory(rs.getString("category"));
               product.setPrice(rs.getString("price"));
              list.add(product); 
           }
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e);
       }
       return list;
    }
    public static void update(Product product)
    {
 String query = "UPDATE product SET name='" + product.getName() + "', category='" + product.getCategory() + "', price='" + product.getPrice() + "' WHERE id='" + product.getId() + "'";
 DbOperations.setDataOrDelete(query,"Product updated Successfully");
    }
     public static void delete(String id)
        {
            String query="delete from product where id='"+id+"'";
            DbOperations.setDataOrDelete(query,"Product deleted successfully!");
        }
     public static ArrayList<Product>getAllRecordsByCategory(String category)
    {
        ArrayList<Product>list=new ArrayList();
        try
        {
            ResultSet rs=DbOperations.getData("select * from product where category='"+category+"'");
            while(rs.next())
            {
                 Product product=new Product();
                 product.setName(rs.getString("name"));
                 list.add(product);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
       public static ArrayList<Product>FilterProductName(String category,String name)
    {
        ArrayList<Product>list=new ArrayList();
        try
        {
            ResultSet rs=DbOperations.getData("select * from product where name like '%"+name+"%' and category='"+category+"'");
            while(rs.next())
            {
                 Product product=new Product();
                 product.setName(rs.getString("name"));
                 list.add(product);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
       public static Product getProductByName(String name)
       {
            Product product=new Product();
            try
            {
                ResultSet rs=DbOperations.getData("select * from product where name='"+name+"'");
                while(rs.next())
                {
                    product.setName(rs.getString(2));
                    product.setCategory(rs.getString(3));
                    product.setPrice(rs.getString(4));
                   
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
            return product;
       }
}
