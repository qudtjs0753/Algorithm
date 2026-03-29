#include <stdio.h>

class Solver {
private:
public:
  Solver() {}

  void solve() {
    int H, I, A, R, C;
    scanf("%d %d %d %d %d", &H, &I, &A, &R, &C);
    printf("%d", H * I - A * R * C);
  }
};

int main() {
  Solver solver;
  solver.solve();
  return 0;
}
