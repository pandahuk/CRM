/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
/**
 *
 * @author Hung
 */
public class Accounts {
    
    private String accountName;
    private ArrayList<Contacts> contractList; // list of contracts
    private boolean Account; // true == account; false == oppotunity
    
    
    public Accounts(String n){
        this.accountName = n;
        this.contractList = null;
        this.Account = false;
    }
    
    public Accounts(Lead l, ArrayList<Contacts> al){
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
    
    public void addContact(Contacts c){
        this.contractList.add(c);
    }
    
    public String allinfo(){
        String all = "Company Name: " + this.accountName + "\n Contacts: \n";
        for (int i = 0; i < this.contractList.size(); i++){
            all += this.contractList.get(i).getName() + "\n "
                    + "Phone number: \n" + this.contractList.get(i).getPhoneNumber() 
                    + "\n E-mail: \n" + this.contractList.get(i).getEmail() + "\n";
        }
        return all;
    }
    
    @Override
    public String toString(){
        return this.accountName;
    }
}
