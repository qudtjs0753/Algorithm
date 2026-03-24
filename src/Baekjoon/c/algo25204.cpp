#include <stdio.h>
#define MAX_COUNT 15000
#define MAX_LENGTH 51

class Solver {
private:
  int T;
  char temp[MAX_COUNT][MAX_LENGTH];

  void copyStr(char dst[MAX_LENGTH], char src[MAX_LENGTH]) {
    for (int i = 0; i < MAX_LENGTH; i++) {
      dst[i] = src[i];
      if (src[i] == '\0')
        break;
    }
  }

  void mergeSort(char strings[MAX_COUNT][MAX_LENGTH], int left, int right,
                 bool (*compare)(char[], char[])) {
    // 원소가 1개 이하면 정렬할 필요 없음
    if (left >= right)
      return;

    // 반으로 나눠서 각각 정렬
    int mid = (left + right) / 2;
    mergeSort(strings, left, mid, compare);
    mergeSort(strings, mid + 1, right, compare);

    // 정렬된 두 구간을 병합
    int leftIdx = left;      // 왼쪽 구간 탐색 위치
    int rightIdx = mid + 1;  // 오른쪽 구간 탐색 위치
    int tempIdx = left;      // temp에 넣을 위치

    // 양쪽 다 남아있으면 비교해서 temp에 복사
    while (leftIdx <= mid && rightIdx <= right) {
      if (compare(strings[leftIdx], strings[rightIdx]))
        copyStr(temp[tempIdx++], strings[leftIdx++]);
      else
        copyStr(temp[tempIdx++], strings[rightIdx++]);
    }

    // 왼쪽에 남은 것 복사
    while (leftIdx <= mid)
      copyStr(temp[tempIdx++], strings[leftIdx++]);

    // 오른쪽에 남은 것 복사
    while (rightIdx <= right)
      copyStr(temp[tempIdx++], strings[rightIdx++]);

    // temp에서 원본으로 복사
    for (int i = left; i <= right; i++)
      copyStr(strings[i], temp[i]);
  }

public:
  Solver(int T) : T(T) {}

  void solve() {
    for (int i = 0; i < T; i++) {
      int N;
      char strings[MAX_COUNT][MAX_LENGTH] = {};
      scanf("%d", &N);
      for (int j = 0; j < N; j++) {
        scanf("%s", strings[j]);
      }
      stringSort(strings, N, compare);
      printSortedWords(strings, N);
    }
  }

  void printSortedWords(char strings[MAX_COUNT][MAX_LENGTH], int N) {
    for (int i = 0; i < N; i++) {
      printf("%s\n", strings[i]);
    }
  }

  void stringSort(char strings[MAX_COUNT][MAX_LENGTH], int N,
                  bool (*func)(char str1[MAX_LENGTH], char str2[MAX_LENGTH])) {
    mergeSort(strings, 0, N - 1, func);
  }

  /**
   * str1이 위면 true, str2가 위면 false
   */

  static bool compare(char str1[MAX_LENGTH], char str2[MAX_LENGTH]) {
    for (int i = 0; i < MAX_LENGTH; i++) {
      if (str1[i] == '\0')
        return true;
      if (str2[i] == '\0')
        return false;
      if (str1[i] == str2[i])
        continue;

      if (str1[i] == '-')
        return false;
      if (str2[i] == '-')
        return true;

      if (str2[i] == str1[i] + 32)
        return true;
      if (str1[i] == str2[i] + 32)
        return false;

      char ch1 = str1[i];
      char ch2 = str2[i];
      if (ch1 < 97)
        ch1 += 32;
      if (ch2 < 97)
        ch2 += 32;

      if (ch1 < ch2)
        return true;
      return false;
    }
    return true;
  }
};

int main() {
  int T;

  scanf("%d", &T);
  Solver solver = Solver(T);
  solver.solve();
  return 0;
}
