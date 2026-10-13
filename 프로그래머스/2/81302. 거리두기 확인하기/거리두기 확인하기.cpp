#include <bits/stdc++.h>

using namespace std;

vector<int> dx = {0, 1, 0, -1};
vector<int> dy = {1, 0, -1, 0};

vector<pair<int, int>> findPersonPositions(vector<string> vec) {
    vector<pair<int, int>> result;
    for (int i = 0; i < vec.size(); i++) {
        size_t pos = 0;
        while (vec[i].find("P", pos) != string::npos) {
            cout << "personPosition: " << i << " " << pos << "\n";
            pos = vec[i].find("P", pos);
            result.push_back(pair{i, pos}); //
            pos++;
        }
    }
    return result;
}

bool invalidMove(int nextX, int nextY) {
    return nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5;
}


bool canMove(pair<int, int> pos, vector<string> place) {
    // pos를 기준으로 두번 갔을 때, 안에 장애물이 없어야 함
    // 장애물: P도 있음 , 만일 X 가 있으면 더이상 탐색하지 않아도 됨
    int currentX = pos.first;
    int currentY = pos.second;
    
    cout << "current: " << currentX << " " << currentY << "\n";
            
    for (int i = 0; i < 4; i++) {
        int step1X = currentX + dx[i];
        int step1Y = currentY + dy[i];
        if (invalidMove(step1X, step1Y)) { // 밖을 나가면 패쓰
            continue;
        }
        if (place[step1X][step1Y] == 'X') {
            continue;
        } 
        if (place[step1X][step1Y] == 'P') {
            cout << "flase1: " << step1X << " " << step1Y << "\n";
            return false;
        }
        for (int j = 0; j < 4; j++) {
            int step2X = step1X + dx[j];
            int step2Y = step1Y + dy[j];
            if (invalidMove(step2X, step2Y)) {
                continue;
            }
            
            if (step2X == currentX && step2Y == currentY) {
                continue;
            }
            
            if (place[step2X][step2Y] == 'X') {
                continue;
            } 
            if (place[step2X][step2Y] == 'P') {
                cout << "flase2: " << step2X << " " << step2Y << "\n";
                return false;
            }    
        }
    }
    return true;   
}



vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;
    
    for (int i = 0; i < places.size(); i++) {
        vector<pair<int, int>> personPositions = findPersonPositions(places[i]);
        
        bool flag = true;
        for (int j = 0; j < personPositions.size(); j++) {
            pair<int, int> pos = personPositions[j];
            
            if (!canMove(pos, places[i])) {
                answer.push_back(0);
                cout << pos.first << " " << pos.second << "\n"; //
                flag = false;
                break;
            }
        }
        if (flag) {
            answer.push_back(1);    
        }
    }
    return answer;
}