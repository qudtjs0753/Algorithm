#include <stdio.h>
#define MAX_PEOPLE 50
#define MAX_VALUE 1000000000

class Solver {
private:
  int N;

public:
  Solver(int N) : N(N) {}

  void solve() {
    int people[MAX_PEOPLE][2] = {0};

    for (int i = 0; i < N; i++) {
      scanf("%d %d", &people[i][0], &people[i][1]);
    }

    // 정렬해서 아래에서 부터 하나씩 본다.
    // 만약 배송비가 더 크면 덧셈 노노.
    sort(people);

    int max = 0;
    int val = 0;

    for (int i = 0; i < N; i++) {
      int cost = people[i][0];
      int sumOfProfit = 0;
      for (int j = i; j < N; j++) {
        int profit = cost - people[j][1];
        if (profit < 0) {
          continue;
        }
        sumOfProfit += profit;
      }

      if (sumOfProfit > max) {
        max = sumOfProfit;
        val = cost;
      }
    }

    if (max == 0)
      printf("0");
    else
      printf("%d", val);
  }

  void sort(int people[MAX_PEOPLE][2]) {
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        if (people[i][0] > people[j][0]) {
          int tempPay = people[i][0];
          int tempDeliveryFee = people[i][1];
          people[i][0] = people[j][0];
          people[i][1] = people[j][1];
          people[j][0] = tempPay;
          people[j][1] = tempDeliveryFee;
        }
      }
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
