package com.bilin.collector;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bilin.common.utils.CommonUtil;

import io.prometheus.client.Collector;
import io.prometheus.client.GaugeMetricFamily;

public class YourCustomCollector2 extends Collector {

	private static final Logger logger = LoggerFactory.getLogger(YourCustomCollector2.class);

	public List<MetricFamilySamples> collect() {
		// With no labels.
		int v1 = CommonUtil.getRandomInt();
		logger.info("Metric sample1 value:{}", v1);
		List<MetricFamilySamples> mfs = new ArrayList<MetricFamilySamples>();
		
		mfs.add(new GaugeMetricFamily("my_gauge_2", "help", v1));
		// With labels
		
		int v2 = CommonUtil.getRandomInt();
		logger.info("Metric sample1 value:{}", v2);
		GaugeMetricFamily labeledGauge = new GaugeMetricFamily("my_other_gauge", "help", Arrays.asList("labelname"));
		labeledGauge.addMetric(Arrays.asList("foo"), v1);
		labeledGauge.addMetric(Arrays.asList("bar"), v2);
		mfs.add(labeledGauge);
		return mfs;
	}
}