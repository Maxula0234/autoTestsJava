package api;

import api.dto.CreateUser;
import api.dto.User;
import api.services.UserApiService;
import org.junit.jupiter.api.Test;

public class PetStoreTest {

    UserApiService userApiService = new UserApiService();

    @Test
    public void firstTets() {
        User user = User.builder()
                .mId(110L)
                .mFirstName("Maks")
                .mLastName("Hor")
                .mEmail("test@test.ru")
                .mPassword("123")
                .mPhone("79995551122")
                .mUserStatus(12L)
                .build();

        CreateUser user1 = userApiService.createUser(user);

    }
}
