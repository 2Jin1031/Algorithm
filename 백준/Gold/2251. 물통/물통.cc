#include <iostream>
#include <vector>
#include <queue>
#include <functional>

using namespace std;

void BFS();

static int Sender[] = {0, 0, 1, 1, 2, 2};
static int Receiver[] = {1, 2, 0, 2, 0, 1};

static bool visited[201][201];
static bool answer[201];
static int now[3];

int main(void) {
    cin >> now[0] >> now[1] >> now[2];
    BFS();

    for (int i = 0; i <= now[2]; i++) {
        if (answer[i]) {
            cout << i << ' ';
        }
    }
}

void BFS() {
    queue<pair<int, int> > q;
    q.push(make_pair(0, 0));
    visited[0][0] = true;
    answer[now[2]] = true;

    while (!q.empty()) {
        int cur[3];
        cur[0] = q.front().first;
        cur[1] = q.front().second;
        cur[2] = now[2] - cur[0] - cur[1];
        q.pop();

        if (cur[0] == 0) {
            answer[cur[2]] = true;
        }

        for (int i = 0; i < 6; i++) {
            int next[3] = {cur[0], cur[1], cur[2]};
            next[Receiver[i]] += next[Sender[i]];
            next[Sender[i]] = 0;

            if (next[Receiver[i]] >= now[Receiver[i]]) {
                next[Sender[i]] = next[Receiver[i]] - now[Receiver[i]];
                next[Receiver[i]] = now[Receiver[i]];
            }

            if (!visited[next[0]][next[1]]) {
                visited[next[0]][next[1]] = true;
                q.push(make_pair(next[0], next[1]));
            }
        }
    }
}