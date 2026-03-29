#include <stdio.h>

class Solver {
private:
  int N;

public:
  Solver(int N) : N(N) {}

  void solve() {
    char ch[4] = {'S', 'H', 'S'};
    for (int i = 0; i < N; i++) {
      if (i == 0)
        printf("S");
      else
        printf("%c", ch[(i - 1) % 3]);
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
