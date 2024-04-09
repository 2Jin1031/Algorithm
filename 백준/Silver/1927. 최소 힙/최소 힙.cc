#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>

// #2307

using namespace std;

static int N;
static priority_queue<int, vector<int>, greater<int> > pq;

struct cmp {
    bool operator() (int a, int b) {
        return a > b;
    }
};

void ft_add_pq(int num) {
    pq.push(num);
}

void ft_delete_pq() {
    if (pq.size () == 0) cout << "0" << "\n";
    else {
        cout << pq.top() << "\n";
    pq.pop();
    }
}

void ft_logic(int num) {
    if (num > 0) ft_add_pq(num);
    else if (num == 0) ft_delete_pq();
    else printf("ERROR");
    return ;
} 

int main(void) {
    cin >> N;
    for (int i = 0; i < N; i++) {
        int value; scanf("%d", &value);
        ft_logic(value);
    }


}
