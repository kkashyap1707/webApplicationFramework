package webLoadTest.request;

import io.restassured.response.Response;

public interface IRequestPostJSON {

	public Response sendRequest(String jsonStr);
	void assertFields(Response res, String checkStatus);
	void saveToModel(Response res);

}
