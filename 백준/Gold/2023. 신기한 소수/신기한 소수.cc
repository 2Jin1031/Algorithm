#include <string>
#include <vector>
#include <cstring>
#include <iostream>

using namespace std;

void DFS(int num, int ja);
bool isPrime(int num);
static int N;
void DFS(int v);

int main(void) {
    cin >> N;

    DFS(2, 1);
    DFS(3, 1);
    DFS(5, 1);
    DFS(7, 1);
}

void DFS(int num, int ja) {
    if (ja == N) {
        if (isPrime(num)) cout << num << "\n";
        return ;
    }

    for (int i = 1; i < 10; i++) {
        if (i % 2 == 0) {
            continue;
        }
        if (isPrime(num * 10 + i)) {
            DFS(num * 10 + i, ja + 1);
        }
    }
}

bool isPrime(int num) {
    for (int i = 2; i <= num / 2; i++) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}