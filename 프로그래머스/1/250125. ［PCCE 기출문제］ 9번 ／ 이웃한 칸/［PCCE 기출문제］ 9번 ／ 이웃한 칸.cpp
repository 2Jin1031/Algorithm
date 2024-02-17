#include <string>
#include <vector>

static int dx[] = {0, 1, 0, -1};
static int dy[] = {1, 0, -1, 0};

using namespace std;

int solution(vector<vector<string>> board, int h, int w) {
    int answer = 0;
    for (int i = 0; i < 4; i++) {
        int x = h + dx[i];
        int y = w + dy[i];
        if (x >= 0 && y >= 0 && x < board.size() && y < board.size()) {
            if (board[h][w] == board[x][y]) {
                answer++;
            }
        }
    }
    
    return answer;
}