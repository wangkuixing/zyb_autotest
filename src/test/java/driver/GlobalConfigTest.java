package driver;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;


class GlobalConfigTest {

    @Test
    void load() {
        GlobalConfig config= GlobalConfig.load("/data/globalConfig.yaml");
        assertThat(config, not(equalTo(null)));
        System.out.println(config);
        System.out.println(config.xueqiu.username);
        System.out.println(config.appium.capabilities);
        System.out.println(config.xueqiu.input.get(0));
        System.out.println(config.zyb.stock.get(0));
    }
}