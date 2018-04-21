package edu.uoc.dpoo.tracker;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PR1_Ex2_Test {
    
    private final String pet1_name = "pet1";
    private final int pet1_serial = 1;
    private final int pet1_contractId = 25;
    private final boolean pet1_allowFriends = true;
    private final Date pet1_start = new Date();
    private final Date pet1_end = new Date();   
    private final String pet2_name = "pet2";
    private final int pet2_serial = 45;
    private final int pet2_contractId = 70;
    private final boolean pet2_allowFriends = false;
    private final Date pet2_start = new Date();
    private final Date pet2_end = new Date();   
        
    public PR1_Ex2_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void addContract() {
        PetTracker tracker = new PetTracker();
        
        // Check that initially the list of pets is empty
        assertNotNull(tracker.getDevices());
        assertEquals((int)tracker.getDevices().size(), 0);
                
        // Add a new contract
        tracker.addContract(pet1_contractId, pet1_start, pet1_end, pet1_name, pet1_allowFriends);
        
        // Check that the list of pets have one element
        assertNotNull(tracker.getDevices());
        assertEquals(1, (int)tracker.getDevices().size());
    }    
    
    @Test
    public void addContractRepeated() {
        PetTracker tracker = new PetTracker();
        
        // Check that initially the list of pets is empty
        assertNotNull(tracker.getDevices());
        assertEquals(0, (int)tracker.getDevices().size());
                
        // Add a new contract
        tracker.addContract(pet1_contractId, pet1_start, pet1_end, pet1_name, pet1_allowFriends);
        
        // Check that the list of pets have one element
        assertNotNull(tracker.getDevices());
        assertEquals(1, (int)tracker.getDevices().size());
        
        // Add again the same contract (repeated clientId)
        tracker.addContract(pet1_contractId, pet1_start, pet1_end, pet1_name, pet1_allowFriends);
        
        // Check that the list of pets have one element
        assertNotNull(tracker.getDevices());
        assertEquals(1, (int)tracker.getDevices().size());
    }   
    
    @Test
    public void getContract() {
        PetTracker tracker = new PetTracker();
        
        // Check that initially the list of pets is empty
        assertNotNull(tracker.getDevices());
        assertEquals(0, (int)tracker.getDevices().size());
                
        // Add a new contract
        tracker.addContract(pet1_contractId, pet1_start, pet1_end, pet1_name, pet1_allowFriends);
        
        // Request the contract
        Contract c1 = tracker.getContract(pet1_contractId);        
        assertNotNull(c1);
        
        // Check contract initialization
        assertEquals(pet1_contractId, c1.getContractId());
        assertEquals(pet1_start, c1.getStart());
        assertEquals(pet1_end, c1.getEnd());
        assertEquals(pet1_allowFriends, c1.getAllowFriends());        
    }    
    
    @Test
    public void getClientDevice() {
        PetTracker tracker = new PetTracker();
        
        // Check that initially the list of pets is empty
        assertNotNull(tracker.getDevices());
        assertEquals(0, (int)tracker.getDevices().size());
                
        // Add a new contract
        tracker.addContract(pet1_contractId, pet1_start, pet1_end, pet1_name, pet1_allowFriends);
        
        // Request the device
        Pet d1 = tracker.getClientDevice(pet1_contractId);        
        assertNotNull(d1);
        
        // Check device initialization
        assertEquals(-1, d1.getSerial());
        assertEquals(pet1_name, d1.getName());
        assertNotNull(d1.getHistoric());
        assertEquals(0, (int)d1.getHistoric().size());
        assertNotNull(d1.getTracker());
        assertSame(tracker, d1.getTracker());
    }    
    
    @Test
    public void linkDevice() {
        PetTracker tracker = new PetTracker();
        
        // Check that initially the list of pets is empty
        assertNotNull(tracker.getDevices());
        assertEquals(0, (int)tracker.getDevices().size());
                
        // Add a new contract
        tracker.addContract(pet1_contractId, pet1_start, pet1_end, pet1_name, pet1_allowFriends);
        
        // Request the device
        Pet d1 = tracker.getClientDevice(pet1_contractId);        
        assertNotNull(d1);
        
        // Check device initialization
        assertEquals(-1, d1.getSerial());
        
        // Link the device
        tracker.linkDevice(pet1_contractId, pet1_serial);
        assertEquals(pet1_serial, d1.getSerial());
    }    
    
    @Test
    public void delContract() {
        PetTracker tracker = new PetTracker();
        
        // Check that initially the list of pets is empty
        assertNotNull(tracker.getDevices());
        assertEquals(0, (int)tracker.getDevices().size());
                
        // Add a new contract
        tracker.addContract(pet1_contractId, pet1_start, pet1_end, pet1_name, pet1_allowFriends);        
        assertNotNull(tracker.getDevices());
        assertEquals(1, (int)tracker.getDevices().size());
        
        // Request the device
        Pet d1 = tracker.getClientDevice(pet1_contractId);        
        assertNotNull(d1);
        
        // Delete the contract
        tracker.delContract(pet1_contractId);
        assertEquals(0, (int)tracker.getDevices().size());
        assertNull(tracker.getClientDevice(pet1_contractId));
        assertNull(tracker.getContract(pet1_contractId));        
    }    
    
    @Test
    public void delNotExistingContract() {
        PetTracker tracker = new PetTracker();
        
        // Check that initially the list of pets is empty
        assertNotNull(tracker.getDevices());
        assertEquals(0, (int)tracker.getDevices().size());       
        
        // Delete the contract
        tracker.delContract(pet1_contractId);
        assertEquals(0, (int)tracker.getDevices().size());
        assertNull(tracker.getClientDevice(pet1_contractId));
        assertNull(tracker.getContract(pet1_contractId));        
    }    
    
    @Test
    public void multipleContracts() {
        PetTracker tracker = new PetTracker();
        
        // Check that initially the list of pets is empty
        assertNotNull(tracker.getDevices());
        assertEquals(0, (int)tracker.getDevices().size());
                
        // Add a new contract
        tracker.addContract(pet1_contractId, pet1_start, pet1_end, pet1_name, pet1_allowFriends);        
        assertNotNull(tracker.getDevices());
        assertEquals(1, (int)tracker.getDevices().size());
        
        // Add a new contract
        tracker.addContract(pet2_contractId, pet2_start, pet2_end, pet2_name, pet2_allowFriends);        
        assertNotNull(tracker.getDevices());
        assertEquals(2, (int)tracker.getDevices().size());
        
        // Request the device 1
        Pet d1 = tracker.getClientDevice(pet1_contractId);        
        assertNotNull(d1);
        assertEquals(pet1_name, d1.getName());
        
        // Request the device 2
        Pet d2 = tracker.getClientDevice(pet2_contractId);        
        assertNotNull(d2);
        assertEquals(pet2_name, d2.getName());
        
        // Delete the contract
        tracker.delContract(pet1_contractId);
        assertEquals(1, (int)tracker.getDevices().size());
        assertNull(tracker.getClientDevice(pet1_contractId));
        assertNull(tracker.getContract(pet1_contractId));        
        tracker.delContract(pet2_contractId);
        assertEquals(0, (int)tracker.getDevices().size());
        assertNull(tracker.getClientDevice(pet2_contractId));
        assertNull(tracker.getContract(pet2_contractId));        
    }        
}
