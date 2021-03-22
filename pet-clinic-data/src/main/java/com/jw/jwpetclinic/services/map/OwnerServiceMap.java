package com.jw.jwpetclinic.services.map;

import com.jw.jwpetclinic.model.Owner;
import com.jw.jwpetclinic.model.Pet;
import com.jw.jwpetclinic.services.OwnerService;
import com.jw.jwpetclinic.services.PetService;
import com.jw.jwpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractServiceMap<Owner> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner save(Owner owner) {
        if (owner == null) {
            throw new IllegalArgumentException("Owner cannot be null.");
        } else if (owner.getId() == null) {
            owner.setId(getNextId());
        }
        savePets(owner);

        return super.save(owner);

    }

    private void savePets(Owner owner) {
        if (owner.getPets() != null) {
            owner.getPets().forEach(pet -> {
                if (pet.getPetType() != null) {
                    if (pet.getPetType().getId() == null) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                } else {
                    throw new RuntimeException("Pet Type is required");
                }

                if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        }
    }
}
