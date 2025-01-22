import java.util.Arrays;
/**
 * A class for testing our LinearAlgebra class
 *
 * @author Jesse Harder
 * @version 1
 */
public class Driver
{        
    public static void main(String[] args)
    {
        System.out.println("Testing vectors...");
        double[] v1 = {1, 2, 3}; 
        double[] v2 = {7, 8, 9};
        
        System.out.println("v1 = " + Arrays.toString(v1));
        System.out.println("v2 = " + Arrays.toString(v2));

        // This will overwrite v1
        LinearAlgebra.add(v1, v2);
        System.out.println("v1 + v2 = " + Arrays.toString(v1));
        
        LinearAlgebra.subtract(v2, v1);
        System.out.println("v2 - v1 = " + Arrays.toString(v2));
        
        LinearAlgebra.scale(v1, 2);
        System.out.println("2 * v1 = " + Arrays.toString(v1));
        
        double dot_prod = LinearAlgebra.dotProduct(v1, v2);
        System.out.println("v1 • v2 = " + dot_prod);
        
        System.out.println("Testing shape compare exception exception...");
        try{
            double[] v3 = {1, 2};
            dot_prod = LinearAlgebra.dotProduct(v1, v3);
            System.out.println("\tException failed");
        }catch(IllegalArgumentException e){
            System.out.println("\tException worked");
        }
        
        System.out.println("\nTesting matrices...");
        double[][] m1 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        double[][] m2 = {
            {7, 8, 9},
            {2, 7, 5}
        };
        
        System.out.println("m1 = " + Arrays.deepToString(m1));
        System.out.println("m2 = " + Arrays.deepToString(m2));

        // This should overrwrite m1
        LinearAlgebra.add(m1, m2);
        System.out.println("m1 + m2 = " + Arrays.deepToString(m1));
        
        LinearAlgebra.subtract(m2, m1);
        System.out.println("m2 - m1 = " + Arrays.deepToString(m2));
        
        LinearAlgebra.scale(m1, 2);
        System.out.println("2 * m1 = " + Arrays.deepToString(m1));
        
        double[][] t = LinearAlgebra.transpose(m1);
        System.out.println("m^t = " + Arrays.deepToString(t));
        
        System.out.println("Testing shape compare exception...");
        try{
            double[][] m3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            LinearAlgebra.subtract(m1, m3);
            System.out.println("\tException failed");
        }catch(IllegalArgumentException e){
            System.out.println("\tException worked");
        }
        
        System.out.println("Testing ragged shape exception...");
        try{
            double[][] m3 = {{1, 2, 3}, {4, 5}, {7, 8, 9}};
            LinearAlgebra.subtract(m1, m3);
            System.out.println("\tException failed");
        }catch(IllegalArgumentException e){
            System.out.println("\tException worked");
        }
        
    }

}