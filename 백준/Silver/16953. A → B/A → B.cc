#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>


// 16953
using namespace std;

static int A;
static int B;
static bool flag = false;

void BFS();

int main(void) {
    scanf("%d %d", &A, &B);

    BFS();
}

void BFS() {
    queue<int> q;
    int num = B;
    int count = 1;
    q.push(num);

    while (1) {
        count++;
        if (num % 2 == 0) {
            num = num / 2;
        }
        else if (num % 10 == 1) {
            num /= 10;
        }
        else {
            flag = false;
            break;
        }
        if (num == A) {
            flag = true;
            break;
        }
        else if (num < A) {
            flag = false;
            break;
        }
    }

    if (flag) printf("%d", count);
    else printf("-1");

    return ;
}