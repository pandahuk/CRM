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
public class Contacts {
    String name;
    String phonenum;
    String Email;
    public Contacts(String N, String PN, String EM)
    {
        name = N;
        phonenum = PN;
        Email = EM;
    }
    
    //setters
    public void setName(String N)
    {
        name = N;
    }
    public void setPhoneNumber(String PN)
    {
        phonenum = PN;
    }
    public void setEmail(String EM)
    {
        Email = EM;
    }
    
    //getters
    public String getName()
    {
        return name;
    }
    public String getPhoneNumber()
    {
        return phonenum;
    }
    public String getEmail()
    {
        return Email;
    }
    
    //overrides toString to return contact info
    @Override
    public String toString()
    {
        return "name: " + name + "\n" + "Phone #: " + phonenum + "\n" + "email: " + Email;
    }
}