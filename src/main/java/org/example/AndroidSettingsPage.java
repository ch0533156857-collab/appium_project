package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AndroidSettingsPage {

    private final AndroidDriver mobileDriver;

    @AndroidFindBy(accessibility = "System")
    private WebElement systemBreadcrumb;

    @AndroidFindBy(accessibility = "Keyboard")
    private WebElement keyboardHeader;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[.//android.widget.TextView[@text='Keyboard']]")
    private WebElement keyboardSelectionLink;

    public AndroidSettingsPage(AndroidDriver driver) {
        this.mobileDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    public void scrollToSystemMenu() {
        // שימוש במפתח החדש שנתנו ב-Enum: SYSTEM_CORE
        String scrollCommand = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                + "new UiSelector().text(\"" + DeviceCategory.SYSTEM_CORE.getLabel() + "\"));";

        WebElement systemEntry = mobileDriver.findElement(AppiumBy.androidUIAutomator(scrollCommand));
        systemEntry.click();
    }

    public boolean isSystemMenuOpen() {
        return systemBreadcrumb.isDisplayed();
    }

    public void openKeyboardSettings() {
        keyboardSelectionLink.click();
    }

    public boolean isKeyboardConfigDisplayed() {
        return keyboardHeader.isDisplayed();
    }
}