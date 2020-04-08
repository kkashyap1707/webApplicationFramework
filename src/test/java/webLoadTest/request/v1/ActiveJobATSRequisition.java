package webLoadTest.request.v1;

import io.restassured.response.Response;
import webLoadTest.request.IRequestPostList;
import webLoadTest.utilities.GlobalVars;
import webLoadTest.utilities.RequestUtil;

import java.util.HashMap;
import java.util.List;


public class ActiveJobATSRequisition implements IRequestPostList {

    public Response sendRequest(List<HashMap<String, String>> params) {

        return 	RequestUtil.createPostListRequest(params, GlobalVars.BASE_URL,"/","upload/v1/requisition/");
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
