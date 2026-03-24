#include <stdio.h>

class Solver {
  private:
    int N;

  public:
    Solver(int N): N(N) {
    }

    void solve() {
      for(int i=0;i<N;i++) {
        for(int j=0; j<N; j++){
          printf("%d ", i%2 + 1 );
        }
        printf("\n");
      }
    }
};

int main() {
  int N;
  scanf("%d", &N);
  Solver solver = Solver(N);
  solver.solve();
  return 0;
}
