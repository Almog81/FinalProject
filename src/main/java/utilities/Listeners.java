package utilities;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {
    public void onStart(ITestContext execution) {
        System.out.println("---------------------- Starting Execution ------------------");
    }

    public void onFinish(ITestContext execution) {
        System.out.println("---------------------- Ending Execution ------------------");
    }

    public void onTestStart(ITestResult test) {
        System.out.println("---------------------- " + test.getMethod().getDescription() + " Started ------------------");
        if (!PlatformName.equalsIgnoreCase("api")) {
            //Start Recording
            try {
                MonteScreenRecorder.startRecord(test.getName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onTestSuccess(ITestResult test) {
        System.out.println("---------------------- " + test.getMethod().getDescription() + " Passed ------------------");
        if (!PlatformName.equalsIgnoreCase("api")) {
            //Stop Recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


            //Delete File
            File file = new File("./test-recordings/"+ test.getName()+".avi");
            if (file.delete())
                System.out.println("File Deleted Successfully");
            else
                System.out.println("Failed to  Deleted File");
        }
    }

    public void onTestFailure(ITestResult test) {
        System.out.println("---------------------- " + test.getMethod().getDescription() + " Failed ------------------");
        if (!PlatformName.equalsIgnoreCase("api")){
            saveScreenshot();

            //Stop Recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
    }

    public void onTestSkipped(ITestResult test) {
        System.out.println("---------------------- Skipping " + test.getMethod().getDescription() + " ------------------");
    }

//    @Attachment(value = "Page Screen-Shot",type = "image/png")
//    public byte[] saveScreenshot(){
//        System.out.println("Start Screenshot");
//        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//    }

}
