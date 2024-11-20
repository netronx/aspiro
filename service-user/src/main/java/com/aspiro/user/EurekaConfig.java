//package com.aspiro.service_user;
//
//import com.netflix.appinfo.ApplicationInfoManager;
//import com.netflix.appinfo.InstanceInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.context.WebServerInitializedEvent;
//import org.springframework.cloud.commons.util.InetUtils;
//import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.EventListener;
//
//import com.netflix.appinfo.ApplicationInfoManager;
//import com.netflix.appinfo.EurekaInstanceConfigBean;
//import com.netflix.appinfo.InstanceInfo;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.context.WebServerInitializedEvent;
//import org.springframework.cloud.commons.util.InetUtils;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.EventListener;
//
//@Configuration
//public class EurekaConfig {
//
//    @Value("${spring.application.name}")
//    private String appName;
//
//    private final EurekaInstanceConfigBean eurekaInstanceConfig;
//    private final ApplicationInfoManager applicationInfoManager;
//
//    public EurekaConfig(InetUtils inetUtils, ApplicationInfoManager applicationInfoManager) {
//        this.eurekaInstanceConfig = new EurekaInstanceConfigBean(inetUtils);
//        this.applicationInfoManager = applicationInfoManager;
//    }
//
//    @Bean
//    public EurekaInstanceConfigBean eurekaInstanceConfig() {
//        return eurekaInstanceConfig;
//    }
//
//    @EventListener(WebServerInitializedEvent.class)
//    public void onApplicationEvent(WebServerInitializedEvent event) {
//        int assignedPort = event.getWebServer().getPort();
//        eurekaInstanceConfig.setNonSecurePort(assignedPort);
//        eurekaInstanceConfig.setInstanceId(appName + ":" + eurekaInstanceConfig.getIpAddress() + ":" + assignedPort);
//
//        // Update Eureka metadata map to include the actual port
//        eurekaInstanceConfig.getMetadataMap().put("instanceId", eurekaInstanceConfig.getInstanceId());
//        eurekaInstanceConfig.getMetadataMap().put("port", String.valueOf(assignedPort));
//
//        // Force Eureka to re-register with the updated port
//        applicationInfoManager.refreshDataCenterInfoIfRequired();
//        applicationInfoManager.setInstanceStatus(InstanceInfo.InstanceStatus.UP);
//
//        System.out.println("Eureka Instance ID: " + eurekaInstanceConfig.getInstanceId());
//        System.out.println("Assigned Port in Eureka Config: " + assignedPort);
//    }
//}
