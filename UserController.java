package com.deepexi.user.controller;

import com.deepexi.product.domain.eo.Product;
import com.deepexi.product.service.ProductService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.naming.Context;

/**
 * @author xuejw
 * @version 1.0
 * @description 服务提供者
 * @date 2019/3/28
 */
public class UserController {
    //product-center是服务消费者
    //user-center是服务提供者
    /**
     * user-center实现远程调用product-center服务
     */

    //新增产品
    //修改产品
    //查看产品
    //分页获取全部产品
    //批量删除
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext(new String[]{"dubbo-test-consumer.xml"} );
        context.start();
        ProductService productService = (ProductService) context.getBean("productService");

        //创建商品
        Product product = new Product();
        product.setName("华为");
        product.setPrice(3000);
        product.setId("99");
        Object product1 = productService.createProduct(product);

        //批量删除
        productService.deleteProductById("99");

        //分页获取数据
        productService.getProductList(3,10,2);
    }

    ClassPathXmlApplicationContext context
            = new ClassPathXmlApplicationContext(new String[]{"dubbo-test-consumer.xml"});
}

