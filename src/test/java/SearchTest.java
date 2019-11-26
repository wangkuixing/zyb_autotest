import driver.GlobalConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import page.HqPage;
import page.MainPage;

import page.SearchPage;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {
    static MainPage mainPage;
    static SearchPage searchPage;
    static HqPage hqPage;

    @BeforeAll
    static void beforeALL() throws InterruptedException {
        mainPage=MainPage.start();
        hqPage =mainPage.gotoHq();
    }

    //配置驱动：将yaml文件实例化对象
    @Test
    void select1() throws InterruptedException {
        GlobalConfig config= GlobalConfig.load("/data/globalConfig.yaml");
        String keyword=config.zyb.stock.get(0);
        System.out.printf(keyword);

        HqPage hqPage1 = hqPage.addZixuan().search(keyword).addSelected().cancel();
        ArrayList<String> array=hqPage1.searchStock();
        assertThat(array, hasItems(config.zyb.stockname));
    }
}
