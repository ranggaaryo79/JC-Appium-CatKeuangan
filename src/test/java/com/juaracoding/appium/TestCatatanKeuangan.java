package com.juaracoding.appium;

import com.juaracoding.appium.pages.CatatanKeuangan;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class TestCatatanKeuangan {

    private static AndroidDriver<MobileElement> driver;
    private CatatanKeuangan catatanKeuangan;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "21081111RG");
        capabilities.setCapability("uuid", "haiv9ds8wkvkjr55");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("appPackage", "com.chad.financialrecord");
        capabilities.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @BeforeMethod
    public void pageObject() {
        catatanKeuangan = new CatatanKeuangan(driver);
    }

    @Test
    public void testExtence() {
        catatanKeuangan.Expense();

        Assert.assertEquals(catatanKeuangan.getTxtResultExpense(), "12.000.000");
        Assert.assertEquals(catatanKeuangan.getTxtResultName(), "Pajak");
        System.out.println("Pengeluaran : ");
        System.out.println("Amount = "+catatanKeuangan.getTxtResultExpense());
        System.out.println("Category = "+catatanKeuangan.getTxtResultName());

    }

    @Test
    public void testIncome() {
        catatanKeuangan.Income();
        Assert.assertEquals(catatanKeuangan.getTxtResultIncome(), "22.000.000");
        Assert.assertEquals(catatanKeuangan.getTxtResultBalance(), "10.000.000");
        Assert.assertEquals(catatanKeuangan.getTxtResultName(), "Gaji");
        System.out.println("Pemasukan : ");
        System.out.println("Amount " + catatanKeuangan.getTxtResultIncome());
        System.out.println("Category = "+catatanKeuangan.getTxtResultName());
        System.out.println("Sisa Saldo = "+catatanKeuangan.getTxtResultBalance());

    }

    @AfterClass
    public void closeApp() {
        driver.quit();
    }

}
