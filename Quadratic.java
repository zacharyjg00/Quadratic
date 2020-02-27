public class Quadratic {
    
    private float a;
    private float b;
    private float c;

    public Quadratic(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    } //Quadratic (constructor) end

    public float getA() {
        return a;
    }
    public void setA(float value) {
        a = value;
    }
    
    public float getB() {
        return b;
    }
    public void setB(float value) {
        b = value;
    }

    public float getC() {
        return a;
    }
    public void setC(float value) {
        c = value;
    }


    public Quadratic add(Quadratic other) {
        a += other.a;
        b += other.b;
        c += other.c;
        return new Quadratic(a, b, c);
    } //add end

    public Quadratic subtract(Quadratic other) {
        a -= other.a;
        b -= other.b;
        c -= other.c;
        return new Quadratic(a, b, c);
    } //subtract end

    public Roots findRoots() {
        double positiveX;
        double squareRoot;
        double negativeX;
        double imaginarySqrt = 0;
        boolean complexOrNot = false;
        double squareRootNumber = ((b * b) - (4 * a * c));
        
        if (squareRootNumber < 0) {
            imaginarySqrt = Math.sqrt(squareRootNumber * -1);
            positiveX = ((-b + imaginarySqrt) / (2 * a));
            negativeX = ((-b - imaginarySqrt) / (2 * a));
            complexOrNot = true;
            return new Roots(positiveX, negativeX, complexOrNot, imaginarySqrt);

        }
        else {
            squareRoot = Math.sqrt(squareRootNumber);
            positiveX = ((-b + squareRoot) / (2 * a));
            negativeX = ((-b - squareRoot) / (2 * a));
            return new Roots(positiveX, negativeX, complexOrNot, imaginarySqrt);
        }
    }

    public String toString() {
        float tempA = a; //These temp variables are set equal to a, b, and c so that in order to format them, we aren't changing the actual values of a, b, and c.
        float tempB = b;
        float tempC = c;
        if (a < 0 && b < 0 && c < 0 ) { //All of these possibilities are for the correct formatting of the quadratic equation depending on whether a, b, or c are negative.
            tempA *= -1;
            tempB *= -1;
            tempC *= -1;
            return "-" + tempA + "x^2 - " + tempB + "x - " + tempC;
        }
        else if (a < 0 && b < 0) {
            tempA *= -1;
            tempB *= -1;
            return "-" + tempA + "x^2 - " + tempB + "x + " + c;
        }
        else if (a < 0 && c < 0) {
            tempA *= -1;
            tempC *= -1;
            return "-" + tempA + "x^2 + " + b + "x - " + tempC;
        }
        else if (b < 0 && c < 0) {
            tempB *= -1;
            tempC *= -1;
            return "" + a + "x^2 - " + tempB + "x - " + tempC;
        }
        else if (a < 0) {
            tempA *= -1;
            return "-" + tempA + "x^2 + " + b + "x + " + c;
        }
        else if (b < 0) {
            tempB *= -1;
            return "" + a + "x^2 - " + tempB + "x + " + c;
        }
        else if (c < 0) {
            tempC *= -1;
            return "" + a + "x^2 + " + b + "x - " + tempC;
        }
        else {
            return "" + a + "x^2 + " + b + "x + " + c;
        }
    } //toString end

    public boolean equals(Object other) {
        Quadratic temp;
        if (other instanceof Quadratic) {
            temp = (Quadratic) other;
            if (a == temp.a && b == temp.b && c == temp.c) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    } //equals end

    public static void main(String[] args) {
        Quadratic quad1 = new Quadratic(9, -4, 1);
        System.out.println("The first Quadratic object is " + quad1);
        System.out.println();
        Quadratic quad2 = new Quadratic(9, -6, 1);
        Quadratic quad4 = new Quadratic(9, -6, 1);
        System.out.println("The second Quadratic object is + " + quad2);
        System.out.println();
        Quadratic quad3 = new Quadratic(18, -5, -4);
        System.out.println("The third Quadratic object is + " + quad3);
        System.out.println();
        System.out.println("The new Quadratic object when Quad 2 is added to Quad 1 is " +  quad1.add(quad2));
        System.out.println();
        System.out.println("The new Quadratic object when Quad 2 is subtracted from Quad 3 is " + quad3.subtract(quad2));
        System.out.println();
        Roots quad1Roots = quad1.findRoots();
        System.out.println("The roots for Quad 1 are as follows: " + quad1Roots);
        System.out.println();
        Roots quad2Roots = quad2.findRoots();
        System.out.println("The roots for Quad 2 are as follows: " + quad2Roots);
        System.out.println();
        System.out.println("Does Quad 1 equal Quad 2? The answer is: " + quad1.equals(quad2));
        System.out.println();
        System.out.println("Does Quad 2 equal Quad 4? The answer is: " + quad2.equals(quad4));
    }
} //Quadratic (class) end