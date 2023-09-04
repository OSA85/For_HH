package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class VerificationPage {

    private final SelenideElement buttonResumes = $x("//a [@data-qa='mainmenu_myResumes']");

    public ResumesPage getResumesPage(){
        buttonResumes.click();
        return new ResumesPage();
    }

}
