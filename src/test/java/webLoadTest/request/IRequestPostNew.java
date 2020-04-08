package webLoadTest.request;

import io.restassured.response.Response;

import java.util.Map;

public interface IRequestPostNew {

	public Response sendRequest(Map<String, String> Body);
	void assertFields(Response res, String checkStatus);
	void saveToModel(Response res);

}
