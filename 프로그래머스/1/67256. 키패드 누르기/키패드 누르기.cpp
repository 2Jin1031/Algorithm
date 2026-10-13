#include <bits/stdc++.h>
using namespace std;

int findDistance(pair<int, int> loc, int hand[2]) {
    return abs(loc.first - hand[0]) + abs(loc.second - hand[1]);
}

void useHand(int hand[2], pair<int, int> loc) {
    hand[0] = loc.first;
    hand[1] = loc.second;
}

string solution(vector<int> numbers, string hand) {
    map<int, pair<int, int>> phone;
    phone[1] = {0, 0}; phone[2] = {0, 1}; phone[3] = {0, 2};
    phone[4] = {1, 0}; phone[5] = {1, 1}; phone[6] = {1, 2};
    phone[7] = {2, 0}; phone[8] = {2, 1}; phone[9] = {2, 2};
    phone[0] = {3, 1};   // 0은 4번째 행 가운데

    int left[2]  = {3, 0};   // * 위치
    int right[2] = {3, 2};   // # 위치

    string result = "";

    for (int number : numbers) {
        pair<int, int> loc = phone[number];

        if (number == 1 || number == 4 || number == 7) {
            result += "L";
            useHand(left, loc);
        } else if (number == 3 || number == 6 || number == 9) {
            result += "R";
            useHand(right, loc);
        } else {
            int leftDist  = findDistance(loc, left);
            int rightDist = findDistance(loc, right);

            if (leftDist < rightDist) {
                result += "L";
                useHand(left, loc);
            } else if (rightDist < leftDist) {
                result += "R";
                useHand(right, loc);
            } else {
                if (hand == "left") {
                    result += "L";
                    useHand(left, loc);
                } else {
                    result += "R";
                    useHand(right, loc);
                }
            }
        }
    }

    return result;
}