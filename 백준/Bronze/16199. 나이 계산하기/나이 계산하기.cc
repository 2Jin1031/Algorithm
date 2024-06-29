#include <iostream>
using namespace std;

int main() {
    int birth_year, birth_month, birth_day;
    int current_year, current_month, current_day;
    
    cin >> birth_year >> birth_month >> birth_day;
    cin >> current_year >> current_month >> current_day;
    
    int age1 = current_year - birth_year;
    if (current_month < birth_month || (current_month == birth_month && current_day < birth_day)) {
        age1--;
    }
    
    int age2 = current_year - birth_year + 1;
    
    int age3 = current_year - birth_year;
    
    cout << age1 << '\n' << age2 << '\n' << age3 << '\n';
    
    return 0;
}