package com.jw.jwpetclinic.services.map;

import com.jw.jwpetclinic.model.PetType;
import com.jw.jwpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractServiceMap<PetType> implements PetTypeService {
}
