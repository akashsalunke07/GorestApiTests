package integrationTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import user.creatUser.CreateRequestBody;
import user.creatUser.UsersClient;

import java.util.UUID;

public class UserTest {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient  = new UsersClient();
    }


    @Test
    public void shouldCreateAndGetUser(){


        //Arrange
        String email = String.format("%s@gmail.com",UUID.randomUUID());

        //Act
        CreateRequestBody createRequestBody = CreateRequestBody.builder()
                .name("Akash Salunke").email(email).gender("male").status("inactive")
                .build();

        int id = usersClient.getAuthorization(createRequestBody).getData().getId();

        //Assert

        //usersClient.getUserResponse(id).assertBody(createRequestBody);

    }








}
