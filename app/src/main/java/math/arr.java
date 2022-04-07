package math;
//393 Gavrilov
public class arr {
    public static float min(float[] mas, int n)
    {
        float x = mas[0];
        for (int i = 0; i < n; i++)
            if (mas[i] < x) x = mas[i];
        return x;
    }
    public static float max(float[] mas, int n)
    {
        float x = mas[n-1];
        for (int i = n-1; i >= 0; i--)
            if(mas[i] > x) x = mas[i];
        return x;
    }
}

