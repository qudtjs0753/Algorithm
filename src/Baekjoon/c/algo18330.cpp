#include <stdio.h>

class Solver {
private:
public:
  Solver() {}

  void solve() {
    int n, k;
    scanf("%d", &n);
    scanf("%d", &k);
    // 60liter, 1달. liter당 1500. 넘어가면 3000

    int canUse = k + 60;

    if (n < canUse)
      printf("%d", 1500 * n);
    else {
      printf("%d", canUse * 1500 + (n - canUse) * 3000);
    }
  }
};

int main() {
  Solver solver;
  solver.solve();
  return 0;
}
