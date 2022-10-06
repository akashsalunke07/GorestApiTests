
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import user.creatUser.CreateRequestBody;
import user.creatUser.Response.CreateUserResponse;
import user.creatUser.Response.ErrorResponse;
import user.creatUser.UsersClient;

public class CreateUserNegetiveTest {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient  = new UsersClient();
    }


    @Test
    public void shouldNotAllowInvalidEmail(){

        int id = 3271;
        String name = "Aditi rao";
        String email = "aditi.rao.11ling.org";
        String gender = "female";
        String status = "";

        CreateRequestBody createRequestBody=CreateRequestBody.builder()
                .id(id).name(name).email(email).gender(gender).status(status)
                .build();

        ErrorResponse userErrorResponse = new UsersClient().createUserErrorResponse(createRequestBody);

        //Assert
        Assert.assertEquals(userErrorResponse.getStatusCode(),422);
        userErrorResponse.hasErrorResponse("email","is invalid");


    }

}
