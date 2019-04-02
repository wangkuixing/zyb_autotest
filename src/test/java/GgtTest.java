import driver.GlobalConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.BuyPage;
import page.LoginPage;
import page.MainPage;
import page.TradePage;
import page.ggt.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class GgtTest {

    static MainPage mainPage;
    static TradePage tradePage;
    static LoginPage loginPage;
    static BuyPage buyPage;
    static BuyggtPage buyggtPage;
    static SaleggtPage saleggtPage;
    static GgchedanPage ggchedanPage;
    static VoteggPage voteggPage;
    static GsxwPage gsxwPage;

    static GlobalConfig config=GlobalConfig.load("/data/globalConfig.yaml");

    @BeforeAll
    static void beforeALL(){
        String username=config.zyb.userggt;
        String password=config.zyb.password;

        mainPage= MainPage.start();
        tradePage=mainPage.gotoTrade();
        loginPage=tradePage.gotoLogin();
        buyPage=loginPage.passwordSuccess(username, password);
        tradePage=buyPage.gotoTrade();
    }

    //港股通买入 -00001
    @Test
    void ggtBuy(){
        String stkcode=config.zyb.stock.get(6);
        String expect=config.zyb.expect.get(2);

        buyggtPage=tradePage.gotoGgt().gotoBuy();
        buyggtPage.buyHgt(stkcode);
        String message1=buyggtPage.getMessage1();

        buyggtPage.buySgt(stkcode);
        String message2=buyggtPage.getMessage2();

        buyggtPage.gotoGgt().gotoTrade();
        assertThat(message1, containsString(expect));
        assertThat(message2, containsString(expect));

    }

    //港股通卖出 - sh:01359 sz:01448
    @Test
    void ggtSale(){

        String stkcodesh=config.zyb.stock.get(7);
        String stkcodesz=config.zyb.stock.get(8);
        String expect=config.zyb.expect.get(2);

        saleggtPage=tradePage.gotoGgt().gotoSale();
        saleggtPage.saleHgt(stkcodesh);
        String message1=saleggtPage.getMessage();

        saleggtPage.saleSgt(stkcodesz);
        String message2=saleggtPage.getMessage();
        saleggtPage.gotoGgt().gotoTrade();

        assertThat(message1, containsString(expect));
        assertThat(message2, containsString(expect));
    }

    //港股撤单,撤第一笔单
    @Test
    void ggtChedan(){

        String expect=config.zyb.expect.get(2);

        ggchedanPage=tradePage.gotoGgt().gotoChedan();
        ggchedanPage.chedan();
        String message=ggchedanPage.getMessage();
        ggchedanPage.gotoGgt().gotoTrade();

        assertThat(message, containsString(expect));
    }

    //港股投票
    @Test
    void ggtVote(){

        String expect1=config.zyb.expect.get(5);
        String expect2=config.zyb.expect.get(6);

        voteggPage=tradePage.gotoGgt().gotoVote();
        voteggPage.voteHgt();
        String message1=voteggPage.getMessage1();

        voteggPage.voteSgt();
        String message2=voteggPage.getMessage2();

        voteggPage.gotoGgt().gotoTrade();
        assertThat(message1, either(containsString(expect1)).or(containsString(expect2)));
        assertThat(message2, either(containsString(expect1)).or(containsString(expect2)));

    }

    //港股公司行为
    @Test
    void ggtGsxw(){

        String expect1=config.zyb.expect.get(5);
        String expect2=config.zyb.expect.get(7);

        gsxwPage=tradePage.gotoGgt().gotoGsxx();
        gsxwPage.gsxwHgt();
        String message1=gsxwPage.getMessage1();

        gsxwPage.gsxwSgt();
        String message2=gsxwPage.getMessage2();

        gsxwPage.gotoGgt().gotoTrade();
        assertThat(message1, either(containsString(expect1)).or(containsString(expect2)));
        assertThat(message2, either(containsString(expect1)).or(containsString(expect2)));

    }
}