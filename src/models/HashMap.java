package models;

public class HashMap {

    private Bucket map[];

    public HashMap() {
        map = new Bucket[10];
    }

    public void put(int key, int value) {
        Bucket b = new Bucket(key, value);
        map[funcao_hash(key)] = b;
    }

    public Bucket delete(int key) {
        Bucket b = map[funcao_hash(key)];
        map[funcao_hash(key)] = null;
        return b;
    }

    public Bucket get(int key) {
        return map[funcao_hash(key)];
    }

    public void clear() {
        for (int i = 0; i < 10; i++) {
            map[i] = null;
        }
    }

    private static int funcao_hash(int key) {
        return Math.abs(key) % 10;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < 10; i++) {
            if (map[i] == null) {
                sb.append("null");
            } else {
                sb.append("(");
                sb.append(map[i].key);
                sb.append(",");
                sb.append(map[i].value);
                sb.append(")");
            }
            if (i < 9) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
