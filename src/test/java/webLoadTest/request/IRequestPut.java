package webLoadTest.request;

import io.restassured.response.Response;

import java.util.Map;

public interface IRequestPut {

	public Response sendRequest(Map<String, String> body);

	void assertFields(Response res, String checkStatus);
	void saveToModel(Response res);

}
