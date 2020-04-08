package webLoadTest.webLoadTest;

import lombok.NoArgsConstructor;
import webLoadTest.request.*;

@NoArgsConstructor
public class RequestFactory {

    public static IRequestGet createGetRequest(String version, String className) {

        try {
            String fullyQualifiedName = new StringBuilder()
                    .append(PackageInfo.PACKAGE_NAME)
                    .append(".")
                    .append(version)
                    .append(".")
                    .append(className)
                    .toString();
            return (IRequestGet) Class.forName(fullyQualifiedName).getConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }


    public static IRequestPostNew createPostNewRequest(String version, String className) {
        try {
            String fullyQualifiedPostName = new StringBuilder()
                    .append(PackageInfo.PACKAGE_NAME)
                    .append(".")
                    .append(version)
                    .append(".")
                    .append(className)
                    .toString();
            return (IRequestPostNew) Class.forName(fullyQualifiedPostName).getConstructor().newInstance();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static IRequestDelete createDeleteRequest(String version, String className) {
        try {
            String fullyQualifiedPostName = new StringBuilder()
                    .append(PackageInfo.PACKAGE_NAME)
                    .append(".")
                    .append(version)
                    .append(".")
                    .append(className)
                    .toString();
            return (IRequestDelete) Class.forName(fullyQualifiedPostName).getConstructor().newInstance();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static IRequestPatch createPatchNewRequest(String version, String className) {
        try {
            String fullyQualifiedPatchName = new StringBuilder()
                    .append(PackageInfo.PACKAGE_NAME)
                    .append(".")
                    .append(version)
                    .append(".")
                    .append(className)
                    .toString();
            return (IRequestPatch) Class.forName(fullyQualifiedPatchName).getConstructor().newInstance();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static IRequestPostForm createPostFormRequest(String version, String className) {
        try {
            String fullyQualifiedPostName = new StringBuilder()
                    .append(PackageInfo.PACKAGE_NAME)
                    .append(".")
                    .append(version)
                    .append(".")
                    .append(className)
                    .toString();
            return (IRequestPostForm) Class.forName(fullyQualifiedPostName).getConstructor().newInstance();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static IRequestPutList createPutRequestList(String version, String className) {
        try {
            String fullyQualifiedPostName = new StringBuilder()
                    .append(PackageInfo.PACKAGE_NAME)
                    .append(".")
                    .append(version)
                    .append(".")
                    .append(className)
                    .toString();
            return (IRequestPutList) Class.forName(fullyQualifiedPostName).getConstructor().newInstance();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static IRequestPostList createPostRequestList(String version, String className) {
        try {
            String fullyQualifiedPostName = new StringBuilder()
                    .append(PackageInfo.PACKAGE_NAME)
                    .append(".")
                    .append(version)
                    .append(".")
                    .append(className)
                    .toString();
            return (IRequestPostList) Class.forName(fullyQualifiedPostName).getConstructor().newInstance();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static IRequestPostJSON createPostRequestJSON(String version, String className) {
        try {
            String fullyQualifiedPostName = new StringBuilder()
                    .append(PackageInfo.PACKAGE_NAME)
                    .append(".")
                    .append(version)
                    .append(".")
                    .append(className)
                    .toString();
            return (IRequestPostJSON) Class.forName(fullyQualifiedPostName).getConstructor().newInstance();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static IRequestPut createPutRequest(String version, String className) {
        try {
            String fullyQualifiedPostName = new StringBuilder()
                    .append(PackageInfo.PACKAGE_NAME)
                    .append(".")
                    .append(version)
                    .append(".")
                    .append(className)
                    .toString();
            return (IRequestPut) Class.forName(fullyQualifiedPostName).getConstructor().newInstance();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static IRequestHead createHeadRequest(String version, String className) {

        System.out.println(">>>>>>>>>>>>>>PPPPPPPPPPPPPPPPPP>>>>>>>>>>>>>>"+PackageInfo.PACKAGE_NAME);
        try {
            String fullyQualifiedName = new StringBuilder()
                    .append(PackageInfo.PACKAGE_NAME)
                    .append(".")
                    .append(version)
                    .append(".")
                    .append(className)
                    .toString();
            return (IRequestHead) Class.forName(fullyQualifiedName).getConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }

}
