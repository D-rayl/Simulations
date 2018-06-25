using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
/*
 * Daryl Crosbie
 * ID: P453055
 * 
 * This program is a calculator which does Arithmetic, Alegbra, Trigonometry calculations 
 * 
 * @author D-veloper
 * @package Calc
 * */
namespace Calculator
{

    public partial class Calc : Form
    {
        public Calc()
        {
            InitializeComponent();
        }

        double total1 = 0; 
        double total2 = 0; 
        bool plusButtonClicked = false;
        bool minusButtonClicked = false;
        bool divideButtonClicked = false;
        bool multiplyButtonClicked = false;
        
        /*
         * Equals button, when clicked first check the number sign
         * then call the appropriate method from the appropriate library
         * passing in the two values
         * */
        private void BtnEquals_Click(object sender, EventArgs e)
        {
            if (!(plusButtonClicked || minusButtonClicked) && !(divideButtonClicked || multiplyButtonClicked))
            {
                MessageBox.Show("No claculation");
            }
            else
            {
                if (plusButtonClicked == true)
                {
                    total2 = Arithmetic.Arithmetic.Add(total1, double.Parse(tb.Text));
                }
                else if (minusButtonClicked == true)
                {
                    total2 = Arithmetic.Arithmetic.Sub(total1, double.Parse(tb.Text));
                }
                else if (divideButtonClicked == true)
                {
                    if (double.Parse(tb.Text) == 0)
                    {
                        MessageBox.Show("Cannot divide by Zero");
                    }
                    else
                    {
                        total2 = Arithmetic.Arithmetic.Div(total1, double.Parse(tb.Text));
                    }
                }
                else if (multiplyButtonClicked == true)
                {
                    total2 = Arithmetic.Arithmetic.Multi(total1, double.Parse(tb.Text));
                }
                tb.Text = total2.ToString();
                total1 = 0;
            }
        }

        /*
         * Start of numeric buttons
         * When clicked the value is added to the text field
         * */
        private void Btn1_Click(object sender, EventArgs e)
        {
            tb.Text = tb.Text + button1.Text;
        }

        private void Btn2_Click(object sender, EventArgs e)
        {
            tb.Text = tb.Text + button2.Text;
        }

        private void Btn3_Click(object sender, EventArgs e)
        {
            tb.Text = tb.Text + button3.Text;
        }

        private void Btn4_Click(object sender, EventArgs e)
        {
            tb.Text = tb.Text + button4.Text;
        }

        private void Btn5_Click(object sender, EventArgs e)
        {
            tb.Text = tb.Text + button5.Text;
        }

        private void Btn6_Click(object sender, EventArgs e)
        {
            tb.Text = tb.Text + button6.Text;
        }

        private void Btn7_Click(object sender, EventArgs e)
        {
            tb.Text = tb.Text + button7.Text;
        }

        private void Btn8_Click(object sender, EventArgs e)
        {
            tb.Text = tb.Text + button8.Text;
        }

        private void Btn9_Click(object sender, EventArgs e)
        {
            tb.Text = tb.Text + button9.Text;
        }
        //Last numeric button
        private void BtnZero_Click(object sender, EventArgs e)
        {
            tb.Text = tb.Text + bZero.Text;
        }
        
        /*
         * Clear button clears the text field
         * */
        private void BtnClear_Click(object sender, EventArgs e)
        {
            tb.Clear();
        }

        /*
         * Decimal point adds to the text field
         * */
        private void BtnPoint_Click(object sender, EventArgs e)
        {
            tb.Text = tb.Text + bPoint.Text;
        }

        /*
         * Add button stores the initial value
         * Clears the text field
         * Assigns which numeric sign has been clicked for the equals operator
         * */
        private void BtnAdd_Click(object sender, EventArgs e)
        {
            total1 += double.Parse(tb.Text);
            tb.Clear();
            plusButtonClicked = true;
            minusButtonClicked = false;
            divideButtonClicked = false;
            multiplyButtonClicked = false;
        }

        /*
         * Subtract button follows the same procedure as the add button
         * */
        private void BtnSub_Click(object sender, EventArgs e)
        {
            total1 += double.Parse(tb.Text);
            tb.Clear();
            plusButtonClicked = false;
            minusButtonClicked = true;
            divideButtonClicked = false;
            multiplyButtonClicked = false;
        }

