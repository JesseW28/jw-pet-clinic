package com.jw.jwpetclinic.services.jpa;

import com.jw.jwpetclinic.model.Owner;
import com.jw.jwpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class OwnerJpaServiceTest {

    public static final String LAST_NAME = "Smith";

    @Mock
    OwnerRepository repository;

    @InjectMocks
    OwnerJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(repository.findByLastName(any())).thenReturn(Optional.ofNullable(returnOwner));

        Owner smith = service.findByLastName(LAST_NAME).get();

        assertEquals(LAST_NAME, smith.getLastName());

        verify(repository).findByLastName(any());
    }

    @Test
    void findAll() {
        List<Owner> returnOwnerList = new ArrayList<>();
        returnOwnerList.add(Owner.builder().id(1L).build());
        returnOwnerList.add(Owner.builder().id(2L).build());

        when(repository.findAll()).thenReturn(returnOwnerList);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }


    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(repository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(repository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        //default is 1 times
        verify(repository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(repository).deleteById(anyLong());
    }
}
