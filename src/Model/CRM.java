package Model;


public class CRM {
    
    private String companyName;
    //private ArrayList<Accounts> account;
    //private ArrayList<Accounts> opportunity;
    //private ArrayList<Leads> leads;
    
    public void CRM(String name) {
        //initialize
        this.companyName = name;
        //this.account = new 
        //this.leads = new 
    }
    
    public String getName(){
        return this.companyName;
    }
    
    public void addContact(){
        
    }
    
    public void updateContact(){
        
    }
    
    @Override
    public String toString(){
        return "CRM";
        
        //list of accounts
            //list
        //list of opp
            //opp
        //list of leads
            //leads
    }
}
