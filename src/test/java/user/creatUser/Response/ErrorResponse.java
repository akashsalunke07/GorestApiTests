package user.creatUser.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ErrorResponse{

	private String meta;

	@JsonProperty("data")
	private List<Data> errorResponse;

	@Setter
	private int statusCode;


	@Getter
	public static class Data {

		private String field;
		private String message;

	}

		public void hasErrorResponse(String field, String massage) {
		int size = errorResponse.stream()
				.filter(errorResponseItem -> errorResponseItem.getField().equals(field))
				.filter(errorResponseItem -> errorResponseItem.getMessage().equals(massage))
				.collect(Collectors.toList())
				.size();

		Assert.assertEquals(size,1);
	}
}