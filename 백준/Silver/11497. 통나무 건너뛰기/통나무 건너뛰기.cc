#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
    int T;
    cin >> T;  // 테스트 케이스 수 입력

    int N;
    for (int t = 0; t < T; t++) {
        cin >> N;
        vector<int> A(N);

        // 통나무 높이 입력
        for (int i = 0; i < N; i++) {
            cin >> A[i];
        }

        // 통나무 높이 정렬
        sort(A.begin(), A.end());

        // 통나무를 지그재그로 배치
        vector<int> arrangement(N);
        int left = 0, right = N - 1;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                arrangement[left++] = A[i];
            } else {
                arrangement[right--] = A[i];
            }
        }

        // 최대 높이 차이 계산
        int resDiff = 0;
        for (int i = 1; i < N; i++) {
            resDiff = max(resDiff, abs(arrangement[i] - arrangement[i - 1]));
        }

        // 원형 배치 고려: 처음과 마지막 통나무 사이의 차이
        resDiff = max(resDiff, abs(arrangement[0] - arrangement[N - 1]));

        cout << resDiff << endl;
    }

    return 0;
}