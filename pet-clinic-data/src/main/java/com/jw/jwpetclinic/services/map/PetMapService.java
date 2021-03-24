package com.jw.jwpetclinic.services.map;

import com.jw.jwpetclinic.model.Pet;
import com.jw.jwpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetMapService extends AbstractMapService<Pet> implements PetService {

}

