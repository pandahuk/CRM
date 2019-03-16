/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Model.Lead;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author devonnair
 */
public class test_lead {
    Lead l;
    @Before
    public void setUp() {
        l = new Lead("new comp");
    }
    @Test
    public void test()
    {
        l.setCompanyName("Possibly Good Company");
    }
    
}
