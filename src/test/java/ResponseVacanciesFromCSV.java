import Core.BaseTest;
import Core.UserInfo;
import Pages.StartPage;
import Pages.VacancyDescriptionPage;
import Pages.VacancyResponsePopUpPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ResponseVacanciesFromCSV extends BaseTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    @DisplayName("Check")
    public void changePage(String url) throws InterruptedException {
        VacancyDescriptionPage vacancyDescriptionPage = new VacancyDescriptionPage(url);
        VacancyResponsePopUpPage vacancyResponsePopUpPage = new VacancyResponsePopUpPage();
        StartPage startPage = new StartPage();
        String name = vacancyDescriptionPage.getNameVacancyH1().getText().toLowerCase();
        String experience = vacancyDescriptionPage.getExperienceVacancy().getText().toLowerCase();
        if (name.contains("qa")
                || name.contains("тестировщик")
                || name.contains("тестированию")
                || name.contains("тестирование")
                || name.contains("тестирования")
                || name.contains("контрол")
                || name.contains("качеств")) {
            if (!experience.contains("6")) {
                startPage.getLoginPage()
                        .getLoginPageWithPass()
                        .getVacancyDescriptionPage(UserInfo.getAuthInfo());
                Thread.sleep(3000);
                boolean i = vacancyDescriptionPage.getSeeResponse().get(0).isDisplayed();
                if(i){
                    System.out.println(url + "\nУже откликались");
                } else {
                    vacancyDescriptionPage.getPopUp().choseResumeAndInputLetter(vacancyResponsePopUpPage.getNameResumeQAengineer(), vacancyResponsePopUpPage.getLetterWithNameVacancy());
                    System.out.println( url + "\nОтклик отправлен");

                    assertEquals( "Резюме доставлено", vacancyDescriptionPage.getNameRespondedBlock().getText());
                }
            } else {
                System.out.println(url + "\nНе подошел по стажу работы");
            }
        } else {
            System.out.println(url + "\nНет подходящих слов в названии вакансии");
        }

    }

}
