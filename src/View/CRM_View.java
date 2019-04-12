package View;

import Model.*;
import java.util.Scanner;
import java.util.ArrayList;

public class CRM_View {  
    private static String userCompanyName;
    private static CRM userCRM;
    private static final Scanner scan = new Scanner(System.in);
    
    //testing new clone
    public static void main(String[] args) {
        userCompanyName = CRMname();
        userCRM = new CRM(userCompanyName);
        int choice, pos = 0, secondChoice;
        String name,temp,input;
        ArrayList <String> questions;
        Boolean promote;
        //switch case for menus
        do {
            choice = simpleMenu();
            switch(choice) {
            case 1: //make lead
                userCRM.addLead(createLead());
                break;
            case 2: //make opp
		userCRM.addOpporunity(createOpp());
		break;
            case 3: // make account
		userCRM.addAccount(createAccount());
		break;
            case 4: //print lead followed by lead menu
                print(userCRM.printLeads());
                
                if(leadMenu()){
                    print("select a Lead: ");
                    do{
                        pos = scan.nextInt();
                    }while(pos < 0);
                    userCRM.leadToOpportunity(pos, createContactList(), createFourm(), createType());
                }
		break;
                
            case 5:// print opp followed by opp menu
                print(userCRM.printOpportunityContacts());
                secondChoice = oppMenu();
                
                switch(secondChoice){
                    case 1: //opp to account
                        pos = getPos();
                        promote = true;
                        questions =  userCRM.getOppForm(pos);
                        if(!questions.isEmpty()){
                            print("Answer Y/N if you completed the following task\n");
                            for(String i : questions){
                               print(i);
                                do{
                                    input = scan.nextLine();
                                }while(input.trim().equals(""));
                                if(input.toLowerCase().compareTo("n") == 0){
                                    print("can not make oppurtunity to account");
                                    promote = false;
                                    break;
                                }
                            }
                        }
                        if(promote){ 
                            print("Making Opportunity to account\n");
                            userCRM.opportunityToAccount(pos);
                        }
                        break;
                    case 2: //updating contact
                        pos = getPos();
                        print("Enter current contact name: ");
                        do{
                            name = scan.nextLine();
                        }while(name.trim().equals(""));
                        userCRM.updateContactOpportunity(pos, name, createContact());
                        break;
                    case 3:
                        pos = getPos();
                        print("Enter current contact name: ");
                        do{
                            name = scan.nextLine();
                        }while(name.trim().equals(""));
                        
                        print("Enter new contact name: ");
                        do{
                            temp = scan.nextLine();
                        }while(temp.trim().equals(""));
                        userCRM.updateContactNameOpportunity(pos, name, temp);
                        break;
                    case 4:
                        pos = getPos();
                        print("Enter current contact name: ");
                        do{
                            name = scan.nextLine();
                        }while(name.trim().equals(""));
                        
                        print("Enter new contact number: ");
                        do{
                            temp = scan.nextLine();
                        }while(temp.trim().equals(""));
                        userCRM.updateContactNumOpportunity(pos, name, temp);
                        break;
                    case 5:
                        pos = getPos();
                        print("Enter current contact name: ");
                        do{
                            name = scan.nextLine();
                        }while(name.trim().equals(""));
                        
                        print("Enter new contact email: ");
                        do{
                            temp = scan.nextLine();
                        }while(temp.trim().equals(""));
                        userCRM.updateContactEmailOpportunity(pos, name, temp);
                        break;
                    case 6:
                        pos = getPos();
                        userCRM.addContactOpportunity(pos,createContact());
                }
		break;
            case 6: //print account followed by account menu
                print(userCRM.printAccountContacts());
                secondChoice = accountMenu();
                switch(secondChoice){
                    case 1: //update contacts
                        pos = getPos();
                        print("Enter current contact name: ");
                        do{
                            name = scan.nextLine();
                        }while(name.trim().equals(""));
                        userCRM.updateContactAccount(pos, name, createContact());
                        break;
                    case 2:
                        pos = getPos();
                        print("Enter current contact name: ");
                        do{
                            name = scan.nextLine();
                        }while(name.trim().equals(""));
                        
                        print("Enter new contact name: ");
                        do{
                            temp = scan.nextLine();
                        }while(temp.trim().equals(""));
                        userCRM.updateContactNameAccount(pos, name, temp);
                        break;
                    case 3:
                        pos = getPos();
                        print("Enter current contact name: ");
                        do{
                            name = scan.nextLine();
                        }while(name.trim().equals(""));
                        
                        print("Enter new contact number: ");
                        do{
                            temp = scan.nextLine();
                        }while(temp.trim().equals(""));
                        userCRM.updateContactNumAccount(pos, name, temp);
                        break;
                    case 4:
                        pos = getPos();
                        print("Enter current contact name: ");
                        do{
                            name = scan.nextLine();
                        }while(name.trim().equals(""));
                        
                        print("Enter new contact email: ");
                        do{
                            temp = scan.nextLine();
                        }while(temp.trim().equals(""));
                        userCRM.updateContactEmailAccount(pos, name, temp);
                        break;
                    case 5:
                        pos = getPos();
                        userCRM.addContactAccount(pos,createContact());
                        break;
                    case 6:
                        pos = getPos();
                        print("How much product was purchesed by account " + pos + " : ");
                        do{
                            choice = scan.nextInt();
                        }while(choice < 1);     
                        //userCRM.updateQty(pos,choice);
                }
		break;
            case 7: // display simple crm info
                print(userCRM + "");
		break;
            case 8: //display detailed information
		print(userCRM.allInfo());
		break;
            case 9: // displaying categories 
                
                print(userCRM.printCategories());
                print("select a Catigory");
                pos = getPos();
                if(pos == 0)
                    print(userCRM.printMedical());
                else
                    print(userCRM.printFinance());   
                break;
            case 10: //opps date
                print(userCRM.listOpportunityDates());
                break;
            case 11: // accounts date
                print(userCRM.listAccountDates());
                break;
            case 12: // accounts qty
                print(userCRM.listAccountQtyPurchased());
                break;
                
            }
            
	}while(choice != 13 );
        print("GoodBye\n");
    }
    //print helper
    public static void print(String outPut){
        System.out.print(outPut);
    }
    // helper to get pos from user
    public static int getPos(){
        int pos;
        print("select an account/oppurtunity: ");
        do{
            pos = scan.nextInt();
        }while(pos < 0);
        return pos;
    }
    //getting form from user
    public static ArrayList<String> createFourm(){
        ArrayList<String> questions = new ArrayList<>();
        print("Enter requirements to make this oppurtunity to become an account, one at a time.\n"
                + "enter Q or quit to stop\n");
        int i = 1;
        String input;
        do{
            print("Enter Requirement " + i );
            do{
                input = scan.nextLine();
            }while(input.trim().equals(""));
            if(input.compareToIgnoreCase("q") == 0 || input.compareToIgnoreCase("quit") == 0)
                break;
            questions.add(input);
            i++;
        }while(true);
        
        return questions;
    }
    //getting name from user
    public static String CRMname(){
        String name;
        print("Enter your Buissness name for the CRM you wish to create: ");
        do{
            name = scan.nextLine();
        }while(name.trim().equals(""));
        
        return name;
    }
    //displaying simple menu and retuns result of use
    public static int simpleMenu(){
        int decision;
        print("\n\n\nplease enter the number of the option you would like to prform\n"+
                "1.Create a lead\n"+
                "2.Create an oppurtunity\n"+
                "3.Create an account\n"+
                "4.View all leads\n"+
                "5.View all oppurtunities\n"+
                "6.View all accounts\n"+
                "7.View minimal CRM info\n"+
                "8.View all CRM info\n"+
                "9.View by Catigory\n"+
                "10.View all oppurtunities by date\n"+
                "11.View all accounts by date\n"+
                "12.View all accounts quantity purchesed\n"+
                "13.quit\n");
        do{
            decision = scan.nextInt();
        }while(decision < 1 || decision > 13);
        return decision;
    }
    
