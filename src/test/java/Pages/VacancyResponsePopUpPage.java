package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Data
public class VacancyResponsePopUpPage {
    private final ElementsCollection nameResumeQAengineer = $$x("//span[@data-qa='resume-title']"); // *[text()='QA engineer']
    private final SelenideElement buttonResponse = $x("//button [@data-qa='vacancy-response-submit-popup']");
    private final SelenideElement buttonLetter = $x("//button [@data-qa='vacancy-response-letter-toggle']");
    private final SelenideElement  textArea = $x("// textarea [@data-qa='vacancy-response-popup-form-letter-input']");
    private final SelenideElement  buttonResponseWithLetter = $x("// button [@data-qa='vacancy-response-submit-popup']");
    private final SelenideElement  nameVacancy = $x("//div [@class='bloko-modal-header bloko-modal-header_outlined'] //div");

    public String getLetterWithNameVacancy () {

        String nameVacancyForLetter = nameVacancy.getText();
        String string = "Добрый день!\n" +
                "   Заинтересовала ваша вакансия " + nameVacancyForLetter +". Знание теории тестирования и применение на практике." +
                " Разработка и поддержка тестовой документации: тест-кейсы, чек-листы..." +
                " Документирование баг-репортов (Rus, En). Писал запросы SQL, работал с Git, DevTools," +
                " Postman/Swagger(написание коллекций тестов), Terminal и др. Также писал авто-тесты на Java," +
                " на JS, некоторые работы можно посмотреть по ссылке: https://github.com/OSA85\n" +
                "Готов выполнить тестовое задание.\n" +
                "\n" +
                "С уважением, Обидин Сергей\n" +
                "Телефон, вайбер, ватсап: 89050318822\n" +
                "Tелеграмм: @Obidin_S\n" +
                "Почта: obidinsa@mail.ru\n";
        return string;
    }

    public void choseResumeAndInputLetter (ElementsCollection elementsCollection, String string){
        elementsCollection.first().click();
        buttonLetter.click();
        textArea.setValue(string);
        buttonResponseWithLetter.click();
    }


}
