import driver.GlobalConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import page.BuyPage;
import page.LoginPage;
import page.MainPage;
import page.TradePage;
import page.yzzz.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class YzzzTest {

    static MainPage mainPage;
    static TradePage tradePage;
    static LoginPage loginPage;
    static BuyPage buyPage;
    static ZjzrPage zjzrPage;
    static ZjzcPage zjzcPage;
    static WdzjPage wdzjPage;
    static ZjgjPage zjgjPage;
    static ZjdbPage zjdbPage;

    static GlobalConfig config=GlobalConfig.load("/data/globalConfig.yaml");

    @BeforeAll
    static void beforeALL(){
        String username=config.zyb.useryzzz;
        String password=config.zyb.password;

        mainPage= MainPage.start();
        tradePage=mainPage.gotoTrade();
        loginPage=tradePage.gotoLogin();
        buyPage=loginPage.passwordSuccess(username, password);
        tradePage=buyPage.gotoTrade();
    }

    //银行转证券
    @Test
    void yhtoZq(){

        String expect=config.zyb.expect.get(3);

        zjzrPage=tradePage.gotoYzzz().gotoZjzr();
        zjzrPage.yhtoZq();
        String message=zjzrPage.getMessage();
        zjzrPage.gotoYzzz().gotoTrade();

        assertThat(message, containsString(expect));
    }


    //证券转银行
    @Test
    void zqtoYh(){

        String expect=config.zyb.expect.get(3);

        zjzcPage=tradePage.gotoYzzz().gotoZjzc();
        zjzcPage.zqtoYh();
        String message=zjzcPage.getMessage();
        zjzcPage.gotoYzzz().gotoTrade();

        assertThat(message, containsString(expect));
    }

    //我的资金
    @Test
    void wdZj(){

        wdzjPage=tradePage.gotoYzzz().gotoWdzj();
        Boolean zj=wdzjPage.wdZj();
        wdzjPage.gotoYzzz().gotoTrade();

        assertTrue(zj);
    }

    //资金归集
    @Test
    void zjGj(){

        String expect=config.zyb.expect.get(4);

        zjgjPage=tradePage.gotoYzzz().gotoZjgj();
        zjgjPage.zjGj();
        String message=zjgjPage.getMessage();
        zjgjPage.gotoYzzz().gotoTrade();

        assertThat(message, containsString(expect));
    }

    //资金调拨
    @Test
    void zjDb(){

        String expect=config.zyb.expect.get(4);

        zjdbPage=tradePage.gotoYzzz().gotoZjdb();
        zjdbPage.zjDb();
        String message=zjdbPage.getMessage();
        zjdbPage.gotoYzzz().gotoTrade();

        assertThat(message, containsString(expect));
    }
}
