import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;
import java.util.TreeSet;

public class Q038Towers {
    static class FastReader {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = read();
            } while (c <= ' ');//skip space, \n, \t

            if (c == '-') {
                sign = -1;
                c = read();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }

            return val * sign;
        }
    }
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int[] cubes = new int[n];
        for(int i = 0; i < cubes.length; i++){
            cubes[i] = fr.nextInt();
        }
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        int towers = 0;
        for(int cube: cubes){
            Integer justGreaterCube = tMap.higherKey(cube);
            if(justGreaterCube != null){
                tMap.put(justGreaterCube, tMap.get(justGreaterCube) - 1);
                if(tMap.get(justGreaterCube) == 0){
                    tMap.remove(justGreaterCube);
                }
            }else{
                towers++;
            }
            tMap.put(cube, tMap.getOrDefault(cube, 0) + 1);

        }
        System.out.println(towers);
    }
}
