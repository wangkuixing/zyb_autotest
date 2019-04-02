import driver.GlobalConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import page.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.stream.Stream;

public class BTest {

    static MainPage mainPage;
    static TradePage tradePage;
    static LoginPage loginPage;
    static BuyPage buyPage;
    static SalePage salePage;

    static GlobalConfig config=GlobalConfig.load("/data/globalConfig.yaml");

    @BeforeAll
    static void beforeALL(){
        String username=config.zyb.userb;
        String password=config.zyb.password;

        mainPage=MainPage.start();
        tradePage=mainPage.gotoTrade();
        loginPage=tradePage.gotoLogin();
        buyPage=loginPage.passwordSuccess(username, password);
        tradePage=buyPage.gotoTrade();
    }


    //买入B股
    @ParameterizedTest
    @MethodSource("GetyamlbuyB")
    void BuyB(String stockcode, String expect){


        buyPage=tradePage.gotoBuy();
        buyPage.buyTest(stockcode);
        String message=buyPage.getMessage();
        buyPage.gotoTrade();

        assertThat(message, containsString(expect));

    }

    //卖出B股
    @ParameterizedTest
    @MethodSource("GetyamlsaleB")
    void SaleB(String stksaleB, String expect){

        String stkamt=config.zyb.stkamt;

        salePage=tradePage.gotoSale();
        salePage.SaleTest(stksaleB, stkamt);
        String message=salePage.getMessage();
        salePage.gotoTrade();

        assertThat(message, containsString(expect));
    }

    static Stream<Arguments> GetyamlbuyB() {

        return Stream.of(Arguments.of(config.zyb.stock.get(2),config.zyb.expect.get(0)),
                Arguments.of(config.zyb.stock.get(3),config.zyb.expect.get(1)));
    }

    static Stream<Arguments> GetyamlsaleB() {

        return Stream.of(Arguments.of(config.zyb.stock.get(4),config.zyb.expect.get(0)),
                Arguments.of(config.zyb.stock.get(5),config.zyb.expect.get(1)));
    }


}

