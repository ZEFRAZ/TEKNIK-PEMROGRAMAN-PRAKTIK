package generic;

import java.util.*;

public class DataManager<T extends Printable, ID> {
    protected Map<ID, T> dataMap = new HashMap<>();

    public void tambah(ID id, T data) {
        dataMap.put(id, data);
    }

    public Optional<T> cari(ID id) {
        return Optional.ofNullable(dataMap.get(id));
    }

    public Collection<T> semua() {
        return dataMap.values();
    }

    public void hapus(ID id) {
        dataMap.remove(id);
    }

    public boolean ada(ID id) {
        return dataMap.containsKey(id);
    }
}