        /*
         * Multiplication button follows the same procedure as the add button 
         * */
        private void bMulti_Click(object sender, EventArgs e)
        {
            total1 += double.Parse(tb.Text);
            plusButtonClicked = false;
            minusButtonClicked = false;
            divideButtonClicked = false;
            multiplyButtonClicked = true;
            tb.Clear();
        }

        /*
         * Division button follows the same procedure as the add button
         * */
        private void bDiv_Click(object sender, EventArgs e)
        {
            total1 = double.Parse(tb.Text);
            plusButtonClicked = false;
            minusButtonClicked = false;
            divideButtonClicked = true;
            multiplyButtonClicked = false;
            tb.Clear();
        }

        /*
         * Square root button 
         * Checks not a negative value
         * Passes the value to the square root method from the Algebra class
         * displays returned value to the text field
         * if negative value display relevant error message
         * */
        private void BtnSqrt_Click(object sender, EventArgs e)
        {
            double num = double.Parse(tb.Text);
            if (num >= 0)
            {
                tb.Text = Algebra.Algebra.SquareRoot(num).ToString();
            }
            else
            {
                MessageBox.Show("Number must be positive", "Error Message");
                tb.Text = "0";
            }
        }

        /*
         * Cube root button
         * Passes the value to the cube root method from the Algebra class
         * displays returned value to the text field
         * */
        private void BtnCubeRT_Click(object sender, EventArgs e)
        {
            double num = double.Parse(tb.Text);
            tb.Text = Algebra.Algebra.CubeRoot(num).ToString();
        }

        /*
         * Inverse button
         * Passes the value to the cube root method from the Algebra class
         * displays returned value to the text field
         * */
        private void BtnInv_Click(object sender, EventArgs e)
        {
            tb.Text = Algebra.Algebra.Inverse(double.Parse(tb.Text)).ToString();
        }

        /*
         * Tan button
         * First check if value = 90 or 270
         * Pass the value to the Tan method from the Trigonometric class
         * Displys return value to the text field
         * */
        private void BtnTan_Click(object sender, EventArgs e)
        {
            double num = double.Parse(tb.Text);
            if (num == 90 || num == 270)
            {
                tb.Text = "Undefined";
            }
            else
            {
                tb.Text = Trigonometric.Trigonometric.Tan(num).ToString();
            }
        }

        /*
         * Sin button
         * Passes the value to the Sin method from the Trigonometric class
         * Displys return value to the text field
         * */
        private void BtnSin_Click(object sender, EventArgs e)
        {
            double num = double.Parse(tb.Text);
            tb.Text = Trigonometric.Trigonometric.Sin(num).ToString();
        }

        /*
         * Cosine button
         * Passes the value to the Cos method from the Trigonometric class
         * Displys return value to the text field
         * */
        private void BtnCos_Click(object sender, EventArgs e)
        {
            double num = double.Parse(tb.Text);
            tb.Text = Trigonometric.Trigonometric.Cos(num).ToString();
        }

        /*
         * Key pressed check
         * Only allow valid keys to input 
         * */
        private void Tb_KeyPress(object sender, KeyPressEventArgs e)
        {
            char ch = e.KeyChar;
            if(!Char.IsDigit(ch) && !Char.IsControl(ch) && (ch != '.'))
            {
                e.Handled = true;
            }
        }

        /*
         * Negative value button
         * if pressed adds negative sign to the text field
         * */
        private void BtnNeg_Click(object sender, EventArgs e)
        {
            if (!tb.Text.Contains("-"))
            {
                tb.Text = "-" + tb.Text;
            }
            else
            {
                tb.Text = tb.Text.TrimStart('-');
            }
        }

        /*
         * Menu bar button clears the text field
         * */
        private void Clear_ToolStripMenuItem(object sender, EventArgs e)
        {
            tb.Clear();
        }
        /*
         * Mune item, quit button
         * if pressed display exit option
         * */
        private void Quit_ToolStripMenuItem(object sender, EventArgs e)
        {
            if (MessageBox.Show("Really Quit?", "Exit", MessageBoxButtons.OKCancel) == DialogResult.OK)
            {
                Application.Exit();
            }
        } 
    }
}
