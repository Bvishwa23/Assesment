# SwagLabs Selenium Automation — IntelliJ IDEA Ready

## Requirements
- IntelliJ IDEA Community or Ultimate
- JDK 17 or newer (the Maven compiler target is Java 17)
- Google Chrome installed
- Internet access on the first Maven import so Maven can download dependencies

## Open in IntelliJ IDEA
1. Extract this ZIP to a normal folder (do not open the ZIP itself).
2. In IntelliJ, choose **File → Open** and select the extracted folder containing `pom.xml`.
3. If prompted, choose **Open as Project** / **Load Maven Project**.
4. Set **File → Project Structure → Project SDK** to JDK 17 or newer.
5. Wait until Maven finishes downloading dependencies.
6. Open `AllTests.xml`, right-click it, and choose **Run** to execute all five test classes.

## Run from IntelliJ Terminal
From the folder containing `pom.xml`:

```powershell
mvn clean test
```

Run with another browser (must be installed):

```powershell
mvn clean test -Dbrowser=edge
mvn clean test -Dbrowser=firefox
```

Run a specific TestNG suite:

```powershell
mvn clean test "-DsuiteXmlFile=smokeGrp.xml"
mvn clean test "-DsuiteXmlFile=FunctionalGrp.xml"
```

## HTML report
After a test run, open:

`target/surefire-reports/index.html`

If the report index is not created by your local Surefire version, open `target/surefire-reports/emailable-report.html` or generate the site report with:

```powershell
mvn surefire-report:report
```

## Test data and settings
- Browser/application settings: `src/main/resources/CommonData.properties`
- Excel test data: `src/test/resources/TestData_AllModules.xlsx`
- Page Objects: `src/main/java/objRepo/`
- Shared WebDriver setup: `src/main/java/genericUtility/BaseClass.java`
- Test classes: `src/test/java/`

## Important
The suite includes all test methods currently present in the five test classes. Test execution still depends on the current source test logic, the Excel sheet data, browser availability, and the SauceDemo website being reachable. This ZIP has not been runtime-verified in this environment because Maven is not installed here; please run it in IntelliJ and share the first error if one appears.
