/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author Hung
 */
public class Accounts {
    
    private String accountName;
    private ArrayList<Contacts> contractList; // list of contracts
    private boolean Account; // true == account; false == oppotunity
    private String Type;
    private ArrayList<String> Form;
    private Calendar dates = Calendar.getInstance();
    private int bought = 0;
    
    // contrutors
    public Accounts(String n){
        this.accountName = n;
        this.contractList = null;
        this.Account = false;
    }
    
    public Accounts(String n,ArrayList<Contacts> al, String type){
        this.Type = type;
        this.accountName = n;
        this.contractList = al;
        this.Account = false;
    }
    
    public Accounts(String n, ArrayList<Contacts> al,String type , boolean a){
        this.Type = type;
        this.accountName = n;
        this.contractList = al;
        this.Account = a;
    }
    
    public Accounts(String n, ArrayList<Contacts> al, ArrayList<String> form, String type){
        this.Form = form;
        this.Type = type;
        this.accountName = n;
        this.contractList = al;
        this.Account = false;
    }
    
    public Accounts(Lead l, ArrayList<Contacts> al){
        this.accountName = l.getCompanyName();
        this.contractList = al;
        this.Account = false;
    }
    
    public Accounts(Lead l, ArrayList<Contacts> al, ArrayList<String> form, String type){
        this.Form = form;
        this.Type = type;
        this.accountName = l.getCompanyName();
        this.contractList = al;
        this.Account = false;
    }
    
    public Accounts(Lead l){
        this.accountName = l.getCompanyName();
        this.contractList = null;
        this.Account = false;
    }
    
    public Accounts(Lead l, boolean a){
        this.accountName = l.getCompanyName();
        this.contractList = null;
        this.Account = a;
    }
    
    public Accounts(Lead l,ArrayList<Contacts> al, boolean a){
        this.accountName = l.getCompanyName();
        this.contractList = al;
        this.Account = a;
    }
    
    //getter
    public ArrayList<Contacts> getContacts(){
        return contractList;
    }
    
    public ArrayList<String> getForm(){
        return Form;
    }
    
    public String getType(){
        return Type;
    }
    
    public Calendar getDates() {
        return this.dates;
    }
    
    public int getBought(){
        return this.bought;
    }
    
    //setter
    public void setType(String t){
        Type =t;
    }
    public void setForm(ArrayList<String> a){
        Form = a;
    }
    
    //will return -1 if it is not found
    private int getindex(String s){
        for(int i= 0; i < contractList.size(); i++){
            if(contractList.get(i).getName().compareToIgnoreCase(s)== 0)
                return i;
        }
        return -1;
    }
    
    //wil compare object not the name, switch to compare contact by name
    public void addContact(Contacts c){
        for (int i = 0; i < contractList.size(); i++)
        {
            if (this.contractList.get(i).getName() == c.getName()){
                System.out.print("Duplicated Contact\n");
                return;
            }
        }
        this.contractList.add(c);
    }
    
    //will compare object not name, switch to compare contact by name
    public void updateContact(String name, Contacts c){
        int r = getindex(name);
        if ( r != -1){
            this.contractList.remove(r);
            this.contractList.add(c);
        }
        else
            System.out.println("name not found \n");
    }
    
    // -1 will be returned if item is not inside the list
    public void updateConName(String name, String newName){
        int r = getindex(name);
        if ( r != -1){
            this.contractList.get(r).setName(newName);
        }
        else
            System.out.println("name not found \n"); 
    }
    // -1 will be returned if item is not inside the list
    public void updateConNum(String name, String Pnum){
        int r = getindex(name);
        if ( r != -1){
            this.contractList.get(r).setPhoneNumber(Pnum);
        }
        else
            System.out.println("name not found \n"); 
    }
    
    // -1 will be returned if item is not inside the list
    public void updateConEM(String name, String Email){
        int r = getindex(name);
        if ( r != -1){
            this.contractList.get(r).setEmail(Email);
        }
        else
            System.out.println("name not found \n"); 
    }
    
    public void toAccount(){
        this.Account = true;
        this.dates = Calendar.getInstance();
    }
    
    public void increaseBought(int more){
        this.bought += more;
    }
    
    //call contacts tostring no need to get each individual element
    public String allinfo(){
        String all = "Company Name: " + this.accountName + "\n Contacts: \n";
        for (int i = 0; i < this.contractList.size(); i++){
            all += this.contractList.get(i) + "\n";
        }
        return all;
    }
    
    @Override
    public String toString(){
        return this.accountName + "\n";
    }
}