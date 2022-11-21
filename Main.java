public class Main {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(3, 3, new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Matrix m2 = new Matrix(3, 3, new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Matrix m3 = m1.matrixMultiply(m2);
        m1.print();
        m2.print();
        m3.print();
        Matrix m4 = m3.transpose();
        m4.print();
        // Matrix m2 = new Matrix(2, 3, new double[]{1, 2, 3, 4, 5, 6});
        // Matrix m3 = new Matrix(3, 2, new double[]{1, 2, 3, 4, 5, 6});
        // m1.print();
        // m2.print();
        // m3.print();

        // Matrix c1 = m1.getColumn(0);
        // Matrix r1 = m1.getRow(0);
        // c1.print();
        // r1.print();

        // Matrix c2 = m2.getColumn(0);
        // Matrix r2 = m2.getRow(0);
        // c2.print();
        // r2.print();

        // Matrix c3 = m3.getColumn(0);
        // Matrix r3 = m3.getRow(0);
        // c3.print();
        // r3.print();
    }
    
}
