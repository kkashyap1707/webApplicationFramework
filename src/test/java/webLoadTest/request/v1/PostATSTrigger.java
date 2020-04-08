package webLoadTest.request.v1;

import io.restassured.response.Response;
import webLoadTest.request.IRequestPostNew;
import webLoadTest.utilities.GlobalVars;
import webLoadTest.utilities.RequestUtil;

import java.util.Map;


public class PostATSTrigger implements IRequestPostNew {

    public Response sendRequest(Map body) {
        //https://services-staging.allyo.com/upload/automation/trigger_ats_job

        return 	RequestUtil.createPostATSTriggerRequest(body, GlobalVars.BASE_URL,"/","upload/automation/trigger_ats_job");
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
