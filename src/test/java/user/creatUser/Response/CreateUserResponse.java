package user.creatUser.Response;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import user.creatUser.CreateRequestBody;

@Getter
public class CreateUserResponse {

    @Setter
    private int statusCode;

    private String meta;
    private Data data;

    public void assertUserDetails(CreateRequestBody createRequestBody) {

        Assert.assertEquals(this.getStatusCode(),201);
        Assert.assertNotNull(this.getData().getId());

        Assert.assertEquals(createRequestBody.getEmail(),this.getData().getEmail());
        Assert.assertEquals(createRequestBody.getName(),this.getData().getName());
        Assert.assertEquals(createRequestBody.getStatus(),this.getData().getStatus());
    }

    @Getter
    public static class Data{
        private int id;
        private String name;
        private String email;
        private String gender;
        private String status;
    }


}
