#include <stdio.h>

class Solver {
private:
  int N;

public:
  Solver(int N) : N(N) {}

  void solve() {
    if (N % 2 == 0) {
      printf("I LOVE CBNU");
      return;
    }

    for (int i = 0; i < N; i++) {
      printf("*");
    }
    printf("\n");

    for (int i = 0; i < N / 2 + 1; i++) {
      int point1 = N / 2 - i;
      int point2 = N / 2 + i;

      for (int j = 0; j < N; j++) {
        if (j == point2) {
          printf("*");
          break;
        } else if (j == point1) {
          printf("*");
        } else {
          printf(" ");
        }
      }
      printf("\n");
    }
  }
};

int main() {
  int N;
  scanf("%d", &N);
  getchar();
  Solver solver = Solver(N);
  solver.solve();
  return 0;
}
