package api.services;

import api.dto.request.pet.Pet;
import io.restassured.specification.RequestSpecification;

public class PetApiService extends BaseRestClient {
    private final String PET = "/pet";

    @Override
    public RequestSpecification jsonRequest() {
        return super.jsonRequest();
    }

    public Pet postPet(Pet pet) {
        return jsonRequest()
                .body(pet)
                .expect()
                .spec(getResponseSpecification())
                .when().post(PET)
                .as(Pet.class);
    }
}
