package org.starrier.imperator.content.component.profile;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static org.starrier.imperator.content.component.constant.ProfileConstant.CONFIG_PREFIX;
import static org.starrier.imperator.content.component.constant.ProfileConstant.DEFAULT_FILE_NAME;
import static org.starrier.imperator.content.component.constant.ProfileConstant.POINT;

/**
 * @author Starrier
 * @date 2019/05/09
 */
@Component
@ConfigurationProperties(prefix = CONFIG_PREFIX)
public class ConfigSupportProperties {

    private boolean enable = true;

    private String fallbackLocation;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getFallbackLocation() {
        return fallbackLocation;
    }

    public void setFallbackLocation(String fallbackLocation) {
        // 如果只是填写路径， 就其添加上一个默认的文件名
        if (!fallbackLocation.contains(POINT)) {
            this.fallbackLocation = fallbackLocation + DEFAULT_FILE_NAME;
            return;
        }
        this.fallbackLocation = fallbackLocation;
    }

}
