package api.services;

import api.ParamNames;
import api.dto.request.pet.Pet;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class PetApiService extends BaseRestClient {
    private static final String PET = "/pet";
    private static final String PET_FIND_BY_STATUS = "/pet/findByStatus";

    @Override
    public RequestSpecification jsonRequest() {
        return super.jsonRequest();
    }

    public Pet createPet(Pet pet) {
        return jsonRequest()
                .body(pet)
                .expect()
                .spec(getResponseSpecification())
                .when().post(PET)
                .as(Pet.class);
    }

    public List<Pet> findPetByStatus(String status) {
        return jsonRequest()
                .param(ParamNames.STATUS,status)
                .expect()
                .spec(getResponseSpecification())
                .when().get(PET_FIND_BY_STATUS)
                .jsonPath().getList(".", Pet.class);
    }
}
