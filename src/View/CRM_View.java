package View;

import Model.*;
import java.util.Scanner;
import java.util.ArrayList;

public class CRM_View {  
    private static String userCompanyName;
    private static CRM userCRM;
    private static Scanner scan = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        userCompanyName = CRMname();
        userCRM = new CRM(userCompanyName);
        int choice, pos, secondChoice;
        String name,temp;
        do {
            choice = simpleMenu();
            switch(choice) {
            case 1:
                userCRM.addLead(createLead());
                break;
            case 2:
		userCRM.addOpporunity(createOpp());
		break;
            case 3:
		userCRM.addOpporunity(createAccount());
		break;
            case 4:
                //once prints are returning strings
                //print(userCRM.printLeads());
		userCRM.printLeads();
                
                if(leadMenu()){
                    print("select a Lead: ");
                    do{
                        pos = scan.nextInt();
                    }while(pos < 0);
                }
                    //userCRM.leadToOpportunity(pos, createContactList());
		break;
            case 5:
		//once prints are returning strings
                //print(userCRM.printOpportunity());
                userCRM.printOpportunity();
                secondChoice = oppMenu();
                if(secondChoice !=7)
                    print("select an opportunity: ");
                do{
                    pos = scan.nextInt();
                }while(pos < 0);
                
                switch(secondChoice){
                    case 1:
                        //userCRM.opportunityToAccount(pos);
                        break;
                    case 2:
                        print("enter current contact name");
                        do{
                            name = scan.nextLine();
                        }while(name.trim().equals(""));
                        userCRM.updateContactOpportunity(pos, name, createContact());
                        break;
                    case 3:
                        print("enter current contact name");
                        do{
                            name = scan.nextLine();
                        }while(name.trim().equals(""));
                        
                        print("enter new contact name");
                        do{
                            temp = scan.nextLine();
                        }while(temp.trim().equals(""));
                        userCRM.updateContactNameOpportunity(pos, name, temp);
                        break;
                    case 4:
                        print("enter current contact name");
                        do{
                            name = scan.nextLine();
                        }while(name.trim().equals(""));
                        
                        print("enter new contact number");
                        do{
                            temp = scan.nextLine();
                        }while(temp.trim().equals(""));
                        userCRM.updateContactNumOpportunity(pos, name, temp);
                        break;
                    case 5:
                        print("enter current contact name");
                        do{
                            name = scan.nextLine();
                        }while(name.trim().equals(""));
                        
                        print("enter new contact email");
                        do{
                            temp = scan.nextLine();
                        }while(temp.trim().equals(""));
                        userCRM.updateContactEmailOpportunity(pos, name, temp);
                        break;
                    case 6:
                        //to come latter
                        //adding contact to opp
                }
		break;
            case 6:
		//once prints are returning strings
                //print(userCRM.printAccount());
                userCRM.printAccount();
                secondChoice = accountMenu();
                if(secondChoice !=6)
                print("select an account: ");
                do{
                    pos = scan.nextInt();
                }while(pos < 0);
                
                switch(secondChoice){
                    case 1:
                        print("enter current contact name");
                        do{
                            name = scan.nextLine();
                        }while(name.trim().equals(""));
                        userCRM.updateContactAccount(pos, name, createContact());
                        break;
                    case 2:
                        print("enter current contact name");
                        do{
                            name = scan.nextLine();
                        }while(name.trim().equals(""));
                        
                        print("enter new contact name");
                        do{
                            temp = scan.nextLine();
                        }while(temp.trim().equals(""));
                        userCRM.updateContactNameAccount(pos, name, temp);
                        break;
                    case 3:
                        print("enter current contact name");
                        do{
                            name = scan.nextLine();
                        }while(name.trim().equals(""));
                        
                        print("enter new contact number");
                        do{
                            temp = scan.nextLine();
                        }while(temp.trim().equals(""));
                        userCRM.updateContactNumAccount(pos, name, temp);
                        break;
                    case 5:
                        print("enter current contact name");
                        do{
                            name = scan.nextLine();
                        }while(name.trim().equals(""));
                        
                        print("enter new contact email");
                        do{
                            temp = scan.nextLine();
                        }while(temp.trim().equals(""));
                        userCRM.updateContactEmailAccount(pos, name, temp);
                        break;
                    case 6:
                        userCRM.addContactAccount(pos,createContact());
                }
		break;
            case 7:
		//print some info
                print(userCRM + "");
		break;
            case 8:
		print(userCRM.allInfo());
		break;
            }
	}while(choice != 9);
        
