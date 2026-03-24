#include <math.h>
#include <stdio.h>

class Solver {
private:
  double N, P, K;

public:
  Solver(int N, int P, int K) : N(N), P(P), K(K) {}

  void solve() {
    // 최소지점이 언제일까?
    // N day, K dollar for hire, P dollar

    double result = K + N * P;
    int person = 2;

    while (result >= K * person + N / person * P) {
      result = K * person + N / person * P;
      person++;
    }

    printf("%.3f", round(result * 1000) / 1000);
  };
};

int main() {
  int N, P, K;
  scanf("%d %d %d", &N, &P, &K);
  Solver solver = Solver(N, P, K);
  solver.solve();
  return 0;
}
