#include <stdio.h>

class Solver {
  private:
    int rows, cols,min,max, sum;
    int **matrix;

  public:
    Solver(int rows, int cols): rows(rows), cols(cols) {
      matrix = new int*[rows];
      for(int i=0; i<rows; i++) {
        matrix[i] = new int[cols];
      }
      min = 100000;
      max = -100000;
      sum = 0;
    }

    void solve() {
      for(int i=0; i<rows; i++) {
        for (int j=0; j<cols; j++){
          scanf("%d", &matrix[i][j]);
        }
      }

      // query
      int query,queryPos, queryVal;
      char direction[10];

      // 메모리 주소 출력 (디버깅용)
      fprintf(stderr, "=== Memory Addresses ===\n");
      fprintf(stderr, "query address:    %p\n", (void*)&query);
      fprintf(stderr, "queryPos address: %p\n", (void*)&queryPos);
      fprintf(stderr, "queryVal address: %p\n", (void*)&queryVal);
      fprintf(stderr, "direction address: %p\n", (void*)&direction);
      fprintf(stderr, "direction[10] size: %zu bytes\n", sizeof(direction));
      fprintf(stderr, "======================\n");

      scanf("%d", &query);

      for(int i=0; i<query; i++) {
        scanf("%s %d %d", direction, &queryPos, &queryVal);
        if(direction[0]=='r') queryRow(queryPos,queryVal);
        else queryCol(queryPos,queryVal);
      }

      for(int i=0; i<rows; i++) {
        for (int j=0; j<cols; j++){
          calculate(i,j);
        }
      }

      printf("%d %d %d", sum, min, max);
    }

    void queryCol(int queryPos, int queryVal) {
      for(int i=0; i<rows; i++) {
        matrix[i][queryPos-1] += queryVal;
      }
    }

    void queryRow(int queryPos, int queryVal) {
      for(int i=0; i<cols; i++) {
        matrix[queryPos-1][i] += queryVal;
      }
    }

    void calculate(int i, int j) {
      if(min>matrix[i][j]) min = matrix[i][j];
      if(max<matrix[i][j]) max = matrix[i][j];
      sum+=matrix[i][j];
    }
};

int main() {
  int rows, cols;
  scanf("%d %d", &rows, &cols);

  Solver solver = Solver(rows, cols);
  solver.solve();
  return 0;
}
