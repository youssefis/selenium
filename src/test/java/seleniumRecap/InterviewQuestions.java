package seleniumRecap;

public class InterviewQuestions {

    /*

    1-What are the advantages and disadvantages of selenium?
        Advantages:
            * Free Resource
            * It supports multiple languages and browser
            * It has big community
        Disadvantages:
            *You can not automate captcha,pictures,mobile apps ect..
            *There is no direct call (no customer support)
            *It only automates web applications
            *It does not have any system to generate report, so we use
            external resources(testNg,cucumber ect..)

    2-What type of testing can you automate with selenium?
        *Regression
        *Smoke
        *Functional test(positive and negative testing)

    3-What are the tests types you do not automate with Selenium?
        *Performance Testing(Jmeter-->It is not hard to learn)
        *Manual Testing(captcha, pictures)
        *Non-Functional Testing(stress testing, loading testing, performance...)
        *Adhoc Testing (randomly testing)

    4-What is locator in Selenium? What type of locators do you use in your framework?
        ->Locator is a way to find page elements from the DOM (development tool/page)
        The locators that I am using in my framework are:
            *ID : with id attribute
            *Name: name attribute
            *ClassName
            *TagName
            *LinkText
            *PartialLinkText
            *Css: id or class we use # for id and . for class
            *Xpath: find the element with Xpath

     5-How do you handle dynamic elements in UI automation? (CVS company question)
        ->In my project, I've faced many dynamic elements during UI automation,to handle this issue I did:
            **I use parent-child relationship for the wanted element
            *** I used different ways to locate the elements(like following-sibling,preceding sibling, contains ect...)
            *I found the element with different attribute which is not dynamic

     6-Different between driver.get() and driver.navigate()?
        *Navigate() -> it does not wait for all WebElements to be loaded from page. (it waits only for needed elements)
                    -> it has some method (to(),refresh(),back(),forward())

        *get()      -> it waits for all elements to be loaded
                    -> it does not have any methods

    7-Different between driver.close() and driver.quit()?
        Driver.close() -> It specifically closes the window that your driver is pointing to, it closes only one tab
        Driver.quit() -> it closes all the tabs that are open during the automation

    8- What is xpath and can you tell me about type of xpath? which one do you use the most?
    8-1 What is the difference between Absolute and Relative Xpath
        ->Xpath : is one of the locators that I use in selenium to find elements.
        ->There are two types of xpath
            1-Absolute Xpath
                *It goes from all the way top (html) to child.
                *it starts with single slash (/)
            2-Relative Xpath:
                *It goes directly to the child or parent-child element
                *It starts with double sash (//)

         Note: mostly I use the relative xpath since it is more functional and effective to locate element

     9-How do you handle Drop-Downs? (static or dynamic drop-down)
        In my project, I was handling the drop-downs with different ways : First
           *I would definitely check the tag of the webElement(location)

                *if the tag has "select" type then I use select class
                    Exp: Select select=new Select(LocationOfElement);

                *if the element does no have "select" TagName then i can use:
                    ->Actions class methods like click or WebElements method click and choose option
                    ->I would use sendKeys() to choose the option

    10- What do you know about Select class and its methods?
        Select class is a way to handle Drop-downs:
            ->It is really useful for my project
            ->The WebElement must have Select tagName

            -Select select =new Select(elementLocation)
                *select.selectByVisibleText("TextValue");
                *select.selectByValue("value");
                *select.select.index(indexNumber);
                *select.getFirstSelectedOption() -> it will give you default option selected
                *select.getOptions() -> it will give you all options

    11-What kind of exceptions have you faced in automation framework
        ->NOSUCHELEMENT EXCEPTION
        ->STALE ELEMENT REFERENCE EXCEPTION
        ->ELEMENT INTERCEPTED EXCEPTION
        ->ELEMENT IS NOT INTERACTABLE EXCEPTION
        ->NO SUCH WINDOW EXCEPTION
        ->NO SUCH FRAME EXCEPTION
        ->TESTING EXCEPTION
        ->UNHANDLED ALERT EXCEPTION
        ->TIMEOUT EXCEPTION
        ->INVALID SELECTOR EXCEPTION

    12-How do you handle stale Element Reference EXCEPTION?
        ->This exception come up when:
            -the dom is not updated fast
            -the dom's element values is changed
            -the page is refreshed
        ->Wait times might solve the issue
            -I would use Thread.sleep or Explicitly wait with condition
         ***-I would reassign and reinitialize the webElement
            -I would refresh the page

    13-How do you handle pop-ups?
        There are different types of pop-ups that I've faced during automation?
        1-Operation System (OS): can not be handled directly by selenium
        2-HTML Alert/pop-up: just need to find the element and handle it directly (Ok or cancel button)
        3-JavaScript alert/pop-up: handle it with Alert interface
            Alert alert=driver.switchTo().alert();

            alert.accept() --> it clicks "Ok" button from alert
            alert.dismiss() --> it clicks "Cancel" button from alert
            alert.getText() --> gets the text from alert
            alert.sendKeys() --> it sends the key to the alert

    14-What do you know bout iframe ? and how do you handle this in your automation?
        ->Iframe is an HTML inside HTML
        ->It is used for protection purposes.
        ->It is widely used for ads, documents or videos

        ->First switch your frame based on the value of WebElement:
            ->driver.switchTo.frame(id or name)
            ->driver.switchTo.frame(WebElement)
            ->driver.switchTo.frame(index)
            ->driver.switchTo.ParentFrame
            ->->driver.switchTo.defaultContent() -> it will take you to the main html

            Note:if you do not handle iframe you will get NOSUCHELEMNTEXCEPTION
            Note:if the value of switchframe is wrong, you will get NOSUCHFRAME Exception

    15-What do you know about Actions class and its methods?
        Actions class basically does the functionality of mouse. I can say it is really useful in some cases during my automation
        to handle some elements some of the important methods are:

    IQ *** -> ContextClick -> it right clicks on the webelement IQ:interview question
           -> DoubleClick -> it double click the element
           -> DragAndDrop -> It drags the element from one spot to another
           -> clickAndHold -> it clicks and hod the element
           ->MoveTOElement -> it hovers over the elemnet
           ->release -> it releases the element that you are holding (it mostly comes after clickAndHold)
           ->Click() -> it clicks the element
           ->sendKeys() -> it sends the keys
       ****->perform() -> it performs the methods from the Action Class,(with no .perform(), non of the action will work)

    16-what is the difference between driver.findElement and driver.findElements?

        *Find Element: 1- syntax : driver.findElement(By.locator())
                       2- Returns single WebElement
                       3-Once it fails, it throws NOSUCHELEMENT Exception

        *Find Elements: 1- driver.findElements(By.locator())
                        2-Returns List of <WebElement>
                        3-it returns no Exceptions when is fails

    17- tell me some driver and webElement methods most used in your automation
        Driver Methods: .get(), navigate(), getCurrentURL(), switchTo(), quit(), close(), getWindowHandle(), .manage(),
        WebElement Methods: click() , sendKeys(), getText(), isDisplayed(), isSelected(), getAttribute(), getCssValue(), clear(), Submit(),

    18- what is the difference between check-box and radio button?
        chockBox : you can click multiple Boxes
        RadioButton: you can choose ony one

    19- How do you handle multiple windows in automation? and what is the difference between getWindowHandle() and getWindowHandles
        ->To be able to handle the windows
            ->i need to switch my driver into the specific window with my logic
                Set<String> allWindows=driver.getWindowHandles

                for(String pageID: allWindows){
                driver.switchTo.window(pageId);
                if(driver.getTitle).contains(expectedTitle)){
                break;}
                }
                1-Use GetwindowHandels -> to store all pages id as Set
                2-Loop through all pages and switch
                3-Break the Loop when title is matching

         Note: Get windowHandle -> return String with Single page Id
               Get WindowHandles -> return Set<String> with all unique page ids

    20- How do you scroll down-up in Web Browsers during automation?

        --> I mostly use JS scrollIntoView script. (I store it in my Browser Utils for any time usage)
        --> actions.scrollByAmount(x,y)
        --> Keys.PageUp Or Down
        --> Keys.ArrowUp or Down

    21-How do you upload file in Selenium?
        ->First of all, you need to find the location of Choose Button
        ->Find the file path that you want to upload
        ->then send the keys of location to the choose button.

    22-what is the difference between assert amd SoftAssert?
        Assert : is a class that have some methods to validate actual and expected data.
        Assert.assertEquals, assertTrue..
        *When it fails it throws exception right away and do not execute the next line of code.

        SoftAssert: it is a class that has some methods to validate actual and expected data.
            *We need to create an object
                SoftAssert softAssert= new SoftAssert():
            *When it fails, it does not throw an exception then it keeps executing the next codes.
            *You must use Assert.all() to make it work properly otherwise it will pass all the time.

    23- can you tell me about your singleton Pattern design? -> Can you make the constructor private,static or final?
        with the help of Singleton, I centralize my driver which reduces the amount of exception
        i got which means it is more reliable and safe to use.

            -->I basically Encapsulate my Singleton:
                ->I need to have Private WebDriver
                ->I need to have Private Constructor
                ->Put if condition to check my driver is null or not
                ->create a public method to call it from other classes

    24-What kind of TestNG annotation do you use in your project? can you tell me what is the purpose
    Of @Parameter usage? Answer is in sublime

    25-What do you know about @DataProvider and why do you use it? Answer is in sublime

    26-What do you know about Wait times and can you tell me the difference between Thread.sleep,
    Implicit, explicit,Fluent time? Answer is in sublime









     */

}
