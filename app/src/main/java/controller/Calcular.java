package controller;

public class Calcular {

    public int calculaH(int n) {
        int h = 0;

        for (int i = 1; i <= n; i++) {
            if ((i % 2) == 0) {
                h = h + (2 * i);
            } else {
                h = h + i;
            }
        }

        return h;
    }
}
