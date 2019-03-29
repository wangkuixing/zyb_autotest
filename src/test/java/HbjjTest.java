import driver.GlobalConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.BuyPage;
import page.LoginPage;
import page.MainPage;
import page.TradePage;
import page.hbjj.HbjjPage;
import page.hbjj.HbjjsgPage;
import page.hbjj.HbjjshPage;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class HbjjTest {

    static MainPage mainPage;
    static TradePage tradePage;
    static LoginPage loginPage;
    static BuyPage buyPage;
    static HbjjPage hbjjPage;
    static HbjjsgPage hbjjsgPage;
    static HbjjshPage hbjjshPage;

    static GlobalConfig config=GlobalConfig.load("/data/globalConfig.yaml");

    @BeforeAll
    static void beforeALL(){
        String username=config.zyb.userhbjj;
        String password=config.zyb.password;

        mainPage=MainPage.start();
        tradePage=mainPage.gotoTrade();
        loginPage=tradePage.gotoLogin();
        buyPage=loginPage.passwordSuccess(username, password);
        tradePage=buyPage.gotoTrade();
        hbjjPage=tradePage.gotoHbjj();
    }

    //货币基金申购
    @Test
    void hbjjSg(){
        String stkcode=config.zyb.stock.get(13);
        String amount=config.zyb.amthbjj;
        String expect=config.zyb.expect.get(9);

        hbjjsgPage=hbjjPage.gotoSg();
        hbjjsgPage.jjSg(stkcode, amount);
        String message=hbjjsgPage.getMessage();
        hbjjsgPage.gotoHbjj();

        assertThat(message, containsString(expect));
    }

    @Test
    void hbjjSh(){
        String stkcode=config.zyb.stock.get(13);
        String amount=config.zyb.stkamt;
        String expect=config.zyb.expect.get(9);

        hbjjshPage=hbjjPage.gotoSh();
        hbjjshPage.jjSh(stkcode, amount);
        String message=hbjjshPage.getMessage();
        hbjjshPage.gotoHbjj();

        assertThat(message, containsString(expect));
    }
}
