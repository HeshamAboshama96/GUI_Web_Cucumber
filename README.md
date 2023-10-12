# Web GUI (Using Cucumber)

## What does it do?
This maven module shows you what a well-structured project that uses Cucumber features/steps along with a page object model / fluent design should look like.
<br/>Note that it is recommended to use the Cucumber approach only if your team is implementing a full BDD cycle, otherwise we recommend using the TestNG approach instead. If you decide to use Cucumber with [SHAFT_Engine](https://github.com/shafthq/SHAFT_ENGINE) keep exploring this maven module.

## How do I run it?
To execute this project follow these simple steps:
- From your right-hand maven menu, run ```Lifecycle > clean```
- Then run ```Lifecycle > test```
  (This will ensure that this test module is built and executed successfully without any errors.)
- The execution report will launch in your default browser once test execution is complete.
- Since this is a Cucumber project, note that you can also execute by pressing the green ```run``` button inside any of your feature files.
- You can also execute all your tests by running your ```CucumberTestRunner``` class.

## How do I explore it?
After checking out this project to your IDE, you should find this basic folder structure:
- ```pom.xml``` <br/>This is the main project object model file which houses the SHAFT_Engine version and some basic project configuration.
- ```src > main > java``` <br/>Here you will find your page object model classes, for every page there is a class. Note that if there are common elements between several pages (like a sticky menu or a footer) it is recommended to create separate classes for them without implementing a base page (inheritance) unless absolutely necessary and in alignment with basic SOLID principles.
- ```src > main > resources``` <br/>Here you will find the ```selenium4.yml``` file to launch your docker-compose selenium grid, along with your SHAFT_Engine ```*.properties``` files to manage all your settings. Pay attention to ```cucumber.properties``` since this is the file that you need to configure to be able to read your step definitions and features and glue them together.
- ```src > test > java``` <br/>Here you will find your ```Steps``` and your ```CucumberTestRunner``` classes. Feel free to add more steps, and note that the test runner will always run all your features unless you configure your properties file to apply specific filters or run specific tags.
- ```src > test > resources``` <br/>Here you will find the ```simpleJSON.json``` test data file to learn how you can externalize your test data with ease. You will also find your ```*.feature``` files where your project will be able to read and glue the steps automatically.
# A Template for using [SHAFT_Engine](https://github.com/shafthq/SHAFT_ENGINE)
<img src="https://github.com/ShaftHQ/SHAFT_ENGINE/raw/main/src/main/resources/images/shaft.png" alt="SHAFT_ENGINE" style="display:block; margin-left:auto; margin-right:auto;"/>

<a id="quick-start-guide"></a>
## I. Quick Start Guide 🏃
### Step 1: Setting up your project
- Click the blue button above that says "Use this template" > "Create a new repository"
- From your new repository click the blue button that says "<> Code" > "Open with GitHub Desktop"
- From your GitHub Desktop click the button that says "Open in JetBrains IntelliJ Idea Community Edition"
- With the latest SHAFT_Engine version, the engine will be able to configure itself in TestNG or JUnit mode automatically. You will not need to add any listeners anymore.
- If you're using Cucumber, due to a known issue with IntelliJ you need to edit your run configuration templates before running your feature files by following these steps:
  - Open 'Edit Run/Debug Configurations' dialog > Edit Configurations... > Edit configuration templates...
  - Select <b>Cucumber Java</b> > Program Arguments > and add this argument:
  <br/>`--plugin --plugin com.shaft.listeners.CucumberFeatureListener`
  - After saving the changes, remember to delete any old runs you may have triggered by mistake before adding the needed config.

### Step 2: Running some Tests
- Navigate to the module that you want to play with. For example ```GUI_Web```
- Navigate to any test class. For example ```src/test/java/TestPackage/TestClass.java```
- Press the green play button next to the class name to run the entire class, or next to a test method to run only that method.
- Test execution will begin, and you'll see the browser opening and the test running.
- The Test execution report will open automatically in your default web browser after the test run is completed.

<img src="https://github.com/allure-framework/allure2/raw/master/.github/allure-report-gif.gif" alt="Allure Report" style="display:block; margin-left:auto; margin-right:auto;"/>

## II. What's next?
### Configuration and User Guide
- Change the target browser, operating system, timeouts, and other configurations using the ⚙️ [Configuration Manager](https://ShaftHQ.github.io/SHAFT_ENGINE/).
- Learn more about using SHAFT_Engine from the 👤 [User Guide](https://ShaftHQ.github.io/SHAFT_Engine_Docusaurus/) and 📚 [Javadocs](https://ShaftHQ.github.io/SHAFT_ENGINE/apidocs/index.html).
- <b>Join</b> our ![GitHub Repo stars](https://img.shields.io/github/stars/shafthq/shaft_engine?logoColor=black&style=social) to get notified by email when a new release is pushed out.
- After upgrading your Engine it is sometimes recommended to delete the properties folder ```src\main\resources\properties``` and allow SHAFT to regenerate the defaults by running any test method.

### CI/CD & DevOps
- This template comes preloaded with some Selenium grid 4 powered CI/CD pipelines to get you started!
- Navigate to "Actions" and then select "Desktop Browser Tests" from the side menu
- Click "Run workflow" and confirm your choice.
- You will notice that the pipeline has started building, and you can download the execution reports once the execution is completed.

<img src="https://github.githubassets.com/images/modules/site/actions/pr-checks-final.png" alt="GitHub Actions" style="display:block; margin-left:auto; margin-right:auto;"/>


### Stop Reinventing the wheel! Start using SHAFT!
