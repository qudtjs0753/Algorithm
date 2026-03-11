# include <stdio.h>

int main() {
  long a, b, c, d;

  scanf("%ld %ld %ld %ld", &a, &b, &c, &d);

  long dividend = a*c;
  long divisor = b*d*2;

  if(dividend < divisor || dividend%divisor!=0) {
    printf("0\n");
  } else {
    printf("1\n");
  }

  return 0;
}


