package Model;


public class CRM {//throws
    
    private String crmCompany;
    //private ArrayList<Accounts> account;
    //private ArrayList<Accounts> opportunity;
    //private ArrayList<Leads> leads;
    
    public void CRM(String name) {
        //initialize
        this.crmCompany = name;
        //this.account = new ArrayList<>();
        //this.leads = new ArrayList<>();
    }
    
    public String getName(){
        return this.crmCompany;
    }
    
    public void setName(String name){
        this.crmCompany = name;
    }
    
    //add account
    public void addAccount(){
        
    }
    //add opportunity
    
    public void addOpportunity(){
        
    }
    //add lead
    public void addLead(){
        
    }
    
    
    //account index ( assume it's the corrrect index passed in) and account name
    public void addContact(int accountPos, Contact contact){
        
    }
    
    public void updateContact(int accountPos, String cName, Contact contact){
        
    }
    
    public void updateContactName(int accountPos, String oldName, String newName){ //
        
    }
    
    public void updateContactNum(int accountPos, String oldNum, String newNum){
        
    }
    
    public void updateContactEmail(int accountPos, String oldEmail, String newEmail){
        
    }
    
    public void leadToOpportunity(){
        //passing in lead
           //create new account object and call constructor to create the lead
           //pass in contact list or empty list blahbalhl
               //delete lead from the list
        //add account into the list
        
        //OR~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            //pass through lead object and arraylist of contact list
    }
    
    
    //print for each of the 3 lists
        //print out index too
    public void printAccounts(){
        
    }
    
    public void printOpportunities(){
        
    }
    
    public void printLeads(){
        
    }
             
    @Override
    public String toString(){        
        //call all 3 prints
        printAccounts();
        printOpportunities();
        printLeads();
        
        return this.crmCompany;
    }
}