        print("GoodBye");
    }
    
    private static void print(String outPut){
        System.out.print(outPut);
    }
    
    private static String CRMname(){
        String name;
        print("Enter your Buissness name for the CRM you wish to create: ");
        do{
            name = scan.nextLine();
        }while(name.trim().equals(""));
        
        return name;
    }
    
    private static int simpleMenu(){
        int decision;
        print("please enter the number of the option you would like to prform\n"+
                "1.Create a lead\n"+
                "2.Create an oppurtunity\n"+
                "3.Create an account\n"+
                "4.View all leads\n"+
                "5.View all oppurtunities\n"+
                "6.View all accounts\n"+
                "7.View minimal CRM info\n"+
                "8.View all CRM info\n"+
                "9.return to main menu\n");
        do{
            decision = scan.nextInt();
        }while(decision < 1 || decision > 8);
        return decision;
    }
    private static boolean leadMenu(){
        String input;
        print("Would you like to change a lead to an opportunity? Y/N\n");
        do{
            input = scan.nextLine();
        }while(input.trim().equals("") && !input.equalsIgnoreCase("y")
                && !input.equalsIgnoreCase("n"));
        return input.equalsIgnoreCase("y");
    }
    private static int oppMenu(){
        int decision;
        print("please enter the number of the option you would like to prform\n"+
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
    
    private static int accountMenu(){
        int decision;
        print("please enter the number of the option you would like to prform\n"+
                "1.Update a contact\n"+
                "2.Update a contact name\n"+
                "3.Update a contact number\n"+
                "4.Update a contact email\n"+
                "5.add new contact\n"+
                "6.Quit\n");
        do{
            decision = scan.nextInt();
        }while(decision < 1 || decision > 7);
        return decision;
    }
    
    
    private static boolean contactQ(){
        String input;
        print("would you like to add contacts? Y/N\n");
        do{
            input = scan.nextLine();
        }while(input.trim().equals("") && !input.equalsIgnoreCase("y")
                && !input.equalsIgnoreCase("n"));
        return input.equalsIgnoreCase("y");
    }
    private static boolean MoreContactQ(){
        String input;
        print("would you like to add more contacts? Y/N\n");
        do{
            input = scan.nextLine();
        }while(input.trim().equals("") && !input.equalsIgnoreCase("y")
                && !input.equalsIgnoreCase("n"));
        return input.equalsIgnoreCase("y");
    }
    private static  Contacts createContact(){
        String name;
        String phoneNum;
        String email;
        print("Enter the name of the new Contact");
        do{
            name = scan.nextLine();
        }while(name.trim().equals(""));
        print("Enter the email of the new Contact");
        email = scan.nextLine();
        print("Enter the phone number of the new Contact");
        phoneNum = scan.nextLine();
        
        return new Contacts(name,phoneNum,email);
    }
    private static  ArrayList<Contacts> createContactList(){
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
    
    
    
    private static Lead createLead(){
        String name;
        print("Enter the name of the new Lead: ");
        do{
            name = scan.nextLine();
        }while(name.trim().equals(""));
        
        Lead nLead = new Lead();
        nLead.setCompanyName(name);
        return nLead;
        //once constructor is made wil be ok
        //return new Lead(name); 
    }
    
    private static Accounts createOpp(){
        String name;
        print("Enter the name of the new Opportunity : ");
        do{
            name = scan.nextLine();
        }while(name.trim().equals(""));
        
        return new Accounts(name, createContactList());
    }
    
    private static Accounts createAccount(){
        String name;
        print("Enter the name of the new Account: ");
        do{
            name = scan.nextLine();
        }while(name.trim().equals(""));
        
        return new Accounts(name, createContactList(), true);
    }
    
}
