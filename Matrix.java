public class Matrix {

    private final int rows;
    private final int columns;
    private final double[][] data;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[this.rows][this.columns];
    }

    public Matrix(int rows, int columns, double[] data) {
        this.rows = rows;
        this.columns = columns;
        this.data = constructDataArray(data);
    }

    public Matrix(double[][] data) {
        this.rows = data.length;
        this.columns = data[0].length;
        this.data = data;
    }

    public Matrix(Matrix m) {
        this(m.data);
    }

    private double[][] constructDataArray(double[] data) {
        double[][] result = new double[this.rows][this.columns];
        double[] row = new double[this.columns];
        for (int i = 0; i < this.rows * this.columns; i++) {
            if (i != 0 && i % this.columns == 0) {
                result[(i - 1) / this.columns] = row;
                row = new double[this.columns];
            }

            if (data.length > i) {
                row[i % this.columns] = data[i];
            } else {
                row[i % this.columns] = 0;
            }
        }
        result[this.rows - 1] = row;
        return result;
    }

    public void scalarMultiply(double scalar) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                data[i][j] *= scalar;
            }
        }
    }

    public Matrix matrixMultiply(Matrix righMatrix) {
        double[][] result = new double[this.rows][righMatrix.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < righMatrix.columns; j++) {
                result[i][j] = dotProduct(this.getRow(i), righMatrix.getColumn(j));
            }
        }
        return new Matrix(result);
    }

    public Matrix transpose() {
        double[][] result = new double[this.columns][this.rows];
        for (int i = 0; i < this.columns; i++) {
            result[i] = this.getColumnAsArray(i);
        }
        return new Matrix(result);
    }
    
    //TODO: gaussian elimination with partial pivoting (reduce round-off errors) -> create function for LU decomposition -> create function for inverse and determinants

    private double[] getColumnAsArray(int column) {
        if (column < this.columns) {
            double[] columnResult = new double[this.rows];
            for (int i = 0; i < this.rows; i++) {
                columnResult[i] = this.data[i][column];
            }
            return columnResult;
        }
        return null;
    }

    public double dotProduct(Matrix rowMatrix, Matrix columnMatrix) {
        double result = 0;
        for (int i = 0; i < rowMatrix.columns; i++) {
            result += rowMatrix.data[0][i] * columnMatrix.data[i][0];
        }
        return result;
    }

    public Matrix getRow(int row) {
        if (row < this.rows) {
            return new Matrix(1, this.columns, this.data[row]);
        }
        return null;
    }

    public Matrix getColumn(int column) {
        if (column < this.columns) {
            double[] columnResult = new double[this.rows];
            for (int i = 0; i < this.rows; i++) {
                columnResult[i] = this.data[i][column];
            }
            return new Matrix(this.rows, 1, columnResult);
        }
        return null;
    }

    public void print() {
        String result = "";
        for (double[] row : this.data) {
            for (double value : row) {
                result += value + " ";
            }
            result += "\n";
        }
        System.out.println(result);
    }

}