    //displays lead menu and retuens user input
    public static boolean leadMenu(){
        String input;
        print("\nWould you like to change a lead to an opportunity? Y/N\n");
        do{
            input = scan.nextLine();
        }while(input.trim().equals("") || (!input.equalsIgnoreCase("y")
                && !input.equalsIgnoreCase("n")));
        return input.equalsIgnoreCase("y");
    }
    
    //displays opp menu and retuens user input
    public static int oppMenu(){
        int decision;
        print("\n\n\nplease enter the number of the option you would like to prform\n"+
                "1.Turn opportunity to account\n"+
                "2.Update a contact\n"+
                "3.Update a contact name\n"+
                "4.Update a contact number\n"+
                "5.Update a contact email\n"+
                "6.add new contact\n"+
                "7.return to main menu\n");
        do{
            decision = scan.nextInt();
        }while(decision < 1 || decision > 7);
        return decision;
    }
    //displays account menu and retuens user input
    public static int accountMenu(){
        int decision;
        print("\n\n\nplease enter the number of the option you would like to prform\n"+
                "1.Update a contact\n"+
                "2.Update a contact name\n"+
                "3.Update a contact number\n"+
                "4.Update a contact email\n"+
                "5.add new contact\n"+
                "6.increase product puchesed\n"+
                "7.return to main menu\n");
        do{
            decision = scan.nextInt();
        }while(decision < 1 || decision > 8);
        return decision;
    }
    
