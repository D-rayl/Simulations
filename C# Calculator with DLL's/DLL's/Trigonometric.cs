using System;
/*
 * Daryl Crosbie
 * ID: P453055
 * 
 * This is a library for Trigonometry calculations
 * 
 * @author Daryl
 * @version 1.0
 * @date 18/05/18
 * */
namespace Trigonometric
{
    public class Trigonometric
    {
        public static double Cos(double x)
        {
            return Math.Round(Math.Cos(Math.PI * (x / 180.0)),3);
        }

        public static double Sin(double x)
        {
            return Math.Round(Math.Sin(Math.PI * (x / 180.0)),3);
        }

        public static double Tan(double x)
        {
            return Math.Round(Math.Tan(x * (Math.PI / 180.0)),3);
        }
    }
}
