package webLoadTest.utilities;


import webLoadTest.test.TestBaseBrowser;

import java.io.FileReader;
import java.util.Properties;

public class Keywords extends TestBaseBrowser {


    public static void loadSheetValue() {

        Properties properties = new Properties();
        String fileName = TestBaseBrowser.env + "_GoogleSpreadsheet.properties";
        System.out.println(fileName);
        try {
            FileReader reader = new FileReader(fileName);
            properties.load(reader);

            //GlobalVars.SystemId    = properties.getProperty("SystemId").isEmpty()?properties.getProperty("SystemId"):"";
            GlobalVars.SystemId    = properties.getProperty("SystemId");
            GlobalVars.createdDate = properties.getProperty("createdDate");
            GlobalVars.updatedDate = properties.getProperty("updatedDate");
            GlobalVars.applyURL    = properties.getProperty("applyURL");
            GlobalVars.noOfPeople  = properties.getProperty("noOfPeople");
            GlobalVars.noOfPeopleNeededRemaining    = properties.getProperty("noOfPeopleNeededRemaining");
            GlobalVars.category                     = properties.getProperty("category");
            GlobalVars.additionalRequirements       = properties.getProperty("additionalRequirements");
            GlobalVars.additionalLicensesNotListed  = properties.getProperty("additionalLicensesNotListed");
            GlobalVars.employmentType  = properties.getProperty("employmentType");
            GlobalVars.jobFolderStatus = properties.getProperty("jobFolderStatus");
            GlobalVars.licensesCertification   = properties.getProperty("licensesCertification");
            GlobalVars.orientationLocation     = properties.getProperty("orientationLocation");
            GlobalVars.otherSpecialRequirements= properties.getProperty("otherSpecialRequirements");
            GlobalVars.physicalRequirements    = properties.getProperty("physicalRequirements");
            GlobalVars.positionId              = properties.getProperty("positionId");
            GlobalVars.postingTitle            = properties.getProperty("postingTitle");
            GlobalVars.winTeamPositionTitle    = properties.getProperty("winTeamPositionTitle");
            GlobalVars.requisitionId           = properties.getProperty("requisitionId");
            GlobalVars.securityClearance       = properties.getProperty("securityClearance");
            GlobalVars.shiftsAvailable         = properties.getProperty("shiftsAvailable");
            GlobalVars.hiringManagerSystemID   = properties.getProperty("hiringManagerSystemID");
            GlobalVars.hiringManageFullName    = properties.getProperty("hiringManageFullName");
            GlobalVars.hiringManagerEmail      = properties.getProperty("hiringManagerEmail");
            GlobalVars.hiringManagerPhone      = properties.getProperty("hiringManagerPhone");
            GlobalVars.hiringManagerAddress    = properties.getProperty("hiringManagerAddress");
            GlobalVars.hiringManagerLoginGroup = properties.getProperty("hiringManagerLoginGroup");
            GlobalVars.additionalBranchReviewRequired = properties.getProperty("additionalBranchReviewRequired");
            GlobalVars.additionalReqReviewerSystemId  = properties.getProperty("additionalReqReviewerSystemId");
            GlobalVars.additionalReqReviewerFullName  = properties.getProperty("additionalReqReviewerFullName");
            GlobalVars.additionalReqReviewerEmail     = properties.getProperty("additionalReqReviewerEmail");
            GlobalVars.additionalReqReviewerPhone     = properties.getProperty("additionalReqReviewerPhone");
            GlobalVars.additionalReqReviewerHomeAddress = properties.getProperty("additionalReqReviewerHomeAddress");
            GlobalVars.primaryRecruiterSystemID = properties.getProperty("primaryRecruiterSystemID");
            GlobalVars.primaryRecruiterFullName = properties.getProperty("primaryRecruiterFullName");
            GlobalVars.primaryRecruiterEmail    = properties.getProperty("primaryRecruiterEmail");
            GlobalVars.primaryRecruiterPhone    = properties.getProperty("primaryRecruiterPhone");
            GlobalVars.primaryRecruiterHomeAddress   = properties.getProperty("primaryRecruiterHomeAddress");
            GlobalVars.interviewLocationAddress      = properties.getProperty("interviewLocationAddress");
            GlobalVars.administrativeSupportSystemID = properties.getProperty("administrativeSupportSystemID");
            GlobalVars.administrativeSupportFullName = properties.getProperty("administrativeSupportFullName");
            GlobalVars.administrativeSupportEmail    = properties.getProperty("administrativeSupportEmail");
            GlobalVars.administrativeSupportPhone    = properties.getProperty("administrativeSupportPhone");
            GlobalVars.administrativeSupportHomeAddress= properties.getProperty("administrativeSupportHomeAddress");
            GlobalVars.postingLocationLocation   = properties.getProperty("postingLocationLocation");
            GlobalVars.postingLocationAddress    = properties.getProperty("postingLocationAddress");
            GlobalVars.postingLocationAddress2    = properties.getProperty("postingLocationAddress2");
            GlobalVars.postingLocationCity       = properties.getProperty("postingLocationCity");
            GlobalVars.postingLocationState      = properties.getProperty("postingLocationState");
            GlobalVars.postingLocationPostalCode = properties.getProperty("postingLocationPostalCode");
            GlobalVars.postingLocationCountry    = properties.getProperty("postingLocationCountry");
            GlobalVars.requisitionPriority       = properties.getProperty("requisitionPriority");
            GlobalVars.videoInterviewingPackage  = properties.getProperty("videoInterviewingPackage");
            GlobalVars.firstInterviewerSystemID  = properties.getProperty("firstInterviewerSystemID");
            GlobalVars.firstInterviewerFullName  = properties.getProperty("firstInterviewerFullName");
            GlobalVars.firstInterviewerEmail     = properties.getProperty("firstInterviewerEmail");
            GlobalVars.firstInterviewerPhone     = properties.getProperty("firstInterviewerPhone");
            GlobalVars.firstInterviewerHomeAddress = properties.getProperty("firstInterviewerHomeAddress");
            GlobalVars.preEmploymentRequirements   = properties.getProperty("preEmploymentRequirements");
            GlobalVars.additionalQualifications    = properties.getProperty("additionalQualifications");
            GlobalVars.jobOfficeAddress1           = properties.getProperty("jobOfficeAddress1");
            GlobalVars.jobOfficeAddress2     = properties.getProperty("jobOfficeAddress2");
            GlobalVars.jobOfficeAddressCity  = properties.getProperty("jobOfficeAddressCity");
            GlobalVars.jobOfficeAddressState = properties.getProperty("jobOfficeAddressState");
            GlobalVars.jobOfficeAddressZip   = properties.getProperty("jobOfficeAddressZip");
            GlobalVars.jobOfficeAddressLocationName= properties.getProperty("jobOfficeAddressLocationName");
            GlobalVars.jobOfficeAddressEmail = properties.getProperty("jobOfficeAddressEmail");
            GlobalVars.BranchOfficeLocationHireVueEnabled = properties.getProperty("BranchOfficeLocationHireVueEnabled");


        }catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void setURL(String env, String ver) {

        Properties properties = new Properties();
        String fileName = "application-" + TestBaseBrowser.env + ".properties";
        System.out.println(fileName);
        try {
            FileReader reader = new FileReader(fileName);
            properties.load(reader);

            /*
            GlobalVars.REMOTE_SSH_HOST = properties.getProperty("REMOTE_SSH_HOST");
            GlobalVars.REMOTE_SSH_PORT = Integer.parseInt(properties.getProperty("REMOTE_SSH_PORT"));

            GlobalVars.REMOTE_SSH_USERNAME = properties.getProperty("REMOTE_SSH_USERNAME");
            GlobalVars.REMOTE_SSH_PASSWORD = properties.getProperty("REMOTE_SSH_PASSWORD");
            GlobalVars.REMOTE_MYSQL_HOST = properties.getProperty("REMOTE_MYSQL_HOST");
            GlobalVars.REMOTE_MYSQL_PORT = Integer.parseInt(properties.getProperty("REMOTE_MYSQL_PORT"));
            GlobalVars.REMOTE_MYSQL_USERNAME = properties.getProperty("REMOTE_MYSQL_USERNAME");
            GlobalVars.REMOTE_MYSQL_PASSWORD = properties.getProperty("REMOTE_MYSQL_PASSWORD");
            */

            GlobalVars.EMAIL_ID = properties.getProperty("EMAIL_ID");


        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }



}
