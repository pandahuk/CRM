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
    
    public ArrayList<Accounts> getAccount(){
        return account;
    }
    public ArrayList<Accounts> getOpportunity(){
        return opportunity;
    }
    public ArrayList<Lead> getLead(){
        return leads;
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
        if(accountPos < account.size())
            account.get(accountPos).addContact(contact);
        else
            System.out.println("Index out of range");
    }
    
    public void updateContactAccount(int accountPos, String cName, Contacts contact){
        if(accountPos < account.size())
            account.get(accountPos).updateContact(cName, contact);
        else
            System.out.println("Index out of range");
    }
    
    public void updateContactNameAccount(int accountPos, String oldName, String newName){ //
        if(accountPos < account.size())
            account.get(accountPos).updateConName(oldName, newName);
        else
            System.out.println("Index out of range");
    }
    
    public void updateContactNumAccount(int accountPos, String oldNum, String newNum){
        if(accountPos < account.size())
            account.get(accountPos).updateConNum(oldNum, newNum);
        else
            System.out.println("Index out of range");
    }
    
    public void updateContactEmailAccount(int accountPos, String oldEmail, String newEmail){
        if(accountPos < account.size())
            account.get(accountPos).updateConEM(oldEmail, newEmail);
        else
            System.out.println("Index out of range");
    }
    
    public void addContactOpportunity(int opportunityPos, Contacts contact){
        if(opportunityPos < opportunity.size())
            opportunity.get(opportunityPos).addContact(contact);
        else
            System.out.println("Index out of range");
    }
    
    public void updateContactOpportunity(int opportunityPos, String cName, Contacts contact){
        if(opportunityPos < opportunity.size())
            opportunity.get(opportunityPos).updateContact(cName, contact);
        else
            System.out.println("Index out of range");
    }
    
    public void updateContactNameOpportunity(int opportunityPos, String oldName, String newName){
        if(opportunityPos < opportunity.size())
            opportunity.get(opportunityPos).updateConName(oldName, newName);
        else
            System.out.println("Index out of range");
    }
    
    public void updateContactNumOpportunity(int opportunityPos, String oldNum, String newNum){
        if(opportunityPos < opportunity.size())
            opportunity.get(opportunityPos).updateConNum(oldNum, newNum);
        else
            System.out.println("Index out of range");
    }
    
    public void updateContactEmailOpportunity(int opportunityPos, String oldEmail, String newEmail){
        if(opportunityPos < opportunity.size())
            opportunity.get(opportunityPos).updateConEM(oldEmail, newEmail);
        else
            System.out.println("Index out of range");
    }
    
    // alter to accept a int for the pos of the lead. view does not have access to
    // CRM class leads. check if its in range if not print error msg and return.
    public void leadToOpportunity(int leadPos, ArrayList<Contacts> contact){
        if(leadPos < leads.size()){
            opportunity.add(new Accounts(leads.get(leadPos), contact));
            leads.remove(leadPos);
        }else
            System.out.println("Index out of range.");
    }
    
    // alter to accept a int for the pos of the opp. view does not have access to
    // CRM class opps. check if its in range if not print error msg and return.
    public void opportunityToAccount(int opportunityPos){
        if(opportunityPos < opportunity.size()){
            opportunity.get(opportunityPos).toAccount();
            account.add( opportunity.get(opportunityPos));
            opportunity.remove(opportunityPos);
        }else
            System.out.println("Index out of range.");
    }
    
    
    //print for each of the 3 lists
        //print out index too
    
    public String printAccount(){
        String accountStr = "Accounts:\n";
        for(int i = 0; i < account.size(); i++){
            
            accountStr += (i + ". " + account.get(i));
            
            //account.get(i).toString(); no need to call too string.
            //just out put the object itself
        }
        return accountStr;
    }
    
    public String printOpportunity(){
        String opportunityStr = "Opportunities: \n";
        for(int i = 0; i < opportunity.size(); i++){
            opportunityStr += (i + ". " + opportunity.get(i));
            //opportunity.get(i).toString(); no need to call too string.
            //just out put the object itself
        }
        return opportunityStr;
    }
    
    public String printLeads(){
        String leadStr = "Leads: \n";
        for(int i = 0; i < leads.size(); i++){
            leadStr += (i + ". " + leads.get(i).getCompanyName() + "\n");
            //System.out.print(i + ". "+ leads.get(i));
            //maybe Lead class needs a toString() function "yes it should"
        }
        return leadStr;
    }
    
    //if you alter the 3 prints to return strings instead of printing then you
    //can just call them in allInfo and return the string that each of them 
    //create together.
    
    //i might also need you to add 2 more methods.... simillar to the 2 above
    //just instead of using tostring call the all info so i can view the 
    //contact info in view.
    
    //I believe these are the two methods needed, let me know if it isn't.
    public String printAccountContacts(){
        String contactStr = "Accounts: \n";
        for(int i = 0; i < account.size(); i++){
            contactStr += (i + ". " + account.get(i).allinfo() + "\n");
            //System.out.print(i + ". "+ leads.get(i));
            //maybe Lead class needs a toString() function "yes it should"
        }
        return contactStr;
    }
    public String printOpportunityContacts(){
        String opportunityStr = "Opportunities: \n";
        for(int i = 0; i < opportunity.size(); i++){
            opportunityStr += (i + ". " + opportunity.get(i).allinfo() + "\n");
            //System.out.print(i + ". "+ leads.get(i));
            //maybe Lead class needs a toString() function "yes it should"
        }
        return opportunityStr;
    }

    public String allInfo(){
        return (printAccountContacts() + printOpportunityContacts() + printLeads());
    }
    
    //loop though the 3 list and create a string that you can return. 
    //str += i + ". " + account.get(i); example.
    // this toString will print out the basic info
    // for all the acocunts/opps/tostrings
    @Override
    public String toString(){        
        return (printAccount() + printOpportunity() + printLeads());
        //should this be the Account object toString() or the CRM toString() for CRM company name? (current class)
             //This should be the CRM company name ( current class) since accounts should have their own company name for each individual objects in their List.
        
    }
}