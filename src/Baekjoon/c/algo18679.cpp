#include <stdio.h>
#define MAX_STRING 21
#define MAX_WORDS 100

class Solver {
private:
  int N;

public:
  Solver(int N) : N(N) {}

  void solve() {
    char earth[MAX_WORDS][MAX_STRING] = {}, mar[MAX_WORDS][MAX_STRING] = {};
    for (int i = 0; i < N; i++) {
      scanf("%s = %s", earth[i], mar[i]);
    }
    int K;
    scanf("%d", &K);

    for (int i = 0; i < K; i++) {
      int wordCnt;
      scanf("%d", &wordCnt);
      char sentence[wordCnt][MAX_STRING] = {};

      for (int j = 0; j < wordCnt; j++) {
        scanf("%s", sentence[j]);
        int index = findMarWord(sentence[j], earth);
        printf("%s ", mar[index]);
      }
      printf("\n");
    }
  }

  int findMarWord(char word[], char earth[MAX_WORDS][MAX_STRING]) {
    for (int i = 0; i < N; i++) {
      if (compare(earth[i], word)) {
        return i;
      }
    }
    return -1;
  }

  bool compare(char ch1[], char ch2[]) {
    int idx = 0;

    while (idx < MAX_STRING) {
      if (ch1[idx] != ch2[idx]) {
        return false;
      }
      idx++;
    }
    return true;
  }
};

int main() {
  int N;
  scanf("%d", &N);
  Solver solver = Solver(N);
  solver.solve();
  return 0;
}
