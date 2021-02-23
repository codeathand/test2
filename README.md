# Preconditions

Internet connection

Windows 10

Page https://coinmarketcap.com/ is accessible

Github repository https://github.com/codeathand/test2

Eclipse IDE

TestNG for Eclipse

Chrome driver 88.0.4324.96 and compatible version of Chrome browser

Install Maven https://mkyong.com/maven/how-to-install-maven-in-windows/

Environment system variable MAVEN_HOME - path of Maven

Environment Path variable add %MAVEN_HOME%\bin

Cucumber Eclipse Plugin 1.0.0.202005150629

Natural 0.9 plugin

User is registered

# Install

Download from the Git repository https://github.com/codeathand/test1

Unpack archive

Import project in Eclipse File > Import

Find Maven > Existing Maven projects, click Next

Click Browse and select unpacked folder from the archive

Click Select All

Click Finish button

# Run the tests ECLIPSE Run as TestNG

In the project expand src/test/java

Expand testRunner package

Right click on RunTestNGTest.java

Find Run As and click TestNG Test

# Run the tests ECLIPSE Run as Cucumber Feature

In the project expand src/test/resources

Expand features folder

Right click on the Test2.feature

Find Run As and click Cucumber Feature or click Run Configurations, on the left panel find Cucumber Feature > feature, and click Run button

# Run the tests  POWERSHELL or TERMINAL

Go to the project folder

Type 

```
mvn clean install
```

for complete build or

```
mvn test
```

only for tests