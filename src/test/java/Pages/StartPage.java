package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Selenide.*;

@Data
public class StartPage {

//    public StartPage startPage = new StartPage();
    private final SelenideElement buttonEnter = $x("//a [@class='supernova-button']");



    public StartPage (String url){
        open(url);
    }

    public StartPage() {
    }

    public LoginPage getLoginPage(){
        buttonEnter.click();
        return new LoginPage();
    }

//    public String namePageForCSV (){
//        return namePage.getText().trim();
//    }
//
//      public int countPage(ElementsCollection elementsCollection){
//        int num = numbersPages.size()-2;
//        var countPage = Integer.parseInt(numbersPages.get(num).getText());
//        return countPage;
//    }


}