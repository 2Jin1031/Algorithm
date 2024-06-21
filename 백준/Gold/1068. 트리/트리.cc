#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
#include <queue>
#include <cmath>
#include <climits>

using namespace std;

static vector<vector<int> > A;
static int removeNode;
static int result = 0;

void DFS(int node);

int main(void) {
    int N; cin >> N; A.resize(N);
    int rootNode;
    for (int i = 0; i < N; i++) {
        int parentNode; cin >> parentNode;
        if (parentNode != -1) A[parentNode].push_back(i);
        else rootNode = i;
    }

    cin >> removeNode;

    DFS(rootNode);

    cout << result;
}

void DFS(int node) {
    if (node == removeNode) return ;
    
    bool hasChild = false;
    for (int childNode : A[node]) {
        if (childNode != removeNode) {
            hasChild = true;
            DFS(childNode);
        }
    }

    if(!hasChild) {
        result++;
    }
}