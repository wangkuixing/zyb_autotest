import driver.GlobalConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.BuyPage;
import page.LoginPage;
import page.MainPage;
import page.TradePage;
import page.cnjj.CnjjPage;
import page.cnjj.CnjjrgPage;
import page.cnjj.CnjjsgPage;
import page.cnjj.CnjjshPage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CnjjTest {

    static MainPage mainPage;
    static TradePage tradePage;
    static LoginPage loginPage;
    static BuyPage buyPage;
    static CnjjPage cnjjPage;
    static CnjjrgPage cnjjrgPage;
    static CnjjsgPage cnjjsgPage;
    static CnjjshPage cnjjshPage;

    static GlobalConfig config=GlobalConfig.load("/data/globalConfig.yaml");

    @BeforeAll
    static void beforeALL(){
        String username=config.zyb.usercnjj;
        String password=config.zyb.password;

        mainPage=MainPage.start();
        tradePage=mainPage.gotoTrade();
        loginPage=tradePage.gotoLogin();
        buyPage=loginPage.passwordSuccess(username, password);
        tradePage=buyPage.gotoTrade();
        cnjjPage=tradePage.gotoCnjj();
    }

    //场内基金认购
    @Test
    void cnjjRg(){
        String stkcode=config.zyb.stock.get(14);
        String amount=config.zyb.amtcnjj;
        String expect=config.zyb.expect.get(9);

        cnjjrgPage=cnjjPage.gotoRg();
        cnjjrgPage.jjRg(stkcode, amount);
        String message=cnjjrgPage.getMessage();
        cnjjrgPage.gotoCnjj();

        assertThat(message, containsString(expect));
    }

    //场内基金申购501001
    @Test
    void cnjjSg(){
        String stkcode=config.zyb.stock.get(14);
        String amount=config.zyb.amtcnjj;
        String expect=config.zyb.expect.get(9);

        cnjjsgPage=cnjjPage.gotoSg();
        cnjjsgPage.jjSg(stkcode, amount);
        String message=cnjjsgPage.getMessage();
        cnjjsgPage.gotoCnjj();

        assertThat(message, containsString(expect));
    }

    //场内基金赎回150169
    @Test
    void cnjjSh(){
        String stkcode=config.zyb.stock.get(15);
        String amount=config.zyb.stkamt;
        String expect=config.zyb.expect.get(9);

        cnjjshPage=cnjjPage.gotoSh();
        cnjjshPage.jjSh(stkcode, amount);
        String message=cnjjshPage.getMessage();
        cnjjshPage.gotoCnjj();

        assertThat(message, containsString(expect));
    }
}
