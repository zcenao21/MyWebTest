package com.will.spring.tx;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class OrdersService {
    private OrdersDao ordersDao;

    public void setOrdersDao(OrdersDao ordersDao){
        this.ordersDao=ordersDao;
    }

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate){
        this.transactionTemplate=transactionTemplate;
    }

    public void addAccountMoney(){
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                Object result = null;

                try{
                    // 如果都维持3000不变则说明事务配置成功
                    // 小王 加 1000
                    ordersDao.addMoney();
                    int i=100/0;

                    // 小马 减 1000
                    ordersDao.reduceMoney();
                }catch (Exception e){
                    status.setRollbackOnly();
                    result =false;
                    System.out.println("Transaction Error!");
                }

                return null;
            }
        });
    }
}
