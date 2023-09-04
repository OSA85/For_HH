package Core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
//import com.codeborne.selenide.Selenide;
//import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.StartPage;
import Pages.VacancyPage;

import java.util.ArrayList;
import java.util.List;
import static Data.Values.BASE_URL_HH;

import static com.codeborne.selenide.Selenide.$$x;

public class GetVacanciesURL {
    List myListVacanciesURL = new ArrayList();
//    GetVacanciesURL getVacanciesURL = new GetVacanciesURL();
    VacancyPage vacancyPage = new VacancyPage();
    Utils utils = new Utils();


    public List getUrlVacancies() throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            Configuration.browser = "chrome";
            Configuration.driverManagerEnabled = true;
            Configuration.browserSize = "1920x1080";
            Configuration.headless = false;
            Configuration.holdBrowserOpen = true;
            Configuration.pageLoadStrategy = "eager";
            Configuration.pageLoadTimeout = 45000;
            StartPage startPage = new StartPage(BASE_URL_HH);
            startPage.getLoginPage()
                .getLoginPageWithPass()
                .getVerificationPage(UserInfo.getAuthInfo())
                .getResumesPage()
                .getVacancyPage();
                    Thread.sleep(2000);
            if (vacancyPage.getButtonCookie().isDisplayed()){
                vacancyPage.getButtonCookie().click();
            }
            int countStepToPages = vacancyPage.countClickForNext(vacancyPage.getNumbersPages())-1;
            for(int i = 0; i <= countStepToPages; i++) {
                if(i < countStepToPages){
                    for (int j = 0; j < vacancyPage.getListVacancies().size(); j++) {
                        var stringUrl = vacancyPage.getListVacancies().get(j).getAttribute("href");
                            myListVacanciesURL.add(stringUrl);
                    }
                    utils.scrollToAndClick(vacancyPage.getButtonNext());
                }
                if(i == countStepToPages) {
                    for (int j = 0; j < vacancyPage.getListVacancies().size(); j++) {
                        var stringUrl = vacancyPage.getListVacancies().get(j).getAttribute("href");
                        myListVacanciesURL.add(stringUrl);
                    }
                }
            }
            Selenide.closeWebDriver();
            return myListVacanciesURL;
        }

}
