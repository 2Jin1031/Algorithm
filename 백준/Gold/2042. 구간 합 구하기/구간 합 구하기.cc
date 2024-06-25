#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <string>
#include <cmath>

using namespace std;

static vector<long> tree;

long getSum(int s, int e);
void changeVal(int index, long val);
void setTree(int i);

int main(void) {
    int N, M, K; cin >> N >> M >> K; 
    int treeHeight = 0;
    int Length = N;

    while (Length != 0) {
        Length /= 2;
        treeHeight++;
    }

    int treeSize = int(pow(2, treeHeight + 1));
    int leftNodeStartIndex = treeSize / 2 - 1;
    tree.resize(treeSize + 1);
    tree[0] = 0;
    for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
        cin >> tree[i];
    }

    setTree(treeSize - 1);

    for (int i = 0; i < M + K; i++) {
        long a, s, e; cin >> a >> s >> e;
        if (a == 1) {
            changeVal(leftNodeStartIndex + s, e);
        }
        else if (a == 2) {
            s = s + leftNodeStartIndex;
            e = e + leftNodeStartIndex;
            cout << getSum(s, e) << "\n";
        }
        else {
            cout << "[ERROR] unexpected value";
            return -1;
        }
    }
}

long getSum(int s, int e) {
    long partSum = 0;

    while (s <= e) {
        if (s % 2 == 1) {
            partSum += tree[s];
            s++;
        }
        if (e % 2 == 0) {
            partSum += tree[e];
            e--;
        }
        
        s = s / 2;
        e = e / 2;
    }

    return partSum;
}

void changeVal(int index, long val) {
    long diff = val - tree[index];

    while (index > 0) {
        tree[index] += diff;
        index = index / 2;
    }
}

void setTree(int i) {
    while (i != 1) {
        tree[i / 2] += tree[i];
        i--;
    }
}