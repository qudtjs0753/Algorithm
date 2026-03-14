#include <cstdio>
#include <cstring>

int getNumber(char str[]);

int main() {
  int N;


  while(scanf("%d", &N) && N !=0) {
    int jean=0, joe=0, jane=0, james = 0, no=0;

    for(int i=0; i<N; i++) {
      char str[10];
      scanf("%s", str);

      if(str[0]=='X') no++;
      else if(str[0]=='S') james++;
      else if(str[0]=='M' || str[0]=='L') joe++;
      else {
        int number = getNumber(str);
        if(number<12) jane++;
        else jean++;
      }
    }

    printf("%d %d %d %d %d\n", joe, jean, jane, james, no);
  }

  return 0;
}

int getNumber(char str[]) {
  int idx = 0, ans=0;
  while(idx<2) {
    if(str[idx]=='\0') return ans;
    ans = 10*ans + str[idx] - '0';
    idx++;
  }
  return ans;
}
