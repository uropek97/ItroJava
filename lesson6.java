import java.util.*;

public class lesson6 {
    public static void main(String[] args) {
        String[] models = new String[]{"Lenovo", "ASUS", "Acer"};
        String[] processors = new String[]{"Intel", "AMD"};
        int[] rams = new int[]{ 8, 16, 32};//ГБ
        int[] memoryes = new int[]{1024, 1536, 2048};//ГБ
        double[] diagonals = new double[]{ 16, 16.5, 17};

        Map<Laptop, Integer> laptops = new HashMap<>();

        Random rdm = new Random();
        for(int i = 0; i < 1000; i++){
            String model = models[rdm.nextInt(0,3)];
            String proc = processors[rdm.nextInt(0,2)];
            int ram = rams[rdm.nextInt(0, 3)];
            int memory = memoryes[rdm.nextInt(0, 3)];
            double diag = diagonals[rdm.nextInt(0, 3)];

            Laptop newLaptop = new Laptop(model, proc, ram, memory, diag);
            if(laptops.containsKey(newLaptop)){
                var a = laptops.get(newLaptop);
                laptops.put(newLaptop, ++a);
            }
            else
                laptops.put(newLaptop, 1);
        }

        Scanner iScanner = new Scanner(System.in);
        System.out.print("Мин. ОЗУ: ");
        var RAMem = iScanner.nextInt();
        System.out.print("Мин. объём памяти: ");
        var minMemory = iScanner.nextInt();
        System.out.print("Мин. диагональ: ");
        var minDiag = iScanner.nextDouble();

        Laptop search = new Laptop("", "", RAMem, minMemory, minDiag);
        int count = 0;
        for(var item : laptops.entrySet()){
            var a = item.getKey();
            if(a.ifMoreOrEqualLaptop(search)){
                System.out.println(a);
                System.out.printf(String.format("В наличии: %d\n", item.getValue()));
                System.out.println("---------------");
                count++;
            }
        }
        System.out.println(String.format("Ноутбуков удовлетворящих критериям: %d", count));
    }
}


