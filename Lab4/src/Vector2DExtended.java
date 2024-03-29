/**
 * Klasa reprezentująca Wektor
 */
public class Vector2DExtended {
    private double x;
    private double y;

    /**
     * Domyślny konstruktor
     */
    public Vector2DExtended() {
        x = 0;
        y = 0;
    }

    /**
     * Konstruktor pobierający dwa parametry — współrzędne x i y wektora.
     * @param x współrzędna x końca wektora
     * @param y współrzędna y końca wektora
     */
    public Vector2DExtended(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Zwróć wartość współrzędnej x końca wektora
     */
    public double getX() {
        return x;
    }

    /**
     * Zwróć wartość współrzędnej y końca wektora
     */
    public double getY() {
        return y;
    }
}

