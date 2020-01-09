package com.yanftch.review.designpatterns.simplefactory;

/**
 * 计算机的的简单工厂类
 */
public class SimpleComputerFactory {

    public static Computer generateComputer(String type) {
        Computer computer = null;
        switch (type) {
            case "lenovo":
                computer = new LenovoComputer();
                break;
            case "hp":
                computer = new HpComputer();
                break;
            case "asus":
                computer = new AsusComputer();
                break;
            default:
                computer = new LenovoComputer();

        }
        return computer;
    }


    // 客户端调用，直接在这地方写喽
    public static void main(String[] args) {
        Computer computer = SimpleComputerFactory.generateComputer("asus");
        computer.start();
    }
}
