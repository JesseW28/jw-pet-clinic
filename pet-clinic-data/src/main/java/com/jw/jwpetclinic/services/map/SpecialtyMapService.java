package com.jw.jwpetclinic.services.map;

import com.jw.jwpetclinic.model.Specialty;
import com.jw.jwpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialtyMapService extends AbstractMapService<Specialty> implements SpecialtyService {

}
