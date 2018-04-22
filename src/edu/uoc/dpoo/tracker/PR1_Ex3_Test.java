package edu.uoc.dpoo.tracker;

import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PR1_Ex3_Test {
    
    private final String pet1_name = "pet1";    
    private final int pet1_contractId = 25;
    private final boolean pet1_allowFriends = true;
    private final Date pet1_start = new Date();
    private final Date pet1_end = new Date();   
                
    public PR1_Ex3_Test() {
        
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
    public void sendMessage() {
        PetTracker tracker = new PetTracker();
        
        // Check that initially the list of messages is empty
        assertNotNull(tracker.getMessages());
        assertEquals(0, (int)tracker.getMessages().size());
                
        // Add a new contract
        tracker.addContract(pet1_contractId, pet1_start, pet1_end, pet1_name, pet1_allowFriends);
        
        // Send a message
        Date dInit = new Date();
        tracker.sendMessage(pet1_contractId, MessageType.FRIEND_NEAR);
        Date dEnd = new Date();
        
        assertNotNull(tracker.getMessages());
        assertEquals(1, (int)tracker.getMessages().size());
        
        Message m = tracker.getMessages().get(0);
        assertEquals(pet1_contractId, m.getContractId());
        assertEquals(MessageType.FRIEND_NEAR, m.getType());
        assertTrue(m.getCreatedAt().compareTo(dInit)>=0);
        assertTrue(m.getCreatedAt().compareTo(dEnd)<=0);
        assertNull(m.getReadAt());
    }
    
    @Test
    public void readMessage() {
        PetTracker tracker = new PetTracker();
        
        // Check that initially the list of messages is empty
        assertNotNull(tracker.getMessages());
        assertEquals(0, (int)tracker.getMessages().size());
                
        // Add a new contract
        tracker.addContract(pet1_contractId, pet1_start, pet1_end, pet1_name, pet1_allowFriends);
        
        // Send a message
        Date dInit = new Date();
        tracker.sendMessage(pet1_contractId, MessageType.FRIEND_NEAR);
        Date dEnd = new Date();
        
        assertNotNull(tracker.getMessages());
        assertEquals(1, (int)tracker.getMessages().size());
        
        Message m = tracker.getMessages().get(0);
        assertEquals(pet1_contractId, m.getContractId());
        assertEquals(MessageType.FRIEND_NEAR, m.getType());
        assertTrue(m.getCreatedAt().compareTo(dInit)>=0);
        assertTrue(m.getCreatedAt().compareTo(dEnd)<=0);
        assertNull(m.getReadAt());
        
        Date dInit2 = new Date();
        m.read();
        Date dEnd2 = new Date();
        assertEquals(pet1_contractId, m.getContractId());
        assertEquals(MessageType.FRIEND_NEAR, m.getType());
        assertTrue(m.getCreatedAt().compareTo(dInit)>=0);
        assertTrue(m.getCreatedAt().compareTo(dEnd)<=0);
        assertTrue(m.getReadAt().compareTo(dInit2)>=0);
        assertTrue(m.getReadAt().compareTo(dEnd2)<=0);
    }       
    
    @Test
    public void isUnreadMessage() {
        PetTracker tracker = new PetTracker();
        
        // Check that initially the list of messages is empty
        assertNotNull(tracker.getMessages());
        assertEquals(0, (int)tracker.getMessages().size());
                
        // Add a new contract
        tracker.addContract(pet1_contractId, pet1_start, pet1_end, pet1_name, pet1_allowFriends);
        
        // Send a message
        Date dInit = new Date();
        tracker.sendMessage(pet1_contractId, MessageType.FRIEND_NEAR);
        Date dEnd = new Date();
        
        assertNotNull(tracker.getMessages());
        assertEquals(1, (int)tracker.getMessages().size());
        
        Message m = tracker.getMessages().get(0);
        assertEquals(pet1_contractId, m.getContractId());
        assertEquals(MessageType.FRIEND_NEAR, m.getType());
        assertTrue(m.getCreatedAt().compareTo(dInit)>=0);
        assertTrue(m.getCreatedAt().compareTo(dEnd)<=0);
        assertNull(m.getReadAt());
        
        assertTrue(m.isUnreaded());
        
        Date dInit2 = new Date();
        m.read();
        Date dEnd2 = new Date();
        assertEquals(pet1_contractId, m.getContractId());
        assertEquals(MessageType.FRIEND_NEAR, m.getType());
        assertTrue(m.getCreatedAt().compareTo(dInit)>=0);
        assertTrue(m.getCreatedAt().compareTo(dEnd)<=0);
        assertTrue(m.getReadAt().compareTo(dInit2)>=0);
        assertTrue(m.getReadAt().compareTo(dEnd2)<=0);
        
        assertFalse(m.isUnreaded());
    }       
    
    @Test
    public void getUnreadMessages() {
        PetTracker tracker = new PetTracker();
        
        // Check that initially the list of messages is empty
        assertNotNull(tracker.getMessages());
        assertEquals(0, (int)tracker.getMessages().size());
                
        // Add a new contract
        tracker.addContract(pet1_contractId, pet1_start, pet1_end, pet1_name, pet1_allowFriends);
        
        Pet device = tracker.getClientDevice(pet1_contractId);
        List<Message> unreadMessages = device.getUnreadMessages();
        
        assertNotNull(unreadMessages);
        assertEquals(0, (int)unreadMessages.size());
        
        // Send a message        
        tracker.sendMessage(pet1_contractId, MessageType.FRIEND_NEAR);
        
        unreadMessages = device.getUnreadMessages();        
        assertNotNull(unreadMessages);
        assertEquals(1, (int)unreadMessages.size());
        
        Message m = unreadMessages.get(0);        
        m.read();
        
        unreadMessages = device.getUnreadMessages();        
        assertNotNull(unreadMessages);
        assertEquals(0, (int)unreadMessages.size());        
    }       
    
    @Test
    public void sendMessageInvalidContract() {
        PetTracker tracker = new PetTracker();
        
        // Check that initially the list of messages is empty
        assertNotNull(tracker.getMessages());
        assertEquals(0, (int)tracker.getMessages().size());
        
        // Send a message
        tracker.sendMessage(pet1_contractId, MessageType.FRIEND_NEAR);
                
        assertNotNull(tracker.getMessages());
        assertEquals(0, (int)tracker.getMessages().size());        
    }
    
    @Test
    public void deleteMessages() {
        PetTracker tracker = new PetTracker();
        
        // Check that initially the list of messages is empty
        assertNotNull(tracker.getMessages());
        assertEquals(0, (int)tracker.getMessages().size());
                
        // Add a new contract
        tracker.addContract(pet1_contractId, pet1_start, pet1_end, pet1_name, pet1_allowFriends);
        
        // Send a message        
        tracker.sendMessage(pet1_contractId, MessageType.FRIEND_NEAR);
                
        assertNotNull(tracker.getMessages());
        assertEquals(1, (int)tracker.getMessages().size());
        
        tracker.delContract(pet1_contractId);
        assertNotNull(tracker.getMessages());
        assertEquals(0, (int)tracker.getMessages().size());        
    }
}
