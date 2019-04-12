package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Desmond
*/

// might need some sort of private list to contain the diffrent category options, we
// can later add a way to add more categories, but for now just hard code the 2 
// categories  we mentioned.
//
// 
public class CRM {//throws
    
    private String crmCompany;
    private ArrayList<Accounts> account;
    private ArrayList<Accounts> opportunity;
    private ArrayList<Lead> leads;
    

    //Categories and general category lists
    private List<String> categories;
    //private ArrayList<ArrayList<Accounts>> generalCategory;
    private ArrayList<Accounts> financeList;
    private ArrayList<Accounts> medicalList;
   
    //hard coded type for medical/financial
    
    public CRM(String name) {
        //initialize
        this.crmCompany = name;
        this.account = new ArrayList<>();
        this.opportunity = new ArrayList<>();
        this.leads = new ArrayList<>();
           
        //Create categories and category lists, should be able to accept both opp and acc
        
        financeList = new ArrayList<>();
        medicalList = new ArrayList<>();
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
    
    public ArrayList<Accounts> getFinance(){
        return financeList;
    }
    
    public ArrayList<Accounts> getMedical(){
        return medicalList;
    }
    
    public List<String> getCategories(){
        return categories;
    }
 
    public void addAccount(Accounts account){
        this.account.add(account);
        if(account.getType().compareToIgnoreCase("Finance") == 0){
            addToFinance(account);
        }else
            addToMedical(account);
    }
    public void addOpporunity(Accounts opportunity){
        this.opportunity.add(opportunity);
        if(opportunity.getType().compareToIgnoreCase("Finance") == 0){
            addToFinance(opportunity);
        }else
            addToMedical(opportunity);
    }
    
    public void addLead(Lead lead){
        this.leads.add(lead);
    }
    
    //currently manual addition to lists.
    public void addToFinance(Accounts acc){
        financeList.add(acc);
    }
    
    public void addToMedical(Accounts acc){
        medicalList.add(acc);
    }
    
    //currently manual removal from list
    public void removeFinance(int pos){
        financeList.remove(pos);
    }
    
    public void removeMedical(int pos){
        medicalList.remove(pos);
    }

   
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
    
    public void leadToOpportunity(int leadPos, ArrayList<Contacts> contact , ArrayList<String> form, String type){
        if(leadPos < leads.size()){
            opportunity.add(new Accounts(leads.get(leadPos), contact, form, type));
            leads.remove(leadPos);
        }else
            System.out.println("Index out of range.");
    }
    
    public ArrayList<String> getOppForm(int pos){
        return opportunity.get(pos).getForm();
    }
    
    public void opportunityToAccount(int opportunityPos){
        if(opportunityPos < opportunity.size()){
            opportunity.get(opportunityPos).toAccount();
            account.add( opportunity.get(opportunityPos));
            
            /*
            get from main.positiongiven > find which sublist has the account, 
            then move to corresponding list in account, then delete
            
            WILL MODIFY THIS later, for now we will use addFinance/Medical
            */
            
            opportunity.remove(opportunityPos);
        }else
            System.out.println("Index out of range.");
    }
    
    public String printAccount(){
        String accountStr = "Accounts:\n";
        for(int i = 0; i < account.size(); i++){     
            accountStr += (i + ". " + account.get(i));
        }
        return accountStr;
    }
    
    public String printOpportunity(){
        String opportunityStr = "Opportunities: \n";
        for(int i = 0; i < opportunity.size(); i++){
            opportunityStr += (i + ". " + opportunity.get(i));
        }
        return opportunityStr;
    }
    
    public String printLeads(){
        String leadStr = "Leads: \n";
        for(int i = 0; i < leads.size(); i++){
            leadStr += (i + ". " + leads.get(i).getCompanyName() + "\n");
        }
        return leadStr;
    }
    
    public String printCategories(){
        String categoryStr = "Categories: \n";
        for(int i = 0 ; i < categories.size() ; i++){
            categoryStr += (i + ". " + categories.get(i)+ "\n");
        }
        return categoryStr;
    }
    
    public String printFinance(){
        String financeStr = "Finance: \n";
        for(int i = 0 ; i < financeList.size() ; i++){
            financeStr += ( i + ". " + financeList.get(i).toString());
        }
        return financeStr;
    }
    
    public String printMedical(){
        String medicalStr = "Medical: \n";
        for(int i = 0 ; i < medicalList.size() ; i++){
            medicalStr += ( i + ". " + medicalList.get(i).toString());
        }
        return medicalStr;
    }

    public String printAccountContacts(){
        String contactStr = "Accounts: \n";
        for(int i = 0; i < account.size(); i++){
            contactStr += (i + ". " + account.get(i).allinfo() + "\n");
        }
        return contactStr;
    }
    public String printOpportunityContacts(){
        String opportunityStr = "Opportunities: \n";
        for(int i = 0; i < opportunity.size(); i++){
            opportunityStr += (i + ". " + opportunity.get(i).allinfo() + "\n");
        }
        return opportunityStr;
    }

    public String allInfo(){
        return (printAccountContacts() + printOpportunityContacts() + printLeads());
    }
    
    @Override
    public String toString(){        
        return (printAccount() + printOpportunity() + printLeads());
    }
    
    //Paper company
    public String listOpportunityDates(){
        StringBuilder date = new StringBuilder();
        date.append("Dates of Opportunities creation: \n");
                
        for(int i = 0 ; i < opportunity.size() ; i++){
            date.append(i);
            date.append(". ");
            date.append(opportunity.get(i).toString());
            date.append("\t");
            date.append((opportunity.get(i).getDates()));
            date.append("\n");

        }
        
        return date.toString();
    }
    
    public String listAccountDates(){
        StringBuilder date = new StringBuilder();
        date.append("Dates of Accounts creation: \n");
                
        for(int i = 0 ; i < account.size() ; i++){
            date.append(i);
            date.append(". ");
            date.append(account.get(i).toString());
            date.append("\t");
            date.append(account.get(i).getDates());
            date.append("\n");

        }
        
        return date.toString();
    }
    
    public String listAccountQtyPurchased(){
        StringBuilder qty = new StringBuilder();
        qty.append("Account quantity purchased: \n");
                
        for(int i = 0 ; i < account.size() ; i++){
            qty.append(i);
            qty.append(". ");
            qty.append(account.get(i).toString());
            qty.append("\t");
            qty.append(account.get(i).getBought());
            qty.append("\n");
        }
        
        return qty.toString();
    }
    
    public void updateQty(int pos, int amt){
        account.get(pos).increaseBought(amt);
    }

}
