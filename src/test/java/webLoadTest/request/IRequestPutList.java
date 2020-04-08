package webLoadTest.request;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

public interface IRequestPutList {

	public Response sendRequest(List<HashMap<String, String>> params);

	void assertFields(Response res, String checkStatus);
	void saveToModel(Response res);

}
