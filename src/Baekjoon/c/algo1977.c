#include <stdio.h>

int main() {
  int M,N;

  scanf("%d",  &M);
  scanf("%d",  &N);

  int sum = 0;
  int min = 0;
  for(int i=M; i<=N; i++) {
    for(int j=1; j*j<=i; j++) {
      if(j*j==i) {
        if(sum==0) min = i;
        sum += i;
      }
    }
  }


  if(sum==0) {
    printf("%d", -1);
  } else {
    printf("%d\n", sum);
    printf("%d", min);
  }

  return 0;
}
