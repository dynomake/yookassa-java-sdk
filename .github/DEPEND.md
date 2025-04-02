## | `Yookassa Java SDK - Add as depend:`
Here is how to add this sdk depending on your project.
### | `Gradle`:
If you use Gradle with Groovy, then here is an example of adding dependencies:
```groovy
repositories {
    // other repositories
    maven {
        url = uri("https://maven.dynomake.space/releases")
    }
}

dependencies {
    // other depend
    implementation 'space.dynomake:yookassa-java-sdk:1.0.6'
}
```

### | `Maven`:

Repository:

```xml
<repository>
    <id>dynomake.space</id>
    <url>https://maven.dynomake.space/releases</url>
</repository>
```

Depend:

```xml

<dependency>
    <groupId>space.dynomake</groupId>
    <artifactId>yookassa-java-sdk</artifactId>
    <version>1.0.6</version>
</dependency>
```