package cxx.code.algori;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class future {
    public static void main(String[] args) {
        String fileP = "D:\\Java项目\\Notes\\src\\main\\java\\cxx\\code\\algori\\P1.txt";
        String fileS = "D:\\Java项目\\Notes\\src\\main\\java\\cxx\\code\\algori\\S1.txt";
        long start = System.currentTimeMillis();
        List<List<Double>> listP = readData(fileP);
        List<List<Double>> listS = readData(fileS);
        System.out.println(listS);
        System.out.println(listP);
        Map<Integer, List<Double>> mapS = readMap(fileS);
        long readEnd = System.currentTimeMillis();
        long readTime = readEnd - start;
        Map<Integer, DTO> rec = new TreeMap();
        mapS.entrySet().parallelStream().forEach(entry -> {
            List<Double> curS = entry.getValue();
            int max = 0;
            int ord = 0;
            for(int j = 0; j < listP.size(); ++j) {
                List<Double> curP = new ArrayList<>(listP.get(j));
                int count = 0;
                int index = 0;
                for(int k = 0; k < curS.size(); ++k) {
                    index = find(curS.get(k), curP);
                    if(index == -1) {
                        continue;
                    }
                    count++;
                    curP = curP.subList(index + 1, curP.size());
                    if(curP.isEmpty()) {
                        break;
                    }
                }
                if(count > max) {
                    max = count;
                    ord = j;
                }
            }
            rec.put(entry.getKey(), new DTO(ord, max));
        });
        try {
            File fileR = new File("D:\\Java项目\\Notes\\src\\main\\java\\cxx\\code\\algori\\R1.txt");
            FileWriter wr = new FileWriter(fileR, true);
            for(DTO dto : rec.values()) {
                String output = dto.getOrd() + " " + dto.getCount();
                System.out.println(output);
//                wr.write(output);
//                wr.flush();
            }
        } catch (Exception e) {
            System.out.println("出错了！");
        }
    }

    static int find(Double target, List<Double> list) {
        int left = 0;
        int right = list.size() - 1;
        int mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if(Math.abs((list.get(mid) - target)) < 0.01) {
                if(mid > 0 && Math.abs((list.get(mid - 1) - target)) >= 0.01) {
                    return mid;
                } else {
                    while(mid > 0 && Math.abs((list.get(mid - 1) - target)) < 0.01) {
                        mid--;
                    }
                    return mid;
                }
            } else if(list.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    static List<List<Double>> readData(String fileName) {
        File file = new File(fileName);
        List<List<Double>> rec = new ArrayList<>();
        List<Double> temp = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = "";
            while((str = br.readLine()) != null) {
                if(str.startsWith("#")) {
                    rec.add(new ArrayList<>(temp));
                    temp.clear();
                } else {
                    temp.add(Double.parseDouble(str));
                }
            }
            rec.add(new ArrayList<>(temp));
            rec.remove(0);
        } catch (Exception e) {

        }
        return rec;
    }

    static Map<Integer, List<Double>> readMap(String fileName) {
        File file = new File(fileName);
        Map<Integer, List<Double>> map = new HashMap<>();
        List<Double> temp = new ArrayList<>();
        int count = 0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = "";
            while((str = br.readLine()) != null) {
                if(str.startsWith("#")) {
                    map.put(count++, new ArrayList<>(temp));
                    temp.clear();
                } else {
                    temp.add(Double.parseDouble(str));
                }
            }
            map.put(count, new ArrayList<>(temp));
        } catch (Exception e) {

        }
        map.remove(0);
        return map;
    }
}


class DTO {
    private int ord;
    private int count;

    public DTO(int ord, int count) {
        this.ord = ord;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getOrd() {
        return ord;
    }
}