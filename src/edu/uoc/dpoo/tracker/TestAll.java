package edu.uoc.dpoo.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    // Tests for PR1
    edu.uoc.dpoo.tracker.PR1_Ex2_Test.class,
    edu.uoc.dpoo.tracker.PR1_Ex3_Test.class,     
    })

public class TestAll {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}
