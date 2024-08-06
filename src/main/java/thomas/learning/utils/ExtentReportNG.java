package thomas.learning.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {

  public  static ExtentReports extent;
  public static ExtentReports setupExtentReport(String path) {
    String nameFile = path.split("/")[2];
    String reportPath = System.getProperty("user.dir") + path + "/" + nameFile + ".html";

    ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);

    extent = new ExtentReports();
    extent.attachReporter(sparkReport);

    sparkReport.config().setDocumentTitle("DocumentTitle");
    sparkReport.config().setTheme(Theme.DARK);
    sparkReport.config().setReportName("ReportName");

    //extent.setSystemInfo("Executed on Environment: ", PropertiesOperations.getInstance().getProperty("url"));
    //extent.setSystemInfo("Executed on Browser: ", PropertiesOperations.getInstance().getProperty("browser"));
    extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
    extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));

    return extent;
  }

}
