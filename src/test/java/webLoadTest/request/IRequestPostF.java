package webLoadTest.request;

import io.restassured.response.Response;

import java.util.Map;

public interface IRequestPostF {

	public Response formParams(Map<String, String> Body);

	//void assertFields(Response res);
	void assertFields(Response res, String checkStatus);

	void saveToModel(Response res);

}
