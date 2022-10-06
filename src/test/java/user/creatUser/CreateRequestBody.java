package user.creatUser;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateRequestBody {

    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;



}
