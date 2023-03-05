package net.biancheng.www.service;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    Cache<String, Object> cache;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int getStock(long productId) {
        // 从缓存中获取库存，如果不存在则从数据库中获取
        String stock = (String) cache.asMap().get(productId);
        if (stock == null) {
            String sql = "select stock from product where id="+productId;
            List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);

//            stock = list.getStock(productId);
//            cache.set(productId, stock);
        }
        return 1;
    }
}
