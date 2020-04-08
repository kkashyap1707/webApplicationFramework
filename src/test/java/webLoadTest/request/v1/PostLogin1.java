package webLoadTest.request.v1;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.response.Response;
import webLoadTest.request.IRequestPostNew;
import webLoadTest.utilities.RequestUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PostLogin1 implements IRequestPostNew {

	static List<String> list = new ArrayList<String>();

	public Response sendRequest(Map body) {

		Gson gson = new Gson();


		Response res = RestAssured
				.given()
				.config(RestAssured.config().logConfig(new LogConfig(RequestUtil.requestCapture, true)))
				.auth()
				.preemptive()
				.basic("ttn_qa","123456@allyo")
				.urlEncodingEnabled(true)
				.contentType("application/json")
				.header("Client-key","allyo")
				.header("employer-identifier","qa_test41")
				/*.header("Content-Type", "application/json")*/
				.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
				.log().all()
				.when()
				.body(body)
				.post("https://services-staging.allyo.com/upload/v1/requisition/");


		return res;
	}


	public void saveToModel(Response res) {

	}

	public void assertFields(Response res, String checkStatus) {

		if(checkStatus != "No"){
			RequestUtil.appendResponseCode200(res);
		}
	}

}