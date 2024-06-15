#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <sstream>

using namespace std;

typedef struct info {
    int number;
    int score[4];
    bool use = false;
} info;

int main(void) {
    int N; cin >> N;
    
    info I[N + 1];
    int number;
    int inputScore[4];
    for (int i = 0; i < N; i++) {
        cin >> number;
        for (int j = 0; j < 4; j++) {
            cin >> inputScore[j];
            I[number].score[j] = inputScore[j];
        }
        
    }

    // sort
    int maxScore;
    int idx = 0;
    for (int j = 0; j < 4; j++) {
        maxScore = -1;
        for (int i = 1; i < N + 1; i++) {
            if (I[i].score[j] > maxScore && !I[i].use) {
                maxScore = I[i].score[j];
                idx = i;
            }
        }
        cout << idx << " ";
        I[idx].use = true;
    }
}