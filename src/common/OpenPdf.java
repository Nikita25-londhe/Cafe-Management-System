/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class OpenPdf
{
    public static void  OpenById(String id)
    {
        try
        {
            if((new File("F:\\"+id+".pdf")).exists())
            {
                Process p=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler F:\\"+id+".pdf");
                
            }
            else
            {
                 JOptionPane.showMessageDialog(null,"File not exist!");
            }
        }
        catch(Exception e )
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
}
