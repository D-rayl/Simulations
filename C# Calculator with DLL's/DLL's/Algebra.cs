using System;
/*
 * Daryl Crosbie
 * ID: P453055
 * 
 * This is a library for Algebraic calculations
 * 
 * @author Daryl
 * @version 1.0
 * @date 18/05/18
 * */
namespace Algebra
{
    public class Algebra
    {
        public static double SquareRoot(double x)
        {
            return Math.Sqrt(x);
        }

        public static double Inverse(double x)
        {
            return 1 / x;
        }
        /*
         * Cube root method
         * check if negative value and apply - sign for correct results
         * */
        public static double CubeRoot(double x)
        {
            double root;
            double roundedRoot;
            if (x.ToString().Contains("-"))
            {
                root = (System.Math.Pow(-x, (1.0 / 3.0)));
                roundedRoot = Math.Round(root);
                if (Math.Abs(roundedRoot - root) < 1e-10)
                {
                    return -roundedRoot;
                }
                else
                {
                    return -root;
                }
            }
            else
            {
                root = (System.Math.Pow(x, (1.0 / 3.0)));
                roundedRoot = Math.Round(root);
                if (Math.Abs(roundedRoot - root) < 1e-10)
                {
                    return roundedRoot;
                }
                else
                {
                    return root;
                }
            }
           

        }
    }
}
