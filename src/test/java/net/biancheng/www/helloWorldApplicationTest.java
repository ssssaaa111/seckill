package net.biancheng.www;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class helloWorldApplicationTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;



    @Test
    void printDBData() {
        String sql = "select stock from product where id="+"101";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        System.out.println(list);
        assert list.size()>0;
    }



    @Test
    public void testValue() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("string", "I am a string");
        log.info("string:{}", valueOperations.get("string"));
        assert Objects.requireNonNull(valueOperations.get("string")).length() > 0;

    }


}