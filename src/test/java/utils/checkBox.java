package utils;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class checkBox {
     public static void clickCheckBox(String name){
         $(By.xpath(String.format("//label[normalize-space()='%s']", name))).click();
     }

    public static void clickCheckBoxForName(String title, String name){
         $(By.xpath(String.format("//label[contains(text(), '%s')]/following::label[normalize-space()='%s']", name, title))).click();
    }

}
