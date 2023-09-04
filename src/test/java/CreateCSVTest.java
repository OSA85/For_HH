import Core.BaseTest;
import Core.CreateCSV;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CreateCSVTest {

    @Test
    @DisplayName("Create CSV")
    public void init() throws IOException, InterruptedException {
        CreateCSV createCSV = new CreateCSV();
        createCSV.addToCSV();
    }

}
