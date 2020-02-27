public class Roots {

    private double negativeRoot;
    private double positiveRoot;

    private Complex4 positiveRootComplex;
    private Complex4 negativeRootComplex;
    
    
    public Roots(double x, double y, boolean complexOrNot, double imaginarySqrt) {
        positiveRoot = x;
        negativeRoot = y;
        if (complexOrNot) {
            positiveRootComplex = new Complex4(positiveRoot, imaginarySqrt);
            negativeRootComplex = new Complex4(negativeRoot, imaginarySqrt);
        }
        else {
            imaginarySqrt = 0;
            positiveRootComplex = new Complex4(positiveRoot, imaginarySqrt);
            negativeRootComplex = new Complex4(negativeRoot, imaginarySqrt);
        }
    }
    public String toString() {
        return "\nPositive: " + positiveRootComplex + "\nNegative: " + negativeRootComplex;
    }
}