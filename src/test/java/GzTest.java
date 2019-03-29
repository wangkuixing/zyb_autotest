import driver.GlobalConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import page.*;
import page.gzxt.GzcdPage;
import page.gzxt.XjmcPage;
import page.gzxt.XjmrPage;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.stream.Stream;

public class GzTest {

    static MainPage mainPage;
    static TradePage tradePage;
    static LoginPage loginPage;
    static BuyPage buyPage;
    static XjmrPage xjmrPage;
    static XjmcPage xjmcPage;
    static GzcdPage gzcdPage;

    static GlobalConfig config=GlobalConfig.load("/data/globalConfig.yaml");

    @BeforeAll
    static void beforeALL(){
        String username=config.zyb.usergz;
        String password=config.zyb.password;

        mainPage=MainPage.start();
        tradePage=mainPage.gotoTrade();
        loginPage=tradePage.gotoLogin();
        buyPage=loginPage.passwordSuccess(username, password);
        tradePage=buyPage.gotoTrade();
    }

    //股转限价买入430074,430005
    @ParameterizedTest
    @MethodSource("getyamlBuygz")
    void buyGz(String stkcode, String expect){

        xjmrPage=tradePage.gotoGz().gotoXjmr();
        xjmrPage.buyGz(stkcode);
        String message=xjmrPage.getMessage();
        xjmrPage.gotoGz().gotoTrade();

        assertThat(message, containsString(expect));

    }

    //股转限价卖出831529
    @Test
    void saleGz(){

        String stkcode=config.zyb.stksale.get(2);
        String expect=config.zyb.expect.get(2);

        xjmcPage=tradePage.gotoGz().gotoXjmc();
        xjmcPage.saleGz(stkcode);
        String message=xjmcPage.getMessage();
        xjmcPage.gotoGz().gotoTrade();

        assertThat(message, containsString(expect));
    }

    //股转撤单
    @Test
    void gzChedan(){
        String expect1=config.zyb.expect.get(0);
        String expect2=config.zyb.expect.get(8);

        gzcdPage=tradePage.gotoGz().gotoGzcd();
        gzcdPage.gzCd();
        String message=gzcdPage.getMessage();
        gzcdPage.gotoGz().gotoTrade();

        assertThat(message, either(containsString(expect1)).or(containsString(expect2)));
    }

    static Stream<Arguments> getyamlBuygz() {

        return Stream.of(Arguments.of(config.zyb.stock.get(9),config.zyb.expect.get(2)),
                Arguments.of(config.zyb.stock.get(10),config.zyb.expect.get(2)));
    }


}
