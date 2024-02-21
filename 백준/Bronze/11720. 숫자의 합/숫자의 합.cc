#include <string>
#include <iostream>

int main(void) {
    int T; std::cin>>T;
    std::string str; std::cin>>str;
    
    int sum = 0;
    for(int i = 0; i < str.size(); i++) {
        sum += str[i] - '0';
    }
    
    std::cout<<sum<<std::endl;
    return 0;
}