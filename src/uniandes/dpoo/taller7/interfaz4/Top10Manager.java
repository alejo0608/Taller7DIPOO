package uniandes.dpoo.taller7.interfaz4;

import java.io.File;

import uniandes.dpoo.taller7.modelo.Top10;

public class Top10Manager {
    private Top10 top10;
    private static final String FILE_PATH = "data/top10.csv";

    public Top10Manager(Top10 top10) {
        this.top10 = top10;
    }

    public void saveTop10() {
        try {
            top10.salvarRecords(new File(FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadTop10() {
        try {
            top10.cargarRecords(new File(FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






