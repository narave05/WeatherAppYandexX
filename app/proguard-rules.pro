# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions

-dontwarn okio.**

# Proguard configuration for Jackson 2.x (fasterxml package instead of codehaus package)

-keep class com.fasterxml.jackson.databind.ObjectMapper {
    public <methods>;
    protected <methods>;
}
-keep class com.fasterxml.jackson.databind.ObjectWriter {
    public ** writeValueAsString(**);
}
-keepattributes *Annotation*,EnclosingMethod,Signature
-keepnames class com.fasterxml.jackson.** { *; }

-dontwarn com.fasterxml.jackson.databind.**
-dontwarn com.fasterxml.jackson.databind.PropertyNamingStrategy$LowerCaseWithUnderscoresStrategy

-keep class org.codehaus.** { *; }
-keep class com.fasterxml.jackson.annotation.** { *; }
-keepclassmembers public final enum org.codehaus.jackson.annotate.JsonAutoDetect$Visibility {
 public static final org.codehaus.jackson.annotate.JsonAutoDetect$Visibility *; }
-keepclassmembers public class com.fasterxml.jackson.databind.PropertyNamingStrategy$LowerCaseWithUnderscoresStrategy {
    public <init>(...); }

#Yelp Serializable objects
-keep class com.yelp.clientlib.entities.*$* {
    *;
}
-keep class com.chog0.weatherappyandexschool.model.** { *; }

-printmapping build/outputs/mapping/release/mapping.txt