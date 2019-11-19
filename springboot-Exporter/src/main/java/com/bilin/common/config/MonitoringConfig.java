package com.bilin.common.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bilin.collector.EcsCpuCollector;
import com.bilin.collector.TriggerTestCollector;
import com.bilin.collector.YourCustomCollector;
import com.bilin.collector.YourCustomCollector2;

import io.prometheus.client.exporter.MetricsServlet;

@Configuration
public class MonitoringConfig {
	
    private static final YourCustomCollector yourCustomCollector = new YourCustomCollector().register();
    private static final YourCustomCollector2 yourCustomCollector2 =  new YourCustomCollector2().register();
    
    private static final EcsCpuCollector ecsCpuCollector = new EcsCpuCollector().register();
    
    private static final TriggerTestCollector triggerTestCollector = new TriggerTestCollector().register();

    @Bean
    ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new MetricsServlet(), "/metrics");
    }
}