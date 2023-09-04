package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Selenide.*;

@Data
public class VacancyDescriptionPage {
    private final SelenideElement nameVacancyH1 = $x("//h1 [@data-qa='vacancy-title']// span");
    private final SelenideElement experienceVacancy = $x("//span [@data-qa='vacancy-experience']");
    private final ElementsCollection seeResponse = $$x("//a[@data-qa='vacancy-response-link-view-topic']");
    private final ElementsCollection buttonResponse = $$x("// a [@data-qa='vacancy-response-link-top']");
    private final SelenideElement  nameRespondedBlock = $x("//div [@class='noprint']//h2 [@data-qa='bloko-header-2']");


    public VacancyDescriptionPage (String url){
        open(url);
    }

    public VacancyDescriptionPage (){}
    public VacancyResponsePopUpPage getPopUp (){
        buttonResponse.first().click();
        return new VacancyResponsePopUpPage();
    }

}
