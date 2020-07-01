package stepik.problem_2_3_4;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Complex complex1 = solution.createComplex(1, -1);
        Complex complex2 = solution.createComplex(3, 6);
        System.out.println(complex1);
        System.out.println(complex1.mul(complex2));
    }

    Complex createComplex(double real, double image) {
        // enter your code
        return new ComplexImpl(real, image);
    }

    class ComplexImpl implements Complex {

        private final double real;
        private final double image;

        public ComplexImpl(double real, double image) {
            this.real = real;
            this.image = image;
        }

        @Override
        public Complex sum(Complex other) {
            return new ComplexImpl(real + other.getReal(), image + other.getImage());
        }

        @Override
        public Complex sub(Complex other) {
            return new ComplexImpl(real - other.getReal(), image - other.getImage());
        }

        @Override
        public Complex mul(Complex other) {

            double newReal = real * other.getReal() - image * other.getImage();
            double newImage = real * other.getImage() + image * other.getReal();

            return new ComplexImpl(newReal, newImage);
        }

        @Override
        public double getReal() {
            return real;
        }

        @Override
        public double getImage() {
            return image;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ComplexImpl)) return false;

            ComplexImpl complex = (ComplexImpl) o;

            return toString().equals(complex.toString());
        }

        @Override
        public int hashCode() {
            return toString().hashCode();
        }

        @Override
        public String toString() {
            return String.format("%.2f+%.2fi", real, image);
        }
    }

    interface Complex {

        Complex sum(Complex other);

        Complex sub(Complex other);

        Complex mul(Complex other);

        double getReal();

        double getImage();
    }

}

