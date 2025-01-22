 
/**
 * Write a description of class LinearAlgebra here.
 *
 * Anmoldeep Singh
 * 3149800
 * 31-01-2023
 */
public class LinearAlgebra {

    // Scalar Multiplication
    public static void scale(double[] v1, double scalar) {
        for (int i = 0; i < v1.length; i++) {
            v1[i] *= scalar;
        }
    }

    public static void scale(double[][] m1, double scalar) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                m1[i][j] *= scalar;
            }
        }
    }

    // Check Shape
    private static boolean checkShape(double[] v1, double[] v2) {
        return v1.length == v2.length;
    }

    private static boolean checkShape(double[][] m1, double[][] m2) {
        if (m1.length != m2.length) {
            return false;
        }
        for (int i = 0; i < m1.length; i++) {
            if (m1[i].length != m2[i].length) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkShape(double[][] m1) {
        int length = m1[0].length;
        for (int i = 1; i < m1.length; i++) {
            if (m1[i].length != length) {
                return false;
            }
        }
        return true;
    }

    // Vector and m1 addition
    public static void add(double[] v1, double[] v2) {
        if (!checkShape(v1, v2)) {
            throw new IllegalArgumentException("Vectors do not have the same length.");
        }
        for (int i = 0; i < v1.length; i++) {
            v1[i] += v2[i];
        }
    }

    public static void subtract(double[] v1, double[] v2) {
        if (!checkShape(v1, v2)) {
            throw new IllegalArgumentException("Vectors do not have the same length.");
        }
        for (int i = 0; i < v1.length; i++) {
            v1[i] -= v2[i];
        }
    }

    public static void add(double[][] m1, double[][] m2) {
        if (!checkShape(m1, m2)) {
            throw new IllegalArgumentException("Matrices do not have the same shape.");
        }
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                m1[i][j] += m2[i][j];
            }
        }
    }

    public static void subtract(double[][] m1, double[][] m2) {
        if (!checkShape(m1, m2)) {
            throw new IllegalArgumentException("Matrices must have the same shape.");
        }
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                m1[i][j] -= m2[i][j];
            }
        }
    }
    
    //dot product
    public static double dotProduct(double[] v1, double[] v2) {
        if (!checkShape(v1, v2)) {
            throw new IllegalArgumentException("Vectors do not have the same length.");
        }
        double dot_prod = 0;
        for (int i = 0; i < v1.length; i++) {
            dot_prod += v1[i] * v2[i];
        }
        return dot_prod;
    }
    
    //transpose
    public static double[][] transpose(double[][] m1) {
        if (!checkShape(m1)) {
            throw new IllegalArgumentException("matrix should not be ragged");
        }
        double[][] t = new double[m1[0].length][m1.length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                t[j][i] = m1[i][j];
            }
        }
        return t;
    }

}
