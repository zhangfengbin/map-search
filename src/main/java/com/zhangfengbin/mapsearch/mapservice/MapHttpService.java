package com.zhangfengbin.mapsearch.mapservice;

import com.zhangfengbin.mapsearch.entity.MapResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.io.*;
import java.util.List;

@Service
public class MapHttpService {

    @Value("${gaode.key}")
    public String key;

    public MapResult httpSearchMap(){

        RestTemplate restTemplate = new RestTemplate();
        String url= "http://restapi.amap.com/v3/place/text?key="+key+"&keywords=药房&types=&city=郑州&children=1&offset=25&page=1&extensions=all";
        String urlStart="http://restapi.amap.com/v3/place/text?key="+key;
        String keywords= "&keywords=药房";
        String city = "&city=郑州";
        String other ="&children=1&offset=25";
        String page = "&page=";
        String extensions= "&extensions=all";
        MapResult mapResult = restTemplate.getForObject(url, MapResult.class);
        int count = Integer.parseInt(mapResult.getCount());
        //获取我需要查询的page数 一般只让查询一百页
         count = (count/25)+1;
        if(count>100){
            count=100;
        }
        //先把查询到的信息写入文件
        writhFile(mapResult.getPois());
        //在循环去分页查询数据
        for (int i = 2; i < count; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            url=urlStart+keywords+city+other+page+i+extensions;
            mapResult = restTemplate.getForObject(url, MapResult.class);
            writhFile(mapResult.getPois());
        }

        return mapResult;
    }

    public static  void writhFile(List pois){
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try {
            File file = new File("./src/main/resources/data.txt");

            if(!file.exists()){
                file.createNewFile();//如果文件不存在，就创建该文件
                fos = new FileOutputStream(file);//首次写入获取
            }else{
                //如果文件已存在，那么就在文件末尾追加写入
                fos = new FileOutputStream(file,true);//这里构造方法多了一个参数true,表示在文件末尾追加写入
            }

            osw = new OutputStreamWriter(fos, "UTF-8");//指定以UTF-8格式写入文件
            for (int i = 0; i < pois.size() ; i++) {
                Object o = pois.get(i);
                osw.write(o.toString()+"\n");
            }

            osw.close();
            fos.close();
        } catch (IOException e) {
            try {
                osw.close();
                fos.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        }

    }

//    public static void main(String[] args) {
//        writhFile();
//    }
    
}
