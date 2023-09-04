package Pages;

import Core.UserInfo;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Selenide.$x;
@Data
public class LoginPage {
    private final SelenideElement buttonEnterWithPass = $x("//button [@data-qa='expand-login-by-password']");
    private final SelenideElement fieldLogin = $x("// input [@data-qa='login-input-username']");
    private final SelenideElement fieldPass = $x("// input [@data-qa='login-input-password']");
    private final SelenideElement buttonSubmit = $x("//button [@data-qa='account-login-submit']");


    public LoginPage getLoginPageWithPass(){
        buttonEnterWithPass.click();
        return new LoginPage();
    }

    public VerificationPage getVerificationPage(UserInfo.AuthInfo info){
        fieldLogin.setValue(info.getLogin());
        fieldPass.setValue(info.getPassword());
        buttonSubmit.click();
        return new VerificationPage();
    }

    public VacancyDescriptionPage getVacancyDescriptionPage (UserInfo.AuthInfo info){
        fieldLogin.setValue(info.getLogin());
        fieldPass.setValue(info.getPassword());
        buttonSubmit.click();
        return new VacancyDescriptionPage();
    }

}
