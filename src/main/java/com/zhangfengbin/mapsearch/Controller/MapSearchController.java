package com.zhangfengbin.mapsearch.Controller;

import com.zhangfengbin.mapsearch.entity.MapResult;
import com.zhangfengbin.mapsearch.mapservice.MapHttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapSearchController {

    @Autowired
    public MapHttpService mapHttpService;

    @GetMapping("/searchMap")
    public MapResult searchMap(){

        MapResult mapResult = mapHttpService.httpSearchMap();
        return mapResult;
    }

}
