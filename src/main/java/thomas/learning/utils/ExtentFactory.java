package thomas.learning.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentFactory {

  private static ExtentFactory instance = null;
  //factory design pattern --> define separate factory methods for creating objects and create objects by calling that methods
  ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

  //Singleton design Pattern
  //private constructor so that no one else can create object of this class
  private ExtentFactory() {

  }

  public static ExtentFactory getInstance() {

    if (instance == null) {
      instance = new ExtentFactory();
    }

    return instance;
  }

  public ExtentTest getExtent() {
    return extent.get();
  }

  public void setExtent(ExtentTest extentTestObject) {
    extent.set(extentTestObject);
  }

  public void removeExtentObject() {
    extent.remove();
  }

}
