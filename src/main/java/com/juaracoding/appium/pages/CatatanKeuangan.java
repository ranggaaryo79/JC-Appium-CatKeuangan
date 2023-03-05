package com.juaracoding.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class CatatanKeuangan {
    public AndroidDriver<MobileElement> driver;

    public CatatanKeuangan(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Locator
//	By btnSatu = By.id("com.android.calculator2:id/digit_1");
//	By btnDua = By.id("com.android.calculator2:id/digit_2");
//	By btnTambah = By.id("com.android.calculator2:id/op_add");
//	By btnSamaDengan = By.id("com.android.calculator2:id/eq");
//	By hasil = By.id("com.android.calculator2:id/result");
//	/* web: xpath = //taghtml[contains(@attr, value)] */
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement permissionAllow;
    @AndroidFindBy(id = "android:id/button2")
    private MobileElement permissionDrive;
    @AndroidFindBy(id = "com.chad.financialrecord:id/fabMenu")
    private MobileElement btnAdd;
    @AndroidFindBy(id = "com.chad.financialrecord:id/spCategory")
    private MobileElement btnCategory;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Pajak\")")
    private MobileElement selectCategoryExtence;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Gaji\")")
    private MobileElement selectCategoryIncome;
    @AndroidFindBy(id = "com.chad.financialrecord:id/etAmount")
    private MobileElement inputAmount;
    @AndroidFindBy(id = "com.chad.financialrecord:id/etNote")
    private MobileElement inputNotes;

    @AndroidFindBy(id = "com.chad.financialrecord:id/btnIncome")
    private MobileElement btnIncome;
    @AndroidFindBy(id = "com.chad.financialrecord:id/btSave")
    private MobileElement btnSave;
    @AndroidFindBy(id = "com.chad.financialrecord:id/tvIncome")
    private MobileElement resultIncome;
    @AndroidFindBy(id = "com.chad.financialrecord:id/tvExpense")
    private MobileElement resultExpense;
    @AndroidFindBy(id = "com.chad.financialrecord:id/tvBalance")
    private MobileElement resultBalance;
    @AndroidFindBy(id = "com.chad.financialrecord:id/tvName")
    private MobileElement resultName;


    public void Expense() {
        permissionAllow.click();
        permissionDrive.click();
        btnAdd.click();
        btnCategory.click();
        selectCategoryExtence.click();
        inputAmount.sendKeys("12000000");
        inputNotes.sendKeys("Pajak Mobil");
        btnSave.click();
    }

    public void Income() {
        btnAdd.click();
        btnIncome.click();
        btnCategory.click();
        selectCategoryIncome.click();
        inputAmount.sendKeys("22000000");
        inputNotes.sendKeys("Gaji Pokok");
        btnSave.click();
    }


    public String getTxtResultIncome() {
        return resultIncome.getText();
    }

    public String getTxtResultName() {
        return resultName.getText();
    }

    public String getTxtResultExpense() {
        return resultExpense.getText();
    }

    public String getTxtResultBalance() {
        return resultBalance.getText();
    }

}
