/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author devonnair
 */
public class Lead {
    private String Company_Name;
    
    //create constructor for lead
    public Lead(String name)
    {
        Company_Name = name;
    }
    
    //setters
    public void setCompanyName(String CN)
    {
        Company_Name = CN;
    }
  
    //getters
    public String getCompanyName()
    {
        return Company_Name;
    }
    // add a tostring method 
    @Override
    public String toString()
    {
        return "Lead Name: " + Company_Name + "\n";
    }
}
