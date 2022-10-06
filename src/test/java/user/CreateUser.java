package user;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import user.creatUser.CreateRequestBody;
import user.creatUser.Response.CreateUserResponse;
import user.creatUser.UsersClient;

import java.util.UUID;

public class CreateUser {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient  = new UsersClient();
    }


    @Test
    public void createMaleUser(){


        //Arrange
        String email = String.format("%s@gmail.com",UUID.randomUUID());

        //Act
        CreateRequestBody createRequestBody=CreateRequestBody.builder()
                .name("Akash Salunke").email(email).gender("male").status("inactive")
                .build();

        CreateUserResponse createUserResponse = usersClient.getAuthorization(createRequestBody);

        //Assert

        createUserResponse.assertUserDetails(createRequestBody);

    }

    @Test
    public void createFemaleUser(){

        //Arrange
        String email = String.format("%s@gmail.com",UUID.randomUUID());


        //Act

        CreateRequestBody createRequestBody=CreateRequestBody.builder()
                .name("Aditi rao").email(email).gender("female").status("inactive")
                .build();

        CreateUserResponse createUserResponse = usersClient.getAuthorization(createRequestBody);


        //Assert

        createUserResponse.assertUserDetails(createRequestBody);
    }







}
