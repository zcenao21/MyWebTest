package com.will.spring.tx;

public class OrdersServiceAop {
    private OrdersDao ordersDao;

    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    public void accountMoney(){
        ordersDao.addMoney();
        int i=100/0;
        ordersDao.reduceMoney();
    }
}
