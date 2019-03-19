/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;


import Model.*;
import static View.CRM_View.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Scanner;

/**
 *
 * @author vlope
 */
public class TestingCRMView {
    Lead lead;
    String temp;
    
   
    @Before
    public void setUp() {
    
    }
   

    @Test
    public void test(){
        String input = "leadName";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        lead = createLead();
        temp = lead.getCompanyName();
        assertEquals("leadName", temp);       
    }
  
   
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
