#include <stdio.h>

class Solver {
  private:
    int N, K;
  public:
    Solver(int N, int K): N(N), K(K){}

    void solve() {
      int students[7][2] = {0};

      for(int i=0; i<N; i++) {
        int sex, grade;
        scanf("%d %d", &sex, &grade);
        students[grade][sex]++;
      }

      int rooms = 0;

      for(int i=1; i<=6; i++) {
        for(int j=0;j<2; j++) {
          rooms += students[i][j]/K;
          if(students[i][j]%K>0) rooms+=1;
        }
      }

      printf("%d", rooms);

    }
};

int main() {
  int N, K;
  scanf("%d %d", &N, &K);
  Solver solver = Solver(N, K);
  solver.solve();
  return 0;
}
