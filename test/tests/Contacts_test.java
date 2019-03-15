/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Model.Contacts;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author devonnair
 */
public class Contacts_test {
    
    Contacts c;
    
    @Before
    public void setUp() {
        c = new Contacts("Very Good Company/","510-123-4567","VGCompany@email.com");
    }
    @Test
    public void test()
    {
        System.out.println(c.toString());
    }
}
