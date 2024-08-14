package com.udemy.backendninja.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.udemy.backendninja.component.ContactConverter;
import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.repository.ContactRepository;

public class ContactServiceImplTests {

    @Mock
    private ContactRepository contactRepository;

    @Mock
    private ContactConverter contactConverter;

    @InjectMocks
    private ContactServiceImpl contactService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddContact() {
        // Test adding a contact with valid data
        // Arrange
        ContactModel contactModel = new ContactModel(1, "John", "Doe", "1234567890", "New York");
        Contact contact = new Contact(1, "John", "Doe", "1234567890", "New York");

        when(contactConverter.convertContactModel2Contact(contactModel)).thenReturn(contact);
        when(contactRepository.save(contact)).thenReturn(contact);
        when(contactConverter.convertContact2ContactModel(contact)).thenReturn(contactModel);

        // Act
        ContactModel result = contactService.addContact(contactModel);

        // Assert
        assertEquals(contactModel, result);
        verify(contactRepository, times(1)).save(contact);  
        
    }

    @Test
    void testFindContactById() {
        // Arrange
        int id = 1;
        Contact contact = new Contact(id, "John", "Doe", "1234567890", "New York");

        when(contactRepository.findById(id)).thenReturn(contact);

        // Act
        Contact result = contactService.findContactById(id);

        // Assert
        assertEquals(contact, result);
        verify(contactRepository, times(1)).findById(id);
    }

    @Test
    void testFindContactByIdModel() {
                // Arrange
        int id = 1;
        Contact contact = new Contact(id, "John", "Doe", "1234567890", "New York");
        ContactModel contactModel = new ContactModel(id, "John", "Doe", "1234567890", "New York");

        when(contactRepository.findById(id)).thenReturn(contact);
        when(contactConverter.convertContact2ContactModel(contact)).thenReturn(contactModel);

        // Act
        ContactModel result = contactService.findContactByIdModel(id);

        // Assert
        assertEquals(contactModel, result);
        verify(contactRepository, times(1)).findById(id);
        verify(contactConverter, times(1)).convertContact2ContactModel(contact);
    }

    @Test
    void testListAllContacts() {
                // Arrange
        Contact contact1 = new Contact(1, "John", "Doe", "1234567890", "New York");
        Contact contact2 = new Contact(2, "Jane", "Doe", "0987654321", "Los Angeles");
        List<Contact> contacts = Arrays.asList(contact1, contact2);

        ContactModel contactModel1 = new ContactModel(1, "John", "Doe", "1234567890", "New York");
        ContactModel contactModel2 = new ContactModel(2, "Jane", "Doe", "0987654321", "Los Angeles");
        List<ContactModel> contactModels = Arrays.asList(contactModel1, contactModel2);

        when(contactRepository.findAll()).thenReturn(contacts);
        when(contactConverter.convertContact2ContactModel(contact1)).thenReturn(contactModel1);
        when(contactConverter.convertContact2ContactModel(contact2)).thenReturn(contactModel2);

        // Act
        List<ContactModel> result = contactService.listAllContacts();

        // Assert
        assertEquals(contactModels, result);
        verify(contactRepository, times(1)).findAll();
        
    }

    @Test
    void testRemoveContact() {
        // Arrange
        int id = 1;
        Contact contact = new Contact(id, "John", "Doe", "1234567890", "New York");

        

        when(contactRepository.findById(id)).thenReturn(contact);

        // Act
        contactService.removeContact(id);

        // Assert
        verify(contactRepository, times(1)).findById(id);
        verify(contactRepository, times(1)).delete(contact);    
    }

}
