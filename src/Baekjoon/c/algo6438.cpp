#include <stdio.h>
#define MAX_LENGTH 71
class Solver {
private:
public:
  Solver() {}

  void solve() {
    int N;
    scanf("%d", &N);
    getchar();

    char sentenses[N][MAX_LENGTH] = {};
    char reversed[N][MAX_LENGTH] = {};

    for (int i = 0; i < N; i++) {
      int idx = 0;
      int c;
      while ((c = getchar()) != '\n' && c != EOF) {
        sentenses[i][idx++] = (char)c;
      }
      sentenses[i][idx] = '\0';
    }

    for (int i = 0; i < N; i++) {
      int idx = 0;
      for (int j = MAX_LENGTH - 1; j >= 0; j--) {
        if (sentenses[i][j] == '\0')
          continue;
        reversed[i][idx++] = sentenses[i][j];
      }
    }

    for (int i = 0; i < N; i++) {
      printf("%s\n", reversed[i]);
    }
  }
};

int main() {
  Solver solver = Solver();
  solver.solve();
  return 0;
}
