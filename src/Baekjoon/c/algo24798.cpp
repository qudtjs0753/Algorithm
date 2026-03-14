#include <stdio.h>
#include <cassert>
#define ALPHABET_MAX 26


class Main {
  private:
    int length, sum;
    int word[40] = {-1};

  public:
    Main(int length, int sum) : length(length), sum(sum){}


    void doMethod() {
      if(sum/length==0 || 26*length<sum) {
        printf("impossible");
        return;
      }

      int avg = sum/length;
      int remain = sum%length;

      for(int i=0; i<length; i++) {
        char result = 'a'+avg-1;
        if(remain>0) {
          result++;
          remain--;
        }
        printf("%c", result);
      }
    }
};


int main() {
  int length, sum;
  scanf("%d %d", &length, &sum);
  Main wordFinder = Main(length, sum);
  wordFinder.doMethod();
  return 0;
}
