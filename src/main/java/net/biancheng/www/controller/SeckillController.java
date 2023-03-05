/*
package net.biancheng.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.sun.xml.internal.ws.api.message.Packet.Status.Response;

@RestController
public class SeckillController {
    @Autowired
    private SeckillService seckillService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/seckill")
    public Response seckill(@RequestParam Long userId, @RequestParam Long goodsId) {
        // 接口请求次数的限制
        String limitKey = "seckill:limit:" + userId;
        Long limit = redisTemplate.opsForValue().increment(limitKey, 1);
        if (limit > 1) {
            return Response.fail("您已经参加过秒杀，请不要重复提交！");
        }
        redisTemplate.expire(limitKey, 10, TimeUnit.SECONDS);

        // 用户提交订单前的验证
        SeckillGoods seckillGoods = seckillService.getSeckillGoodsById(goodsId);
        if (seckillGoods == null) {
            return Response.fail("商品不存在！");
        }
        if (seckillGoods.getStockCount() <= 0) {
            return Response.fail("商品已经售罄！");
        }

        // 秒杀活动期间的并发控制
        String lockKey = "seckill:lock:" + goodsId;
        String uuid = UUID.randomUUID().toString();
        try {
            boolean locked = redisTemplate.opsForValue().setIfAbsent(lockKey, uuid, 10, TimeUnit.SECONDS);
            if (!locked) {
                return Response.fail("参与人数太多，请稍后再试！");
            }
            seckillGoods = seckillService.getSeckillGoodsById(goodsId);
            if (seckillGoods.getStockCount() <= 0) {
                return Response.fail("商品已经售罄！");
            }

            // 订单提交和库存扣减的事务控制
            seckillService.createOrder(userId, seckillGoods);
        } finally {
            if (uuid.equals(redisTemplate.opsForValue().get(lockKey))) {
                redisTemplate.delete(lockKey);
            }
        }

        return Response.ok("抢购成功！");
    }
}

*/
