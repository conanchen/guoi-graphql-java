# Introduction
This library defines the common graphql types/enums/scalars for guoi graphql projects
-  scalar DateTime
-  scalar Money
-  scalar URL
-  enum CropRegion
-  enum CurrencyCode
-  enum WeightUnit
-  type Address
-  type Attribute
-  type Image
-  type PageInfo
-  type UserError
-  input AddressInput
-  input AttributeInput

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
@Import(ZGraphQLScalarsAutoConfiguration.class)
public class ZYourGraphqlConfiguration {
    //...
}    
```
