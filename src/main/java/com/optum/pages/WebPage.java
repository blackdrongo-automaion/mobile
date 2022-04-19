package com.optum.pages;

import com.optum.web.Browsers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public  class WebPage extends Browsers {


    private static By ele = null;

    public static String locator;

    public WebPage(){
    }

    public static WebPage element_by_id(String id){
        locator = String.valueOf(Locators.ID);
        return new By_Id(id);
    }

    public static WebPage element_by_name(String name){
        locator = String.valueOf(Locators.NAME);
        return new By_Name(name);
    }

    public static WebPage element_by_xpath(String xpath){
        locator = String.valueOf(Locators.XPATH);
        return new By_Xpath(xpath);
    }

    public static WebPage element_by_className(String className){
        locator = String.valueOf(Locators.CLASSNAME);
        return new By_ClassName(className);
    }

    public static WebPage element_by_tageName(String tagName){
        locator = String.valueOf(Locators.TAG_NAME);
        return new By_TagName(tagName);
    }

    public static WebPage element_by_partialLinkText(String partialLinkText){
        locator = String.valueOf(Locators.PARTIAL_LINK_TEXT);
        return new By_PartialLinkText(partialLinkText);
    }

    public static WebPage element_by_linkText(String linkText){
        locator = String.valueOf(Locators.LINK_TEXT);
        return new By_LinkText(linkText);
    }

    public static WebPage element_by_css(String css){
        locator = String.valueOf(Locators.CSS);
        return new By_CssSelector(css);
    }



    public static class By_Id extends WebPage {
        private final String pageId;

        public By_Id(String pageId) {
            this.pageId = pageId;
        }

        public String toString() {
            return  this.pageId;
        }
    }
    public static class By_Name extends WebPage{
        private final String name;

        public By_Name(String name) {
            this.name = name;
        }

        public String toString() {
            return  this.name;
        }
    }

    public static class By_Xpath extends WebPage{
        private final String xpath;

        public By_Xpath(String xpath) {
            this.xpath = xpath;
        }

        public String toString() {
            return  this.xpath;
        }
    }

    public static class By_CssSelector extends WebPage{
        private final String css;

        public By_CssSelector(String css) {
            this.css = css;
        }

        public String toString() {
            return  this.css;
        }
    }

    public static class By_ClassName extends WebPage{
        private final String className;

        public By_ClassName(String className) {
            this.className = className;
        }

        public String toString() {
            return this.className;
        }
    }

    public static class By_TagName extends WebPage{
        private final String tagName;

        public By_TagName(String tagName) {
            this.tagName = tagName;
        }

        public String toString() {
            return this.tagName;
        }
    }

    public static class By_LinkText extends WebPage{
        private final String linkText;

        public By_LinkText(String linkText) {
            this.linkText = linkText;
        }

        public String toString() {
            return this.linkText;
        }
    }

    public static class By_PartialLinkText extends WebPage{
        private final String partialLinkText;

        public By_PartialLinkText(String partialLinkText) {
            this.partialLinkText = partialLinkText;
        }

        public String toString() {
            return this.partialLinkText;
        }
    }





}
