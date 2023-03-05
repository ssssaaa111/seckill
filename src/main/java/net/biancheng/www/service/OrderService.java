/*
package net.biancheng.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ProductService productService;
    public boolean placeOrder(long productId, long userId) {
        // 获取商品库存
        int stock = productService.getStock(productId);
        if (stock <= 0) {
            return false;
        }
        // 使用乐观锁更新库存
        boolean success = db.updateStockWithOptimisticLock(productId, stock - 1, stock);
        if (!success) {
            // 库存不足
            return false;
        }
        // 生成订单
        Order order = new Order();
        order.setProductId(productId);
        order.setUserId(userId);
        order.setPrice(productService.getPrice(productId));
        order.setStatus(OrderStatus.WAIT_FOR_PAY);
        order.setCreateTime(new Date());
        db.createOrder(order);
        return true;
    }
}

*/
