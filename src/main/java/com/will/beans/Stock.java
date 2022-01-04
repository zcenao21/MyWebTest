package com.will.beans;

import lombok.Data;

import java.text.DecimalFormat;

@Data
public class Stock {
    private String id;

    private String name;

    private double yesterday;

    private double today ;

    private double highest;

    private double lowest;

    private double current;

    private String range ;

    public Stock(String id, String name, double yesterday) {
        this.id = id;
        this.name = name;
        this.yesterday = yesterday;

        //把开盘价设定为-1，后面在定时器计算出来的随机数，如果发现开盘价是-1，就设置第一次的随机数为开盘价
        this.today = -1;

        //把最高、最低、当前的价格都暂且设置成昨天的开盘价，后面我们可以变化的
        this.highest = yesterday;
        this.current = yesterday;
        this.lowest = yesterday;

    }

    /**
     * 每次设置当前价钱的时候，最高、最低、涨幅都应该随着当前价钱而变化的
     */
    public void setCurrent(double current) {

        //计算出涨幅或跌幅
        double range = (current - this.yesterday) / this.yesterday;

        //设置涨幅和跌幅不能超过10%，当前的价格只能是昨天开盘价的1.1倍或0.9倍

        //当前价格应该是两位小数
        DecimalFormat formatPrice = new DecimalFormat("#.00");

        if (range > 0.1) {
            current = Double.parseDouble(formatPrice.format(this.yesterday * 1.1));
        }

        if (range < -0.1) {
            current = Double.parseDouble(formatPrice.format(this.yesterday * 0.9));
        }
        this.current = current;

        //如果今天开盘价没设定，那么就将第一次的当前价作为今天的开盘价
        if (this.today == -1) {
            this.today = this.current;
        }

        //比较最大值和最小值
        if (this.current > this.highest) {
            this.highest = this.current;
        }
        if (this.current < this.lowest) {
            this.lowest = this.current;
        }

        //格式化涨幅的字符串，整数两位，小数两位
        DecimalFormat formatRange = new DecimalFormat("##.##%");
        this.range = formatRange.format(range);
    }
}