    ////displays contact menu and retuens user input
    public static boolean contactQ(){
        String input;
        print("\nwould you like to add contacts? Y/N\n");
        do{
            input = scan.nextLine();
        }while(input.trim().equals("") && !input.equalsIgnoreCase("y")
                && !input.equalsIgnoreCase("n"));
        return input.equalsIgnoreCase("y");
    }
    //collects contact info till user stops
    public static boolean MoreContactQ(){
        String input;
        print("\nwould you like to add more contacts? Y/N\n");
        do{
            input = scan.nextLine();
        }while(input.trim().equals("") && !input.equalsIgnoreCase("y")
                && !input.equalsIgnoreCase("n"));
        return input.equalsIgnoreCase("y");
    }
    //will promt for contact info
    public static  Contacts createContact(){
        String name;
        String phoneNum;
        String email;
        print("\nEnter the name of the new Contact: ");
        do{
            name = scan.nextLine();
        }while(name.trim().equals(""));
        print("\nEnter the email of the new Contact: ");
        email = scan.nextLine();
        print("\nEnter the phone number of the new Contact: ");
        phoneNum = scan.nextLine();
        
        return new Contacts(name,phoneNum,email);
    }
    // will call the create contact to collect contact infos
    public static  ArrayList<Contacts> createContactList(){
        ArrayList<Contacts> ContactsList = new ArrayList<>();
        Contacts contact;
        if(contactQ()){
            do{
                contact = createContact();
                ContactsList.add(contact);
            }while(MoreContactQ());
        }
        
        return ContactsList;
    }
    //creates lead
    public static Lead createLead(){
        String name;
        print("\nEnter the name of the new Lead: ");
        do{
            name = scan.nextLine();
        }while(name.trim().equals(""));
        return new Lead(name); 
    }
    //create opp
    public static Accounts createOpp(){
        String name;
        print("\nEnter the name of the new Opportunity : ");
        do{
            name = scan.nextLine();
        }while(name.trim().equals(""));
        
        return new Accounts(name, createContactList(), createFourm() , createType());
    }
    // will create account
    public static Accounts createAccount(){
        String name;
        print("\nEnter the name of the new Account: ");
        do{
            name = scan.nextLine();
        }while(name.trim().equals(""));
        
        return new Accounts(name, createContactList(), createType() ,true);
    }
    //getting user input for the type of account
    public static String createType() {
        String type;
        print("\nEnter the category this will be in:\n"
                + "Currently only have Medical and Finance: ");
        do{
            type = scan.nextLine();
        }while(type.trim().equals(""));
        
        return type;
    }  
}
