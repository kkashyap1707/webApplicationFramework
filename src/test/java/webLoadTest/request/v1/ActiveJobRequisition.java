package webLoadTest.request.v1;

import io.restassured.response.Response;
import webLoadTest.request.IRequestPostNew;
import webLoadTest.utilities.GlobalVars;
import webLoadTest.utilities.RequestUtil;

import java.util.Map;


public class ActiveJobRequisition implements IRequestPostNew {

    public Response sendRequest(Map body) {

        return 	RequestUtil.createPostRequest(body, GlobalVars.BASE_URL,"/","upload/v1/requisition/");
    }

    public void saveToModel(Response res) {
       // GlobalVars.v1.getInterviewerModel_v1 = res.getBody().as(GetInterviewerModel_v1[].class);

    }

    public void assertFields(Response res, String checkStatus) {

        if(checkStatus != "No"){
            RequestUtil.appendResponseCode200(res);
        }

    }
}
