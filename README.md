[![Release](https://img.shields.io/github/release/mine-k-projects/ckan-java-api.svg?label=JitPack)](https://jitpack.io/#mine-k-projects/ckan-java-api) 

ckan-java-api
=============
A Java client for the Ckan Action API

## Gradle
Step 1. Add the JitPack repository to your build file
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
```
Step 2. Add the dependency
```groovy
implementation("com.github.mine-k-projects:ckan-java-api:{version}")
```

## Maven
Step 1. Add the JitPack repository to your build file
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
Step 2. Add the dependency in the form
```xml
<dependency>
    <groupId>com.github.mine-k-projects</groupId>
    <artifactId>ckan-java-api</artifactId>
    <version>{version}</version>
</dependency>
```

## Change Logs

### v1.0.0.RELEASE

ckan-java-api v1.0.0.RELEASE Available

## Ckan Action API compatibility
[ckan.logic.action.get](https://docs.ckan.org/en/2.8/api/#module-ckan.logic.action.get) - 100%  
[ckan.logic.action.create](https://docs.ckan.org/en/2.8/api/#module-ckan.logic.action.create) - 100%  
[ckan.logic.action.update](https://docs.ckan.org/en/2.8/api/#module-ckan.logic.action.update) - 100%  
[ckan.logic.action.patch](https://docs.ckan.org/en/2.8/api/#ckan-logic-action-patch) - 100%  
[ckan.logic.action.delete](https://docs.ckan.org/en/2.8/api/#module-ckan.logic.action.delete) - 100%  

## USAGE
```java
CkanClientFactory factory = new CkanClientFactory("baseUrl", "apiKey");
CkanClient client = factory.build();

ActivityService activityService = client.activityService();
AutocompleteService autocompleteService = client.autocompleteService();
DatasetService datasetService = client.datasetService();
GroupService groupService = client.groupService();
MemberService memberService = client.memberService();
RevisionService revisionService = client.revisionService();
SiteService siteService = client.siteService();
TagService tagService = client.tagService();
UserService userService = client.userService();
```

# Ckan API guide
https://docs.ckan.org/en/2.8/api/index.html
