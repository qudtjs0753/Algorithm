#include <stdio.h>

class Solver {
  private:
    int N;

  public:
    Solver(int N): N(N) {}

    void solve() {
      for(int i=0; i<N; i++) {
        char number[61];
        scanf("%s", number);
        int idx=0;
        while(number[idx]!='\0') {
          idx++;
        }
        if((number[idx-1]-'0') %2==0)printf("even\n");
        else printf("odd\n");
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
