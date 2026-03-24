#include <stdio.h>
#include <string.h>

int main() {
    printf("=== 버퍼 오버플로우 테스트 ===\n\n");

    // Test 1: scanf로 버퍼 오버플로우 발생
    printf("--- Test 1: scanf로 오버플로우 ---\n");
    char direction[3];           // 3바이트만 할당
    int queryPos = 999;
    int queryVal = 888;

    printf("Before scanf:\n");
    printf("  direction = (empty)\n");
    printf("  queryPos = %d\n", queryPos);
    printf("  queryVal = %d\n\n", queryVal);

    printf("'row' 입력하기 (3글자 + null terminator = 4바이트)\n");
    scanf("%s", direction);

    printf("\nAfter scanf:\n");
    printf("  direction = %s\n", direction);
    printf("  queryPos = %d (손상될 수 있음!)\n", queryPos);
    printf("  queryVal = %d (손상될 수 있음!)\n\n", queryVal);

    // Test 2: direction[10]으로 수정한 버전
    printf("--- Test 2: direction[10]으로 수정 ---\n");
    char direction2[10];         // 충분한 크기
    int queryPos2 = 999;
    int queryVal2 = 888;

    printf("Before scanf:\n");
    printf("  queryPos2 = %d\n", queryPos2);
    printf("  queryVal2 = %d\n\n", queryVal2);

    printf("'col' 입력하기:\n");
    scanf("%s", direction2);

    printf("\nAfter scanf:\n");
    printf("  direction2 = %s\n", direction2);
    printf("  queryPos2 = %d (안전함!)\n", queryPos2);
    printf("  queryVal2 = %d (안전함!)\n", queryVal2);

    return 0;
}
