#include <stdio.h>

class Solver {
  private:
    int n;

  public:
    Solver(int n): n(n) {}

    void solve() {
      int result = 0;

      for (int i=0; i<n; i++) {
        int count=0, apples=0;
        scanf("%d %d", &count, &apples);
        if(count>apples) result += apples;
        else result += apples%count;
      }

      printf("%d", result);
    }
};

int main() {
  int N;
  scanf("%d", &N);
  Solver solver = Solver(N);
  solver.solve();
  return 0;
}
