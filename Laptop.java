import java.util.Comparator;

public class Laptop {
    private String model;
    private String proc;
    private int RAM;
    private int memory;
    private double diagonal;
    private String name;


    public String getModel() {
        return model;
    }
    public String getProc() {
        return proc;
    }
    public int getRAM() {
        return RAM;
    }
    public int getMemory() {
        return memory;
    }
    public double getDiagonal() {
        return diagonal;
    }

    private boolean ifMoreOrEqualMemory(Laptop laptop){
        if(this.memory >= laptop.memory)
            return true;
        else
            return false;
    }

    private boolean ifMoreOrEqualRAM(Laptop laptop){
        if(this.RAM >= laptop.RAM)
            return true;
        else
            return false;
    }

    private boolean ifMoreOrEqualDiag(Laptop laptop){
        if(this.diagonal >= laptop.diagonal)
            return true;
        else
            return false;
    }

    public boolean ifMoreOrEqualLaptop(Laptop laptop){
        return this.ifMoreOrEqualRAM(laptop)
                && this.ifMoreOrEqualMemory(laptop)
                && this.ifMoreOrEqualDiag(laptop);
    }

    public Laptop(String model, String proc, int RAM, int memory, double diagonal) {
        this.model = model;
        this.proc = proc;
        this.RAM = RAM;
        this.memory = memory;
        this.diagonal = diagonal;
        this.name = this.toString();
    }

    //в рамках текущей задачи equals переопределяю так. хотя это вроде неверно
    //@Override
    public boolean equals(Object o1){
        Laptop laptop = (Laptop) o1;
        if(this.memory == laptop.memory
        && this.RAM == laptop.RAM
        && this.diagonal == laptop.diagonal)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Модель: %s\n" +
                "Процессор: %s\n" +
                "ОЗУ: %d ГБ\n" +
                "Память: %d ГБ\n" +
                "Диагональ: %.1f\t", this.model, this.proc, this.RAM, this.memory, this.diagonal);
    }
}
