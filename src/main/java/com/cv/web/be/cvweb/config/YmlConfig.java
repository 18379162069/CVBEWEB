package com.cv.web.be.cvweb.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 读取yml文件中的配置
 *
 * @Author zhou_wb
 * @Date 2017/3/7  10:15.
 */
@Component
@ConfigurationProperties(prefix="cvProps") //application.yml中的cvProps下的属性
public class YmlConfig {
    private String url_api_cvbe;
    private int runEnv;

    public String getUrl_api_cvbe() {
        return url_api_cvbe;
    }

    public void setUrl_api_cvbe(String url_api_cvbe) {
        this.url_api_cvbe = url_api_cvbe;
    }

    public int getRunEnv() {
        return runEnv;
    }

    public void setRunEnv(int runEnv) {
        this.runEnv = runEnv;
    }
}