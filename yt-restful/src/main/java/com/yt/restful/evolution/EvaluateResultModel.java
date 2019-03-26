package com.yt.restful.evolution;

import com.yt.datastructure.datastructure.restful.evolution.propties.*;
import com.yt.restful.evolution.propties.*;
import com.yt.restful.evolution.propties.modifiability.EvolvabilityProperty;
import com.yt.restful.evolution.propties.modifiability.ConfigurabilityProperty;
import com.yt.restful.evolution.propties.modifiability.CustomizabilityProperty;
import com.yt.restful.evolution.propties.modifiability.ReusabilityProperty;
import com.yt.restful.evolution.propties.performance.NetworkEfficiencyProperty;
import com.yt.restful.evolution.propties.performance.NetworkPerformanceProperty;
import com.yt.restful.evolution.propties.performance.UserPerceivedPerformanceProperty;

/**
 * Created by yantong on 2019/2/20.
 */
public class EvaluateResultModel {

    /**
     * {@link ConfigurabilityProperty}
     */
    private String configurabilityPropertyValue;

    /**
     * {@link CustomizabilityProperty}
     */
    private String customizabilityPropertyValue;

    /**
     * {@link EvolvabilityProperty}
     */
    private String evolvabilityPropertyValue;

    /**
     * {@link ConfigurabilityProperty}
     */
    private String extensibilityPropertyValue;

    /**
     * {@link ReusabilityProperty}
     */
    private String reusabilityPropertyValue;

    /**
     * {@link NetworkEfficiencyProperty}
     */
    private String networkEfficiencyPropertyValue;

    /**
     * {@link NetworkPerformanceProperty}
     */
    private String networkPerformancePropertyValue;

    /**
     * {@link UserPerceivedPerformanceProperty}
     */
    private String userPerceivedPerformancePropertyValue;

    /**
     * {@link PortabilityProperties}
     */
    private String portabilityPropertiesValue;

    /**
     * {@link ReliabilityProperties}
     */
    private String reliabilityPropertiesValue;

    /**
     * {@link ScalabilityProperties}
     */
    private String scalabilityPropertiesValue;

    /**
     * {@link SimplicityProperties}
     */
    private String simplicityPropertiesValue;

    /**
     * {@link VisibilityProperties}
     */
    private String visibilityPropertiesValue;

    public String getConfigurabilityPropertyValue() {
        return configurabilityPropertyValue;
    }

    public void setConfigurabilityPropertyValue(String configurabilityPropertyValue) {
        this.configurabilityPropertyValue = configurabilityPropertyValue;
    }

    public String getCustomizabilityPropertyValue() {
        return customizabilityPropertyValue;
    }

    public void setCustomizabilityPropertyValue(String customizabilityPropertyValue) {
        this.customizabilityPropertyValue = customizabilityPropertyValue;
    }

    public String getEvolvabilityPropertyValue() {
        return evolvabilityPropertyValue;
    }

    public void setEvolvabilityPropertyValue(String evolvabilityPropertyValue) {
        this.evolvabilityPropertyValue = evolvabilityPropertyValue;
    }

    public String getExtensibilityPropertyValue() {
        return extensibilityPropertyValue;
    }

    public void setExtensibilityPropertyValue(String extensibilityPropertyValue) {
        this.extensibilityPropertyValue = extensibilityPropertyValue;
    }

    public String getReusabilityPropertyValue() {
        return reusabilityPropertyValue;
    }

    public void setReusabilityPropertyValue(String reusabilityPropertyValue) {
        this.reusabilityPropertyValue = reusabilityPropertyValue;
    }

    public String getNetworkEfficiencyPropertyValue() {
        return networkEfficiencyPropertyValue;
    }

    public void setNetworkEfficiencyPropertyValue(String networkEfficiencyPropertyValue) {
        this.networkEfficiencyPropertyValue = networkEfficiencyPropertyValue;
    }

    public String getNetworkPerformancePropertyValue() {
        return networkPerformancePropertyValue;
    }

    public void setNetworkPerformancePropertyValue(String networkPerformancePropertyValue) {
        this.networkPerformancePropertyValue = networkPerformancePropertyValue;
    }

    public String getUserPerceivedPerformancePropertyValue() {
        return userPerceivedPerformancePropertyValue;
    }

    public void setUserPerceivedPerformancePropertyValue(String userPerceivedPerformancePropertyValue) {
        this.userPerceivedPerformancePropertyValue = userPerceivedPerformancePropertyValue;
    }

    public String getPortabilityPropertiesValue() {
        return portabilityPropertiesValue;
    }

    public void setPortabilityPropertiesValue(String portabilityPropertiesValue) {
        this.portabilityPropertiesValue = portabilityPropertiesValue;
    }

    public String getReliabilityPropertiesValue() {
        return reliabilityPropertiesValue;
    }

    public void setReliabilityPropertiesValue(String reliabilityPropertiesValue) {
        this.reliabilityPropertiesValue = reliabilityPropertiesValue;
    }

    public String getScalabilityPropertiesValue() {
        return scalabilityPropertiesValue;
    }

    public void setScalabilityPropertiesValue(String scalabilityPropertiesValue) {
        this.scalabilityPropertiesValue = scalabilityPropertiesValue;
    }

    public String getSimplicityPropertiesValue() {
        return simplicityPropertiesValue;
    }

    public void setSimplicityPropertiesValue(String simplicityPropertiesValue) {
        this.simplicityPropertiesValue = simplicityPropertiesValue;
    }

    public String getVisibilityPropertiesValue() {
        return visibilityPropertiesValue;
    }

    public void setVisibilityPropertiesValue(String visibilityPropertiesValue) {
        this.visibilityPropertiesValue = visibilityPropertiesValue;
    }
}
