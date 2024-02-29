#include <iostream>
using namespace std;

int main(void) {
    int x1, y1, x2, y2, x3, y3;
    scanf("%d %d", &x1, &y1);
    scanf("%d %d", &x2, &y2);
    scanf("%d %d", &x3, &y3);

    // 벡터 (x2 - x1, y2 - y1)와 (x3 - x1, y3 - y1)의 외적 계산
    int cross_product = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);

    // 외적의 부호로 위치 판별
    if (cross_product > 0) {
        printf("1\n"); // 점 (x3, y3)가 직선의 왼쪽에 위치
    } else if (cross_product < 0) {
        printf("-1\n"); // 점 (x3, y3)가 직선의 오른쪽에 위치
    } else {
        printf("0\n"); // 점 (x3, y3)가 직선 위에 위치
    }

    return 0;
}
