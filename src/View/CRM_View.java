package View;

import Model.*;
import java.util.Scanner;
import java.util.ArrayList;

public class CRM_View {  
    private static String userCompanyName;
    private static CRM userCRM;
    private static final Scanner scan = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        userCompanyName = CRMname();
        userCRM = new CRM(userCompanyName);
        int choice, pos = 0, secondChoice;
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
		userCRM.addAccount(createAccount());
		break;
            case 4:
                print(userCRM.printLeads());
                
                if(leadMenu()){
                    print("select a Lead: ");
                    do{
                        pos = scan.nextInt();
                    }while(pos < 0);
                    userCRM.leadToOpportunity(pos, createContactList());
                }
		break;
                
            case 5:
                print(userCRM.printOpportunityContacts());
                secondChoice = oppMenu();
                
                switch(secondChoice){
                    case 1:
                        pos = getPos();
                        userCRM.opportunityToAccount(pos);
                        break;
                    case 2:
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
            case 6:
                print(userCRM.printAccountContacts());
                secondChoice = accountMenu();
                switch(secondChoice){
                    case 1:
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
                }
		break;
            case 7:
                print(userCRM + "");
		break;
            case 8:
		print(userCRM.allInfo());
		break;
            }
	}while(choice != 9 );
        
        print("GoodBye\n");
    }
    
    private static void print(String outPut){
        System.out.print(outPut);
    }
        
    private static int getPos(){
        int pos;
        print("select an account/oppurtunity: ");
        do{
            pos = scan.nextInt();
        }while(pos < 0);
        return pos;
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
        print("\n\n\nplease enter the number of the option you would like to prform\n"+
                "1.Create a lead\n"+
                "2.Create an oppurtunity\n"+
                "3.Create an account\n"+
                "4.View all leads\n"+
                "5.View all oppurtunities\n"+
                "6.View all accounts\n"+
                "7.View minimal CRM info\n"+
                "8.View all CRM info\n"+
                "9.quit\n");
        do{
            decision = scan.nextInt();
        }while(decision < 1 || decision > 9);
        return decision;
    }
    private static boolean leadMenu(){
        String input;
        print("\nWould you like to change a lead to an opportunity? Y/N\n");
        do{
            input = scan.nextLine();
        }while(input.trim().equals("") || (!input.equalsIgnoreCase("y")
                && !input.equalsIgnoreCase("n")));
        return input.equalsIgnoreCase("y");
    }
    private static int oppMenu(){
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
    
    private static int accountMenu(){
        int decision;
        print("\n\n\nplease enter the number of the option you would like to prform\n"+
                "1.Update a contact\n"+
                "2.Update a contact name\n"+
                "3.Update a contact number\n"+
                "4.Update a contact email\n"+
                "5.add new contact\n"+
                "6.return to main menu\n");
        do{
            decision = scan.nextInt();
        }while(decision < 1 || decision > 7);
        return decision;
    }
    
    
    private static boolean contactQ(){
        String input;
        print("\nwould you like to add contacts? Y/N\n");
        do{
            input = scan.nextLine();
        }while(input.trim().equals("") && !input.equalsIgnoreCase("y")
                && !input.equalsIgnoreCase("n"));
        return input.equalsIgnoreCase("y");
    }
    private static boolean MoreContactQ(){
        String input;
        print("\nwould you like to add more contacts? Y/N\n");
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
        print("\nEnter the name of the new Lead: ");
        do{
            name = scan.nextLine();
        }while(name.trim().equals(""));
        return new Lead(name); 
    }
    
    private static Accounts createOpp(){
        String name;
        print("\nEnter the name of the new Opportunity : ");
        do{
            name = scan.nextLine();
        }while(name.trim().equals(""));
        
        return new Accounts(name, createContactList());
    }
    
    private static Accounts createAccount(){
        String name;
        print("\nEnter the name of the new Account: ");
        do{
            name = scan.nextLine();
        }while(name.trim().equals(""));
        
        return new Accounts(name, createContactList(), true);
    }
    
}
