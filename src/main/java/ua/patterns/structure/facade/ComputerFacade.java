package ua.patterns.structure.facade;

public class ComputerFacade {
    private Memory memory;
    private CPU cpu;

    public ComputerFacade(Memory memory, CPU cpu) {
        this.memory = memory;
        this.cpu = cpu;
    }

    void showInfo(){
        memory.totalMemory();
        cpu.temperature();
    }
}
