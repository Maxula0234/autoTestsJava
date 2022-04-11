package api;

import api.dto.request.user.CreateUser;
import api.dto.response.User;
import api.services.UserApiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class UserTest extends BaseApiTest {

    UserApiService userApiService = new UserApiService();

    @Test
    @DisplayName("Создание клиента клиента - позитивный")
    public void createClient() {
        //Проверим создание клиента
        String nameNewClient = "TestovichTest" + new Random().nextInt(1123);

        User user = User.builder()
                .id(new BigDecimal(0))
                .username(nameNewClient)
                .firstName(nameNewClient)
                .lastName("Hor")
                .email("test@test.ru")
                .password("123")
                .phone("79995551122")
                .userStatus(new BigDecimal(0))
                .build();

        CreateUser createUser = userApiService.createUser(user);
        User getNewUser = userApiService.getUser(nameNewClient);

        assertAll(
                () -> assertThat(getNewUser.getId()).isEqualTo(Integer.parseInt(createUser.getMessage())),
                () -> assertThat(getNewUser.getUsername()).isEqualTo(nameNewClient)
        );
    }


    @Test
    @DisplayName("Создание клиента - негативный")
    public void createClientNegative() {
        //Передадим некорректный json запрос
        //Проверим, что клиент не создался

        User user = User.builder()
                .id(new BigDecimal(0))
                .lastName("Hor")
                .email("test@test.ru")
                .password("123")
                .phone("79995551122")
                .userStatus(new BigDecimal(0))
                .build();

        CreateUser createUser = userApiService.createUser(user);

        assertThat(createUser.getMessage()).as("Получен идентификатор клиента").isEqualTo("0");
    }
}
