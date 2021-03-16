package com.jw.jwpetclinic.services.map;

import com.jw.jwpetclinic.model.Owner;
import com.jw.jwpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
