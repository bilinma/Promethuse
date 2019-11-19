package com.bilin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bilin.dao.SamplesMapper;
import com.bilin.entity.Samples;
import com.bilin.service.SamplesService;

@Service
public class SamplesServiceImpl implements SamplesService {

	@Resource
	private SamplesMapper samplesMapper;

	@Override
	public void saveData(Samples userInfo) {
		samplesMapper.saveData(userInfo);
	}

	@Override
	public Samples selectById(String id) {
		return samplesMapper.selectById(id);
	}

	@Override
	public List<Samples> selectList() {
		return samplesMapper.selectList();
	}

}
