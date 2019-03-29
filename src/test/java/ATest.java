import driver.GlobalConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import page.*;
import page.gznhg.ShnhgPage;
import page.gznhg.SznhgPage;
import page.xingu.XinguPage;
import page.xingu.XinzhaiPage;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.stream.Stream;

public class ATest {

    static MainPage mainPage;
    static TradePage tradePage;
    static LoginPage loginPage;
    static BuyPage buyPage;
    static SalePage salePage;
    static ChaxunPage chaxunPage;
    static ChicangPage chicangPage;
    static MorePage morePage;
    static CdbuyPage cdbuyPage;
    static CdsalePage cdsalePage;
    static XinguPage xinguPage;
    static XinzhaiPage xinzhaiPage;
    static SznhgPage sznhgPage;
    static ShnhgPage shnhgPage;

    static GlobalConfig config=GlobalConfig.load("/data/globalConfig.yaml");

    @BeforeAll
    static void beforeALL(){
        String username=config.zyb.username;
        String password=config.zyb.password;

        mainPage=MainPage.start();
        tradePage=mainPage.gotoTrade();
        loginPage=tradePage.gotoLogin();
        buyPage=loginPage.passwordSuccess(username, password);
        tradePage=buyPage.gotoTrade();
    }

    //买入A股000001,600000
    @ParameterizedTest
    @MethodSource("Getyamlbuy")
    void buyA(String stockcode, String expect){

        buyPage=tradePage.gotoBuy();
        buyPage.buyTest(stockcode);
        String message=buyPage.getMessage();
        buyPage.gotoTrade();

        assertThat(message, containsString(expect));
    }

    //卖出A股
    @ParameterizedTest
    @MethodSource("Getyamlsale")
    void saleA(String stksale, String expect){

        String stkamt=config.zyb.stkamt;

        salePage=tradePage.gotoSale();
        salePage.SaleTest(stksale, stkamt);
        String message=salePage.getMessage();
        salePage.gotoTrade();

        assertThat(message, containsString(expect));
    }

    @Test
    void chaZijin(){

        chaxunPage=tradePage.gotoChaxun();
        Boolean cha=chaxunPage.chaxunTest();
        chaxunPage.gotoTrade();

        assertTrue(cha);
    }

    @Test
    void chiCang(){

        chicangPage=tradePage.gotoChicang();
        Boolean chicang=chicangPage.chicangTest();
        chicangPage.gotoTrade();

        assertTrue(chicang);
    }

    //拆单买入A股000001
    @Test
    void cdbuyA(){

        String stockcode=config.zyb.stock.get(0);
        String expect=config.zyb.expect.get(2);

        cdbuyPage=tradePage.gotoMore().gotocdBuy();
        cdbuyPage.jfTest(stockcode);
        String message1=cdbuyPage.getMessage1();

        cdbuyPage.randomTest(stockcode);
        String message2=cdbuyPage.getMessage2();

        cdbuyPage.gotoMore().gotoTrade();

        assertThat(message1, containsString(expect));
        assertThat(message2, containsString(expect));
    }

    //拆单卖出A股000882
    @Test
    void cdsaleA(){
        //todo
        return;

    }

    //密码修改
    //todo

    //新股申购
    @Test
    void xinguTest(){

        tradePage.gotoYjdx()
                .gotoXgsg()
                .xinguTest()
                .gotoYjdx()
                .gotoTrade();

    }

    //债券申购
    @Test
    void xinzhaiTest(){

        tradePage.gotoYjdx()
                .gotoXinzhai()
                .xinzhaiTest()
                .gotoYjdx()
                .gotoTrade();

    }

    //深市国债逆回购
    @Test
    void sznhgTest(){

        sznhgPage=tradePage.gotoNhg().gotoSz();
        sznhgPage.weituo1318xx();
        String message1=sznhgPage.getMessage1();
        String message2=sznhgPage.getMessage2();
        sznhgPage.gotoNhg().gotoTrade();

        assertThat(message1, containsString("成功"));
        assertThat(message2, containsString("成功"));

    }

    //沪市国债逆回购
    @Test
    void shnhgTest(){

        shnhgPage=tradePage.gotoNhg().gotoSh();
        shnhgPage.weituo204xxx();
        String message1=shnhgPage.getMessage1();
        String message2=shnhgPage.getMessage2();
        shnhgPage.gotoNhg().gotoTrade();

        assertThat(message1, containsString("成功"));
        assertThat(message2, containsString("成功"));

    }

    //银证转账


//    //买入B股
//    @ParameterizedTest
//    @MethodSource("GetyamlbuyB")
//    void BuyB(String stockcode, String expect){
//
//        String name="退出登录";
//        String userb=config.zyb.userb;
//        String passb=config.zyb.password;
//
//        buyPage=tradePage.swipeControl().logOut(name)
//                .gotoLogin()
//                .passwordSuccess(userb, passb)
//                .gotoTrade()
//                .gotoBuy();
//
//        buyPage.ATest(stockcode);
//        String message=buyPage.getMessage();
//
//        assertThat(message, containsString(expect));
//        buyPage.gotoTrade();
//
//    }
//
//    //卖出B股
//    @ParameterizedTest
//    @MethodSource("GetyamlsaleB")
//    void SaleB(String stksaleB, String expect){
//
//        String stkamt=config.zyb.stkamt;
//        String name="退出登录";
//        String userb=config.zyb.userb;
//        String passb=config.zyb.password;
//
//        salePage=tradePage.logOut(name)
//                .gotoLogin()
//                .passwordSuccess(userb, passb)
//                .gotoTrade()
//                .gotoSale();
//
//        salePage.SaleTest(stksaleB, stkamt);
//        String message=salePage.getMessage();
//
//        assertThat(message, containsString(expect));
//        salePage.gotoTrade();
//    }

    static Stream<Arguments> Getyamlbuy() {

        return Stream.of(Arguments.of(config.zyb.stock.get(0),config.zyb.expect.get(0)),
                Arguments.of(config.zyb.stock.get(1),config.zyb.expect.get(1)));
    }

    static Stream<Arguments> Getyamlsale() {

        return Stream.of(Arguments.of(config.zyb.stksale.get(0),config.zyb.expect.get(0)),
                Arguments.of(config.zyb.stksale.get(1),config.zyb.expect.get(1)));
    }

//    static Stream<Arguments> GetyamlbuyB() {
//
//        return Stream.of(Arguments.of(config.zyb.stock.get(2),config.zyb.expect.get(0)),
//                Arguments.of(config.zyb.stock.get(3),config.zyb.expect.get(1)));
//    }
//
//    static Stream<Arguments> GetyamlsaleB() {
//
//        return Stream.of(Arguments.of(config.zyb.stock.get(4),config.zyb.expect.get(0)),
//                Arguments.of(config.zyb.stock.get(5),config.zyb.expect.get(1)));
//    }


}


