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

typedef pair<int, int> Node;

static vector<vector<Node> > A;
static vector<bool> visited;
static vector<int> m_distance;
static int N;

void BFS(int index);

int main(void) {
    scanf("%d", &N);
    A = vector<vector<Node> >(N + 1);
    visited = vector<bool> (N + 1, false);

    for (int i = 0; i < N; i++) {
        int a; scanf("%d", &a);
        while (1) {
            int b, c;
            for (int j = 0; j < 2; j++) {
                scanf("%d", &b);
                if (b == -1) break;
                scanf("%d", &c);
                A[a].push_back(Node(b, c));
            }
            if (b == -1) break;
        }
    }

    m_distance = vector<int>(N + 1, 0);
    BFS(1);
    int Max = 1;

    for (int i = 2; i <= N; i++) {
        if (m_distance[Max] < m_distance[i]) {
            Max = i;
        }
    }
    fill(m_distance.begin(), m_distance.end(), 0);
    fill(visited.begin(), visited.end(), false);
    BFS(Max);
    sort(m_distance.begin(), m_distance.end());
    cout << m_distance[N] << "\n";
}

void BFS(int index) {
    queue<int> myqueue;
    myqueue.push(index);
    visited[index] = true;

    while (!myqueue.empty()) {
        int now_node = myqueue.front();
        myqueue.pop();
        for (Node i: A[now_node]) {
            if(! visited[i.first]) {
                visited[i.first] = true;
                myqueue.push(i.first);

                m_distance[i.first] = m_distance[now_node] + i.second;
            }
        }
    }
}