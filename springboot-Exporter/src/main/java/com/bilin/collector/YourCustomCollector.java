package com.bilin.collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bilin.common.utils.CommonUtil;

import io.prometheus.client.Collector;

public class YourCustomCollector extends Collector {
	private static final Logger logger = LoggerFactory.getLogger(YourCustomCollector.class);
	
	
    public List<MetricFamilySamples> collect() {
        List<MetricFamilySamples> mfs = new ArrayList<MetricFamilySamples>();
        
        String metricName = "my_guage_1";

        // Your code to get metrics
        int v1 = CommonUtil.getRandomInt();
        logger.info("Metric sample1 value:{}",v1);
        MetricFamilySamples.Sample sample = new MetricFamilySamples.Sample(metricName, Arrays.asList("l1"), Arrays.asList("v1"), v1);
        
        int v2 = CommonUtil.getRandomInt();
        logger.info("Metric  sample2 value:{}",v2);
        MetricFamilySamples.Sample sample2 = new MetricFamilySamples.Sample(metricName, Arrays.asList("l1", "l2"), Arrays.asList("v1", "v2"), v2);

        MetricFamilySamples samples = new MetricFamilySamples(metricName, Type.GAUGE, "help", Arrays.asList(sample, sample2));

        mfs.add(samples);
        
        
        return mfs;
    }
}