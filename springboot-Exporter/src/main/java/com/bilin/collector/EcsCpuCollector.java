package com.bilin.collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.prometheus.client.Collector;
import io.prometheus.client.GaugeMetricFamily;

/**
 * 模拟获取华为云数据由Prometheus Server 拉取数据（存在问题时间序列无法保存华为返回的）
 * 
 * 验证结果：一次拉取的数据时间序列相同
 * @author hp
 *
 */
public class EcsCpuCollector extends Collector {

	private static final Logger logger = LoggerFactory.getLogger(EcsCpuCollector.class);

	
	
	@Override
	public List<MetricFamilySamples> collect() {
		List<MetricFamilySamples> mfs = new ArrayList<MetricFamilySamples>();

		String metricName = "cpuUsage";

		GaugeMetricFamily cpuGauge = new GaugeMetricFamily(metricName, "help", Arrays.asList("namespace","filter", "unit"));
		
		/**
		 * 调用华为接口实时获取数据
		 */
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logger.info("调用华为接口实时获取数据{}", i);
			cpuGauge.addMetric(Arrays.asList("SYS.ECS","average","s"),i );
		}
		
		
		mfs.add(cpuGauge);
		
		return mfs;
	}

}
