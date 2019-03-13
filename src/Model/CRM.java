package Model;

import java.util.ArrayList;

/**
 * 
 * @author Desmond
*/

public class CRM {//throws
    
    private String crmCompany;
    private ArrayList<Accounts> account;
    private ArrayList<Accounts> opportunity;
    private ArrayList<Lead> leads;
    
    public CRM(String name) {
        //initialize
        this.crmCompany = name;
        this.account = new ArrayList<>();
        this.opportunity = new ArrayList<>();
        this.leads = new ArrayList<>();
    }
    
    //Setters and getters
    public String getName(){
        return crmCompany;
    }
    
    public void setName(String name){
        crmCompany = name;
    }
 
    public void addAccount(Accounts account){
        this.account.add(account);
    }
    public void addOpporunity(Accounts opportunity){
        this.opportunity.add(opportunity);
    }
    
    public void addLead(Lead lead){
        this.leads.add(lead);
    }
    
    //account index ( assume it's the corrrect index passed in) and account name
    // you will need to test to see if the account pos is in range before using it!!!
    // sorry about this 
    public void addContactAccount(int accountPos, Contacts contact){
        account.get(accountPos).addContact(contact);
    }
    
    public void updateContactAccount(int accountPos, String cName, Contacts contact){
        account.get(accountPos).updateContact(cName, contact);
    }
    
    public void updateContactNameAccount(int accountPos, String oldName, String newName){ //
        account.get(accountPos).updateConName(oldName, newName);
    }
    
    public void updateContactNumAccount(int accountPos, String oldNum, String newNum){
        account.get(accountPos).updateConNum(oldNum, newNum);
    }
    
    public void updateContactEmailAccount(int accountPos, String oldEmail, String newEmail){
        account.get(accountPos).updateConEM(oldEmail, newEmail);
    }
    
    public void updateContactOpportunity(int opportunityPos, String cName, Contacts contact){
        opportunity.get(opportunityPos).updateContact(cName, contact);
    }
    
    public void updateContactNameOpportunity(int opportunityPos, String oldName, String newName){
        opportunity.get(opportunityPos).updateConName(oldName, newName);
    }
    
    public void updateContactNumOpportunity(int opportunityPos, String oldNum, String newNum){
        opportunity.get(opportunityPos).updateConNum(oldNum, newNum);
    }
    
    public void updateContactEmailOpportunity(int opportunityPos, String oldEmail, String newEmail){
        opportunity.get(opportunityPos).updateConEM(oldEmail, newEmail);
    }
    
    // alter to accept a int for the pos of the lead. view does not have access to
    // CRM class leads. check if its in range if not print error msg and return.
    public void leadToOpportunity(Lead lead, ArrayList<Contacts> contact){
        opportunity.add(new Accounts(lead, contact));
    }
    
    // alter to accept a int for the pos of the opp. view does not have access to
    // CRM class opps. check if its in range if not print error msg and return.
    public void opportunityToAccount(Accounts opp){
        opp.toAccount();
    }
    
    
    //print for each of the 3 lists
        //print out index too
    
    public void printAccount(){
        for(int i = 0; i < account.size(); i++){
            System.out.print(i + ". " + account.get(i));
            
            //account.get(i).toString(); no need to call too string.
            //just out put the object itself
        }
    }
    
    public void printOpportunity(){
        for(int i = 0; i < opportunity.size(); i++){
            System.out.print(i + ". " + opportunity.get(i));
            //opportunity.get(i).toString(); no need to call too string.
            //just out put the object itself
        }
    }
    
    public void printLeads(){
        for(int i = 0; i < leads.size(); i++){
            System.out.print(i + ". " + leads.get(i).getCompanyName() + "\n");
            //System.out.print(i + ". "+ leads.get(i));
            //maybe Lead class needs a toString() function "yes it should"
        }
    }
    
    //if you alter the 3 prints to return strings instead of printing then you
    //can just call them in allInfo and return the string that each of them 
    //create together.
    //i might also need you to add 2 more methods.... simillar to the 2 above
    //just instead of using tostring call the all info so i can view the 
    //contact info in view.
    
    public String allInfo(){
        String all = "";
        for (int i = 1; i <= account.size(); i++){
            all += i + ". " + account.get(i).allinfo() + "\n";
        }
        
        return all;
    }
    
    //loop though the 3 list and create a string that you can return. 
    //str += i + ". " + account.get(i); example.
    // this toString will print out the basic info
    // for all the acocunts/opps/tostrings
    @Override
    public String toString(){        
        return account.toString();
        //should this be the Account object toString() or the CRM toString() for CRM company name? (current class)
        //return getName();
    }
}