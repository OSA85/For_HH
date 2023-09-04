package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ResumesPage {
    private final SelenideElement buttonRecommendations = $x("//a [@class='bloko-button bloko-button_kind-primary bloko-button_scale-small bloko-button_stretched bloko-button_appearance-outlined']");  //a [@data-qa='resume-recommendations__button_editResume']


    public VacancyPage getVacancyPage(){
        buttonRecommendations.click();
        return new VacancyPage();
    }

}
