package com.optum.pages;

import org.openqa.selenium.By;

public class Page1{


    public static By search = By.name("q");

    public static By searchbutton = By.name("btnK");

    public static By link = By.xpath("//h3[contains(.,'Speedtest by Ookla - The Global Broadband Speed Test')]");

    public static By text =By.xpath("//h2[@class='qrShPb kno-ecr-pt PZPZlf q8U8x']/span");
}
