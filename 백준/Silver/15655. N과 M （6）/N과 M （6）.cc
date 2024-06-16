#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <sstream>

using namespace std;

void DFS(int num, int depth, vector<int> &vec);

static vector<int> v;
static int M;

int main(void) {
    int N; cin >> N >> M; v.resize(N);
    for (int i = 0; i < N; i++) {
        cin >> v[i];
    }
    
    // sort
    sort(v.begin(), v.end());

    vector<int> vec;
    DFS(0, 0, vec);
}

void DFS(int i, int depth, vector<int> &vec) {
    if (depth == M) {
        for (int ve : vec) {
            cout << ve << " ";
        }
        cout << endl;
    }
    
    for (int j = i; j < v.size(); j++) {
        vec.push_back(v[j]);
        DFS(j + 1, depth + 1, vec);
        vec.pop_back();
    }
}