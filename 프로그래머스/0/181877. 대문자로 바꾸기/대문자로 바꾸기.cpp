#include <string>
#include <vector>
#include <cctype>

using namespace std;

string solution(string myString) {
    string answer = "";
    for (int i = 0; i < myString.length(); i++) {
        char myChar = myString[i];
        if (myChar >= 'a' && myChar <= 'z') {
            answer += myChar - 32;            
        } else {
            answer += myChar;
        }
        
    }
    return answer;
}