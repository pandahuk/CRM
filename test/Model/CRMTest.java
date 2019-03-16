/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import static org.hamcrest.core.StringContains.containsString;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author d1031
 */
public class CRMTest {
    
    CRM instance;
    Accounts account;
    Accounts opportunity;
    Contacts contact;
    ArrayList<Contacts> contactList;
    Lead lead;
    
    
    public CRMTest() {
    }
    
    @Before
    public void setUp() {
        instance = new CRM("Model Company");
        
        contactList = new ArrayList<>();
        contact = new Contacts("Google manager", "5101119999","manager.google.com");
        contactList.add(contact);
        contact = new Contacts("Google Engineer", "5102229999","engineer.google.com");
        contactList.add(contact);
        account = new Accounts("Google", contactList, true);
        instance.addAccount(account);

        contactList = new ArrayList<>();
        contact = new Contacts("Agent", "5100105555","agent.nationwide.com");
        contactList.add(contact);
        account = new Accounts("Nationwide", contactList, true);
        instance.addAccount(account);

        contactList = new ArrayList<>();
        contact = new Contacts("Manager", "6965009000","manager.stone.com");
        contactList.add(contact);
        contact = new Contacts("Barista", "6968009000","barista.stone.com");
        contactList.add(contact);
        opportunity = new Accounts("Stone", contactList, false);
        instance.addOpporunity(opportunity);
        
        lead = new Lead("Hitachi");
        instance.addLead(lead);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addAccount method, of class CRM.
     */
    @Test
    public void testAddAccount() {
        System.out.println("addAccount");
        account = new Accounts("Netflix");
        instance.addAccount(account);
        
        assertEquals(3, instance.getAccount().size());
    }

    /**
     * Test of addOpporunity method, of class CRM.
     */
    @Test
    public void testAddOpporunity() {
        System.out.println("addOpporunity");
        opportunity = new Accounts("Yalla");
        instance.addOpporunity(opportunity);
        assertEquals(2, instance.getAccount().size());

    }

    /**
     * Test of addLead method, of class CRM.
     */
    @Test
    public void testAddLead() {
        System.out.println("addLead");
        lead = new Lead("Robot");
        instance.addLead(lead);
        assertEquals(2, instance.getAccount().size());
    }

    /**
     * Test of addContactAccount method, of class CRM.
     */
    @Test
    public void testAddContactAccount() {
        System.out.println("addContactAccount");
        int accountPos = 5;
        instance.addContactAccount(accountPos, contact);
        assertEquals(2, instance.getAccount().size());
        
    }

    /**
     * Test of updateContactAccount method, of class CRM.
     */
    @Test
    public void testUpdateContactAccount() {
        System.out.println("updateContactAccount");
        
        //instance.updateContactAccount(0, "Google Assistnant", instance.getAccount().get(0).);
    }

    /**
     * Test of updateContactNameAccount method, of class CRM.
     */
    @Test
    public void testUpdateContactNameAccount() {
        System.out.println("updateContactNameAccount");
        //instance.updateContactNameAccount(0, oldName, newName);

    }

    /**
     * Test of updateContactNumAccount method, of class CRM.
     */
    @Test
    public void testUpdateContactNumAccount() {
        System.out.println("updateContactNumAccount");
        //instance.updateContactNumAccount(accountPos, oldNum, newNum);

    }

    /**
     * Test of updateContactEmailAccount method, of class CRM.
     */
    @Test
    public void testUpdateContactEmailAccount() {
        System.out.println("updateContactEmailAccount");
       // instance.updateContactEmailAccount(accountPos, oldEmail, newEmail);

    }

    /**
     * Test of updateContactOpportunity method, of class CRM.
     */
    @Test
    public void testUpdateContactOpportunity() {
        System.out.println("updateContactOpportunity");
       // instance.updateContactOpportunity(opportunityPos, cName, contact);

    }

    /**
     * Test of updateContactNameOpportunity method, of class CRM.
     */
    @Test
    public void testUpdateContactNameOpportunity() {
        System.out.println("updateContactNameOpportunity");
        //instance.updateContactNameOpportunity(opportunityPos, oldName, newName);

    }

    /**
     * Test of updateContactNumOpportunity method, of class CRM.
     */
    @Test
    public void testUpdateContactNumOpportunity() {
        System.out.println("updateContactNumOpportunity");
        instance.updateContactNumOpportunity(0, "6965009000", "0001112222");
        //assertThat(instance.allInfo(), containsString("0001112222"));
        
    }

    /**
     * Test of updateContactEmailOpportunity method, of class y() {
        System.out.println("updateContactNumOpportunity");
        instance.updateContactNumOpportunity(0,CRM.
     */
    @Test
    public void testUpdateContactEmailOpportunity() {
        System.out.println("updateContactEmailOpportunity");
        instance.updateContactEmailOpportunity(0, "manager.stone.com", "manager2.stone.com");
        String expResult =
"Accounts: \n" +
"0. Company Name: Google\n" +
" Contacts: \n" +
"name: Google manager\n" +
"Phone #: 5101119999\n" +
"email: manager.google.com\n" +
"name: Google Engineer\n" +
"Phone #: 5102229999\n" +
"email: engineer.google.com\n" +
"\n" +
"1. Company Name: Nationwide\n" +
" Contacts: \n" +
"name: Agent\n" +
"Phone #: 5100105555\n" +
"email: agent.nationwide.com\n" +
"\n" +
"Opportunities: \n" +
"0. Company Name: Stone\n" +
" Contacts: \n" +
"name: Manager\n" +
"Phone #: 6965009000\n" +
"email: manager.stone.com\n" +
"name: Barista\n" +
"Phone #: 6968009000\n" +
"email: barista.stone.com\n" +
"\n" +
"Leads: \n" +
"0. Hitachi\n" +
"";
        String result = instance.allInfo();
        assertEquals(expResult, result);
    }

    /**
     * Test of leadToOpportunity method, of class CRM.
     */
    @Test
    public void testLeadToOpportunity() {
        System.out.println("leadToOpportunity");
        instance.leadToOpportunity(0, contactList);
        assertEquals(0, instance.getLead().size());
    }

    /**
     * Test of opportunityToAccount method, of class CRM.
     */
    @Test
    public void testOpportunityToAccount() {
        System.out.println("opportunityToAccount");
        instance.opportunityToAccount(0);
        assertEquals(0, instance.getOpportunity().size());

    }

    /**
     * Test of printAccount method, of class CRM.
     */
    @Test
    public void testPrintAccount() {
        System.out.println("printAccount");
        String expResult = "Accounts:\n" +
"0. Google\n" +
"1. Nationwide\n" +
"";
        String result = instance.printAccount();
        assertEquals(expResult, result);

    }

    /**
     * Test of printOpportunity method, of class CRM.
     */
    @Test
    public void testPrintOpportunity() {
        System.out.println("printOpportunity");
        String expResult = "Opportunities: \n" +
        "0. Stone\n" + 
        "";
        String result = instance.printOpportunity();
        assertEquals(expResult, result); 
    }

    /**
     * Test of printLeads method, of class CRM.
     */
    @Test
    public void testPrintLeads() {
        System.out.println("printLeads");
        String expResult = "Leads: \n" +
"0. Hitachi\n" +
"";
        String result = instance.printLeads();

        assertEquals(expResult, result);
    }

    /**
     * Test of allInfo method, of class CRM.
     */
    @Test
    public void testAllInfo() {
        System.out.println("allInfo");
        String expResult = "Accounts: \n" +
"0. Company Name: Google\n" +
" Contacts: \n" +
"name: Google manager\n" +
"Phone #: 5101119999\n" +
"email: manager.google.com\n" +
"name: Google Engineer\n" +
"Phone #: 5102229999\n" +
"email: engineer.google.com\n" +
"\n" +
"1. Company Name: Nationwide\n" +
" Contacts: \n" +
"name: Agent\n" +
"Phone #: 5100105555\n" +
"email: agent.nationwide.com\n" +
"\n" +
"Opportunities: \n" +
"0. Company Name: Stone\n" +
" Contacts: \n" +
"name: Manager\n" +
"Phone #: 6965009000\n" +
"email: manager.stone.com\n" +
"name: Barista\n" +
"Phone #: 6968009000\n" +
"email: barista.stone.com\n" +
"\n" +
"Leads: \n" +
"0. Hitachi\n" +
"";
        String result = instance.allInfo();
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class CRM.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Accounts:\n" +
"0. Google\n" +
"1. Nationwide\n" +
"Opportunities: \n" +
"0. Stone\n" +
"Leads: \n" +
"0. Hitachi\n" +
"";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
