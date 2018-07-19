# Introduction
This library defines the common graphql types/enums/scalars for guoi graphql projects
-  scalar DateTime
-  scalar Money
-  scalar URL
-  enum CropRegion
-  enum CurrencyCode
-  enum WeightUnit
-  type Address
-  type AddressConnection
-  type AddressEdge
-  type Attribute
-  type Image
-  type ImageConnection
-  type ImageEdge
-  type PageInfo
-  type UserError
-  input AddressInput
-  input AttributeInput

> Refer to [ZGuoiCommonTypes.java](graphql-java-common/src/main/java/com/github/conanchen/guoi/graphql/types/ZGuoiCommonTypes.java) 
[ZGuoiCommonTypes.graphqls](graphql-java-common/src/main/resources/graphql/ZGuoiCommonTypes.graphqls)
etc.  for detail definitions.

# For JAVA Application 
## Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
	
## Step 2. Add the dependency

### Check build.log whether it pass the build
[https://jitpack.io/com/github/conanchen/guoi-graphql-java/master-SNAPSHOT/build.log](https://jitpack.io/com/github/conanchen/guoi-graphql-java/master-SNAPSHOT/build.log)
```angular2html
BUILD SUCCESSFUL in 5s
9 actionable tasks: 7 executed, 2 up-to-date
Looking for artifacts...
Picked up JAVA_TOOL_OPTIONS: -Dfile.encoding=UTF-8 -Djavax.xml.accessExternalSchema=all
Found artifact: guoi-graphql-java-common:graphql-java-common:0.0.1-SNAPSHOT
EXIT_CODE=0
2018-04-01T05:52:22.636014333Z
Exit code: 0

Build artifacts:
com.github.conanchen:guoi-graphql-java:master-add60ddc41-1
```
### Add Dependencies As Needed To Your build.gradle
```gradle
dependencies {
    compile 'com.github.conanchen:guoi-graphql-java:master-SNAPSHOT'
}
```
	
## Step 3. Import the library configuration into your project configuration to use the common scalars
```java
@Configuration
@Import(ZGuoiScalarsAutoConfiguration.class)
public class ZYourGraphqlConfiguration {
    //...
}    
```
## Step 4. include ZGuoiCommonTypes in your root query
```graphql
# The Root Query 
type Query {

  # ...
  
  zGuoiCommonTypes: ZGuoiCommonTypes
}

```
# GUOI Graphql API Design Guide
- Refer to [graph.cool Graphql API](https://www.graph.cool/docs/reference/graphql-api/overview-abogasd0go)
- Refer to [Customize GUOI Graphql API Design Guide](GUOI_GRAPHQL_API_DESIGN_GUIDE.md)
# DateTime支持的时间格式
```
//2018-05-31T14:20:12.894Z
DATE_FORMATTERS.add(DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.systemDefault()));
//2018-05-31T22:10:59.254
DATE_FORMATTERS.add(DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.systemDefault()));
//2018-05-31
DATE_FORMATTERS.add(DateTimeFormatter.ISO_LOCAL_DATE.withZone(ZoneId.systemDefault()));
//2018/05/31
DATE_FORMATTERS.add(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//2012/09/11 11:30
DATE_FORMATTERS.add(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//2012-09-11 11:30:00
DATE_FORMATTERS.add(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
```