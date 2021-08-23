package com.scholars.cf.sample.support;

import com.scholars.cf.sample.support.aspects.SupportAspect;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    @DeleteMapping("/cache/clear")
    public int clearCache(){
        try{
            return SupportAspect.cache.size();
        }
        finally {
            SupportAspect.cache.clear();
        }
    }

}
