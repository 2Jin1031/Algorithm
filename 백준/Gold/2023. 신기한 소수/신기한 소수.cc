#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>

using namespace std;
static vector<vector<int> > A;
static vector<bool> visited;
static int N;
void DFS(int v, int count);
bool isPrime(int num);

int main(void) {
    scanf("%d", &N);

    DFS(2, 1);
    DFS(3, 1);
    DFS(5, 1);
    DFS(7, 1);
    
}

void DFS(int v, int count) {
    if (!isPrime(v)) {
        return ;
    }

    if (count == N) {
        printf("%d\n", v);
        return ;
    }

    for (int i = 1; i < 10; i++) {
        DFS(v * 10 + i, count + 1);
    }

}

bool isPrime(int num) {
    for (int i = 2; i < num / 2; i++) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}