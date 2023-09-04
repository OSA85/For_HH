package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
@Data
public class VacancyPage {

    private final ElementsCollection listVacancies = $$x("//a [@data-qa='serp-item__title']");
    private final ElementsCollection numbersPages = $$x("//div [@data-qa='pager-block']//a//span");
    private final SelenideElement buttonNext = $x("//div [@data-qa='pager-block']//a [@data-qa='pager-next']");
    private final SelenideElement buttonCookie = $x("// button // span [contains(text(), 'Понятно')]");


    public int countClickForNext(ElementsCollection elementsCollection){
        int num = elementsCollection.size()-2;
        var countPage = Integer.parseInt(elementsCollection.get(num).getText());
        return countPage;
//        return elementsCollection.size();

    }


}
