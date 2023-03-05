package db;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MySqlTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Test
    void printData() {
        String sql = "select stock from product where id="+"101";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        System.out.println(list);
    }
}
