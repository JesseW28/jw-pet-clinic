package com.jw.jwpetclinic.services.map;

import com.jw.jwpetclinic.model.Pet;
import com.jw.jwpetclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractServiceMap<Pet> implements PetService {

}

