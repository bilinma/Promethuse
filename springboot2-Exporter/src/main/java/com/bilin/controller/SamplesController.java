package com.bilin.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bilin.entity.Samples;
import com.bilin.service.SamplesService;

@RestController
@RequestMapping("/samples")
public class SamplesController {
    @Resource
    private SamplesService samplesService;
    
    @RequestMapping(value ="/saveData" ,method = RequestMethod.POST)
    public String saveData (Samples samples){
    	samples.setTs(new Date());
    	samples.setUpdated(new Date());
        samplesService.saveData(samples);
        return "ok";
    }
    @RequestMapping(value ="/selectById" ,method = RequestMethod.GET)
    public Samples selectById (String name) {
        return samplesService.selectById(name) ;
    }
    
    @RequestMapping(value ="/selectList",method = RequestMethod.GET)
    public List<Samples> selectList () {
        return samplesService.selectList() ;
    }
}
