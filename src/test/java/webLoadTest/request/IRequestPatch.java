package webLoadTest.request;

import io.restassured.response.Response;

import java.util.Map;

public interface IRequestPatch {

	public Response sendRequest(Map<String, String> Body, String ETagHeader, Integer questionSetId);

	//void assertFields(Response res);
	void assertFields(Response res, String checkStatus);

	void saveToModel(Response res);

}
