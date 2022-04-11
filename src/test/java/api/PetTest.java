package api;

import api.dto.request.pet.Category;
import api.dto.request.pet.Pet;
import api.dto.request.pet.TagsItem;
import api.services.PetApiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class PetTest extends BaseApiTest {
    PetApiService petApiService = new PetApiService();

    @Test
    @DisplayName("Создадим питомца")
    public void checkCreatePet() {
        //Проверим создание питомца
        String name = "Ping";
        String nameCategory = "DOG";

        Category category = Category.builder()
                .id(new BigDecimal(0))
                .name(nameCategory)
                .build();

        TagsItem tag = TagsItem.builder()
                .id(new BigDecimal(0))
                .name("")
                .build();


        Pet pet = Pet.builder()
                .id(new BigDecimal(0))
                .category(category)
                .name(name)
                .status("available")
                .build();

        Pet pet1 = petApiService.createPet(pet);

        assertAll(
                () -> assertThat(pet1.getCategory().getName()).isEqualTo(nameCategory),
                () -> assertThat(pet.getName()).isEqualTo(name),
                () -> assertThat(pet1.getId()).isNotNull()
        );

    }

    @ParameterizedTest
    @DisplayName("Получим всех питомцев по статусу")
    @CsvSource({
            "available",
            "sold",
            "pending"
    })
    public void checkCreatePet2(String status) {
        //Проверим точку "Получение питомца по статусу"
        List<Pet> petByStatus = petApiService.findPetByStatus(status);

        assertThat(petByStatus).allSatisfy(pet -> assertThat(pet.getStatus()).isEqualTo(status));
    }
}
