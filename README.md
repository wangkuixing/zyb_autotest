# 证券交易APP UI自动化测试

这个是android项目，IOS项目见zyb_ios

## 使用工具

* appium@1.15.1
* junit5:测试用例执行
* allure2:自动生成测试报告
* jenkins:CI
* gitlab:代码仓库（私有化部署）

## 项目结构
* main/driver: driver全局配置，数据驱动读取yaml文件
* page: pageObject页面
* test/java: testCase

## 运行

代码上传至gitlab，通过jenkins作业化执行，执行完成后生成allure report
