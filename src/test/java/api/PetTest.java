package api;

import api.dto.request.pet.Category;
import api.dto.request.pet.Pet;
import api.dto.request.pet.TagsItem;
import api.services.PetApiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;


public class PetTest extends BaseApiTest {
    PetApiService petApiService = new PetApiService();

    @Test
    @DisplayName("Создадим питомца")
    public void checkCreatePet() {
        Category category = Category.builder()
                .id(0)
                .name("DOG")
                .build();

        TagsItem tag = TagsItem.builder()
                .id(0)
                .name("")
                .build();

        Pet pet = Pet.builder()
                .id(new BigDecimal(0))
                .category(category)
                .name("Reks")
                .photoUrls(List.of(""))
                .tags(List.of(tag))
                .status("available")
                .build();

        Pet pet1 = petApiService.postPet(pet);
    }
}
