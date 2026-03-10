#include <stdio.h>
#include <limits.h>

#define LIMIT 512


int main() {
  int min_diff = INT_MAX;
  int N = 0;
  int oneRM = -1;

  scanf("%d", &N);

  for(int i=0; i<N; i++) {
    int a, b, c;

    scanf("%d %d %d", &a, &b, &c);

    int sum = a+b+c;

    if(sum>=LIMIT && sum - LIMIT < min_diff) {
      oneRM = sum;
      min_diff = sum - LIMIT;
    }
  }

  printf("%d", oneRM);
  return 0;
}
