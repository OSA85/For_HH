package Core;

import Pages.VacancyPage;
import com.codeborne.selenide.SelenideElement;

public class Utils {
    public VacancyPage scrollToAndClick (SelenideElement element) {

        element.scrollIntoView(false).click();
        return new VacancyPage();
    }


}
