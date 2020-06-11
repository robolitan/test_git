package ua.patterns.structure.facade;

/**
 * Просто сведение различных сервисов к одному классу, который будет предоставлять требуемые запросы
 * (Посредник)
 *
 * */

public class MainFacade {
    public static void main(String[] args) {
        Memory memory = new Memory();
        CPU cpu = new CPU();

        new ComputerFacade(memory,cpu).showInfo();


    }
}
