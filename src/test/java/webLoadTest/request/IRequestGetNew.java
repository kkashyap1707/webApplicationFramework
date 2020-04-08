package webLoadTest.request;



import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;


public interface IRequestGetNew {

	Response sendRequest(List<HashMap<String, String>> params);
	void saveToModel(Response res);
	void assertFields(Response res, String checkStatus);




}
