package webLoadTest.request;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class PackageInfo {

    public static final String PACKAGE_NAME = PackageInfo.class.getPackage().getName();


}
