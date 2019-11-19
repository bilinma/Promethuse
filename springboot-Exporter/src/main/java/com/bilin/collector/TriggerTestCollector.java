package com.bilin.collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.prometheus.client.Collector;
import io.prometheus.client.GaugeMetricFamily;

public class TriggerTestCollector extends Collector{
	
	private static final Logger logger = LoggerFactory.getLogger(TriggerTestCollector.class);

	@Override
	public List<MetricFamilySamples> collect() {
		List<MetricFamilySamples> mfs = new ArrayList<MetricFamilySamples>();
		logger.error("测试触发是否生效");
		GaugeMetricFamily cpuGauge = new GaugeMetricFamily("cpuUsage_demo", "help", Arrays.asList("namespace","filter", "unit"));
		mfs.add(cpuGauge);
		return mfs;
	}

}
