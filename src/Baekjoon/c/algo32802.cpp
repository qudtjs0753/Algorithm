#include <stdio.h>

class Solver {
  private:
    int n;

  public:
    Solver(int n): n(n) {}

    void solve() {
      long mouse[n][3];
      char command[n][6];

      for(int i=0; i<n; i++) {
        scanf("%s %ld %ld %ld", command[i], &mouse[i][0], &mouse[i][1], &mouse[i][2]);
      }

      long time;
      scanf("%ld", &time);

      long gainedCheese = 0, gainedGlory = 0;

      for(int i=0; i<n; i++) {
        if(time<mouse[i][0]) continue;
        if(command[i][0] == 'C') {
          gainedCheese += mouse[i][1];
          gainedGlory += mouse[i][2];
        }else {
          gainedCheese -= mouse[i][1];
          gainedGlory -= mouse[i][2];
        }
      }

      printf("%ld %ld", gainedCheese, gainedGlory);
    }
};

int main() {
  int N;
  scanf("%d", &N);

  Solver solver = Solver(N);
  solver.solve();
  return 0;
}
